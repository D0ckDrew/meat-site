package com.meatSite.meatSiteBackend.deliveries.model;

import com.meatSite.meatSiteBackend.materialWarehouse.model.ReceiptElementModel;

import java.util.List;

public class AddedEntranceModel {
    private int deliveryId;
    private int receiptsReasonId;
    private List<ReceiptElementModel> receiptElements;

    public AddedEntranceModel() {
    }

    public AddedEntranceModel(int deliveryId, int receiptsReasonId, List<ReceiptElementModel> receiptElements) {
        this.deliveryId = deliveryId;
        this.receiptsReasonId = receiptsReasonId;
        this.receiptElements = receiptElements;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public List<ReceiptElementModel> getReceiptElements() {
        return receiptElements;
    }

    public void setReceiptElements(List<ReceiptElementModel> receiptElements) {
        this.receiptElements = receiptElements;
    }

    public int getReceiptsReasonId() {
        return receiptsReasonId;
    }

    public void setReceiptsReasonId(int receiptsReasonId) {
        this.receiptsReasonId = receiptsReasonId;
    }
}
