package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "fence_from_warehouse", schema = "meat_site_db", catalog = "")
public class FenceFromWarehouseModel {
    private Long id;
    private Timestamp date;
    private Integer recyclingId;
    private Integer materialExpenseLogId;
    private RecyclingModel recyclingByRecyclingId;
    private MaterialExpenseLogModel materialExpenseLogByMaterialExpenseLogId;

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
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "recyclingId")
    public Integer getRecyclingId() {
        return recyclingId;
    }

    public void setRecyclingId(Integer recyclingId) {
        this.recyclingId = recyclingId;
    }

    @Basic
    @Column(name = "materialExpenseLogId")
    public Integer getMaterialExpenseLogId() {
        return materialExpenseLogId;
    }

    public void setMaterialExpenseLogId(Integer materialExpenseLogId) {
        this.materialExpenseLogId = materialExpenseLogId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FenceFromWarehouseModel that = (FenceFromWarehouseModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (recyclingId != null ? !recyclingId.equals(that.recyclingId) : that.recyclingId != null) return false;
        if (materialExpenseLogId != null ? !materialExpenseLogId.equals(that.materialExpenseLogId) : that.materialExpenseLogId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (recyclingId != null ? recyclingId.hashCode() : 0);
        result = 31 * result + (materialExpenseLogId != null ? materialExpenseLogId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "recyclingId", referencedColumnName = "id", insertable = false, updatable = false)
    public RecyclingModel getRecyclingByRecyclingId() {
        return recyclingByRecyclingId;
    }

    public void setRecyclingByRecyclingId(RecyclingModel recyclingByRecyclingId) {
        this.recyclingByRecyclingId = recyclingByRecyclingId;
    }

    @ManyToOne
    @JoinColumn(name = "materialExpenseLogId", referencedColumnName = "id", insertable = false, updatable = false)
    public MaterialExpenseLogModel getMaterialExpenseLogByMaterialExpenseLogId() {
        return materialExpenseLogByMaterialExpenseLogId;
    }

    public void setMaterialExpenseLogByMaterialExpenseLogId(MaterialExpenseLogModel materialExpenseLogByMaterialExpenseLogId) {
        this.materialExpenseLogByMaterialExpenseLogId = materialExpenseLogByMaterialExpenseLogId;
    }
}
