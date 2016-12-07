<%-- 
    Document   : PEYMENT
    Created on : 07-12-2016, 15:32:18
    Author     : Bruger
--%>

<%@page import="model.paymant"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1" >
            <tr>
                <TH>
                    oversigt til din køb
                </TH>

            </tr>



            <%
                
                ArrayList<paymant> invoice = (ArrayList)request.getAttribute("oversigt");%>

            <%  for (paymant msg : invoice) {

            %>

            <tr>
                 
                <td>
                    <%=msg.getCustomerID() %>
                </td>   
                <td>
                    <%=msg.getBalance() %>
                </td>   
                <td>
                    <%=msg.getTotalprice() %>
                </td>   

            </tr>
            <%}%>
        </table>
        
      
            <p> <a href="index.html">Logout</a></p> 
    </body>
</html>
