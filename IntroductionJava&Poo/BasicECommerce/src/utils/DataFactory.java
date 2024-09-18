package utils;

import model.Product;
import model.ProductType;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class DataFactory {

    public static List<Product> createElectronicProducts() {
        return Arrays.asList(
                new Product(1L, "iPhone 15 Pro", "Latest iPhone with advanced features", new BigDecimal("999.99"), ProductType.ELECTRONIC),
                new Product(2L, "iPhone 15", "Standard model with excellent performance", new BigDecimal("799.99"), ProductType.ELECTRONIC),
                new Product(3L, "iPhone 14 Pro Max", "Previous generation premium model", new BigDecimal("1099.99"), ProductType.ELECTRONIC),
                new Product(4L, "MacBook Air M2", "Lightweight laptop with Apple's M2 chip", new BigDecimal("1199.00"), ProductType.ELECTRONIC),
                new Product(5L, "MacBook Pro 14-inch M2", "High-performance laptop with M2 Pro chip", new BigDecimal("1999.00"), ProductType.ELECTRONIC)
        );
    }

    public static List<Product> createLibraryProducts() {
        return Arrays.asList(
                new Product(6L, "Fundamentals of Electromechanical Systems", "Comprehensive introduction to electromechanical systems", new BigDecimal("89.99"), ProductType.LIBRARY),
                new Product(7L, "Electromechanical Energy Conversion", "Focused on energy conversion principles in electromechanics", new BigDecimal("105.00"), ProductType.LIBRARY),
                new Product(8L, "Effective Java", "Best practices for Java programming", new BigDecimal("45.00"), ProductType.LIBRARY),
                new Product(9L, "Java: The Complete Reference", "Comprehensive guide to Java programming", new BigDecimal("50.00"), ProductType.LIBRARY),
                new Product(10L, "Head First Java", "Interactive introduction to Java programming", new BigDecimal("35.00"), ProductType.LIBRARY)

        );
    }

    public static List<Product> createOtherProducts() {
        return Arrays.asList(
                new Product(11L, "T-shirt", "Cotton 'Globant Logo' T-shirt", new BigDecimal("12.4"), ProductType.OTHERS),
                new Product(12L, "Coffee Mug", "Ceramic mug with motivational quote", new BigDecimal("8.99"), ProductType.OTHERS),
                new Product(13L, "Notebook", "Hardcover notebook with lined pages", new BigDecimal("15.50"), ProductType.OTHERS),
                new Product(14L, "Pen Set", "Pack of 3 high-quality pens", new BigDecimal("5.75"), ProductType.OTHERS),
                new Product(15L, "Water Bottle", "Stainless steel water bottle, 500ml", new BigDecimal("20.00"), ProductType.OTHERS)

        );
    }


}
