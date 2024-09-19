package utils;

public interface ValidationStrategy<T> {
    void validate(T value, String fieldName) throws IllegalArgumentException;
}
