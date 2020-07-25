/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entity;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import org.json.JSONObject;

/**
 *
 * @author ahza0
 */
public class Products {
    private int productID;
    private String productName;
    private int supplierID;
    private int categoryID;
    private String quantityPerUnit;
    private BigDecimal unitPrice;
    private int unitsInStock;
    private int unitsOnOrder;
    private int reorderLevel;
    private boolean discontinued;

    public Products() {
    }

    public Products(JSONObject json) {
        this.productID = json.optInt("productID", 0);
        this.productName = json.optString("productName", "");
        this.supplierID = json.optInt("supplierID", 0);
        this.categoryID = json.optInt("categoryID", 0);
        this.quantityPerUnit = json.optString("quantityPerUnit", "");
        this.unitPrice = json.optBigDecimal("unitPrice", BigDecimal.ZERO);
        this.unitsInStock = json.optInt("unitsInStock", 0);
        this.unitsOnOrder = json.optInt("unitsOnOrder", 0);
        this.reorderLevel = json.optInt("reorderLevel", 0);
        this.discontinued = json.optBoolean("discontinued", false);
    }
    
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("productID", productID);
        json.put("productName", productName);
        json.put("supplierID", supplierID);
        json.put("categoryID", categoryID);
        json.put("quantityPerUnit", quantityPerUnit);
        json.put("unitPrice", unitPrice);
        json.put("unitsInStock", unitsInStock);
        json.put("unitsOnOrder", unitsOnOrder);
        json.put("reorderLevel", reorderLevel);
        json.put("discontinued", discontinued);
        return json;
    }
    
    private DecimalFormat df = new DecimalFormat("###,###.##");
    public Object getValue(int index){
        switch(index){
            case 0: return productID;
            case 1: return productName;
            case 2: return supplierID;
            case 3: return categoryID;
            case 4: return quantityPerUnit;
            case 5: return df.format(unitPrice);
            case 6: return unitsInStock;
            case 7: return discontinued;
            case 8: return reorderLevel;
            case 9: return discontinued;
            default: return null;
        }
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public int getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(int unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }
    
}
