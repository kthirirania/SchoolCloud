package tn.isetrades.test10.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.openstack4j.api.Builders.user;
import org.openstack4j.api.OSClient.OSClientV3;
import tn.isetrades.test10.api.AuthenticationApiImpl;

/**
 *
 * @author Rania
 */
public class AuthenticationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    OSClientV3 os;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("username: " + username);
        System.out.println("password: " + password);
        // do some processing here
        try {
            AuthenticationApiImpl authAI = new AuthenticationApiImpl();
            os = authAI.unsocpedAuth(username, password);
        } catch (Exception ex) {

        }
        // get response writer
        PrintWriter writer = response.getWriter();
        if (os != null) {
            String name = os.getToken().getUser().getName();
            HttpSession session = request.getSession();
            session.setAttribute("sname", name);
            
            Cookie loginCookie = new Cookie("name", name);
            //setting cookie to expiry in 30 mins
            loginCookie.setMaxAge(30 * 60);
            response.addCookie(loginCookie);
            response.sendRedirect("welcome.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
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
