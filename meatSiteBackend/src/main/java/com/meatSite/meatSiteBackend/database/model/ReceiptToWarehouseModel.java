package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "receipt_to_warehouse", schema = "meat_site_db", catalog = "")
public class ReceiptToWarehouseModel {
    private Long id;
    private Timestamp date;
    private Integer recyclingId;
    private Integer materialReceiptsLogId;

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
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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
    @Column(name = "material_receipts_log_id", nullable = false)
    public Integer getMaterialReceiptsLogId() {
        return materialReceiptsLogId;
    }

    public void setMaterialReceiptsLogId(Integer materialReceiptsLogId) {
        this.materialReceiptsLogId = materialReceiptsLogId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceiptToWarehouseModel that = (ReceiptToWarehouseModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (recyclingId != null ? !recyclingId.equals(that.recyclingId) : that.recyclingId != null) return false;
        if (materialReceiptsLogId != null ? !materialReceiptsLogId.equals(that.materialReceiptsLogId) : that.materialReceiptsLogId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (recyclingId != null ? recyclingId.hashCode() : 0);
        result = 31 * result + (materialReceiptsLogId != null ? materialReceiptsLogId.hashCode() : 0);
        return result;
    }
}
