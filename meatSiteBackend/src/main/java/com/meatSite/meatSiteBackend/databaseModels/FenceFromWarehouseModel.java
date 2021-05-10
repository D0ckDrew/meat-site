package com.meatSite.meatSiteBackend.databaseModels;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "fence_from_warehouse", schema = "meat_site_db", catalog = "")
public class FenceFromWarehouseModel {
    private Long id;
    private Timestamp date;
    private int recyclingId;
    private int materialExpenseLogId;
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
    public int getRecyclingId() {
        return recyclingId;
    }

    public void setRecyclingId(int recyclingId) {
        this.recyclingId = recyclingId;
    }

    @Basic
    @Column(name = "materialExpenseLogId")
    public int getMaterialExpenseLogId() {
        return materialExpenseLogId;
    }

    public void setMaterialExpenseLogId(int materialExpenseLogId) {
        this.materialExpenseLogId = materialExpenseLogId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FenceFromWarehouseModel that = (FenceFromWarehouseModel) o;

        if (recyclingId != that.recyclingId) return false;
        if (materialExpenseLogId != that.materialExpenseLogId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + recyclingId;
        result = 31 * result + materialExpenseLogId;
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
