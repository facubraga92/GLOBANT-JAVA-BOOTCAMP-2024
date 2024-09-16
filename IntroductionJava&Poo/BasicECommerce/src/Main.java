import model.*;
import service.ShoppingCartService;
import utils.DataFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /////////////////*BUILDING OBJECTS*/////////////////

        //Create a Customer named JOHN SMITH with your favourite birth date.
        Customer johnSmith = new Customer("John", "Smith", LocalDate.of(1992, 9, 18), "facundobraga@hotmail.com", "+54 3624-123456", "12345678");

        //Create list of 5 products of each type:
        List<Product> electronics = DataFactory.createElectronicProducts();
        List<Product> libraries = DataFactory.createLibraryProducts();
        List<Product> others = DataFactory.createOtherProducts();

        //Create a shopping cart with 4 ELECTRONIC products
        ShoppingCart electronicCart = new ShoppingCart(johnSmith, Arrays.asList(
                new ShoppingCartItem(electronics.get(0), 1),
                new ShoppingCartItem(electronics.get(1), 2),
                new ShoppingCartItem(electronics.get(2), 1),
                new ShoppingCartItem(electronics.get(4), 3)
        ));

        //Create a shopping cart with 3 LIBRARY products
        ShoppingCart libraryCart = new ShoppingCart(johnSmith, Arrays.asList(
                new ShoppingCartItem(libraries.get(1), 1),
                new ShoppingCartItem(libraries.get(2), 1),
                new ShoppingCartItem(libraries.get(3), 1)
        ));

        //Create a shopping cart with 1 OTHER products
        ShoppingCart otherCart = new ShoppingCart(johnSmith, Arrays.asList(
                new ShoppingCartItem(others.get(0), 1)
        ));

        //Submit a Shopping Cart
        electronicCart.setShoppingCartStatus(ShoppingCartStatus.SUBMITTED);


        /////////////////*EXPECTED RESULT*/////////////////

        //Create an instance of ShoppingCartService to use methods
        ShoppingCartService cartService = new ShoppingCartService();
        //Create a mixed products cart:
        ShoppingCart mixedCart = new ShoppingCart(johnSmith, new ArrayList<>());

        // Add items with "addItem" method of ShoppingCartService Class
        cartService.addItem(mixedCart, new ShoppingCartItem(electronics.get(0), 1));
        cartService.addItem(mixedCart, new ShoppingCartItem(electronics.get(1), 1));
        cartService.addItem(mixedCart, new ShoppingCartItem(electronics.get(2), 1));

        cartService.addItem(mixedCart, new ShoppingCartItem(libraries.get(1), 1));
        cartService.addItem(mixedCart, new ShoppingCartItem(libraries.get(3), 1));
        cartService.addItem(mixedCart, new ShoppingCartItem(libraries.get(4), 1));

        cartService.addItem(mixedCart, new ShoppingCartItem(others.get(1), 2));
        cartService.addItem(mixedCart, new ShoppingCartItem(others.get(3), 3));
        cartService.addItem(mixedCart, new ShoppingCartItem(others.get(4), 1));


        //Given a shopping cart with a list of products in different categories (At least 3 for category). Please do the following:

        //Calculate and Print all products with price > 100 and product type is library
        System.out.println("*All products with price > 100 and type Library: ");
        cartService.printProductsAbovePriceAndType(mixedCart, BigDecimal.valueOf(100), ProductType.LIBRARY);

        System.out.println();

        //Calculate and Print sum(price) of all products
        System.out.println("*Cart Total: $" + cartService.getCartTotal(mixedCart));

        System.out.println();

        //Calculate and Print sum(price) of all electronic products
        System.out.println("*Sum(price) of all electronic products in cart: $" + cartService.getTotalPriceByProductType(mixedCart, ProductType.ELECTRONIC));
        System.out.println();
        //Calculate and Print all information of the shopping cart ordered by price
        System.out.println("*All information of shopping cart ordered by price: ");
        cartService.printCartDetailsOrderedByPrice(mixedCart);

    }
}