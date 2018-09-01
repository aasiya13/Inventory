/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.Controller;

import inventory.db.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
}
