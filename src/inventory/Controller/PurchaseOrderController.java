/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.Controller;

import inventory.db.DbConnection;
import inventory.models.PurchaseItem;
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
public class PurchaseOrderController {

    public static ResultSet getInfoForItemTable() throws ClassNotFoundException, SQLException {
        String sql = "SELECT itemName,itemId,amount,sellingPrice FROM item";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }
    
    public static ResultSet getInfoForItemTableReturnStock() throws ClassNotFoundException, SQLException {
        String sql = "SELECT itemName,itemId,amount,purchasePrice FROM item";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }
    
     public static ResultSet getInfoForPurchaseReport(String id) throws ClassNotFoundException, SQLException {
        String sql = "select purchase.supplierId, item.itemName, purchaseorder.itemId, purchaseorder.quantity, purchaseorder.unitPrice, purchaseorder.lineTotal from purchaseorder join purchase on purchaseorder.purchaseId = purchase.purchaseId join item on purchaseorder.itemId = item.itemId where purchaseorder.purchaseId = '"+id+"'";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }

    public static ResultSet getInfoForOrderTblByPurchase(String purchaseId) throws ClassNotFoundException, SQLException {
        String sql = "select item.itemName,purchaseorder.ItemId,purchaseorder.quantity,purchaseorder.unitType,purchaseOrder.unitPrice,purchaseOrder.lineTotal from purchaseOrder join item on purchaseOrder.ItemId = item.itemId where purchaseorder.purchaseId = '"+purchaseId+"'";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }

    public static ResultSet getInfoForPurcahseOrderTblTable() throws ClassNotFoundException, SQLException {
        String sql = "select distinct purchaseorder.purchaseId, purchaseorder.date, purchase.supplierId, purchase.status from purchaseorder join purchase on purchaseorder.purchaseId = purchase.purchaseId";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }
    
    public static ResultSet getInfoForPurcahseOrderTblTable(String id) throws ClassNotFoundException, SQLException {
        String sql = "select distinct purchaseorder.purchaseId, purchaseorder.date, purchase.supplierId, purchase.status from purchaseorder join purchase on purchaseorder.purchaseId = purchase.purchaseId where purchaseorder.purchaseId = '"+id+"'";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }


    public static ResultSet getInfoForItemTableSubCategories(String subCatName) throws ClassNotFoundException, SQLException {
        String query = "SELECT subcategoryId FROM subcategory where subcategoryName = '" + subCatName + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        String subCatId = "";
        if (rst.next()) {
            subCatId = rst.getString(1);
        }
        rst.close();
        //   System.out.println("catId : "+ catId);
        String query1 = "SELECT itemName,itemId,amount,sellingPrice FROM item WHERE subcategoryId = '" + subCatId + "'";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(query1);
    }

    public static String getPurchaseId() throws ClassNotFoundException, SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        Statement s = connection.createStatement();
        // Creating the Id
        ResultSet r = s.executeQuery("SELECT purchaseId AS rowCount FROM purchaseOrder ORDER BY purchaseId DESC LIMIT 1");
        String tempId;
        if (r.next()) {
            String countStr = r.getString("rowCount");
            String str = countStr.replaceAll("\\D+", "");
            int count = Integer.parseInt(str);
            //     System.out.println("Str "+ str+" Count "+count);
            //  int count = r.getInt("rowCount") ;
            int generatedSupplierId = count + 1;
            if (generatedSupplierId / 10 < 1) {
                tempId = "PUR00" + Integer.toString(generatedSupplierId);
            } else if (generatedSupplierId / 100 < 1) {
                tempId = "PUR0" + Integer.toString(generatedSupplierId);
            } else if (generatedSupplierId / 1000 < 1) {
                tempId = "PUR" + Integer.toString(generatedSupplierId);
            } else {
                tempId = "PUR" + Integer.toString(generatedSupplierId);
            }
        } else {
            tempId = "PUR001";
        }
        r.close();
        return tempId;
    }

    public static void addPurchase(ArrayList<PurchaseItem> purchaseItem) throws ClassNotFoundException, SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        int flag = 0;
        String uniqureKey = "";
        for (PurchaseItem purItem : purchaseItem) {
            Statement s = connection.createStatement();
            // Creating the Id

            String supplierId = "";
            ResultSet r2 = s.executeQuery("SELECT supplierId As supId FROM item where  itemId = '" + purItem.getItemId() + "'");
            if (r2.next()) {
                supplierId = r2.getString("supId");
            }

            r2.close();

            //  uniqureKey =  purItem.getPurchaseId();
            // add data to the purchaseOrder table
            String addPurchaseorder = "INSERT INTO purchaseorder VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pre_stm = connection.prepareStatement(addPurchaseorder);
            pre_stm.setString(1, purItem.getPurchaseId());
            pre_stm.setString(2, purItem.getItemId());
            pre_stm.setString(3, purItem.getDate());
            pre_stm.setString(4, purItem.getQunatity());
            pre_stm.setString(5, purItem.getUnitType());
            pre_stm.setString(6, purItem.getUnitPrice());
            pre_stm.setString(7, purItem.getLineTotal());
            pre_stm.setString(8, null);

            int res = pre_stm.executeUpdate();
            if (res > 0) {
                pre_stm.close();
            }
            // add data to purchase Table
            PreparedStatement pre_stm2 = null;
            if (!purItem.getPurchaseId().equals(uniqureKey)) {
                String addPurchase = "INSERT INTO purchase VALUES(?,?,?)";
                pre_stm2 = connection.prepareStatement(addPurchase);
                pre_stm2.setString(1, purItem.getPurchaseId());
                pre_stm2.setString(2, purItem.getStatus());
                pre_stm2.setString(3, supplierId);
                uniqureKey = purItem.getPurchaseId();
                res = pre_stm2.executeUpdate();
                if (res > 0) {
                    pre_stm2.close();
                }
            }

        }
        JOptionPane.showMessageDialog(null, "Added purchase Order");

        connection.setAutoCommit(true);
    }
}
