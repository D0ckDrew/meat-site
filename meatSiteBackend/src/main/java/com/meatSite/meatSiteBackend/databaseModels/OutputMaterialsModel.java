package com.meatSite.meatSiteBackend.databaseModels;

import javax.persistence.*;

@Entity
@Table(name = "output_materials", schema = "meat_site_db", catalog = "")
public class OutputMaterialsModel {
    private Long id;
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

        OutputMaterialsModel that = (OutputMaterialsModel) o;

        if (materialId != that.materialId) return false;
        if (operationId != that.operationId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + materialId;
        result = 31 * result + operationId;
        return result;
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
    @JoinColumn(name = "operationId", referencedColumnName = "id", nullable = false)
    public OperationModel getOperationByOperationId() {
        return operationByOperationId;
    }

    public void setOperationByOperationId(OperationModel operationByOperationId) {
        this.operationByOperationId = operationByOperationId;
    }
}
