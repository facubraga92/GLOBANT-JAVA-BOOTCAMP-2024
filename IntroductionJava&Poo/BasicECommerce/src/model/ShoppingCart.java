package model;

import utils.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShoppingCart {
    private String id;
    private Customer customer;
    private ShoppingCartStatus shoppingCartStatus;
    private List<ShoppingCartItem> shoppingCartItemList;


    /**
     * @param customer             The customer associated with the shopping cart. Cannot be null.
     * @param shoppingCartItemList The list of items in the shopping cart. Can be null, in which case an empty list is used.
     * @throws IllegalArgumentException if customer is null.
     */
    public ShoppingCart(Customer customer, List<ShoppingCartItem> shoppingCartItemList) {
        if (Objects.isNull(customer)) {
            throw new IllegalArgumentException("Field customer is required.");
        }

        this.id = IdGenerator.generateId();
        this.customer = customer;
        this.shoppingCartStatus = ShoppingCartStatus.DRAFT;
        this.shoppingCartItemList = Objects.isNull(shoppingCartItemList) ? new ArrayList<>() : shoppingCartItemList;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ShoppingCartStatus getShoppingCartStatus() {
        return shoppingCartStatus;
    }

    public void setShoppingCartStatus(ShoppingCartStatus status) {
        this.shoppingCartStatus = status;
    }

    public List<ShoppingCartItem> getShoppingCartItemList() {
        return shoppingCartItemList;
    }

}
