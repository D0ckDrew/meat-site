package com.meatSite.meatSiteBackend.databaseModels;

import javax.persistence.*;

@Entity
@Table(name = "fence_from_receipts", schema = "meat_site_db", catalog = "")
public class FenceFromReceiptsModel {
    private Long id;
    private int materialReceiptsLogId;
    private int recyclingId;
    private double quantity;
    private MaterialReceiptsLogModel materialReceiptsLogByMaterialReceiptsLogId;
    private RecyclingModel recyclingByRecyclingId;

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
    @Column(name = "recyclingId")
    public int getRecyclingId() {
        return recyclingId;
    }

    public void setRecyclingId(int recyclingId) {
        this.recyclingId = recyclingId;
    }

    @Basic
    @Column(name = "quantity")
    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FenceFromReceiptsModel that = (FenceFromReceiptsModel) o;

        if (materialReceiptsLogId != that.materialReceiptsLogId) return false;
        if (recyclingId != that.recyclingId) return false;
        if (Double.compare(that.quantity, quantity) != 0) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + materialReceiptsLogId;
        result = 31 * result + recyclingId;
        temp = Double.doubleToLongBits(quantity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
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
    @JoinColumn(name = "recyclingId", referencedColumnName = "id", insertable = false, updatable = false)
    public RecyclingModel getRecyclingByRecyclingId() {
        return recyclingByRecyclingId;
    }

    public void setRecyclingByRecyclingId(RecyclingModel recyclingByRecyclingId) {
        this.recyclingByRecyclingId = recyclingByRecyclingId;
    }
}
