package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private Long id;
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
    public Product(Long id, String name, String description, BigDecimal price, ProductType productType) {
        if (Objects.isNull(id)) throw new IllegalArgumentException("Field id is required.");
        if (Objects.isNull(name)) throw new IllegalArgumentException("Field name is required.");
        if (Objects.isNull(description)) throw new IllegalArgumentException("Field description is required.");
        if (Objects.isNull(price)) throw new IllegalArgumentException("Field price is required.");
        if (price.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Price must be greater than zero.");
        if (Objects.isNull(productType)) throw new IllegalArgumentException("Field productType is required.");


        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.productType = productType;
    }

    public Long getId() {
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
