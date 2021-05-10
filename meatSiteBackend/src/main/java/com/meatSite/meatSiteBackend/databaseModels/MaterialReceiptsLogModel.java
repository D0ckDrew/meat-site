package com.meatSite.meatSiteBackend.databaseModels;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "material_receipts_log", schema = "meat_site_db", catalog = "")
public class MaterialReceiptsLogModel {
    private Long id;
    private double quantity;
    private double quantityRemains;
    private Timestamp date;
    private int materialId;
    private int materialReceiptsReasonId;
    private int userId;
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
    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "quantityRemains")
    public double getQuantityRemains() {
        return quantityRemains;
    }

    public void setQuantityRemains(double quantityRemains) {
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
    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    @Basic
    @Column(name = "materialReceiptsReasonId")
    public int getMaterialReceiptsReasonId() {
        return materialReceiptsReasonId;
    }

    public void setMaterialReceiptsReasonId(int materialReceiptsReasonId) {
        this.materialReceiptsReasonId = materialReceiptsReasonId;
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

        MaterialReceiptsLogModel that = (MaterialReceiptsLogModel) o;

        if (Double.compare(that.quantity, quantity) != 0) return false;
        if (Double.compare(that.quantityRemains, quantityRemains) != 0) return false;
        if (materialId != that.materialId) return false;
        if (materialReceiptsReasonId != that.materialReceiptsReasonId) return false;
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
        temp = Double.doubleToLongBits(quantityRemains);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + materialId;
        result = 31 * result + materialReceiptsReasonId;
        result = 31 * result + userId;
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
    @JoinColumn(name = "materialId", referencedColumnName = "id", nullable = false)
    public MaterialModel getMaterialByMaterialId() {
        return materialByMaterialId;
    }

    public void setMaterialByMaterialId(MaterialModel materialByMaterialId) {
        this.materialByMaterialId = materialByMaterialId;
    }

    @ManyToOne
    @JoinColumn(name = "materialReceiptsReasonId", referencedColumnName = "id", nullable = false)
    public MaterialReceiptsReasonModel getMaterialReceiptsReasonByMaterialReceiptsReasonId() {
        return materialReceiptsReasonByMaterialReceiptsReasonId;
    }

    public void setMaterialReceiptsReasonByMaterialReceiptsReasonId(MaterialReceiptsReasonModel materialReceiptsReasonByMaterialReceiptsReasonId) {
        this.materialReceiptsReasonByMaterialReceiptsReasonId = materialReceiptsReasonByMaterialReceiptsReasonId;
    }

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
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
