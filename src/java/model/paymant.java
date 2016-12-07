/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Bruger
 */
public class paymant {
    private String customerName;
   private int customerID;
   private double balance;
    private int totalprice;

    public paymant(int customerID, double balance , int totalprice) {
        this.customerID = customerID;
        this.balance = balance;
        this.totalprice = totalprice;
    }

    public paymant(String customerName, int balance, int totalprice) {
        this.customerName = customerName;
        this.balance = balance;
        this.totalprice = totalprice;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
   
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

   

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    @Override
    public String toString() {
        return "paymant{" + "customerName=" + customerName + ", customerID=" + customerID + ", customerAmount=" + balance + ", totalprice=" + totalprice + '}';
    }

    
   
    
}
