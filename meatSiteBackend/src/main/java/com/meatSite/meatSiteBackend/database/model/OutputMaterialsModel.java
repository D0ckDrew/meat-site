package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;

@Entity
@Table(name = "output_materials", schema = "meat_site_db", catalog = "")
public class OutputMaterialsModel {
    private Long id;
    private Integer materialId;
    private Integer operationId;

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
    @Column(name = "material_id", nullable = false)
    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    @Basic
    @Column(name = "operation_id", nullable = false)
    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OutputMaterialsModel that = (OutputMaterialsModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (materialId != null ? !materialId.equals(that.materialId) : that.materialId != null) return false;
        if (operationId != null ? !operationId.equals(that.operationId) : that.operationId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (materialId != null ? materialId.hashCode() : 0);
        result = 31 * result + (operationId != null ? operationId.hashCode() : 0);
        return result;
    }
}
