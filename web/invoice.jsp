<%-- 
    Document   : invoice
    Created on : Nov 21, 2016, 12:15:27 AM
    Author     : mahnaz
--%>

<%@page import="dataaccesslayer.invoiceSql"%>
<%@page import="model.Invoice"%>
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
                
                ArrayList<Invoice> invoice = (ArrayList)request.getAttribute("Invoice");%>

            <%  for (Invoice msg : invoice) {

            %>

            <tr>
                 
                <td>
                    <%=msg.getCupcakesName()%>
                </td>   
                <td>
                    <%=msg.getAntal() %>
                </td>   
                <td>
                    <%=msg.getTotalPrice() %>
                </td>   

            </tr>
            <%}%>
        </table>
        <form name="show" action="betaling" method="GET">
        <input type="hidden" name="custumerID" value="<%=request.getAttribute("custumerid")%>"/>
            <input type="submit" value="betale" />
            <p> <a href="shopPage.jsp">tilbage</a></p>
            <p> <a href="index.html">Logout</a></p> </form>
    </body>
</html>
