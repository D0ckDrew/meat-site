package com.meatSite.meatSiteBackend.databaseModels;

import javax.persistence.*;

@Entity
@Table(name = "input_materials", schema = "meat_site_db", catalog = "")
public class InputMaterialsModel {
    private Long id;
    private double quantity;
    private int materialId;
    private int operationId;
    private MaterialModel materialByMaterialId;
    private OperationModel operationByOperationId;

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
    @Column(name = "materialId")
    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    @Basic
    @Column(name = "operationId")
    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InputMaterialsModel that = (InputMaterialsModel) o;

        if (Double.compare(that.quantity, quantity) != 0) return false;
        if (materialId != that.materialId) return false;
        if (operationId != that.operationId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        temp = Double.doubleToLongBits(quantity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + materialId;
        result = 31 * result + operationId;
        return result;
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
    @JoinColumn(name = "operationId", referencedColumnName = "id", insertable = false, updatable = false)
    public OperationModel getOperationByOperationId() {
        return operationByOperationId;
    }

    public void setOperationByOperationId(OperationModel operationByOperationId) {
        this.operationByOperationId = operationByOperationId;
    }
}
