package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "material_receipts_log", schema = "meat_site_db", catalog = "")
public class MaterialReceiptsLogModel {
    private Long id;
    private Double quantity;
    private Double quantityRemains;
    private Timestamp date;
    private Integer materialId;
    private Integer materialReceiptsReasonId;
    private Integer userId;

    private MaterialModel materialByMaterialId;
    private MaterialReceiptsReasonModel materialReceiptsReasonById;

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
    @Column(name = "quantity", nullable = false, precision = 3)
    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "quantity_remains", nullable = false, precision = 3)
    public Double getQuantityRemains() {
        return quantityRemains;
    }

    public void setQuantityRemains(Double quantityRemains) {
        this.quantityRemains = quantityRemains;
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
    @Column(name = "material_id", nullable = false)
    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    @Basic
    @Column(name = "material_receipts_reason_id", nullable = false)
    public Integer getMaterialReceiptsReasonId() {
        return materialReceiptsReasonId;
    }

    public void setMaterialReceiptsReasonId(Integer materialReceiptsReasonId) {
        this.materialReceiptsReasonId = materialReceiptsReasonId;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaterialReceiptsLogModel that = (MaterialReceiptsLogModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (quantityRemains != null ? !quantityRemains.equals(that.quantityRemains) : that.quantityRemains != null)
            return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (materialId != null ? !materialId.equals(that.materialId) : that.materialId != null) return false;
        if (materialReceiptsReasonId != null ? !materialReceiptsReasonId.equals(that.materialReceiptsReasonId) : that.materialReceiptsReasonId != null)
            return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (quantityRemains != null ? quantityRemains.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (materialId != null ? materialId.hashCode() : 0);
        result = 31 * result + (materialReceiptsReasonId != null ? materialReceiptsReasonId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "material_id", referencedColumnName = "id", insertable = false, updatable = false)
    public MaterialModel getMaterialByMaterialId() {
        return materialByMaterialId;
    }

    public void setMaterialByMaterialId(MaterialModel materialByMaterialId) {
        this.materialByMaterialId = materialByMaterialId;
    }

    @ManyToOne
    @JoinColumn(name = "material_receipts_reason_id", referencedColumnName = "id", insertable = false, updatable = false)
    public MaterialReceiptsReasonModel getMaterialReceiptsReasonById() {
        return materialReceiptsReasonById;
    }

    public void setMaterialReceiptsReasonById(MaterialReceiptsReasonModel materialReceiptsReasonById) {
        this.materialReceiptsReasonById = materialReceiptsReasonById;
    }
}
