/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.Controller;

import inventory.db.Config;
import inventory.db.DbConnection;
import inventory.models.Brand;
import inventory.models.Employee;
import java.io.IOException;
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
public class BrandController {

    public static int addBrand(Brand brand) throws SQLException, ClassNotFoundException, IOException {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            Statement s = connection.createStatement();
            ResultSet r = s.executeQuery("SELECT brandId AS brandCount FROM brand ORDER BY brandId DESC LIMIT 1");
            int brandId = 0;
            if (!r.next()) {
                brandId = 1;
            } else {
                int count = r.getInt("brandCount");
                brandId = count + 1;
            }
            r.close();
            System.out.println(brandId);

            Statement sm = connection.createStatement();
            ResultSet rm = sm.executeQuery("SELECT * FROM brand where brandName = '" + brand.getBrandName() + "'");
            if (rm.next()) {
                JOptionPane.showMessageDialog(null, "The Brand is already in the List");
            } else {
                String addQuery = "INSERT INTO brand VALUES ('" + brandId + "'" + ",?)";

                PreparedStatement pre_stm = connection.prepareStatement(addQuery);
                pre_stm.setString(1, brand.getBrandName());

                int res = pre_stm.executeUpdate();
                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "Successfully Added");
                    pre_stm.close();
                }

            }
            rm.close();
            //  System.out.println("id "+id+" count: "+count);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            connection.rollback();
            throw e;
        } finally {

            connection.setAutoCommit(true);
        }
        return 0;
    }

    public static Brand getBrand(String name) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM brand WHERE brandName = '" + name + "'";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
        if (rst.next()) {
            return new Brand(rst.getString(1), rst.getString(2));
        }
        return null;
    }

    public static ArrayList<Brand> getAllBrands() throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM brand";
        ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(query);
        ArrayList<Brand> brandList = new ArrayList<>();
        while (rst.next()) {
            brandList.add(new Brand(rst.getString(1), rst.getString(2)));
        }
        return brandList;

    }

    public static ResultSet ListgetInfoForTable() throws SQLException, ClassNotFoundException {
        String sql = "SELECT brandName FROM brand";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }

    public static void deleteBrand(String brandName) throws SQLException, ClassNotFoundException {

        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            String sql = "DELETE FROM brand WHERE brandName=?";
            PreparedStatement pre_stm = connection.prepareStatement(sql);
            pre_stm.setString(1, brandName);

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
}
