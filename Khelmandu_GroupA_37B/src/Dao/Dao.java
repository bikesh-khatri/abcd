package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Userdata;
import Database.MySqlConnection;

/**
 * @author User
 */
public class Dao {
    MySqlConnection mysql = new MySqlConnection();

    public void signup(Userdata user) {
        Connection conn = mysql.openConnection();
        
        String sql = "INSERT into users(f_name,l_name,ph_number,password) values(?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getFname());
            pstmt.setString(2, user.getLname());
            pstmt.setLong(3, user.getNumber());
            pstmt.setString(4, user.getpassword());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
    }

    public boolean checkuser(Userdata user) {
        Connection conn = mysql.openConnection();
        
        String sql = "SELECT * FROM users where ph_number = ? or f_name = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, user.getNumber());
            pstmt.setString(2, user.getFname());
            ResultSet result = pstmt.executeQuery();
            return result.next();
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }
}