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
public class Supplier {
    private String supplierId;
    private String supplierName;
    private String supplierAddress;
    private String teleNo;
    private String officialNo;
    private String email;
    private String contactName;

    public Supplier(String supplierId, String supplierName, String supplierAddress, String teleNo, String officialNo, String email, String contactName) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.teleNo = teleNo;
        this.officialNo = officialNo;
        this.email = email;
        this.contactName = contactName;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getTeleNo() {
        return teleNo;
    }

    public void setTeleNo(String teleNo) {
        this.teleNo = teleNo;
    }

    public String getOfficialNo() {
        return officialNo;
    }

    public void setOfficialNo(String officialNo) {
        this.officialNo = officialNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @Override
    public String toString() {
        return "Supplier{" + "supplierId=" + supplierId + ", supplierName=" + supplierName + ", teleNo=" + teleNo + ", officialNo=" + officialNo + ", email=" + email + ", contactName=" + contactName + '}';
    }
    
}
