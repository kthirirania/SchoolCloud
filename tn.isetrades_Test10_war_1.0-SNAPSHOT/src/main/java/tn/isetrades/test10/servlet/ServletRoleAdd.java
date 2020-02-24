package tn.isetrades.test10.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.openstack4j.model.identity.v3.Role;
import tn.isetrades.test10.api.RoleAPiImpl;

import tn.isetrades.test10.entity.service.RoleService;

/**
 *
 * @author Rania
 */
public class ServletRoleAdd extends HttpServlet {

    RoleService rS = new RoleService();
    RoleAPiImpl rAI = new RoleAPiImpl();
    boolean result = false;
    org.openstack4j.model.identity.v3.Role role = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        tn.isetrades.test10.entity.model.Role role1 = new tn.isetrades.test10.entity.model.Role(name);
        try {
            rS.createRole(role1);
            result = true;
            try {
                role = rAI.createRole(name);
            }catch(Exception ex){
                
            }

        } catch (Exception ex) {

        }

        if (result) {
            response.sendRedirect("RoleView.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/RoleAdd.jsp");
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
