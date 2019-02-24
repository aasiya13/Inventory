/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.Controller;

import inventory.db.DbConnection;
import inventory.models.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sithara
 */
public class CustomerController {
    
     public static ResultSet getInfoForCustomerTable() throws ClassNotFoundException, SQLException{
         String sql = "SELECT nic, customerName, tel, loyaltyCard FROM customer";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }
     
    public static ResultSet getInfoCustomerTableById(String id) throws ClassNotFoundException, SQLException{
         String sql = "SELECT nic, customerName, tel, loyaltyCard FROM customer where nic = '"+id+"'";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }
    
    public static ResultSet getInfoCustomerTableByCardNo(String id) throws ClassNotFoundException, SQLException{
         String sql = "SELECT nic, customerName, tel, loyaltyCard FROM customer where loyaltyCard = '"+id+"'";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }
     
    public static Customer getCustomerById(String id) throws ClassNotFoundException, SQLException{
         String sql = "SELECT * FROM customer WHERE nic = '"+id+"'" ;
         ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
         if (rst.next()){
         return new Customer(rst.getString(2), rst.getString(1), rst.getString(8), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7),rst.getString(9));
        }
       return null;
    }
    
    public static ResultSet getCustomer() throws ClassNotFoundException, SQLException{
         String sql = "SELECT nic,customerName,loyaltyCard,points FROM customer" ;
         ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
//         if (rst.next()){
//         return new Customer(rst.getString(2), rst.getString(1), rst.getString(8), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7),rst.getString(9));
//        }
       return rst;
    }
    
    public static ResultSet getInfoCustomerById(String id) throws ClassNotFoundException, SQLException{
        String sql = "SELECT nic,customerName,loyaltyCard,points FROM customer where nic = '"+id+"'" ;
         ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
//         if (rst.next()){
//         return new Customer(rst.getString(2), rst.getString(1), rst.getString(8), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7),rst.getString(9));
//        }
       return rst;
    }
    
    public static ResultSet getInfoCustomerByCardNo(String no) throws ClassNotFoundException, SQLException{
        String sql = "SELECT nic,customerName,loyaltyCard,points FROM customer where loyaltyCard = '"+no+"'" ;
         ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
//         if (rst.next()){
//         return new Customer(rst.getString(2), rst.getString(1), rst.getString(8), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7),rst.getString(9));
//        }
       return rst;
    }
    
    
    public static void addCustomer(Customer customer) throws ClassNotFoundException, SQLException{
         Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
         String addQuery = "INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pre_stm = connection.prepareStatement(addQuery);
            pre_stm.setString(1, customer.getNic());
            pre_stm.setString(2, customer.getName());
            pre_stm.setString(3, customer.getAddress());
            pre_stm.setString(4, customer.getDob());
            pre_stm.setString(5, customer.getTel());
            pre_stm.setString(6, customer.getEmail());
            pre_stm.setString(7, customer.getLoyaltyCard());
            pre_stm.setString(8, customer.getGender());
            pre_stm.setString(9, "0");
            
            int res = pre_stm.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Successfully Added");
                pre_stm.close();
            }
            connection.setAutoCommit(true);
    }
    
    public static void deleteCustomer(String customerId) throws ClassNotFoundException, SQLException{
        Connection connection = DbConnection.getInstance().getConnection();
       connection.setAutoCommit(false);
       try{
        String sql = "DELETE FROM customer WHERE nic = ?";
            PreparedStatement pre_stm = connection.prepareStatement(sql);
            pre_stm.setString(1, customerId);
            
            int res = pre_stm.executeUpdate();
            if (res > 0) {
                 JOptionPane.showMessageDialog(null,"Successfully Deleted");
                 pre_stm.close();
                }
       }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }
    
    public static void updateCustomer(Customer customer) throws ClassNotFoundException, SQLException{
         Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
         String addQuery = "UPDATE customer SET customerName = ?, address = ?, dob = ?, tel = ?, email = ?, loyaltyCard = ?, gender = ? WHERE nic = ?";
            PreparedStatement pre_stm = connection.prepareStatement(addQuery);
            
            pre_stm.setString(1, customer.getName());
            pre_stm.setString(2, customer.getAddress());
            pre_stm.setString(3, customer.getDob());
            pre_stm.setString(4, customer.getTel());
            pre_stm.setString(5, customer.getEmail());
            pre_stm.setString(6, customer.getLoyaltyCard());
            pre_stm.setString(7, customer.getGender());
            pre_stm.setString(8, customer.getNic());
            
            int res = pre_stm.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Successfully Updated");
                pre_stm.close();
            }
            connection.setAutoCommit(true);
    }
}
