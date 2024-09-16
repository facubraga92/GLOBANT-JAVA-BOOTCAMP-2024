package model;

public enum ShoppingCartStatus {
    DRAFT("Draft"),
    SUBMITTED("Submitted");

    private final String value;

    ShoppingCartStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
