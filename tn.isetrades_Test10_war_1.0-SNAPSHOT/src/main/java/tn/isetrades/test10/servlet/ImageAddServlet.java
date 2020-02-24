package tn.isetrades.test10.servlet;

import java.io.IOException;
import java.net.URL;
import javax.servlet.RequestDispatcher;
import org.openstack4j.model.image.v2.Image;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.common.Payload;
import org.openstack4j.model.image.v2.DiskFormat;
import org.openstack4j.model.image.v2.Image.ImageVisibility;
import tn.isetrades.test10.api.ImageApiImpl;

/**
 *
 * @author Rania
 */
public class ImageAddServlet extends HttpServlet {

    ImageApiImpl iAI = new ImageApiImpl();
    Image image = null;
    Payload<URL> payload = null;
    ActionResponse aR = null;
    ImageVisibility iV = null;
    DiskFormat dF = null;
    boolean result = true;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String format = request.getParameter("format");
        String file = request.getParameter("file");
        String visibility = request.getParameter("visibility");
        String protect = request.getParameter("protected");
        long mindisk = Long.parseLong(request.getParameter("mindisk"));
        long minram = Long.parseLong(request.getParameter("minram"));

        if (DiskFormat.AKI.toString().equalsIgnoreCase(format)) {
            dF = DiskFormat.AKI;
        } else if (DiskFormat.AMI.toString().equalsIgnoreCase(format)) {
            dF = DiskFormat.AMI;
        } else if (DiskFormat.ARI.toString().equalsIgnoreCase(format)) {
            dF = DiskFormat.ARI;
        } else if (DiskFormat.ISO.toString().equalsIgnoreCase(format)) {
            dF = DiskFormat.ISO;
        } else if (DiskFormat.QCOW2.toString().equalsIgnoreCase(format)) {
            dF = DiskFormat.QCOW2;
        } else if (DiskFormat.RAW.toString().equalsIgnoreCase(format)) {
            dF = DiskFormat.RAW;
        } else if (DiskFormat.UNRECOGNIZED.toString().equalsIgnoreCase(format)) {
            dF = DiskFormat.UNRECOGNIZED;
        } else if (DiskFormat.VDI.toString().equalsIgnoreCase(format)) {
            dF = DiskFormat.VDI;
        } else if (DiskFormat.VHD.toString().equalsIgnoreCase(format)) {
            dF = DiskFormat.VHD;
        } else if (DiskFormat.VHDX.toString().equalsIgnoreCase(format)) {
            dF = DiskFormat.VHDX;
        } else if (DiskFormat.VMDK.toString().equalsIgnoreCase(format)) {
            dF = DiskFormat.VMDK;
        }

        if (visibility.equalsIgnoreCase("private")) {
            iV = ImageVisibility.PRIVATE;
        } else {
            iV = ImageVisibility.PUBLIC;
        }

        try {
            image = iAI.createImage(name, mindisk, minram, iV, dF);
        } catch (Exception e) {

        }

        if (image != null) {
            try {
                payload = iAI.createPayload(file);
            } catch (Exception e) {

            }
        } else {
            result = false;
        }

        if (payload != null) {
            try {
                aR = iAI.uploadImage(image, payload);
            } catch (Exception e) {

            }
        } else {
            result = false;
        }

        if (result) {
            response.sendRedirect("ImageView.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ImageAdd.jsp");
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
