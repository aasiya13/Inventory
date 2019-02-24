/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.Controller;

import inventory.db.DbConnection;
import inventory.models.SubCategory;
import java.awt.List;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Sithara
 */
public class SubCategoryController {

    private static ArrayList<String> subList = new ArrayList<>();
    private static ArrayList<String> brandList = new ArrayList<>();

    public static ArrayList<String> getSubList() {
        return subList;
    }

    public static void addSubList(String value) {
        subList.add(value);
    }

    public static void addBrandList(String value) {
        brandList.add(value);
    }

    public static ArrayList<String> getBrandList() {
        return brandList;
    }

    public static void removeSubList(String value) {
        subList.remove(value);
    }

    public static void removeAll() {
        brandList.clear();
    }

    public static int addSubCategory(SubCategory subcategory) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            Statement s = connection.createStatement();
            ResultSet r = s.executeQuery("SELECT subcategoryId AS rowCount FROM subcategory ORDER BY subcategoryId DESC LIMIT 1");
            String tempId;
            if (r.next()) {
                String countStr = r.getString("rowCount");
                // reomve all the chracters except numbers
                String str = countStr.replaceAll("\\D+", "");
                int count = Integer.parseInt(str);
                //     System.out.println("Str "+ str+" Count "+count);
                //  int count = r.getInt("rowCount") ;
                int generatedSupplierId = count + 1;
                if (generatedSupplierId / 10 < 1) {
                    tempId = "SCAT00" + Integer.toString(generatedSupplierId);
                } else if (generatedSupplierId / 100 < 1) {
                    tempId = "SCAT0" + Integer.toString(generatedSupplierId);
                } else if (generatedSupplierId / 1000 < 1) {
                    tempId = "SCAT" + Integer.toString(generatedSupplierId);
                } else {
                    tempId = "SCAT" + Integer.toString(generatedSupplierId);
                }
            } else {
                tempId = "SCAT001";
            }
            r.close();
            s.close();

            Statement sm = connection.createStatement();
            ResultSet rm = sm.executeQuery("SELECT categoryId AS rowCount FROM category where categoryName = '" + subcategory.getCategoryId() + "'");
            String categoryId = "";
            if (rm.next()) {
                categoryId = rm.getString("rowCount");
            }

            rm.close();
            sm.close();
            String addQuery = "INSERT INTO subcategory VALUES(?,?,?,?)";
            PreparedStatement pre_stm = connection.prepareStatement(addQuery);
            pre_stm.setString(1, tempId);
            pre_stm.setString(2, categoryId);
            pre_stm.setString(3, subcategory.getSubcategoryName());
            // pre_stm.setArray(4,  subcategory.getBrandList());
            boolean processedFirst = false;
            String firstParam = null;
            StringBuilder buffer = new StringBuilder();

            try {
                for (String record : subcategory.getBrandList()) {
                    if (processedFirst) {
                        buffer.append(",");
                    }
                    buffer.append(record);
                    processedFirst = true;
                }
                firstParam = buffer.toString();
            } finally {
                buffer = null;
            }
            pre_stm.setObject(4, firstParam);
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
        String sql = "SELECT subcategory.subcategoryName,subcategory.subcategoryId,category.categoryName FROM category INNER JOIN subcategory ON subcategory.categoryId = category.categoryId ";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }
    
    
     public static SubCategory getSubCategory(String id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM subcategory WHERE subcategoryId = '" + id + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
        if (rst.next()) {
            ArrayList<String> items = new ArrayList<>(Arrays.asList((rst.getString(4)).split("\\s*,\\s*")));
            return new SubCategory(rst.getString(1), rst.getString(2), rst.getString(3),items);
        }
        return null;
    }
     
    public static String getSubCategoryNameByID(String id) throws SQLException, ClassNotFoundException {

        String query = "SELECT subcategoryName  FROM subcategory where subcategoryId = '" + id + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        String itemId = "";
        if (rst.next()) {
            itemId = rst.getString(1);
        }
        // rst.close();
        return itemId;
    }
    
    public static String getSubCategoryIdByName(String name) throws SQLException, ClassNotFoundException {

        String query = "SELECT subcategoryId  FROM subcategory where subcategoryName = '" + name + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        String itemId = "";
        if (rst.next()) {
            itemId = rst.getString(1);
        }
        // rst.close();
        return itemId;
    }
    
    
    public static String getCategoryNameBySubCategoryId(String id) throws ClassNotFoundException, SQLException{
        String query = "SELECT category.categoryName  FROM category join subcategory on subcategory.categoryId = category.categoryId where subcategory.subcategoryId = '" + id + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        String itemId = "";
        if (rst.next()) {
            itemId = rst.getString(1);
        }
        // rst.close();
        return itemId;
    }
    
}
