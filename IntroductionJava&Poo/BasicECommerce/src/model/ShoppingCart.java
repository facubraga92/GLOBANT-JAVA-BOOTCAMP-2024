package model;


import utils.ValidationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShoppingCart {
    private Long id;
    private Customer customer;
    private ShoppingCartStatus shoppingCartStatus;
    private List<ShoppingCartItem> shoppingCartItemList;
    private ValidationContext validationContext = ValidationContext.getInstance();


    /**
     * @param customer             The customer associated with the shopping cart. Cannot be null.
     * @param shoppingCartItemList The list of items in the shopping cart. Can be null, in which case an empty list is used.
     * @throws IllegalArgumentException if customer is null.
     */
    public ShoppingCart(Long id, Customer customer, List<ShoppingCartItem> shoppingCartItemList) {
        validationContext.validate("id", id);
        validationContext.validate("customer", customer);

        this.id = id;
        this.customer = customer;
        this.shoppingCartStatus = ShoppingCartStatus.DRAFT;
        this.shoppingCartItemList = Objects.isNull(shoppingCartItemList) ? new ArrayList<>() : shoppingCartItemList;
    }

    public Long getId() {
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
