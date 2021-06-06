package com.meatSite.meatSiteBackend.materialWarehouse.model;

public class ReceiptElementModel {
    private int materialId;
    private Double count;

    public ReceiptElementModel(int materialId, Double count) {
        this.materialId = materialId;
        this.count = count;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }
}
