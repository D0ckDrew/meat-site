package com.meatSite.meatSiteBackend.databaseModels;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "recycling", schema = "meat_site_db", catalog = "")
public class RecyclingModel {
    private Long id;
    private Timestamp date;
    private int status;
    private int operationId;
    private int userId;
    private Collection<FenceFromReceiptsModel> fenceFromReceiptsById;
    private Collection<FenceFromWarehouseModel> fenceFromWarehousesById;
    private Collection<ItemsInProductWarehouseModel> itemsInProductWarehousesById;
    private Collection<ProductionOutputModel> productionOutputsById;
    private Collection<ReceiptToWarehouseModel> receiptToWarehousesById;
    private OperationModel operationByOperationId;
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
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "operationId")
    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
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

        RecyclingModel that = (RecyclingModel) o;

        if (status != that.status) return false;
        if (operationId != that.operationId) return false;
        if (userId != that.userId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + operationId;
        result = 31 * result + userId;
        return result;
    }

    @OneToMany(mappedBy = "recyclingByRecyclingId")
    public Collection<FenceFromReceiptsModel> getFenceFromReceiptsById() {
        return fenceFromReceiptsById;
    }

    public void setFenceFromReceiptsById(Collection<FenceFromReceiptsModel> fenceFromReceiptsById) {
        this.fenceFromReceiptsById = fenceFromReceiptsById;
    }

    @OneToMany(mappedBy = "recyclingByRecyclingId")
    public Collection<FenceFromWarehouseModel> getFenceFromWarehousesById() {
        return fenceFromWarehousesById;
    }

    public void setFenceFromWarehousesById(Collection<FenceFromWarehouseModel> fenceFromWarehousesById) {
        this.fenceFromWarehousesById = fenceFromWarehousesById;
    }

    @OneToMany(mappedBy = "recyclingByRecyclingId")
    public Collection<ItemsInProductWarehouseModel> getItemsInProductWarehousesById() {
        return itemsInProductWarehousesById;
    }

    public void setItemsInProductWarehousesById(Collection<ItemsInProductWarehouseModel> itemsInProductWarehousesById) {
        this.itemsInProductWarehousesById = itemsInProductWarehousesById;
    }

    @OneToMany(mappedBy = "recyclingByRecyclingId")
    public Collection<ProductionOutputModel> getProductionOutputsById() {
        return productionOutputsById;
    }

    public void setProductionOutputsById(Collection<ProductionOutputModel> productionOutputsById) {
        this.productionOutputsById = productionOutputsById;
    }

    @OneToMany(mappedBy = "recyclingByRecyclingId")
    public Collection<ReceiptToWarehouseModel> getReceiptToWarehousesById() {
        return receiptToWarehousesById;
    }

    public void setReceiptToWarehousesById(Collection<ReceiptToWarehouseModel> receiptToWarehousesById) {
        this.receiptToWarehousesById = receiptToWarehousesById;
    }

    @ManyToOne
    @JoinColumn(name = "operationId", referencedColumnName = "id", nullable = false)
    public OperationModel getOperationByOperationId() {
        return operationByOperationId;
    }

    public void setOperationByOperationId(OperationModel operationByOperationId) {
        this.operationByOperationId = operationByOperationId;
    }

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    public UserModel getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserModel userByUserId) {
        this.userByUserId = userByUserId;
    }
}
