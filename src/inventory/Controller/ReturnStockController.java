/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.Controller;

import inventory.db.DbConnection;
import inventory.models.ReturnStock;
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
public class ReturnStockController {
    public static String getReturnStockId() throws ClassNotFoundException, SQLException{
           Connection connection = DbConnection.getInstance().getConnection();

        Statement s = connection.createStatement();
        // Creating the Id
        ResultSet r = s.executeQuery("SELECT returnStockId AS rowCount FROM returnStock ORDER BY returnStockId DESC LIMIT 1");
        String tempId;
        if (r.next()) {
            String countStr = r.getString("rowCount");
            String str = countStr.replaceAll("\\D+", "");
            int count = Integer.parseInt(str);
            //     System.out.println("Str "+ str+" Count "+count);
            //  int count = r.getInt("rowCount") ;
            int generatedSupplierId = count + 1;
            if (generatedSupplierId / 10 < 1) {
                tempId = "GRN00" + Integer.toString(generatedSupplierId);
            } else if (generatedSupplierId / 100 < 1) {
                tempId = "GRN0" + Integer.toString(generatedSupplierId);
            } else if (generatedSupplierId / 1000 < 1) {
                tempId = "GRN" + Integer.toString(generatedSupplierId);
            } else {
                tempId = "GRN" + Integer.toString(generatedSupplierId);
            }
        } else {
            tempId = "GRN001";
        }
        r.close();
        return tempId;
    }
    
    public static ResultSet getInfoForReturnTable() throws ClassNotFoundException, SQLException{
         String sql = "select returnStock.returnStockId, returnStock.date, sum(returnStockItem.lineTotal) as GRNTotal from returnStockItem join returnStock on returnStockItem.returnStockId = returnStock.returnStockId  group by returnStock.returnStockId";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }
    
    public static String getStatusById(String itemId, String grnId) throws ClassNotFoundException, SQLException{
        String query = "SELECT status  FROM returnstockitem where  itemId = '" + itemId + "' and returnStockId = '"+grnId+"'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        String status = "";
        if (rst.next()) {
            status = rst.getString(1);
        }
        // rst.close();
        return status;
    }
    
    public static ResultSet getInfoForReturnTable(String id) throws ClassNotFoundException, SQLException{
         String sql = "select returnStock.returnStockId, returnStock.date, sum(returnStockItem.lineTotal) as GRNTotal from returnStockItem join returnStock on returnStockItem.returnStockId = returnStock.returnStockId where returnStockItem.returnStockId = '"+id+"' group by returnStock.returnStockId";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }
    
    public static ResultSet getInfoForReturnTableClick(String grnId) throws ClassNotFoundException, SQLException{
         String sql = "select returnstockitem.itemId, item.itemId, returnstockitem.quantity, returnstockitem.reason from returnStockItem join item on returnStockItem.itemId = item.itemId where returnStockId = '"+grnId+"'";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }
    
    public static void addReturnStock(ArrayList<ReturnStock> returnStock) throws ClassNotFoundException, SQLException{
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        int once = 0;
        for (ReturnStock rts : returnStock) {
          //  Statement s = connection.createStatement();
            
             String addreturnStockItem = "INSERT INTO returnStockItem VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pre_stm = connection.prepareStatement(addreturnStockItem);
            pre_stm.setString(1, null);
            pre_stm.setString(2, rts.getReturnStockId());
            pre_stm.setString(3, rts.getItemId());
            pre_stm.setString(4, rts.getQuantitiy());
            pre_stm.setString(5, rts.getStatus());
            pre_stm.setString(6, rts.getLineTotal());
            pre_stm.setString(7, rts.getReason());
            int res = pre_stm.executeUpdate();
            if (res > 0) {
                pre_stm.close();
            }
            if(once == 0){
            String addReturnStock = "INSERT INTO returnStock VALUES(?,?)";
                PreparedStatement pre_stm2 = connection.prepareStatement(addReturnStock);
                pre_stm2.setString(1, rts.getReturnStockId());
                pre_stm2.setString(2, rts.getDate());
                
                res = pre_stm2.executeUpdate();
                if (res > 0) {
                    pre_stm2.close();
                }
            }
            once = 1;
        }
        JOptionPane.showMessageDialog(null, "Added Return Stock Details");
        connection.setAutoCommit(true);
    }
    
    public static void deleteGrnById(String id) throws ClassNotFoundException, SQLException{
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            String sql = "DELETE FROM returnstockitem WHERE returnStockId=?";
            PreparedStatement pre_stm = connection.prepareStatement(sql);
            pre_stm.setString(1, id);
            int res = pre_stm.executeUpdate();
           
            sql = "DELETE FROM returnStock WHERE returnStockId=?";
            PreparedStatement pre_stm1 = connection.prepareStatement(sql);
            pre_stm1.setString(1, id);

            if(pre_stm1.executeUpdate() > 0 && res > 0 ){
                pre_stm.close();
                pre_stm1.close();
                JOptionPane.showMessageDialog(null, "Successfully Deleted");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
