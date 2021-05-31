package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "material_expense_log", schema = "meat_site_db", catalog = "")
public class MaterialExpenseLogModel {
    private Long id;
    private Double quantity;
    private Timestamp date;
    private Integer materialId;
    private Integer materialExpenseReasonId;
    private Integer userId;
    private Collection<FenceFromWarehouseModel> fenceFromWarehousesById;
    private MaterialModel materialByMaterialId;
    private MaterialExpenseReasonModel materialExpenseReasonByMaterialExpenseReasonId;
    private UserModel userByUserId;

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
    @Column(name = "quantity")
    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
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
    @Column(name = "materialId")
    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    @Basic
    @Column(name = "materialExpenseReasonId")
    public Integer getMaterialExpenseReasonId() {
        return materialExpenseReasonId;
    }

    public void setMaterialExpenseReasonId(Integer materialExpenseReasonId) {
        this.materialExpenseReasonId = materialExpenseReasonId;
    }

    @Basic
    @Column(name = "userId")
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

        MaterialExpenseLogModel that = (MaterialExpenseLogModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (materialId != null ? !materialId.equals(that.materialId) : that.materialId != null) return false;
        if (materialExpenseReasonId != null ? !materialExpenseReasonId.equals(that.materialExpenseReasonId) : that.materialExpenseReasonId != null)
            return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (materialId != null ? materialId.hashCode() : 0);
        result = 31 * result + (materialExpenseReasonId != null ? materialExpenseReasonId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "materialExpenseLogByMaterialExpenseLogId")
    public Collection<FenceFromWarehouseModel> getFenceFromWarehousesById() {
        return fenceFromWarehousesById;
    }

    public void setFenceFromWarehousesById(Collection<FenceFromWarehouseModel> fenceFromWarehousesById) {
        this.fenceFromWarehousesById = fenceFromWarehousesById;
    }

    @ManyToOne
    @JoinColumn(name = "materialId", referencedColumnName = "id", insertable = false, updatable = false)
    public MaterialModel getMaterialByMaterialId() {
        return materialByMaterialId;
    }

    public void setMaterialByMaterialId(MaterialModel materialByMaterialId) {
        this.materialByMaterialId = materialByMaterialId;
    }

    @ManyToOne
    @JoinColumn(name = "materialExpenseReasonId", referencedColumnName = "id", insertable = false, updatable = false)
    public MaterialExpenseReasonModel getMaterialExpenseReasonByMaterialExpenseReasonId() {
        return materialExpenseReasonByMaterialExpenseReasonId;
    }

    public void setMaterialExpenseReasonByMaterialExpenseReasonId(MaterialExpenseReasonModel materialExpenseReasonByMaterialExpenseReasonId) {
        this.materialExpenseReasonByMaterialExpenseReasonId = materialExpenseReasonByMaterialExpenseReasonId;
    }

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    public UserModel getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserModel userByUserId) {
        this.userByUserId = userByUserId;
    }
}
