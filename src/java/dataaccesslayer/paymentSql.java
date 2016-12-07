/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import dbconnector.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Invoice;
import model.paymant;

/**
 *
 * @author Bruger
 */
public class paymentSql {
     ArrayList<paymant> pay;
    Connection con;

    public void addEnPayment(int customer_id, double acount, int sumPrice) //som set her er der andre navn end de string den få ind men plades and type passer så det går
    {
        PreparedStatement pst;
        pay = new ArrayList<paymant>();

        try {
            con = Connector.getCon();
            pst = con.prepareStatement("insert into betalinger(customer_id, customer_account, totalPrice_inkøb) values(?,?,?)");
            pst.setInt(1, customer_id);
            pst.setDouble(2, acount);
            pst.setInt(3, sumPrice);
           

            pst.executeUpdate();
            pay.add(new paymant(customer_id, acount, sumPrice));
        } catch (SQLException ex) {
            ex.getStackTrace();
        }

    }

    public ArrayList<paymant> getBetalint(int customerId) {
        PreparedStatement pst;
        ArrayList<paymant> inv= new ArrayList<>();
        try {
            con = Connector.getCon();
            pst = con.prepareStatement("select * from betalinger where customer_id='" + customerId + "';");
            try {
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {
                  int customer_id   = resultSet.getInt("customer_id");
                  int acount = resultSet.getInt("customer_account");
                  int total  = resultSet.getInt("totalPrice_inkøb");
                  inv.add(new paymant(customer_id, acount,total));
                }
                return inv;
            } catch (SQLException es) {
                es.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return inv;
    }

    public String viseInvoic() {
        return "";
    }

    
}
