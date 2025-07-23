

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orden</title>
    </head>
    <body>
       
        <form action="SvOrdenes" method="POST">
             <h1>Orden nueva</h1>
            <p><label for="nombre">Nombre<input type="text" name="nombre"></label></p>
            
            <p><label for="tipo_orden">Tipo de orden <input type="text" name="tipo_orden"></label></p>
            <p><label for="descripcion">Descripcion <input type="text" name="descripcion" id="descripcion"></label></p>
       
            <button type="submit">Enviar</button>
        </form>
        
        <h1>Ver lista de ordenes</h1>
        <p>para ver los datos del usuario haga click en el boton mostrar</p>
        <form action="SvOrdenes" method="GET">
            <button type="submit">Mostrar ordenes</button>
        </form>
        
        
        <h1>Eliminar Orden</h1>
        <p>ingrese el id de la orden</p>
        <form action="SvEliminar" method="POST">
            <p><label>ID</label> <input type="text" name="id_orden"> </p>
            <button type="submit">Eliminar Orden</button>
        </form>
    </body>
</html>
