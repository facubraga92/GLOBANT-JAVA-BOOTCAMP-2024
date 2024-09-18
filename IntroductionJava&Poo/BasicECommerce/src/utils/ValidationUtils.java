package utils;

public class ValidationUtils {
    /**
     * Validates if the provided email address is in a correct format.
     *
     * @param email The email address to be validated.
     * @return true if the email is in a valid format, false otherwise.
     */
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email != null && email.matches(emailRegex);
    }
}
