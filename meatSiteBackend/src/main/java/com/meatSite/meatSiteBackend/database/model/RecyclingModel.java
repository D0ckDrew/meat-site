package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "recycling", schema = "meat_site_db", catalog = "")
public class RecyclingModel {
    private Long id;
    private Timestamp startDate;
    private Timestamp endDate;
    private Integer status;
    private Integer operationId;
    private Integer userId;
    private Collection<FenceFromReceiptsModel> fenceFromReceiptsById;
    private Collection<FenceFromWarehouseModel> fenceFromWarehousesById;
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
    @Column(name = "startDate")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "endDate")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "operationId")
    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
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

        RecyclingModel that = (RecyclingModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (operationId != null ? !operationId.equals(that.operationId) : that.operationId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (operationId != null ? operationId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
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
    @JoinColumn(name = "operationId", referencedColumnName = "id", insertable = false, updatable = false)
    public OperationModel getOperationByOperationId() {
        return operationByOperationId;
    }

    public void setOperationByOperationId(OperationModel operationByOperationId) {
        this.operationByOperationId = operationByOperationId;
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
