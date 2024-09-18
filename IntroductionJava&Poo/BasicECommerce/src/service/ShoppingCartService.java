package service;

import model.ProductType;
import model.ShoppingCart;
import model.ShoppingCartItem;
import model.ShoppingCartStatus;

import java.math.BigDecimal;
import java.util.Objects;

public class ShoppingCartService {


    /**
     * Calculates the total price of all items in the shopping cart.
     *
     * @param cart The shopping cart.
     * @return The total price of all items in the cart.
     * @throws IllegalArgumentException if the cart is null.
     */
    public BigDecimal getCartTotal(ShoppingCart cart) {
        if (Objects.isNull(cart)) throw new IllegalArgumentException("Field cart cannot be null.");

        return cart.getShoppingCartItemList().stream()
                .map(ShoppingCartItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    /**
     * Changes the status of the shopping cart.
     *
     * @param cart      The shopping cart.
     * @param newStatus The new status to set.
     * @throws IllegalArgumentException if the cart is null or the new status is null.
     */
    public void changeCartStatus(ShoppingCart cart, ShoppingCartStatus newStatus) {
        if (Objects.isNull(cart)) throw new IllegalArgumentException("Field cart cannot be null.");
        if (Objects.isNull(newStatus)) throw new IllegalArgumentException("Field newStatus cannot be null.");

        cart.setShoppingCartStatus(newStatus);
    }

    /**
     * Adds an item to the shopping cart.
     *
     * @param cart The shopping cart.
     * @param item The item to add.
     * @throws IllegalArgumentException if the cart or item is null.
     */
    public void addItem(ShoppingCart cart, ShoppingCartItem item) {
        if (Objects.isNull(cart) || Objects.isNull(item))
            throw new IllegalArgumentException("Cart and item cannot be null.");

        cart.getShoppingCartItemList().add(item);

    }


    /**
     * Removes an item from the shopping cart.
     *
     * @param cart The shopping cart.
     * @param item The item to remove.
     * @throws IllegalArgumentException if the cart or item is null.
     */
    public void removeItem(ShoppingCart cart, ShoppingCartItem item) {
        if (Objects.isNull(cart) || Objects.isNull(item))
            throw new IllegalArgumentException("Cart and item cannot be null.");

        cart.getShoppingCartItemList().remove(item);
    }


    /**
     * Calculates the total price of all products in the shopping cart that are of a specified type.
     *
     * @param cart The shopping cart.
     * @param type The product type to filter.
     * @return The total price of products of the specified type.
     * @throws IllegalArgumentException if the cart or type is null.
     */
    public BigDecimal getTotalPriceByProductType(ShoppingCart cart, ProductType type) {
        if (Objects.isNull(cart)) throw new IllegalArgumentException("Field cart cannot be null.");
        if (Objects.isNull(type)) throw new IllegalArgumentException("Product type cannot be null.");

        return cart.getShoppingCartItemList().stream()
                .filter(item -> item.getProduct().getProductType() == type)
                .map(ShoppingCartItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


}
