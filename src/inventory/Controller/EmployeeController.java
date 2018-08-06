/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.Controller;

import inventory.models.Employee;
import inventory.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Sithara
 */
public class EmployeeController {
    
    public static int addEmployee(Employee employee) throws SQLException, ClassNotFoundException {
       Connection connection = DbConnection.getInstance().getConnection();
       connection.setAutoCommit(false);
        try {
            Statement s = connection.createStatement();
            ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM employee");
            r.next();
            int count = r.getInt("rowcount") ;
            r.close() ;
            int generatedEmployeeId = count + 1;
            String tempId;
            if (generatedEmployeeId/10 < 1){
                tempId = "EM00"+Integer.toString(generatedEmployeeId);
            } 
            else if (generatedEmployeeId/100 < 1){
                tempId = "EM0"+Integer.toString(generatedEmployeeId);
            }
            else if (generatedEmployeeId/1000 < 1){
                tempId = "EM"+Integer.toString(generatedEmployeeId);
            }else{
                tempId = "EM"+Integer.toString(generatedEmployeeId);
            }      
            System.out.println("temp ID "+tempId);
          
            String addQuery = "INSERT INTO employee VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";     
            PreparedStatement pre_stm = connection.prepareStatement(addQuery);
            pre_stm.setString(1, tempId);
            pre_stm.setString(2, "");
            pre_stm.setString(3, employee.getEmployeeName());
            pre_stm.setString(4, employee.getGender());
            pre_stm.setString(5, employee.getCivilStatus());
            pre_stm.setString(6, employee.getAddress());
            pre_stm.setString(7, employee.getDateOfBirth());
            pre_stm.setString(8, employee.getNicNo());
            pre_stm.setString(9, employee.getMobileNo());
            pre_stm.setString(10, employee.getLandPhoneNo());
            pre_stm.setString(11, employee.getEmail());
            pre_stm.setString(12, employee.getDesignation());
            pre_stm.setString(13, employee.getAssignDate());
            pre_stm.setBytes(14, employee.getImg());

            int res = pre_stm.executeUpdate();
            if (res > 0) {
                 JOptionPane.showMessageDialog(null,"Successfully Added");
                 pre_stm.close();
                }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            connection.rollback();
            throw e;
        } finally {
            
            connection.setAutoCommit(true);
        }
  return 0;  }
}

