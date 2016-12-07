<%-- 
    Document   : shopPage
    Created on : Nov 15, 2016, 8:30:20 PM
    Author     : mahnaz
--%>

<%@page import="dataaccesslayer.CupcakeSql"%>
<%@page import="model.baseOrTop"%>
<%@page import="dataaccesslayer.CupcakeSql"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            th {text-align: center;width:50%;}
            td {vertical-align:top;}
        </style>
    </head>
    <body>


        <% ArrayList< baseOrTop> baseList = new CupcakeSql().getBase(); %>
        <% ArrayList< baseOrTop> topList = new CupcakeSql().getTop(); %>


        <h1>List of cakes!</h1>
        <form name="show" action="invoiceHandler" method="GET">


            <select name="base">
                <% for (int i = 0; i < baseList.size(); i++) {
                %>
                <option  value="<%=baseList.get(i).getId()%>">
                    <%out.print(baseList.get(i).getBaseorTop());%></option>
                    <%
                }%>
            </select>
            <select name="top">
                <% for (int i = 0; i < topList.size(); i++) {
                %>
                <option  value="<%=topList.get(i).getId()%>">
                    <% out.print(topList.get(i).getBaseorTop()); %></option>
                    <%
                }%>
            </select>
                <input type="hidden" name="custumerid" value="<%=request.getAttribute("user")%>"/>
            <input type="text" name="amount" required="" value="" />
            <input type="submit" value="send to basket" name="basket" />
            <p> <a href="index.html">Logout</a></p> 
        </form>
           
    </body>
</html>
