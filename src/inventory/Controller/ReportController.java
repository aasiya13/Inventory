/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.Controller;

import inventory.db.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sithara
 */
public class ReportController {
    public static ResultSet getInvoiceDetailsByDateforSailsReport(String fromDate, String toDate) throws ClassNotFoundException, SQLException{
        String sql = "SELECT invoice.invoiceId, invoice.customerId, invoice.date, invoice.total  FROM invoice where invoice.date between '"+fromDate+"' and '"+toDate+"'" ;
         ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
       return rst;
    }
    
    public static String getTotalSales(String fromDate, String toDate) throws ClassNotFoundException, SQLException{
    String query = "SELECT sum(invoice.total)  FROM invoice where invoice.date between '"+fromDate+"' and '"+toDate+"'" ;
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        String purchasePrice = "";
        if (rst.next()) {
            purchasePrice = rst.getString(1);
        }
        // rst.close();
        return purchasePrice;
    
    }
    
    public static ResultSet getGRNeDetailsBySupplierId(String id) throws ClassNotFoundException, SQLException{
         String sql = "SELECT purchaseorder.ItemId, item.itemName, purchaseorder.unitType, purchaseorder.date, purchaseorder.lineTotal FROM purchaseorder join item on purchaseorder.ItemId = item.itemId where item.supplierId = '"+id+"'" ;
         ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
       return rst;
        
    }
    
    public static String getTotalItem(String id) throws ClassNotFoundException, SQLException{
        String query = "SELECT sum(purchaseorder.lineTotal) FROM purchaseorder join item on purchaseorder.ItemId = item.itemId where item.supplierId = '"+id+"'" ;
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        String total = "";
        if (rst.next()) {
            total = rst.getString(1);
        }
        // rst.close();
        return total;
    }
}
