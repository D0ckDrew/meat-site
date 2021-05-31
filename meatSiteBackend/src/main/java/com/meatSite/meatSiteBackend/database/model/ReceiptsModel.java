package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;

@Entity
@Table(name = "receipts", schema = "meat_site_db", catalog = "")
public class ReceiptsModel {
    private Long id;
    private Integer materialReceiptsLogId;
    private Integer deliveryId;
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
    public Integer getMaterialReceiptsLogId() {
        return materialReceiptsLogId;
    }

    public void setMaterialReceiptsLogId(Integer materialReceiptsLogId) {
        this.materialReceiptsLogId = materialReceiptsLogId;
    }

    @Basic
    @Column(name = "deliveryId")
    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceiptsModel that = (ReceiptsModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (materialReceiptsLogId != null ? !materialReceiptsLogId.equals(that.materialReceiptsLogId) : that.materialReceiptsLogId != null)
            return false;
        if (deliveryId != null ? !deliveryId.equals(that.deliveryId) : that.deliveryId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (materialReceiptsLogId != null ? materialReceiptsLogId.hashCode() : 0);
        result = 31 * result + (deliveryId != null ? deliveryId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "materialReceiptsLogId", referencedColumnName = "id", insertable = false, updatable = false)
    public MaterialReceiptsLogModel getMaterialReceiptsLogByMaterialReceiptsLogId() {
        return materialReceiptsLogByMaterialReceiptsLogId;
    }

    public void setMaterialReceiptsLogByMaterialReceiptsLogId(MaterialReceiptsLogModel materialReceiptsLogByMaterialReceiptsLogId) {
        this.materialReceiptsLogByMaterialReceiptsLogId = materialReceiptsLogByMaterialReceiptsLogId;
    }

    @ManyToOne
    @JoinColumn(name = "deliveryId", referencedColumnName = "id", insertable = false, updatable = false)
    public DeliveryModel getDeliveryByDeliveryId() {
        return deliveryByDeliveryId;
    }

    public void setDeliveryByDeliveryId(DeliveryModel deliveryByDeliveryId) {
        this.deliveryByDeliveryId = deliveryByDeliveryId;
    }
}
