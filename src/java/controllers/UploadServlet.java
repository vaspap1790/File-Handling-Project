package controllers;

import dao.MyFileDao;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import tools.Utilities;

@MultipartConfig
public class UploadServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {


        for (Part p : request.getParts()) {
            
            if ((p.getContentType() != null)&&(p.getSize()<104857600)) {

                String filename = p.getSubmittedFileName();

                if (filename.length() > 30) {
                    filename = filename.substring(0, 29);
                }

                MyFileDao mfo = new MyFileDao();
                mfo.fileUpload(p, filename);

                String directory = "D:" + File.separator + "Files";
                Utilities.checkPath(directory);
                p.write(directory + File.separator + filename);
            }
        }
        response.sendRedirect("Start");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

//        //manyfiles
//        for (Part part : request.getParts()) {
//            String fileName = part.getSubmittedFileName();
//
//            // to disk
//            part.write("directory" + File.separator + fileName);
//        }
//        request.setCharacterEncoding("UTF-8");
