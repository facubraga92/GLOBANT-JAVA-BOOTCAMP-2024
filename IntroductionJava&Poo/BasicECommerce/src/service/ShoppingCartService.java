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
        if (Objects.isNull(cart)) {
            throw new IllegalArgumentException("Field cart cannot be null.");
        }
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
        if (Objects.isNull(cart)) {
            throw new IllegalArgumentException("Field cart cannot be null.");
        }
        if (Objects.isNull(newStatus)) {
            throw new IllegalArgumentException("Field newStatus cannot be null.");
        }

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
        if (Objects.isNull(cart) || Objects.isNull(item)) {
            throw new IllegalArgumentException("Cart and item cannot be null.");
        }

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
        if (Objects.isNull(cart) || Objects.isNull(item)) {
            throw new IllegalArgumentException("Cart and item cannot be null.");
        }
        cart.getShoppingCartItemList().remove(item);
    }


    /**
     * Prints all products in the shopping cart that have a price greater than a specified threshold and are of a specified type.
     *
     * @param cart           The shopping cart.
     * @param priceThreshold The minimum price to filter products.
     * @param type           The product type to filter.
     * @throws IllegalArgumentException if the cart, priceThreshold, or type is null.
     */
    public void printProductsAbovePriceAndType(ShoppingCart cart, BigDecimal priceThreshold, ProductType type) {
        if (Objects.isNull(cart)) {
            throw new IllegalArgumentException("Field cart cannot be null.");
        }
        if (Objects.isNull(priceThreshold)) {
            throw new IllegalArgumentException("Price threshold cannot be null.");
        }
        if (Objects.isNull(type)) {
            throw new IllegalArgumentException("Product type cannot be null.");
        }

        cart.getShoppingCartItemList().stream()
                .filter(item -> item.getProduct().getPrice().compareTo(priceThreshold) > 0)
                .filter(item -> item.getProduct().getProductType() == type)
                .forEach(item -> System.out.println(
                        "Product ID: " + item.getProduct().getId() +
                                ", Name: " + item.getProduct().getName() +
                                ", Price: " + item.getProduct().getPrice()
                ));
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
        if (Objects.isNull(cart)) {
            throw new IllegalArgumentException("Field cart cannot be null.");
        }
        if (Objects.isNull(type)) {
            throw new IllegalArgumentException("Product type cannot be null.");
        }

        return cart.getShoppingCartItemList().stream()
                .filter(item -> item.getProduct().getProductType() == type)
                .map(ShoppingCartItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    /**
     * Prints the details of all items in the shopping cart, ordered by price.
     *
     * @param cart The shopping cart.
     * @throws IllegalArgumentException if the cart is null.
     */
    public void printCartDetailsOrderedByPrice(ShoppingCart cart) {
        if (Objects.isNull(cart)) {
            throw new IllegalArgumentException("Field cart cannot be null.");
        }

        cart.getShoppingCartItemList().stream()
                .sorted((item1, item2) -> item1.getProduct().getPrice().compareTo(item2.getProduct().getPrice()))
                .forEach(item -> System.out.printf(
                        "%-10s %-10s %-15s %-20s %s%n",
                        cart.getId(),
                        item.getProduct().getId(),
                        item.getProduct().getProductType().getValue(),
                        item.getProduct().getName(),
                        item.getTotalPrice()
                ));
    }

}
