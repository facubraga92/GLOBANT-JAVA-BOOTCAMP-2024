package model;

import utils.IdGenerator;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private ProductType productType;


    /**
     * @param name        The name of the product. Cannot be null.
     * @param description The description of the product. Cannot be null.
     * @param price       The price of the product. Must be greater than zero.
     * @param productType The type of the product. Cannot be null.
     * @throws IllegalArgumentException if any required field (name, description, price, or productType) is null,
     *                                  or if the price is less than or equal to zero.
     */
    public Product(String name, String description, BigDecimal price, ProductType productType) {
        if (Objects.isNull(name) || Objects.isNull(description) || Objects.isNull(price) || Objects.isNull(productType)) {
            throw new IllegalArgumentException("Fields name, description, price, and productType are required.");
        }
        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }

        this.id = IdGenerator.generateId();
        this.name = name;
        this.description = description;
        this.price = price;
        this.productType = productType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductType getProductType() {
        return productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price) && productType == product.productType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, productType);
    }
}
