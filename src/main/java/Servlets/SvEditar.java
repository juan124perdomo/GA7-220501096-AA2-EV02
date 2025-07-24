/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Ordenes;


@WebServlet(name = "SvEditar", urlPatterns = {"/SvEditar"})
public class SvEditar extends HttpServlet {
Controladora control = new Controladora ();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       int id_editar = Integer.parseInt(request.getParameter("id_editar"));
       Ordenes usu = control.traerOrden(id_editar);
       
       HttpSession misesion = request.getSession();
        misesion.setAttribute("usueditar",usu );
       
       response.sendRedirect("editar.jsp");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String tipo_orden = request.getParameter("tipo_orden");
        String descripcion = request.getParameter("descripcion");

        
        Ordenes usu =(Ordenes) request.getSession().getAttribute("usueditar");
        usu.setNombre(nombre);
        usu.setTipo_orden(tipo_orden);
        usu.setDescripcion(descripcion);
        
        
            
       control.editarOrdenes(usu);
       response.sendRedirect("index.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
