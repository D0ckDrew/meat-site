package com.meatSite.meatSiteBackend.databaseModels;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "material_expense_log", schema = "meat_site_db", catalog = "")
public class MaterialExpenseLogModel {
    private Long id;
    private double quantity;
    private Timestamp date;
    private int materialId;
    private int materialExpenseReasonId;
    private int userId;
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
    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
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
    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    @Basic
    @Column(name = "materialExpenseReasonId")
    public int getMaterialExpenseReasonId() {
        return materialExpenseReasonId;
    }

    public void setMaterialExpenseReasonId(int materialExpenseReasonId) {
        this.materialExpenseReasonId = materialExpenseReasonId;
    }

    @Basic
    @Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaterialExpenseLogModel that = (MaterialExpenseLogModel) o;

        if (Double.compare(that.quantity, quantity) != 0) return false;
        if (materialId != that.materialId) return false;
        if (materialExpenseReasonId != that.materialExpenseReasonId) return false;
        if (userId != that.userId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        temp = Double.doubleToLongBits(quantity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + materialId;
        result = 31 * result + materialExpenseReasonId;
        result = 31 * result + userId;
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
