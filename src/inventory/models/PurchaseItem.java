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
public class PurchaseItem {
    private String purchaseId;
    private String itemId;
    private String date;
    private String status;
    private String supplierId;
    private String qunatity;
    private String unitType;
    private String unitPrice;
    private String lineTotal;

    public PurchaseItem(String purchaseId, String itemId, String date, String status, String supplierId, String qunatity, String unitType, String unitPrice, String lineTotal) {
        this.purchaseId = purchaseId;
        this.itemId = itemId;
        this.date = date;
        this.status = status;
        this.supplierId = supplierId;
        this.qunatity = qunatity;
        this.unitType = unitType;
        this.unitPrice = unitPrice;
        this.lineTotal = lineTotal;
    }

    

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getQunatity() {
        return qunatity;
    }

    public void setQunatity(String qunatity) {
        this.qunatity = qunatity;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(String lineTotal) {
        this.lineTotal = lineTotal;
    }
    
    
    
}
