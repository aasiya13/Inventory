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
public class Invoice {
    private String invoiceId;
    private String itemId;
    private String quantity;
    private String unitType;
    private String price;
    private String lineTotal;
    private String date;
    private String total;
    private String customerId;

    public Invoice(String invoiceId, String itemId, String quantity, String unitType, String price, String lineTotal, String date, String total, String customerId) {
        this.invoiceId = invoiceId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.unitType = unitType;
        this.price = price;
        this.lineTotal = lineTotal;
        this.date = date;
        this.total = total;
        this.customerId = customerId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(String lineTotal) {
        this.lineTotal = lineTotal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    
    
}
