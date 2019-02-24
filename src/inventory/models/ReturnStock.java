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
public class ReturnStock {
    private String returnStockId;
    private String itemId;
    private String quantitiy;
    private String reason;
    private String date;
    private String status;
    private String lineTotal;

    public ReturnStock(String returnStockId, String itemId, String quantitiy, String reason, String date, String status, String lineTotal) {
        this.returnStockId = returnStockId;
        this.itemId = itemId;
        this.quantitiy = quantitiy;
        this.reason = reason;
        this.date = date;
        this.status = status;
        this.lineTotal = lineTotal;
    }

    
    public String getReturnStockId() {
        return returnStockId;
    }

    public void setReturnStockId(String returnStockId) {
        this.returnStockId = returnStockId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getQuantitiy() {
        return quantitiy;
    }

    public void setQuantitiy(String quantitiy) {
        this.quantitiy = quantitiy;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public String getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(String lineTotal) {
        this.lineTotal = lineTotal;
    }
    
    
}
