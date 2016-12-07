package dataaccesslayer;

import dbconnector.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.baseOrTop;

public class CupcakeSql {

    Connection con = Connector.getCon();

    ;

    public ArrayList<baseOrTop> getBase() {
        ArrayList<baseOrTop> cupcakes = new ArrayList<>();
        PreparedStatement pst;
        try {

            pst = con.prepareStatement("SELECT * FROM base;");

            try (ResultSet resultSet = pst.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("base_id");
                    String name = resultSet.getString("base_name");
                    int price = resultSet.getInt("price");

                    cupcakes.add(new baseOrTop(id, name, price));
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cupcakes;
    }

    public ArrayList<baseOrTop> getTop() {
        ArrayList<baseOrTop> cupcakes = new ArrayList<>();
        PreparedStatement pst;
        try {

            pst = con.prepareStatement("SELECT * FROM top;");

            try (ResultSet resultSet = pst.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("top_id");
                    String name = resultSet.getString("top_name");
                    int price = resultSet.getInt("price");

                    cupcakes.add(new baseOrTop(id, name, price));
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cupcakes;
    }

    public int getBasePrice(int id) {
        int price = 0;
        PreparedStatement pst;
        try {
            con = Connector.getCon();
            pst = con.prepareStatement("SELECT price FROM base where base_id ='" + id + "'; ");

            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                price = resultSet.getInt("price");
            }
             return price;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return price;
    }

    public int getTopPrice(int id) {
        int price = 0;
        PreparedStatement pst;
        try {
           con = Connector.getCon();
            pst = con.prepareStatement("SELECT price FROM top where top_id ='" + id + "';");
            try {
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {
                    price = resultSet.getInt("price");
                }
                 return price;
            }catch (SQLException es){
                es.getStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return price;
    }

    public String getBaseName(int id) {
        String name = "";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement("SELECT base_name FROM base where base_id ='" + id + "';");
        
            try {
            ResultSet resultSet = pst.executeQuery();
while (resultSet.next()) {
            name = resultSet.getString("base_name");}
            return name;
 }catch(SQLException es){
     es.printStackTrace();
 }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return name;

    }

    public String getTopName(int id) {
        String name = "";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement("SELECT top_name FROM top where top_id ='" + id + "';");
 try {
            ResultSet resultSet = pst.executeQuery();
while (resultSet.next()) {
            name = resultSet.getString("top_name");}
            return name;
 }catch(SQLException es){
     es.printStackTrace();
 }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return name;
    }
}
