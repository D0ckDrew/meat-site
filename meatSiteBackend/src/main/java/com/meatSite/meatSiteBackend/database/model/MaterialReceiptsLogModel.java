package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

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
    private Collection<FenceFromReceiptsModel> fenceFromReceiptsById;
    private MaterialModel materialByMaterialId;
    private MaterialReceiptsReasonModel materialReceiptsReasonByMaterialReceiptsReasonId;
    private UserModel userByUserId;
    private Collection<ReceiptToWarehouseModel> receiptToWarehousesById;
    private Collection<ReceiptsModel> receiptsById;

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
    @Column(name = "quantityRemains")
    public Double getQuantityRemains() {
        return quantityRemains;
    }

    public void setQuantityRemains(Double quantityRemains) {
        this.quantityRemains = quantityRemains;
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
    @Column(name = "materialReceiptsReasonId")
    public Integer getMaterialReceiptsReasonId() {
        return materialReceiptsReasonId;
    }

    public void setMaterialReceiptsReasonId(Integer materialReceiptsReasonId) {
        this.materialReceiptsReasonId = materialReceiptsReasonId;
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

    @OneToMany(mappedBy = "materialReceiptsLogByMaterialReceiptsLogId")
    public Collection<FenceFromReceiptsModel> getFenceFromReceiptsById() {
        return fenceFromReceiptsById;
    }

    public void setFenceFromReceiptsById(Collection<FenceFromReceiptsModel> fenceFromReceiptsById) {
        this.fenceFromReceiptsById = fenceFromReceiptsById;
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
    @JoinColumn(name = "materialReceiptsReasonId", referencedColumnName = "id", insertable = false, updatable = false)
    public MaterialReceiptsReasonModel getMaterialReceiptsReasonByMaterialReceiptsReasonId() {
        return materialReceiptsReasonByMaterialReceiptsReasonId;
    }

    public void setMaterialReceiptsReasonByMaterialReceiptsReasonId(MaterialReceiptsReasonModel materialReceiptsReasonByMaterialReceiptsReasonId) {
        this.materialReceiptsReasonByMaterialReceiptsReasonId = materialReceiptsReasonByMaterialReceiptsReasonId;
    }

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    public UserModel getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserModel userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "materialReceiptsLogByMaterialReceiptsLogId")
    public Collection<ReceiptToWarehouseModel> getReceiptToWarehousesById() {
        return receiptToWarehousesById;
    }

    public void setReceiptToWarehousesById(Collection<ReceiptToWarehouseModel> receiptToWarehousesById) {
        this.receiptToWarehousesById = receiptToWarehousesById;
    }

    @OneToMany(mappedBy = "materialReceiptsLogByMaterialReceiptsLogId")
    public Collection<ReceiptsModel> getReceiptsById() {
        return receiptsById;
    }

    public void setReceiptsById(Collection<ReceiptsModel> receiptsById) {
        this.receiptsById = receiptsById;
    }
}
