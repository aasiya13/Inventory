/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.Controller;

import inventory.db.DbConnection;
import inventory.models.Category;
import inventory.models.Employee;
import java.awt.HeadlessException;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Sithara
 */
public class CategoryController {

    public static int addCategory(Category category) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            String addQuery = "INSERT INTO category VALUES(?,?)";
            PreparedStatement pre_stm = connection.prepareStatement(addQuery);

            pre_stm.setString(1, category.getCategoryCode());
            pre_stm.setString(2, category.getCategoryName());

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

    public static Category getCategory(String cateId) throws ClassNotFoundException, SQLException {
        String sql = "select * from category where categoryId = '" + cateId + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
        if (rst.next()) {
            return new Category(rst.getString(1), rst.getString(2));
        }
        return null;
    }

    public static Category getCategory(String searchName, String categoryId) {
        String sql = "";
        try {
            if (!searchName.equals("") && !categoryId.equals("")) {
                sql = "select * from category where name ='" + searchName + "'" + "and categoryId ='" + categoryId + "'";
            } else if (!categoryId.equals("")&& searchName.equals("")) {
                sql = "select * from category where categoryId ='" + categoryId + "'";
            } else if (!searchName.equals("")&& categoryId.equals("")) {
                sql = "select * from category where name ='" + searchName + "'";
            }
            ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
            if (rst.next()) {
                return new Category(rst.getString(1), rst.getString(2));
            } else {
                JOptionPane.showMessageDialog(null, "Search content does not match");
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
             JOptionPane.showMessageDialog(null,e);
        } return null;
    }
    
    public static ArrayList<Category> getAllCategory() throws SQLException, ClassNotFoundException{
        
        String query = "SELECT * FROM category";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
       ArrayList<Category> categoryList = new ArrayList<>();
        while (rst.next()){
            categoryList.add(new Category(rst.getString(1),rst.getString(2)));
        }
        return categoryList;
    }

    public static int updateCategory(Category cate) throws ClassNotFoundException, SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            String updateQuery = "UPDATE category SET name=? where categoryId = ?";
            PreparedStatement pre_stm = connection.prepareStatement(updateQuery);

            //  pre_stm.setString(1, cate.getCategoryCode());
            pre_stm.setString(1, cate.getCategoryName());
            pre_stm.setString(2, cate.getCategoryCode());

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

    public static void deleteCategory(String categoryId) throws ClassNotFoundException, SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            String sql = "DELETE FROM category WHERE categoryId=?";
            PreparedStatement pre_stm = connection.prepareStatement(sql);
            pre_stm.setString(1, categoryId);

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

    public static ResultSet ListgetInfoForTable() throws SQLException, ClassNotFoundException {
        String sql = "select * from category";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }
}
