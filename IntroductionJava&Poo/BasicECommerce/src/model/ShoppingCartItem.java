package model;


import java.math.BigDecimal;
import java.util.Objects;

public class ShoppingCartItem {
    private Long id;
    private Product product;
    private int quantity;


    /**
     * @param product  The product associated with this item. Cannot be null.
     * @param quantity The quantity of the product. Must be greater than 0.
     * @throws IllegalArgumentException if product is null or quantity is less than 1.
     */
    public ShoppingCartItem(Long id, Product product, int quantity) {
        if (Objects.isNull(id)) throw new IllegalArgumentException("Field id are required.");
        if (Objects.isNull(product)) throw new IllegalArgumentException("Product cannot be null.");
        if (quantity < 1) throw new IllegalArgumentException("Quantity must be greater than 0.");

        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCartItem that = (ShoppingCartItem) o;
        return quantity == that.quantity && Objects.equals(id, that.id) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, quantity);
    }

    /**
     * Calculates the total price for this shopping cart item.
     *
     * @return The total price (price of the product multiplied by the quantity).
     * <p>
     * "Don't talk to strangers" (Unique Responsibility) example method:
     */
    public BigDecimal getTotalPrice() {
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }
}
