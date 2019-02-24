/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.Controller;

import inventory.db.DbConnection;
import inventory.models.Invoice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Sithara
 */
public class InvoiceController {

    public static ResultSet getInvoiceForInvoiceTable() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM invoice";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }
    
    public static String getTotalInvoice(String id) throws ClassNotFoundException, SQLException{
        String sql = "SELECT sum(lineTotal) As total FROM invoiceissue where invoiceId = '" + id + "'";
        ResultSet r = DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
        String countStr = "";
        if (r.next()) {
            countStr = r.getString("total");
            r.close();

            return countStr;
        }
        return countStr;
    }

    public static ResultSet getInvoiceDetailsByInvoiceId(String id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT invoiceissue.itemId, item.itemName, invoiceissue.quantity, invoiceissue.unitType, invoiceissue.price, invoiceissue.lineTotal FROM invoiceissue join item on invoiceissue.itemId = item.itemId where invoiceId = '" + id + "'";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }
    
    public static ResultSet getInvoiceByInvoiceId(String id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM invoice where invoiceId = '" + id + "'";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }
    
    public static ResultSet getInvoiceByDateRange(String fromDate, String toDate) throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM invoice where date between '" + fromDate + "' and '"+toDate+"'";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }

    public static int getCountInvoiceDetatilsByInvoiceId(String id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT count(*) As countInv FROM invoiceissue where invoiceId = '" + id + "'";
        ResultSet r = DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
        String countStr = "";
        if (r.next()) {
            countStr = r.getString("countInv");
            r.close();

            return Integer.parseInt(countStr);
        }
        return Integer.parseInt(countStr);
    }
    
    public static float getCurrentPoint(String id) throws ClassNotFoundException, SQLException{
        String sql = "SELECT points As countInv FROM customer where nic = '" + id + "'";
        ResultSet r = DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
        String countStr = "";
        if (r.next()) {
            countStr = r.getString("countInv");
            r.close();

            return Float.parseFloat(countStr);
        }
        return Float.parseFloat(countStr);
    }

    public static String getInvoiceId() throws ClassNotFoundException, SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        Statement s = connection.createStatement();
        // Creating the Id
        ResultSet r = s.executeQuery("SELECT invoiceId AS rowCount FROM invoice ORDER BY invoiceId DESC LIMIT 1");
        String tempId;
        if (r.next()) {
            String countStr = r.getString("rowCount");
            String str = countStr.replaceAll("\\D+", "");
            int count = Integer.parseInt(str);
            //     System.out.println("Str "+ str+" Count "+count);
            //  int count = r.getInt("rowCount") ;
            int generatedSupplierId = count + 1;
            if (generatedSupplierId / 10 < 1) {
                tempId = "INV00" + Integer.toString(generatedSupplierId);
            } else if (generatedSupplierId / 100 < 1) {
                tempId = "INV0" + Integer.toString(generatedSupplierId);
            } else if (generatedSupplierId / 1000 < 1) {
                tempId = "INV" + Integer.toString(generatedSupplierId);
            } else {
                tempId = "INV" + Integer.toString(generatedSupplierId);
            }
        } else {
            tempId = "INV001";
        }
        r.close();
        return tempId;
    }

    public static void addInvoice(ArrayList<Invoice> invoices) throws ClassNotFoundException, SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        int flag = 0;
        String uniqueKey = "";
        for (Invoice inv : invoices) {
            Statement s = connection.createStatement();
            // Creating the Id

            //  uniqureKey =  purItem.getPurchaseId();
            // add data to the purchaseOrder table
            String addPurchaseorder = "INSERT INTO invoiceIssue VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pre_stm = connection.prepareStatement(addPurchaseorder);
            pre_stm.setString(1, inv.getInvoiceId());
            pre_stm.setString(2, inv.getItemId());
            pre_stm.setString(3, inv.getQuantity());
            pre_stm.setString(4, inv.getUnitType());
            pre_stm.setString(5, inv.getPrice());
            pre_stm.setString(6, inv.getLineTotal());
            pre_stm.setString(7, null);

            int res = pre_stm.executeUpdate();
            if (res > 0) {
                pre_stm.close();
            }
            // add data to purchase Table
            PreparedStatement pre_stm2 = null;
            if (!inv.getInvoiceId().equals(uniqueKey)) {
                String addPurchase = "INSERT INTO invoice VALUES(?,?,?,?)";
                pre_stm2 = connection.prepareStatement(addPurchase);
                pre_stm2.setString(1, inv.getInvoiceId());
                pre_stm2.setString(2, inv.getDate());
                pre_stm2.setString(3, inv.getTotal());
                pre_stm2.setString(4, inv.getCustomerId());
                uniqueKey = inv.getInvoiceId();
                res = pre_stm2.executeUpdate();
                if (res > 0) {
                    pre_stm2.close();
                }
                
//                int total = Integer.parseInt(inv.getTotal());
//                if(total >= 1000){
//                    int points = total % 1000;
//                }
//                 String addPoints= "INSERT INTO invoice VALUES(?,?,?)";
//                pre_stm2 = connection.prepareStatement(addPurchase);
                
            }

        }
        JOptionPane.showMessageDialog(null, "Added Invoice");

        connection.setAutoCommit(true);
    }

    public static void updateItem(HashMap<String, String> itemMap) throws ClassNotFoundException, SQLException {
        Iterator it = itemMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            String query = "SELECT amount FROM item where itemId = '" + pair.getKey() + "'";
            ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
            String amount = "";
            if (rst.next()) {
                amount = rst.getString(1);
            }
            rst.close();

            int currentAmount = Integer.parseInt(amount) - Integer.parseInt((String) pair.getValue());

            if (currentAmount < 0) {
                JOptionPane.showMessageDialog(null, "Item: " + pair.getKey() + "is out of Stock ");
                currentAmount = 0;
            }

            Connection connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            String updateQuery = "UPDATE item SET amount=? where itemId =?";
            PreparedStatement pre_stm = connection.prepareStatement(updateQuery);

            pre_stm.setString(1, Integer.toString(currentAmount));
            pre_stm.setString(2, (String) pair.getKey());
            int res = pre_stm.executeUpdate();
            if (res > 0) {
                pre_stm.close();
            }
            connection.setAutoCommit(true);
        }
    }
    
    public static void addPoint(String total, String id) throws ClassNotFoundException, SQLException{
        Connection connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            String updateQuery = "UPDATE customer SET points=? where nic =?";
            PreparedStatement pre_stm = connection.prepareStatement(updateQuery);

            pre_stm.setString(1, total);
            pre_stm.setString(2, id);
            int res = pre_stm.executeUpdate();
            if (res > 0) {
                pre_stm.close();
            }
            connection.setAutoCommit(true);
    }
    
     public static void updateTotalInotPoint(String id, String total) throws ClassNotFoundException, SQLException{
        Connection connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            String updateQuery = "UPDATE invoice SET total=? where invoiceId =?";
            PreparedStatement pre_stm = connection.prepareStatement(updateQuery);

            pre_stm.setString(1, total);
            pre_stm.setString(2, id);
            int res = pre_stm.executeUpdate();
            System.out.println(id);
            if (res > 0) {
                
                JOptionPane.showMessageDialog(null, "Successfully Paid Points");
                pre_stm.close();
            }
            connection.setAutoCommit(true);
    }
}
