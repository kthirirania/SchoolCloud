package tn.isetrades.test10.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openstack4j.model.compute.Flavor;
import org.openstack4j.model.image.v2.Image;

import tn.isetrades.test10.api.FlavorApiImpl;
import tn.isetrades.test10.api.ImageApiImpl;

/**
 *
 * @author Rania
 */
public class ListFlavors extends HttpServlet {

    private List<? extends Flavor> ff;
    FlavorApiImpl fA = new FlavorApiImpl();
    
    private List<? extends Image> rr;
    ImageApiImpl iA = new ImageApiImpl();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            //TODO output your page here.You may use following sample code

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListFlavors</title>");
            out.println("</head>");
            out.println("<body>");
            
            /*ff = fA.listAllFlavors();
            for (Flavor flavor : ff) {
            out.format("Flavor id: %s, Flavor name: %s; vCPUs: %d; Local disk size: %d;GB Ram: %dMB \n",
            flavor.getId(), flavor.getName(), flavor.getVcpus(), flavor.getDisk(), flavor.getRam());
            }*/
            out.println("<h1>Servlet ListFlavors at " + request.getContextPath() + "</h1>");
            
            rr = iA.listAllImages();
            for (Image image : rr) {
                out.format("Image id: %s, Flavor name: %s; Size: %d; Status: %s\n",
                        image.getId(), image.getName(), image.getSize(), image.getStatus());
                out.println("</body>");
                out.println("</html>");
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
