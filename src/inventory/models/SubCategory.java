/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.models;

import java.util.ArrayList;

/**
 *
 * @author Sithara
 */
public class SubCategory {
    private String subcategoryId;
    private String categoryId;
    private String subcategoryName;
    private ArrayList<String> brandList;

    public SubCategory(String subcategoryId, String categoryId, String subcategoryName, ArrayList<String> brandList) {
        this.subcategoryId = subcategoryId;
        this.categoryId = categoryId;
        this.subcategoryName = subcategoryName;
        this.brandList = brandList;
    }

    public String getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public ArrayList<String> getBrandList() {
        return brandList;
    }

    public void setBrandList(ArrayList<String> brandList) {
        this.brandList = brandList;
    }

    @Override
    public String toString() {
        return "SubCategory{" + "subcategoryId=" + subcategoryId + ", categoryId=" + categoryId + ", subcategoryName=" + subcategoryName + ", brandList=" + brandList + '}';
    }
    
}
