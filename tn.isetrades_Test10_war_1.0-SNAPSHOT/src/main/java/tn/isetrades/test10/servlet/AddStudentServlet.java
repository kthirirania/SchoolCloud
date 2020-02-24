package tn.isetrades.test10.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tn.isetrades.test10.entity.model.Course;
import tn.isetrades.test10.entity.model.Member;
import tn.isetrades.test10.entity.model.Role;
import tn.isetrades.test10.entity.service.CourseService;
import tn.isetrades.test10.entity.service.MemberService;
import tn.isetrades.test10.entity.service.RoleService;

/**
 *
 * @author Rania
 */
public class AddStudentServlet extends HttpServlet {

    MemberService mS = new MemberService();
    RoleService rS = new RoleService();
    CourseService cS = new CourseService();
    boolean result = false;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int role = Integer.parseInt(request.getParameter("role"));
        String en = request.getParameter("en");
        String[] courses = request.getParameterValues("courses");

        Role role1 = rS.getRole(role);

        Course course = new Course();
        Set<Course> courses1 = new HashSet<>();

        for (int i = 0; i < courses.length; i++) {
            course = cS.getCourse(Integer.parseInt(courses[i]));
            courses1.add(course);
        }

        Set<Course> courses2 = new HashSet<>();
        courses2.add(cS.getCourse(13));
        courses2.add(cS.getCourse(14));
        courses2.add(cS.getCourse(15));

        boolean res = false;
        if (en.equalsIgnoreCase("enabled")) {
            res = true;
        }
        Member member = new Member(role1, email, fname, lname, password, username, true);
        member.setCourses(courses1);

        try {
            mS.createMember(member);
            result = true;
        } catch (Exception ex) {

        }

        if (result) {
            response.sendRedirect("StudentView.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/StudentAdd.jsp");
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
