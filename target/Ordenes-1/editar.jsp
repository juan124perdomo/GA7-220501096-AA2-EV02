
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="logica.Ordenes"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar usuario</title>
    </head>
    <body>
        
        <% Ordenes usu =(Ordenes) request.getSession().getAttribute("usueditar");%>
        <h1>Hello World!</h1>
        
        
         <form action="SvEditar" method="POST">
             <h1>Orden nueva</h1>
             <p><label for="nombre">Nombre<input type="text" name="nombre" value="<%=usu.getNombre()%>"></label></p>
            
            <p><label for="tipo_orden">Tipo de orden <input type="text" name="tipo_orden" value="<%=usu.getTipo_orden()%>"></label></p>
            <p><label for="descripcion">Descripcion <input type="text" name="descripcion" id="descripcion" value="<%=usu.getDescripcion()%>" ></label></p>
       
            <button type="submit">Guardar</button>
        </form>
        
    </body>
</html>
