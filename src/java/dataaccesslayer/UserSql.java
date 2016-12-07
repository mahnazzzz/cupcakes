package dataaccesslayer;

import dbconnector.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserSql {
    Connection con;
    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            PreparedStatement pst;
            
            
            con = Connector.getCon();
            pst = con.prepareStatement("SELECT * FROM user");

            ResultSet resultSet = pst.executeQuery();
                
            while (resultSet.next()) {
                int userId= resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                double balance = resultSet.getDouble("balance");
                
                users.add(new User(userId,username, password, balance));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }
   
    public User getUserr(String username) {
        User user = null;
        try {
             PreparedStatement pst;
             con = Connector.getCon();
            pst = con.prepareStatement("SELECT * FROM user WHERE username = '" + username+"'");

            ResultSet resultSet = pst.executeQuery();
            
            if (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String password = resultSet.getString("password");
                double balance = resultSet.getDouble("balance");
                user = new User(userId, username, password, balance);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    public User getUser(int id) {
        User user = null;
        try {
             PreparedStatement pst;
             con = Connector.getCon();
            pst = con.prepareStatement("SELECT * FROM user WHERE id ='" +id+"'");

            ResultSet resultSet = pst.executeQuery();
            
            if (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                double balance = resultSet.getDouble("balance");
                user = new User(id, username, password, balance);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    

//    public void withdraw(User customer, double total) {
//        String username = customer.getUsername();
//        double balance = customer.getBalance() - total;
//        try {
//            Connector c = new Connector();
//            c.doUpdate("UPDATE user SET balance='"+balance+"' WHERE username='"+username+"';");
//        } catch (SQLException | ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
//    }

}
