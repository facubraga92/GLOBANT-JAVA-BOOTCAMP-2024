package utils;

import model.Customer;
import model.Product;
import model.ProductType;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ValidationContext {
    //Singleton pattern to use only one instance in the whole code.Eager initializacion.
    private static final ValidationContext instance = new ValidationContext();

    private final Map<String, ValidationStrategy<?>> strategies = new HashMap<>();

    private ValidationContext() {
        strategies.put("id", new GenericNotNullValidation<Long>());
        strategies.put("name", new GenericStringValidation());
        strategies.put("lastName", new GenericStringValidation());
        strategies.put("email", new GenericStringValidation());
        strategies.put("phone", new GenericStringValidation());
        strategies.put("identificationNumber", new GenericStringValidation());
        strategies.put("description", new GenericStringValidation());
        strategies.put("price", new GenericNotNullValidation<BigDecimal>());
        strategies.put("productType", new GenericNotNullValidation<ProductType>());
        strategies.put("customer", new GenericNotNullValidation<Customer>());
        strategies.put("product", new GenericNotNullValidation<Product>());
        strategies.put("quantity", new GenericNotNullValidation<Integer>());

    }

    public static ValidationContext getInstance() {
        return instance;
    }


    @SuppressWarnings("unchecked")
    public void validate(String field, Object value) {
        ValidationStrategy<Object> strategy = (ValidationStrategy<Object>) strategies.get(field);
        if (Objects.isNull(strategy)) {
            throw new IllegalArgumentException("No validation strategy found for field: " + field);
        }
        strategy.validate(value, field);
    }
}
