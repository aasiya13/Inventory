/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.Controller;


import inventory.db.DbConnection;
import inventory.models.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Sithara
 */
public class UserController {
     public static boolean authUser(User user) throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM User WHERE userName = ? AND password = ?";
        PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
        statement.setString(1, user.getUserName());
        statement.setString(2, user.getPassword());
        return statement.executeQuery().next();
    }
}
