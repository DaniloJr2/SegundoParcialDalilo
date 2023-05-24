package com.emergentes.controlador;

import com.emergentes.dao.ProductosDAOimpl;
import com.emergentes.modelo.Productos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.dao.ProductosDAO;

import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ProductosControlador", urlPatterns = {"/ProductosControlador"})
public class ProductosControlador extends HttpServlet {

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ProductosDAO dao = new ProductosDAOimpl();        
        Productos avi = new Productos();
        int id;
        
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
            {
                try {
                  
                } catch (Exception ex) {
                    Logger.getLogger(ProductosControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                request.setAttribute("productos", avi);
                
                request.getRequestDispatcher("frmproductos.jsp").forward(request, response);
                break;

            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    avi = dao.getById(id);
                    
                } catch (Exception ex) {
                    System.out.println("Eror al obtener registro " + ex.getMessage());
                }
                
                request.setAttribute("productos", avi);
                request.getRequestDispatcher("frmproductos.jsp").forward(request, response);
                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("Error al eliminar: " + ex.getMessage());
                }
                response.sendRedirect("ProductosControlador");
                break;
            case "view":
                List<Productos> lista = new ArrayList<Productos>(); 
                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    System.out.println("Error al listar "+ex.getMessage());
                }
                request.setAttribute("productos", lista);
                request.getRequestDispatcher("productos.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion =  request.getParameter("descripcion");
        int cantidad =  Integer.parseInt(request.getParameter("cantidad"));
        float precio = Float.parseFloat(request.getParameter("precio"));
        String categorias =  request.getParameter("categorias");
        
        Productos avi = new Productos();
        
        avi.setId(id);
        avi.setDescripcion(descripcion);
        avi.setCantidad(cantidad);
        avi.setPrecio(precio);
        avi.setCategorias(categorias);
        
        ProductosDAO dao = new ProductosDAOimpl();
        
        if (id == 0){
            try {
                dao.insert(avi);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ ex.getMessage());
            }
        }
        else{
            try {
                dao.update(avi);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("ProductosControlador");
    }
}
