
<%@page import="java.util.List"%>
<%@page import="logica.Ordenes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de ordenes</h1>
        <%
            List<Ordenes> listaOrdenes = (List) request.getSession().getAttribute("listaOrdenes");
            int cont = 1;
            for(Ordenes usu : listaOrdenes){
            
        %>
        
               <p><b>Usuario N° <%=cont%> </b></p>
                <p>id: <%=usu.getId()%> </p>
                <p>Nombre: <%=usu.getNombre()%> </p>
                <p>Tipo de orden: <%=usu.getTipo_orden()%> </p>
                <p>Descripcion:  <%=usu.getDescripcion()%></p>
                <p>___________________________________________</p>
                <%cont = cont + 1;%>
        <%}%>
    </body>
</html>
