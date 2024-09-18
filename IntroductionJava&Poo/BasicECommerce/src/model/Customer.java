package model;

import utils.ValidationUtils;

import java.time.LocalDate;
import java.util.Objects;

public class Customer {
    private Long id;
    private String name;
    private String lastName;
    private LocalDate birthday;
    private String email;
    private String phone;
    private String identificationNumber;


    /**
     * @param name                 The customer's first name. Cannot be null.
     * @param lastName             The customer's last name. Cannot be null.
     * @param birthday             The customer's date of birth. Can be null.
     * @param email                The customer's email address. Cannot be null.
     * @param phone                The customer's phone number. Cannot be null.
     * @param identificationNumber The customer's identification number. Cannot be null.
     * @throws IllegalArgumentException if any required field (name, lastName, email, phone, or identificationNumber) is null.
     */
    public Customer(Long id, String name, String lastName, LocalDate birthday, String email, String phone, String identificationNumber) {
        if (Objects.isNull(id)) throw new IllegalArgumentException("Field id is required.");
        if (Objects.isNull(name)) throw new IllegalArgumentException("Field name is required.");
        if (Objects.isNull(lastName)) throw new IllegalArgumentException("Field lastName is required.");
        if (Objects.isNull(email)) throw new IllegalArgumentException("Field email is required.");
        if (!ValidationUtils.isValidEmail(email)) throw new IllegalArgumentException("Invalid email address.");
        if (Objects.isNull(phone)) throw new IllegalArgumentException("Field phone is required.");
        if (Objects.isNull(identificationNumber))
            throw new IllegalArgumentException("Field identificationNumber is required.");


        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.identificationNumber = identificationNumber;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(lastName, customer.lastName) && Objects.equals(birthday, customer.birthday) && Objects.equals(email, customer.email) && Objects.equals(phone, customer.phone) && Objects.equals(identificationNumber, customer.identificationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, birthday, email, phone, identificationNumber);
    }


}
