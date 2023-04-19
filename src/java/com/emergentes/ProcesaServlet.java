package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

@WebServlet(name = "ProcesaServlet", urlPatterns = {"/ProcesaServlet"})
public class ProcesaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            System.out.println("En el Servlet");
            //obtener acceso al objeto session
            HttpSession ses = request.getSession();
            //Se elimina la sesion
            ses.invalidate();
            //transfiere el cobtrol a index.jsp
            response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            System.out.println("En el metodo POST del servlet");
            //Recupera el producto enviado desde el formulario
            String producto = request.getParameter("producto");
            //se obtiene el acceso a la session
            HttpSession ses = request.getSession();
            //se obtiene la lista que esta como atributo de session
            ArrayList<String> lista = (ArrayList<String>)ses.getAttribute("lista");
            //a la coleccion se adiciona el elemento producto
            lista.add(producto);
            //se redirecciona a index.jsp
            response.sendRedirect("index.jsp");
    }
}
