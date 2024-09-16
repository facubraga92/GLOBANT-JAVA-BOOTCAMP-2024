package model;

public enum ProductType {
    ELECTRONIC("Electronic"),
    LIBRARY("Library"),
    OTHERS("Others");

    private final String value;

    ProductType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
