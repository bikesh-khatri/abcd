/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import java.sql.*;
/**
 *
 * @author khatr
 */

public interface database{
Connection openConnection();
void closeConnection(Connection conn);
ResultSet runQuery(Connection conn, String query); //reference type
int executeUpdate(Connection conn, String query);
}
    

