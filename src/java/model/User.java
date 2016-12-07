package model;

public class User {
    private int userID;
    private String username;
    private String password;
    private double balance;

    public User(int userID, String username, String password, double balance) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }
    
    
  
    public User(){ }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", username=" + username + ", password=" + password + ", balance=" + balance + '}';
    }
   
}
