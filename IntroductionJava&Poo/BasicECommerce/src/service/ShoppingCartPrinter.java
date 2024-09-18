package service;

import model.ProductType;
import model.ShoppingCart;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Objects;

public class ShoppingCartPrinter {
    /**
     * Prints all products in the shopping cart that have a price greater than a specified threshold and are of a specified type.
     *
     * @param cart           The shopping cart.
     * @param priceThreshold The minimum price to filter products.
     * @param type           The product type to filter.
     * @throws IllegalArgumentException if the cart, priceThreshold, or type is null.
     */
    public void printProductsAbovePriceAndType(ShoppingCart cart, BigDecimal priceThreshold, ProductType type) {
        if (Objects.isNull(cart)) throw new IllegalArgumentException("Field cart cannot be null.");
        if (Objects.isNull(priceThreshold)) throw new IllegalArgumentException("Price threshold cannot be null.");
        if (Objects.isNull(type)) throw new IllegalArgumentException("Product type cannot be null.");

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
     * Prints the details of all items in the shopping cart, ordered by price.
     *
     * @param cart The shopping cart.
     * @throws IllegalArgumentException if the cart is null.
     */
    public void printCartDetailsOrderedByPrice(ShoppingCart cart) {
        if (Objects.isNull(cart)) throw new IllegalArgumentException("Field cart cannot be null.");

        // Print table headers
        System.out.printf("%-2s || %-4s || %-10s || %-15s || %s%n",
                "CART ID", "PRODUCT ID", "PRODUCT TYPE", "PRODUCT NAME", "PRICE");
        System.out.println("---------------------------------------------------------------");

        cart.getShoppingCartItemList().stream()
                .sorted(Comparator.comparing(item -> item.getProduct().getPrice()))
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
