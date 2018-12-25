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
import javax.swing.JOptionPane;

/**
 *
 * @author Sithara
 */
public class InvoiceController {
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
    
    public static void addInvoice(ArrayList<Invoice> invoices) throws ClassNotFoundException, SQLException{
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        int flag = 0;
        String uniqueKey = "";
        for (Invoice inv: invoices) {
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
                String addPurchase = "INSERT INTO invoice VALUES(?,?,?)";
                pre_stm2 = connection.prepareStatement(addPurchase);
                pre_stm2.setString(1, inv.getInvoiceId());
                pre_stm2.setString(2, inv.getDate());
                pre_stm2.setString(3, inv.getTotal());
                uniqueKey = inv.getInvoiceId();
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
