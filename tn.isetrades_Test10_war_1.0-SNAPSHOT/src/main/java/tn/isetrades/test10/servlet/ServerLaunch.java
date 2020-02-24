/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.isetrades.test10.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import org.openstack4j.model.compute.Server;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.openstack4j.model.compute.ServerCreate;
import tn.isetrades.test10.api.ServerApiImpl;

/**
 *
 * @author Rania
 */
public class ServerLaunch extends HttpServlet {

    ServerApiImpl sAI = new ServerApiImpl();
    Server server;
    ServerCreate serverCreate = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        String flavor = request.getParameter("flavor");
        int count = Integer.parseInt(request.getParameter("count"));

        try {
            serverCreate = sAI.createServer(name, flavor, image);
        } catch (Exception e) {
        }

        if (serverCreate != null) {
            for (int c = 0; c < count; c++) {
                try {
                    server = sAI.ServerBoot(serverCreate);
                } catch (Exception e) {}
            }
        }
    

    if (server!= null) {
            response.sendRedirect("ServerView.jsp");
    }

    
        else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ServerAdd.jsp");
        rd.include(request, response);
    }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
