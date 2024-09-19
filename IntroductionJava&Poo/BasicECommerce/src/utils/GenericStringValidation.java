package utils;

import java.util.Objects;

public class GenericStringValidation implements ValidationStrategy<String> {

    @Override
    public void validate(String value, String fieldName) throws IllegalArgumentException {
        if (Objects.isNull(value)) throw new IllegalArgumentException("Field " + fieldName + " is required.");
        if ("email".equals(fieldName) && !isValidEmail(value))
            throw new IllegalArgumentException("Field " + fieldName + " must be a valid email address.");
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }
}
