/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dataaccesslayer.CupcakeSql;
import dataaccesslayer.invoiceSql;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Invoice;

/**
 *
 * @author mahnaz
 */
@WebServlet(name = "invoiceHandler", urlPatterns = {"/invoiceHandler"})
public class invoiceHandler extends HttpServlet {
          dataaccesslayer.invoiceSql isql = new invoiceSql();
         dataaccesslayer.CupcakeSql dal= new CupcakeSql();
         

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         //HttpSession session = request.getSession(true);//??
         
         
   
        }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         
         int baseSelectID = Integer.parseInt(request.getParameter("base"));
         int price1=dal.getBasePrice(baseSelectID);
         System.out.println("this is price"+price1);
         
         int topSelectID = Integer.parseInt(request.getParameter("top"));
         int price2=dal.getTopPrice(topSelectID);
         System.out.println("this is price"+price2);
         
         int customerID= Integer.parseInt(request.getParameter("custumerid"));
         System.out.println("this is price"+customerID);
         
         
         String stringAmount = request.getParameter("amount");
         int amount = tryParse(stringAmount);
         
         int sum = (price1+price2)*amount;
         
         String cupcake =  dal.getBaseName(baseSelectID)+"/"+dal.getTopName(topSelectID);
         isql.addInvoice(customerID, cupcake, amount, sum);
         ArrayList<Invoice> invoice = isql.getInvoice(customerID);
         
          request.setAttribute("Invoice", invoice);

         request.setAttribute("custumerid", customerID);
        getServletContext().getRequestDispatcher("/invoice.jsp").forward(request, response);
    }
    public int  tryParse(String text) {
  try {
    return Integer.parseInt(text);
  } catch (NumberFormatException e) {
    return 0;
  }
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
