/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Ordenes;


/**
 *
 * @author juanz
 */
@WebServlet(name = "SvOrdenes", urlPatterns = {"/SvOrdenes"})
public class SvOrdenes extends HttpServlet {
Controladora control = new Controladora (); 
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
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
       
        
        List<Ordenes> listaOrdenes = new ArrayList<>();
        listaOrdenes = control.traerOrdenes();
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaOrdenes",listaOrdenes );
        
        
        response.sendRedirect("mostrarOrdenes.jsp");
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String nombre = request.getParameter("nombre");
        String tipo_orden = request.getParameter("tipo_orden");
        String descripcion = request.getParameter("descripcion");

        
        Ordenes usu = new Ordenes();
        usu.setNombre(nombre);
        usu.setTipo_orden(tipo_orden);
        usu.setDescripcion(descripcion);
        
        
            
       control.crearOrden(usu);
       response.sendRedirect("index.jsp");
        
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
