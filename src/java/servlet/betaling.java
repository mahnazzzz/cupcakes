/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dataaccesslayer.UserSql;
import dataaccesslayer.invoiceSql;
import dataaccesslayer.paymentSql;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Invoice;
import model.User;
import model.paymant;

/**
 *
 * @author Bruger
 */
@WebServlet(name = "betaling", urlPatterns = {"/betaling"})
public class betaling extends HttpServlet {

          dataaccesslayer.invoiceSql isql = new invoiceSql();
        dataaccesslayer.UserSql usq= new UserSql();
         dataaccesslayer.paymentSql pay = new paymentSql();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String id = request.getParameter("custumerID");
        int custom = Integer.parseInt(id);
        User u= usq.getUser(custom);
        double balance = u.getBalance();
         ArrayList<Invoice> invoice = isql.getInvoice(custom);
         int sum =0;
         for (Invoice invoice1 : invoice) {
             sum += invoice1.getTotalPrice();
        }
          double nowBalance = balance -sum;
          
          pay.addEnPayment(custom, nowBalance, sum);
          pay.setNySaldo(nowBalance, custom);
          ArrayList<paymant> payList =pay.getBetalint(custom);
          request.setAttribute("oversigt", payList);
        getServletContext().getRequestDispatcher("/PEYMENT.jsp").forward(request, response);
          
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
