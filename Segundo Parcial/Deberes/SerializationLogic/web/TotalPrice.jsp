<%@page import="ec.edu.espe.Utils.RestClient"%>
<%@page import="ec.edu.espe.Models.Product"%>
<%@page import="com.google.gson.Gson"%>

<%-- 
    Document   : TotalPrice
    Created on : 13/12/2017, 13:51:05
    Author     : wason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Calculando Precios</h1>
        <form method="GET">
            <div class="field-wrap">
                <label>
                    Enter Product ID<span class="req">*</span>
                </label>
                <input type="text" name="TextId" value="0" />
            </div> 
        </form>
    </body>
</html>
<%
    String id = request.getParameter("TextId");
    try
    {
        Gson parser = new Gson();
        String jsonProduct=RestClient.doGet("http://localhost:8080/SerializationApp/products/"+id);
        Product obj= new Product();
        obj= parser.fromJson(jsonProduct, Product.class);
        out.println("Precio Total: "+String.format("%.2f",(float)obj.getAmmount()*obj.getPrice()*1.12)+" Producto:"+obj.getName());

    } catch (Exception e)
    {
        System.out.println("Error al llamar al servicio");
    }
%>