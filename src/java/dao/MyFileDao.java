package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.Part;
import model.MyFile;
import static tools.DBUtils.close;
import static tools.DBUtils.getConnection;

public class MyFileDao {

    public MyFile getById(int id) {

        Connection conn = getConnection();

        MyFile myfile = new MyFile();
        String q = "SELECT * FROM myfiles WHERE id=?";

        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                myfile.setId(rs.getInt(1));
                myfile.setFilename(rs.getString(2));
                myfile.setThefile(rs.getBytes(3));
                myfile.setThefileasblob(rs.getBlob(3));

            }

        } catch (SQLException e) {
            System.out.println("Query failed:" + e.getMessage());
        }

        close(conn);

        return myfile;
    }

    public ArrayList<MyFile> getAllFiles() {

        Connection conn = getConnection();

        ArrayList<MyFile> myfiles = new ArrayList<>();

        try (Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM myfiles")) {
            while (rs.next()) {
                MyFile f = new MyFile();
                f.setId(rs.getInt(1));
                f.setFilename(rs.getString(2));
                f.setThefileasblob(rs.getBlob(3));
                myfiles.add(f);
            }
        } catch (SQLException e) {
            System.out.println("Query failed:" + e.getMessage());
        }

        close(conn);

        return myfiles;
    }

    public void deleteById(int id) {

        Connection conn = getConnection();

        String q = "DELETE FROM myfiles WHERE id=?";

        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.setInt(1, id);
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Query failed:" + e.getMessage());
        }

        close(conn);
    }

    public void fileUpload(Part p, String filename) throws IOException {
        
        Connection conn = getConnection();

        String q = "INSERT INTO myfiles (filename,myfile) VALUES (?,?)";

        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.setString(1, filename);
            pstm.setBinaryStream(2, p.getInputStream());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Query failed:" + e.getMessage());
        }
        close(conn);
    }
    
}
