package tn.isetrades.test10.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tn.isetrades.test10.api.ProjectApiImpl;
import tn.isetrades.test10.entity.service.CourseService;

/**
 *
 * @author Rania
 */
public class CoursesActions extends HttpServlet {

    CourseService sC = new CourseService();
    ProjectApiImpl PAI = new ProjectApiImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.getRequestDispatcher("CourseView.jsp").forward(request, response);
        String action = request.getParameter("action");
        String projectId = request.getParameter("course_radio");
        int course_radio = Integer.parseInt(projectId);

        if (null != action) {
            switch (action) {
                case "Disable/Enable":
                    if (sC.getStatus(course_radio)) {
                        sC.enableorDisableCourse(course_radio, false);
                    } else {
                        sC.enableorDisableCourse(course_radio, true);
                    }
                    break;
                case "Delete":
                    sC.deleteCourse(course_radio);
                
                default:
                    break;
            }
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
