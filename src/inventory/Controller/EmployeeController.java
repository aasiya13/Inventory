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
    
    public static ResultSet ListgetInfoForTable() throws SQLException, ClassNotFoundException{
        String sql = "select employeeId,name,designation,mobileno,email from employee";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }
    
    public static ResultSet ListgetInfoForTable(String employeeID) throws SQLException, ClassNotFoundException{
        String sql = "select employeeId,name,designation,mobileno,email from employee where employeeId = '"+employeeID+"'";
        return DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
    }
    
    public static Employee getEmployee(String id) throws ClassNotFoundException, SQLException{
        String sql = "select * from employee where employeeId = '"+id+"'" ;
         ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
         if (rst.next()){
         return new Employee(rst.getString(1), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getString(11), rst.getString(12), rst.getString(13), rst.getBytes(14));
        }
       return null;
    }
    
    public static Employee getEmployee(String name, String employeeId, String des ) throws ClassNotFoundException, SQLException{
     
        String sql = "";
        
        try{
            
            if(!name.equals("")&&!employeeId.equals("")&&!des.equals(""))
                sql = "select * from employee where designation = '"+des+"'"+" and name ='"+name+"'"+"and employeeId ='"+employeeId+"'";
            else if(!name.equals("")&&!employeeId.equals(""))
                sql = "select * from employee where name ='"+name+"'"+"and employeeId ='"+employeeId+"'";
            else if(!employeeId.equals("")&&!des.equals(""))
                sql = "select * from employee where designation ='"+des+"'"+"and employeeId ='"+employeeId+"'";
            else if(!name.equals("")&&!des.equals(""))
                sql = "select * from employee where designation = '"+des+"'"+" and name ='"+name+"'";
            else if(!name.equals(""))
                sql = "select * from employee where name = '"+name+"'";
            else if(!employeeId.equals(""))
                sql = "select * from employee where employeeId = '"+employeeId+"'";
            else if(!des.equals(""))
                sql = "select * from employee where designation = '"+des+"'";
           
        
            ResultSet rst = DbConnection.getInstance().getConnection().createStatement().executeQuery(sql);
            if (rst.next()){
                return new Employee(rst.getString(1), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getString(11), rst.getString(12), rst.getString(13), rst.getBytes(14));
            }else{
                 JOptionPane.showMessageDialog(null,"Search content does not match");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
       return null;
    }
    public static int updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
       Connection connection = DbConnection.getInstance().getConnection();
       connection.setAutoCommit(false);
        try {
          
            String addQuery = "UPDATE employee SET name=?,gender=?,civilStatus=?,address=?,dateOfBirth=?,"
                    +"nic=?,mobileNo=?,landNo=?,email=?,designation=?,assignDate=?,img=? where employeeId =?";     
            PreparedStatement pre_stm = connection.prepareStatement(addQuery);
         
            pre_stm.setString(1, employee.getEmployeeName());
            pre_stm.setString(2, employee.getGender());
            pre_stm.setString(3, employee.getCivilStatus());
            pre_stm.setString(4, employee.getAddress());
            pre_stm.setString(5, employee.getDateOfBirth());
            pre_stm.setString(6, employee.getNicNo());
            pre_stm.setString(7, employee.getMobileNo());
            pre_stm.setString(8, employee.getLandPhoneNo());
            pre_stm.setString(9, employee.getEmail());
            pre_stm.setString(10, employee.getDesignation());
            pre_stm.setString(11, employee.getAssignDate());
            pre_stm.setBytes(12, employee.getImg());
            pre_stm.setString(13, employee.getEmployeeId());

            int res = pre_stm.executeUpdate();
            if (res > 0) {
                 JOptionPane.showMessageDialog(null,"Successfully Updated");
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

