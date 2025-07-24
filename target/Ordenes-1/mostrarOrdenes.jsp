
<%@page import="java.util.List"%>
<%@page import="logica.Ordenes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listado de ordenes</title>
        <link rel="stylesheet" href="style.css"/>
    </head>
    <body>
       <h1>Listado de órdenes</h1>

<div class="contenedor-listado">
<%
    List<Ordenes> listaOrdenes = (List) request.getSession().getAttribute("listaOrdenes");
    int cont = 1;
    for(Ordenes usu : listaOrdenes){
%>
    <div class="orden-card">
        <p><strong>Usuario N° <%=cont%></strong></p>
        <p><strong>ID:</strong> <%=usu.getId()%></p>
        <p><strong>Nombre:</strong> <%=usu.getNombre()%></p>
        <p><strong>Tipo de orden:</strong> <%=usu.getTipo_orden()%></p>
        <p><strong>Descripción:</strong> <%=usu.getDescripcion()%></p>
    </div>
<%  cont++; } %>
</div>
    </body>
</html>
