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
import javax.swing.JOptionPane;

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
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Registration Successful");
            } else {
                JOptionPane.showMessageDialog(null, "Registration Failed");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
    }

    public boolean checkuser(Userdata user) {
        Connection conn = mysql.openConnection();
        
        String sql = "SELECT * FROM users where ph_number = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, user.getNumber());
            ResultSet result = pstmt.executeQuery();
            return result.next();
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }
    
    public void logIn(String phno, String password) {
        MySqlConnection mySql = new MySqlConnection();
        Connection conn1 = mySql.openConnection();
        String sql = "SELECT * FROM users WHERE ph_number = ? AND password = ?";

        try (PreparedStatement pstm = conn1.prepareStatement(sql)) {
            pstm.setString(1, phno);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery(); 

            if (rs.next()) {
                // Login successful
                JOptionPane.showMessageDialog(null, "Login successful");
            } else {
                // Login failed
                JOptionPane.showMessageDialog(null, "Login failed: Invalid username or password");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occurred during login");
        } finally {
            mySql.closeConnection(conn1);
        }
    }
}