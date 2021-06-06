package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;

@Entity
@Table(name = "fence_from_receipts", schema = "meat_site_db", catalog = "")
public class FenceFromReceiptsModel {
    private Long id;
    private Integer materialReceiptsLogId;
    private Integer recyclingId;
    private Double quantity;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "material_receipts_log_id", nullable = false)
    public Integer getMaterialReceiptsLogId() {
        return materialReceiptsLogId;
    }

    public void setMaterialReceiptsLogId(Integer materialReceiptsLogId) {
        this.materialReceiptsLogId = materialReceiptsLogId;
    }

    @Basic
    @Column(name = "recycling_id", nullable = false)
    public Integer getRecyclingId() {
        return recyclingId;
    }

    public void setRecyclingId(Integer recyclingId) {
        this.recyclingId = recyclingId;
    }

    @Basic
    @Column(name = "quantity", nullable = false, precision = 3)
    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FenceFromReceiptsModel that = (FenceFromReceiptsModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (materialReceiptsLogId != null ? !materialReceiptsLogId.equals(that.materialReceiptsLogId) : that.materialReceiptsLogId != null)
            return false;
        if (recyclingId != null ? !recyclingId.equals(that.recyclingId) : that.recyclingId != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (materialReceiptsLogId != null ? materialReceiptsLogId.hashCode() : 0);
        result = 31 * result + (recyclingId != null ? recyclingId.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
