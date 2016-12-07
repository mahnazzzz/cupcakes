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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Invoice;
import model.baseOrTop;

/**
 *
 * @author mahnaz
 */
public class invoiceSql {

    ArrayList<Invoice> invoice;
    Connection con;

    public void addInvoice(int customer_id, String cupcakesName, int amount, int sumPrice) //som set her er der andre navn end de string den få ind men plades and type passer så det går
    {
        PreparedStatement pst;
        invoice = new ArrayList<Invoice>();

        try {
            con = Connector.getCon();
            pst = con.prepareStatement("insert into invoice(customer_id, cupcakesName, amount, sumPrice) values(?,?,?,?)");
            pst.setInt(1, customer_id);
            pst.setString(2, cupcakesName);
            pst.setInt(3, amount);
            pst.setInt(4, sumPrice);

            pst.executeUpdate();
            invoice.add(new Invoice(customer_id, cupcakesName, amount, sumPrice));
        } catch (SQLException ex) {
            ex.getStackTrace();
        }

    }

    public ArrayList<Invoice> getInvoice(int customerId) {
        PreparedStatement pst;
        ArrayList<Invoice> inv= new ArrayList<>();
        try {
            con = Connector.getCon();
            pst = con.prepareStatement("select * from invoice where customer_id='" + customerId + "';");
            try {
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {
                  int customer_id   = resultSet.getInt("customer_id");
                  String cupcakesName = resultSet.getString("cupcakesName");
                  int amount= resultSet.getInt("amount");
                  int sumPrice = resultSet.getInt("sumPrice");
                  inv.add(new Invoice(customer_id, cupcakesName,amount, sumPrice));
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
