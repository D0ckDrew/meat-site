package com.meatSite.meatSiteBackend.databaseModels;

import javax.persistence.*;

@Entity
@Table(name = "receipts", schema = "meat_site_db", catalog = "")
public class ReceiptsModel {
    private Long id;
    private int materialReceiptsLogId;
    private int deliveryId;
    private MaterialReceiptsLogModel materialReceiptsLogByMaterialReceiptsLogId;
    private DeliveryModel deliveryByDeliveryId;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "materialReceiptsLogId")
    public int getMaterialReceiptsLogId() {
        return materialReceiptsLogId;
    }

    public void setMaterialReceiptsLogId(int materialReceiptsLogId) {
        this.materialReceiptsLogId = materialReceiptsLogId;
    }

    @Basic
    @Column(name = "deliveryId")
    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceiptsModel that = (ReceiptsModel) o;

        if (materialReceiptsLogId != that.materialReceiptsLogId) return false;
        if (deliveryId != that.deliveryId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + materialReceiptsLogId;
        result = 31 * result + deliveryId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "materialReceiptsLogId", referencedColumnName = "id", nullable = false)
    public MaterialReceiptsLogModel getMaterialReceiptsLogByMaterialReceiptsLogId() {
        return materialReceiptsLogByMaterialReceiptsLogId;
    }

    public void setMaterialReceiptsLogByMaterialReceiptsLogId(MaterialReceiptsLogModel materialReceiptsLogByMaterialReceiptsLogId) {
        this.materialReceiptsLogByMaterialReceiptsLogId = materialReceiptsLogByMaterialReceiptsLogId;
    }

    @ManyToOne
    @JoinColumn(name = "deliveryId", referencedColumnName = "id", nullable = false)
    public DeliveryModel getDeliveryByDeliveryId() {
        return deliveryByDeliveryId;
    }

    public void setDeliveryByDeliveryId(DeliveryModel deliveryByDeliveryId) {
        this.deliveryByDeliveryId = deliveryByDeliveryId;
    }
}
