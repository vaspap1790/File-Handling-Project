package controllers;

import dao.MyFileDao;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MyFile;

public class DownloadServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        MyFileDao myFileDao = new MyFileDao();
        MyFile file = myFileDao.getById(Integer.parseInt(request.getParameter("id")));

        InputStream inputStream = null;
        inputStream = file.getThefileasblob().getBinaryStream();

        ServletContext context = getServletContext();       
        response.setHeader("Content-disposition", "attachment; filename=" + file.getFilename());
        String mimeType = context.getMimeType(file.getFilename());

        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }

        OutputStream outStream = response.getOutputStream();
        response.setContentType(mimeType);

        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            //send response to browser
            outStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outStream.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DownloadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DownloadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getServletInfo() {
        return "Short description";
    }

}
