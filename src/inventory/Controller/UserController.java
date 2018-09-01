/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.Controller;

import inventory.db.DbConnection;
import inventory.models.Supplier;
import inventory.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Sithara
 */
public class UserController {

    public static boolean authUser(User user) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM User WHERE userName = ? AND password = ?";
        PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
        statement.setString(1, user.getUserName());
        statement.setString(2, user.getPassword());
        return statement.executeQuery().next();
    }

    public static ArrayList<String> getAllEmployee() throws SQLException, ClassNotFoundException {

        String query = "SELECT name FROM employee";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        ArrayList<String> employeeList = new ArrayList<>();
        while (rst.next()) {
            employeeList.add(rst.getString(1));
        }
        return employeeList;
    }

    public static int addUser(User user) throws ClassNotFoundException, SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            Statement s = connection.createStatement();
            ResultSet r = s.executeQuery("SELECT userId AS rowCount FROM user ORDER BY userId DESC LIMIT 1");
            String tempId;
            if (r.next()) {
                String countStr = r.getString("rowCount");
                String str = countStr.replaceAll("\\D+", "");
                int count = Integer.parseInt(str);
                //     System.out.println("Str "+ str+" Count "+count);
                //  int count = r.getInt("rowCount") ;
                int generatedSupplierId = count + 1;
                if (generatedSupplierId / 10 < 1) {
                    tempId = "U00" + Integer.toString(generatedSupplierId);
                } else if (generatedSupplierId / 100 < 1) {
                    tempId = "U0" + Integer.toString(generatedSupplierId);
                } else if (generatedSupplierId / 1000 < 1) {
                    tempId = "U" + Integer.toString(generatedSupplierId);
                } else {
                    tempId = "U" + Integer.toString(generatedSupplierId);
                }
            } else {
                tempId = "U001";
            }
            String employeeName = "";
            ResultSet r2 = s.executeQuery("SELECT employeeId AS employeeName FROM employee where name = '"+user.getEmployeeName()+"'");
            if(r2.next()){
                employeeName = r2.getString("employeeName");
            }
            r2.close();
            r.close();
            s.close();
            System.out.println("temp ID " + tempId);
              
            String addQuery = "INSERT INTO user VALUES(?,?,?,?)";
            PreparedStatement pre_stm = connection.prepareStatement(addQuery);
            pre_stm.setString(1, tempId);
            pre_stm.setString(2, user.getUserName());
            pre_stm.setString(3, user.getPassword());
            pre_stm.setString(4, employeeName);
           
            int res = pre_stm.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Successfully Added");
                pre_stm.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            connection.rollback();
            throw e;
        } finally {

            connection.setAutoCommit(true);
        }
        return 0;
    }
    public static User getUser(String userName) throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM user WHERE userName = '" + userName + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
        if (rst.next()) {
            return new User(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4));
        }
        return null;
    }
    
    public static String getEmployee(String id) throws ClassNotFoundException, SQLException{
        String sql = "SELECT name FROM employee WHERE employeeId = '" + id + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
        if (rst.next()) {
            String name =  rst.getString(1);
            rst.close();
            return name;
        }
        return null;
    }
    public static ResultSet ListgetInfoForTable() throws SQLException, ClassNotFoundException {
        String sql = "SELECT user.userName,employee.name FROM user INNER JOIN employee ON user.employeeId = employee.employeeId";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }
    
    public static void deleteUser(String userId) throws ClassNotFoundException, SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            String sql = "DELETE FROM user WHERE userId=?";
            PreparedStatement pre_stm = connection.prepareStatement(sql);
            pre_stm.setString(1, userId);

            int res = pre_stm.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Successfully Deleted");
                pre_stm.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }
    public static int updateUser(User user) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {

            String updateQuery = "UPDATE user SET userName=?,password=? where userId =?";
            PreparedStatement pre_stm = connection.prepareStatement(updateQuery);

            pre_stm.setString(1, user.getUserName());
            pre_stm.setString(2, user.getPassword());
            pre_stm.setString(3, user.getUserId());
            int res = pre_stm.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Successfully Updated");
                pre_stm.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
        return 0;
    }
}
