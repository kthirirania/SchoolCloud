package tn.isetrades.test10.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tn.isetrades.test10.api.ServerApiImpl;

/**
 *
 * @author Rania
 */
public class Test extends HttpServlet {

    ServerApiImpl sAI = new ServerApiImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("ImageAdd.jsp").forward(request, response);

            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String format = request.getParameter("format");
            String file = request.getParameter("file");
            String visibility = request.getParameter("visibility");
            String protect = request.getParameter("protected");
            long mindisk = Long.parseLong(request.getParameter("mindisk"));
            long minram = Long.parseLong(request.getParameter("minram"));

            String m = request.getParameter("minram");
            String n = request.getParameter("mindisk");

            out.println(name + description + format + n + m + protect + visibility);

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
