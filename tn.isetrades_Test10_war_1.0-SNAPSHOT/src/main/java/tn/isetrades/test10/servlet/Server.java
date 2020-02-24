package tn.isetrades.test10.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tn.isetrades.test10.api.ServerApiImpl;

/**
 *
 * @author Rania
 */
public class Server extends HttpServlet {

    ServerApiImpl sAI = new ServerApiImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        

        request.getRequestDispatcher("ServerView.jsp").forward(request, response);
        String action = request.getParameter("action");

        String serverId = request.getParameter("server_radio");

        if (null != action) {
            switch (action) {
                case "Stop":
                    sAI.ServerStop(serverId);
                    break;
                case "Pause":
                    sAI.ServerPause(serverId);
                    break;
                case "Unpause":
                    sAI.ServerUnpause(serverId);
                    break;
                case "Start":
                    sAI.ServerStart(serverId);
                    break;
                case "Lock":
                    sAI.ServerLock(serverId);
                    break;
                case "Unlock":
                    sAI.ServerUnlock(serverId);
                    break;
                case "Delete":
                    sAI.ServerDelete(serverId);
                    break;
                case "Create Snapshot":
                    sAI.ServerCreateSnapshot(serverId);
                    break;
                case "Associate Floating IP":
                sAI.ServerCreateSnapshot(serverId);
                break;
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
