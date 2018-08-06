/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.models;

/**
 *
 * @author Sithara
 */
public class Employee {
    private String employeeId;
    private String employeeName;
    private String gender;
    private String civilStatus;
    private String address;
    private String dateOfBirth;
    private String nicNo;
    private String landPhoneNo;
    private String mobileNo;
    private String email;
    private String designation;
    private String assignDate;
    private byte[] img = null;


    public Employee(String employeeId, String employeeName, String gender, String civilStatus, String address, String dateOfBirth, String nicNo, String landPhoneNo, String mobileNo, String email, String designation, String assignDate, byte[] img) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.gender = gender;
        this.civilStatus = civilStatus;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.nicNo = nicNo;
        this.landPhoneNo = landPhoneNo;
        this.mobileNo = mobileNo;
        this.email = email;
        this.designation = designation;
        this.assignDate = assignDate;
        this.img = img;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    public String getLandPhoneNo() {
        return landPhoneNo;
    }

    public void setLandPhoneNo(String landPhoneNo) {
        this.landPhoneNo = landPhoneNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(String assignDate) {
        this.assignDate = assignDate;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
    
}
