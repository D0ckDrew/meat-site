package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;

@Entity
@Table(name = "operation", schema = "meat_site_db", catalog = "")
public class OperationModel {
    private Long id;
    private String name;
    private Double estimatedNumber;
    private Integer typeOperationId;

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
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "estimated_number", nullable = false, precision = 3)
    public Double getEstimatedNumber() {
        return estimatedNumber;
    }

    public void setEstimatedNumber(Double estimatedNumber) {
        this.estimatedNumber = estimatedNumber;
    }

    @Basic
    @Column(name = "type_operation_id", nullable = false)
    public Integer getTypeOperationId() {
        return typeOperationId;
    }

    public void setTypeOperationId(Integer typeOperationId) {
        this.typeOperationId = typeOperationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperationModel that = (OperationModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (estimatedNumber != null ? !estimatedNumber.equals(that.estimatedNumber) : that.estimatedNumber != null)
            return false;
        if (typeOperationId != null ? !typeOperationId.equals(that.typeOperationId) : that.typeOperationId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (estimatedNumber != null ? estimatedNumber.hashCode() : 0);
        result = 31 * result + (typeOperationId != null ? typeOperationId.hashCode() : 0);
        return result;
    }
}
