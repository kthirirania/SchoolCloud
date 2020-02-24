package tn.isetrades.test10.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tn.isetrades.test10.entity.model.Member;
import tn.isetrades.test10.entity.model.Role;
import tn.isetrades.test10.entity.service.MemberService;
import tn.isetrades.test10.entity.service.RoleService;

/**
 *
 * @author Rania
 */
public class StudentsActions extends HttpServlet {

    MemberService mS = new MemberService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.getRequestDispatcher("StudentView.jsp").forward(request, response);
        
        String action = request.getParameter("action");
        int student_radio = Integer.parseInt(request.getParameter("student_radio"));
        
        int course = Integer.parseInt(request.getParameter("course"));
        int role = Integer.parseInt(request.getParameter("role"));

        Role role1 = new RoleService().getRole(role);
        Member member = new Member();
        member.setRole(role1);

        if (null != action) {
            switch (action) {
                case "Disable/Enable":
                    if (mS.getStatus(student_radio)) {
                        mS.enableorDisableMember(student_radio, false);
                    } else {
                        mS.enableorDisableMember(student_radio, true);
                    }
                    break;
                case "Set Role":
                    mS.updateMemberFull(member);
                case "Delete":
                    mS.deleteMember(student_radio);
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
