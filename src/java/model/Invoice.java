package model;

import java.util.ArrayList;

public class Invoice {
    private int id;
    private int customerID;
    private String cupcakesName;
    private int antal ;
    private int totalPrice ;

    public Invoice(int customer, String cupcakesName, int antal, int totalPrice) {
        this.customerID = customer;
        this.cupcakesName = cupcakesName;
        this.antal = antal;
        this.totalPrice = totalPrice;
    }

    public int getCustomer() {
        return customerID;
    }

    public void setCustomer(int customer) {
        this.customerID = customer;
    }
    

    public String getCupcakesName() {
        return cupcakesName;
    }

    public void setCupcakesName(String cupcakesName) {
        this.cupcakesName = cupcakesName;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

  
}
