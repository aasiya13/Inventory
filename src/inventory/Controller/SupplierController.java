/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.Controller;

import inventory.db.DbConnection;
import inventory.models.Supplier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Sithara
 */
public class SupplierController {

    public static int addSupplier(Supplier supplier) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            Statement s = connection.createStatement();
            ResultSet r = s.executeQuery("SELECT supplierId AS rowCount FROM supplier ORDER BY supplierId DESC LIMIT 1");
            String tempId;
            if (r.next()) {
                String countStr = r.getString("rowCount");
                String str = countStr.replaceAll("\\D+", "");
                int count = Integer.parseInt(str);
                //     System.out.println("Str "+ str+" Count "+count);
                //  int count = r.getInt("rowCount") ;
                int generatedSupplierId = count + 1;
                if (generatedSupplierId / 10 < 1) {
                    tempId = "SUP00" + Integer.toString(generatedSupplierId);
                } else if (generatedSupplierId / 100 < 1) {
                    tempId = "SUP0" + Integer.toString(generatedSupplierId);
                } else if (generatedSupplierId / 1000 < 1) {
                    tempId = "SUP" + Integer.toString(generatedSupplierId);
                } else {
                    tempId = "SUP" + Integer.toString(generatedSupplierId);
                }
            } else {
                tempId = "SUP001";
            }
            r.close();
            s.close();
            System.out.println("temp ID " + tempId);

            String addQuery = "INSERT INTO supplier VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pre_stm = connection.prepareStatement(addQuery);
            pre_stm.setString(1, tempId);
            pre_stm.setString(2, supplier.getSupplierName());
            pre_stm.setString(3, supplier.getTeleNo());
            pre_stm.setString(4, supplier.getOfficialNo());
            pre_stm.setString(5, supplier.getEmail());
            pre_stm.setString(6, supplier.getContactName());
            pre_stm.setString(7, supplier.getSupplierAddress());

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

    public static ResultSet ListgetInfoForTable() throws SQLException, ClassNotFoundException {
        String sql = "SELECT supplierId,supplierName,teleNO,officialNo,email,contactName FROM supplier";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }

    public static Supplier getSupplier(String id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM supplier WHERE supplierId = '" + id + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
        if (rst.next()) {
            return new Supplier(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(7), rst.getString(4), rst.getString(5), rst.getString(6));
        }
        return null;
    }
    
     public static Supplier searchSupplier(String name) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM supplier WHERE supplierName = '" + name + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
        if (rst.next()) {
            return new Supplier(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(7), rst.getString(4), rst.getString(5), rst.getString(6));
        }
        return null;
    }
    
    
    public static void deleteSupplier(String supplierId) throws ClassNotFoundException, SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            String sql = "DELETE FROM supplier WHERE supplierId=?";
            PreparedStatement pre_stm = connection.prepareStatement(sql);
            pre_stm.setString(1, supplierId);

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

    public static int updateSupplier(Supplier supplier) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {

            String updateQuery = "UPDATE supplier SET supplierName=?,teleNO=?,officialNo=?, email=?,contactName=?,"
                    + "supplierAddress=? where supplierId =?";
            PreparedStatement pre_stm = connection.prepareStatement(updateQuery);

            pre_stm.setString(1, supplier.getSupplierName());
            pre_stm.setString(2, supplier.getTeleNo());
            pre_stm.setString(3, supplier.getOfficialNo());
            pre_stm.setString(4, supplier.getEmail());
            pre_stm.setString(5, supplier.getContactName());
            pre_stm.setString(6, supplier.getSupplierAddress());
            pre_stm.setString(7, supplier.getSupplierId());
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
