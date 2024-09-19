package utils;

import java.util.Objects;

public class GenericNotNullValidation<T> implements ValidationStrategy<T> {
    @Override
    public void validate(T value, String fieldName) throws IllegalArgumentException {
        if (Objects.isNull(value)) throw new IllegalArgumentException("Field " + fieldName + " is required.");

        if (value instanceof Number) {
            double numberValue = ((Number) value).doubleValue();

            if ("quantity".equals(fieldName) && numberValue < 1)
                throw new IllegalArgumentException("Field " + fieldName + " must be greater than or equal to 1.");

            if ("price".equals(fieldName) && numberValue <= 0)
                throw new IllegalArgumentException("Field " + fieldName + " must be greater than zero.");


        }
    }


}
