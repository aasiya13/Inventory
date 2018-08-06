/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Sithara
 */
public class DbConnection {
     public static DbConnection dbConnection;
    private final Connection con;

    public DbConnection() throws ClassNotFoundException, SQLException {
      // Class.forName("com.mysql.jdbc.Driver");

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventory", "root", "root");
    }

    public static DbConnection getInstance() throws ClassNotFoundException, SQLException {
        if (dbConnection == null) 
            dbConnection = new DbConnection();
        return dbConnection;
    }

    public Connection getConnection(){ 
        return con;
    }
}
