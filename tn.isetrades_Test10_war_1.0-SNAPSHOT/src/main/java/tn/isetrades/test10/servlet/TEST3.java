/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.isetrades.test10.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
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
public class TEST3 extends HttpServlet {

    MemberService mS = new MemberService();
    RoleService rS = new RoleService();
    CourseService cS = new CourseService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/TEST3.jsp");
        rd.include(request, response);
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TEST3</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TEST3 at " + request.getContextPath() + "</h1>");

            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            int role = Integer.parseInt(request.getParameter("role"));
            String en = request.getParameter("en");
            String[] courses = request.getParameterValues("courses");

            for (String ch : courses) {
                out.println("name: " + ch);
            }

            Course course = new Course();
            Set<Course> courses1 = new HashSet<>();

            for (int i = 0; i < courses.length; i++) {
                course = cS.getCourse(Integer.parseInt(courses[i]));
                courses1.add(course);
            }
            out.println("<br/>");
            for (Course course1 : courses1) {
                out.println("name: " + course1.getName() + " id: " + course1.getIdCourse());
            }
            Role role1 = rS.getRole(role);
            boolean res = false;
            if (en.equalsIgnoreCase("enabled")) {
                res = true;
            }
            Member member = new Member(role1, email, fname, lname, password, username, res, courses1);

            try {
                mS.createMember(member);
            } catch (Exception ex) {

            }
            out.println("</body>");
            out.println("</html>");
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
