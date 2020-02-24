package tn.isetrades.test10.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tn.isetrades.test10.api.ProjectApiImpl;
import tn.isetrades.test10.entity.model.Course;
import tn.isetrades.test10.entity.model.Member;
import tn.isetrades.test10.entity.service.CourseService;
import tn.isetrades.test10.entity.service.MemberService;

/**
 *
 * @author Rania
 */
public class ServletCourseAdd extends HttpServlet {

    CourseService cS = new CourseService();
    MemberService mS = new MemberService();
    boolean result = false;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String memberid = request.getParameter("memberid");

        Member m = new Member();
        m = mS.getMember(Integer.parseInt(memberid));

        Course course = new Course(description, true, name, m);
        try {
            cS.createCourse(course);
            result = true;
        } catch (Exception ex) {

        }

        if (result) {
            response.sendRedirect("CourseView.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/CourseAdd.jsp");
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
