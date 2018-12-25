/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.Controller;

import inventory.db.DbConnection;
import inventory.models.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Sithara
 */
public class ItemController {

    public static ArrayList<String> getAllCategories() throws SQLException, ClassNotFoundException {

        String query = "SELECT categoryName FROM category";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        ArrayList<String> categoryList = new ArrayList<>();
        while (rst.next()) {
            categoryList.add(rst.getString(1));
        }
        return categoryList;
    }

    public static ArrayList<ArrayList<String>> getAllDetailCategories(String catName) throws SQLException, ClassNotFoundException {

        String query = "SELECT * FROM category where categoryName ='" + catName + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        ArrayList<ArrayList<String>> catDetails = new ArrayList<>();
        while (rst.next()) {
            ArrayList<String> tempList = new ArrayList<>();
            tempList.add(rst.getString(1));
            tempList.add(rst.getString(2));
            catDetails.add(tempList);
        }
        return catDetails;
    }

    public static ArrayList<ArrayList<String>> getAllDetailSubCategories(String subCatName) throws SQLException, ClassNotFoundException {

        String query = "SELECT * FROM subcategory where subCategoryName ='" + subCatName + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        ArrayList<ArrayList<String>> catDetails = new ArrayList<>();
        while (rst.next()) {
            ArrayList<String> tempList = new ArrayList<>();
            tempList.add(rst.getString(1));
            tempList.add(rst.getString(3));
            tempList.add(rst.getString(4));
            catDetails.add(tempList);
        }
        return catDetails;
    }

    public static ArrayList<String> getAllSubCategories() throws SQLException, ClassNotFoundException {

        String query = "SELECT subcategoryName FROM subcategory";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        ArrayList<String> subCategoryList = new ArrayList<>();
        while (rst.next()) {
            subCategoryList.add(rst.getString(1));
        }
        return subCategoryList;
    }

    public static ArrayList<String> getAllBrands() throws SQLException, ClassNotFoundException {

        String query = "SELECT brandName FROM brand";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        ArrayList<String> brandList = new ArrayList<>();
        while (rst.next()) {
            brandList.add(rst.getString(1));
        }
        return brandList;
    }

    public static ArrayList<String> getAllSuppliers() throws SQLException, ClassNotFoundException {

        String query = "SELECT supplierName FROM supplier";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        ArrayList<String> supplierList = new ArrayList<>();
        while (rst.next()) {
            supplierList.add(rst.getString(1));
        }
        return supplierList;
    }

    public static ArrayList<String> getRelatedSubCategories(String catName) throws SQLException, ClassNotFoundException {
        String query = "SELECT categoryId FROM category where categoryName = '" + catName + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        String catId = "";
        if (rst.next()) {
            catId = rst.getString(1);
        }

        String query1 = "SELECT subcategory.subcategoryName FROM subcategory WHERE categoryId = '" + catId + "'";
        rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query1);
        ArrayList<String> subCatList = new ArrayList<>();
        while (rst.next()) {
            subCatList.add(rst.getString(1));
        }
        rst.close();
        return subCatList;
    }

    public static List<String> getRelatedBrand(String catName) throws ClassNotFoundException, SQLException {
        String query = "SELECT categoryId FROM category where categoryName = '" + catName + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        String catId = "";
        if (rst.next()) {
            catId = rst.getString(1);
        }
        //   System.out.println("catId : "+ catId);
        String query1 = "SELECT subcategory.brandList FROM subcategory WHERE categoryId = '" + catId + "'";
        rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query1);

        List<String> brandList = new ArrayList();

        if (rst.next()) {
            String brands = rst.getString(1);
            brandList = Arrays.asList(brands.split(","));
        }
        // rst.close();
        return brandList;
    }

    public static String getItemId(String name) throws SQLException, ClassNotFoundException {

        String query = "SELECT itemId FROM item where itemName = '" + name + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        String itemId = "";
        if (rst.next()) {
            itemId = rst.getString(1);
        }
        return itemId;
    }
    
     public static ResultSet getItemById(String id) throws SQLException, ClassNotFoundException {
         
         String itemId = "IT" + id;
          String query1 = "SELECT itemName,itemId,amount,sellingPrice FROM item WHERE itemId = '" + itemId + "'";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(query1);

    }

    public static String getSubCategoryId(String name) throws SQLException, ClassNotFoundException {

        String query = "SELECT subcategoryId  FROM subcategory where subcategoryName = '" + name + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        String itemId = "";
        if (rst.next()) {
            itemId = rst.getString(1);
        }
        // rst.close();
        return itemId;
    }

    public static String getSupplierName(String id) throws SQLException, ClassNotFoundException {

        String query = "SELECT supplierName  FROM supplier where supplierId = '" + id + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        String supName = "";
        if (rst.next()) {
            supName = rst.getString(1);
        }
        // rst.close();
        return supName;
    }
    
    public static String getUnitSize(String itemId) throws ClassNotFoundException, SQLException{
        String query = "SELECT unit_size  FROM item where itemId = '" + itemId + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        String unitSize = "";
        if (rst.next()) {
            unitSize = rst.getString(1);
        }
        // rst.close();
        return unitSize;
    }
    
    public static String getPurchasePrice(String itemId) throws ClassNotFoundException, SQLException{
        String query = "SELECT purchasePrice  FROM item where itemId = '" + itemId + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        String purchasePrice = "";
        if (rst.next()) {
            purchasePrice = rst.getString(1);
        }
        // rst.close();
        return purchasePrice;
    }
    public static Item getForSearch(String itemName, String subCatName) throws SQLException, ClassNotFoundException {
        String subCatId = getSubCategoryId(subCatName);
        String query = "SELECT * FROM item where subcategoryId = '" + subCatId + "' OR itemName = '" + itemName + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        Item item = null;
        if (rst.next()) {
            item = new Item(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), getSupplierName(rst.getString(7)), rst.getString(8), rst.getString(9), rst.getString(10));
        }
        return item;
    }
    
    public static ResultSet getInfoForItemTable() throws ClassNotFoundException, SQLException {
        String sql = "SELECT itemName,itemId,amount FROM item";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }

     public static ResultSet getInfoForInfoTable() throws ClassNotFoundException, SQLException {
        String sql = "SELECT itemName,itemId,amount,purchasePrice,sellingPrice,status FROM item";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }
    
    public static ResultSet getInfoForInfoTableOFItem(String itemId) throws ClassNotFoundException, SQLException{
         String sql = "SELECT itemName,itemId,amount,purchasePrice,sellingPrice,status FROM item where itemId = '"+itemId+"'";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }
    
    public static ResultSet getInfoForInfoTableOFSubCategories(String subCatName)throws ClassNotFoundException, SQLException{
        String query = "SELECT subcategoryId FROM subcategory where subcategoryName = '" + subCatName + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        String subCatId = "";
        if (rst.next()) {
            subCatId = rst.getString(1);
        }
        rst.close();
        //   System.out.println("catId : "+ catId);
        String query1 = "SELECT itemName,itemId,amount,purchasePrice,sellingPrice,status FROM item WHERE subcategoryId = '" + subCatId + "'";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(query1);
    }
    
    public static ResultSet getInfoForInfoTableOFInvoiceSubCategories(String subCat) throws ClassNotFoundException, SQLException{
        String query = "SELECT subcategoryId FROM subcategory where subcategoryName = '" + subCat + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        String subCatId = "";
        if (rst.next()) {
            subCatId = rst.getString(1);
        }
        rst.close();
        //   System.out.println("catId : "+ catId);
        String query1 = "SELECT itemName,itemId,sellingPrice,amount FROM item WHERE subcategoryId = '" + subCatId + "'";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(query1);
    }
     
    public static int addItem(Item item) throws ClassNotFoundException, SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            Statement s = connection.createStatement();
            // Creating the Id
            ResultSet r = s.executeQuery("SELECT itemId AS rowCount FROM item ORDER BY itemId DESC LIMIT 1");
            String tempId;
            if (r.next()) {
                String countStr = r.getString("rowCount");
                String str = countStr.replaceAll("\\D+", "");
                int count = Integer.parseInt(str);
                //     System.out.println("Str "+ str+" Count "+count);
                //  int count = r.getInt("rowCount") ;
                int generatedSupplierId = count + 1;
                if (generatedSupplierId / 10 < 1) {
                    tempId = "IT00" + Integer.toString(generatedSupplierId);
                } else if (generatedSupplierId / 100 < 1) {
                    tempId = "IT0" + Integer.toString(generatedSupplierId);
                } else if (generatedSupplierId / 1000 < 1) {
                    tempId = "IT" + Integer.toString(generatedSupplierId);
                } else {
                    tempId = "IT" + Integer.toString(generatedSupplierId);
                }
            } else {
                tempId = "IT001";
            }
            // Getting the SubCategory Id
            String subCatId = "";
            ResultSet r2 = s.executeQuery("SELECT subcategoryId AS subId FROM subcategory where  subcategoryName = '" + item.getSubcategoryId() + "'");
            if (r2.next()) {
                subCatId = r2.getString("subId");
            }

            // Getting the Brand Id
            String brandId = "";
            ResultSet r3 = s.executeQuery("SELECT brandId AS brandId FROM brand where brandName = '" + item.getBrandId() + "'");
            if (r3.next()) {
                brandId = r3.getString("brandId");
            }
            String supId = "";
            ResultSet r4 = s.executeQuery("SELECT supplierId AS supplierId FROM supplier where supplierName = '" + item.getSupplierId() + "'");
            if (r4.next()) {
                supId = r4.getString("supplierId");
            }

            r2.close();
            r3.close();
            r4.close();
            r.close();
            s.close();
            //   System.out.println("temp ID " + tempId);

            String addQuery = "INSERT INTO item VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pre_stm = connection.prepareStatement(addQuery);
            pre_stm.setString(1, tempId);
            pre_stm.setString(2, subCatId);
            pre_stm.setString(3, brandId);
            pre_stm.setString(4, item.getItemName());
            pre_stm.setString(5, item.getQuantity());
            pre_stm.setString(6, item.getAmount());
            pre_stm.setString(7, supId);
            pre_stm.setString(8, item.getPurchasePrice());
            pre_stm.setString(9, item.getSellingPrice());
            pre_stm.setString(10, item.getStatus());

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

    public static void deleteItem(String itemName) throws ClassNotFoundException, SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            String sql = "DELETE FROM item WHERE itemName=?";
            PreparedStatement pre_stm = connection.prepareStatement(sql);
            pre_stm.setString(1, itemName);

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

    public static void updateItem(Item item) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            String sql = "DELETE FROM item WHERE itemName=?";
            PreparedStatement pre_stm = connection.prepareStatement(sql);
            pre_stm.setString(1, item.getItemName());

            int res = pre_stm.executeUpdate();
            if (res > 0) {
                //  JOptionPane.showMessageDialog(null, "Successfully Deleted");
                pre_stm.close();
                addItem(item);
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
