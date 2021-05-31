package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "operation", schema = "meat_site_db", catalog = "")
public class OperationModel {
    private Long id;
    private String name;
    private Double estimatedNumber;
    private Integer typeOperationId;
    private Collection<InputMaterialsModel> inputMaterialsById;
    private TypeOperationModel typeOperationByTypeOperationId;
    private Collection<OutputMaterialsModel> outputMaterialsById;
    private Collection<OutputProductsModel> outputProductsById;
    private Collection<RecyclingModel> recyclingsById;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "estimatedNumber")
    public Double getEstimatedNumber() {
        return estimatedNumber;
    }

    public void setEstimatedNumber(Double estimatedNumber) {
        this.estimatedNumber = estimatedNumber;
    }

    @Basic
    @Column(name = "typeOperationId")
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

    @OneToMany(mappedBy = "operationByOperationId")
    public Collection<InputMaterialsModel> getInputMaterialsById() {
        return inputMaterialsById;
    }

    public void setInputMaterialsById(Collection<InputMaterialsModel> inputMaterialsById) {
        this.inputMaterialsById = inputMaterialsById;
    }

    @ManyToOne
    @JoinColumn(name = "typeOperationId", referencedColumnName = "id", insertable = false, updatable = false)
    public TypeOperationModel getTypeOperationByTypeOperationId() {
        return typeOperationByTypeOperationId;
    }

    public void setTypeOperationByTypeOperationId(TypeOperationModel typeOperationByTypeOperationId) {
        this.typeOperationByTypeOperationId = typeOperationByTypeOperationId;
    }

    @OneToMany(mappedBy = "operationByOperationId")
    public Collection<OutputMaterialsModel> getOutputMaterialsById() {
        return outputMaterialsById;
    }

    public void setOutputMaterialsById(Collection<OutputMaterialsModel> outputMaterialsById) {
        this.outputMaterialsById = outputMaterialsById;
    }

    @OneToMany(mappedBy = "operationByOperationId")
    public Collection<OutputProductsModel> getOutputProductsById() {
        return outputProductsById;
    }

    public void setOutputProductsById(Collection<OutputProductsModel> outputProductsById) {
        this.outputProductsById = outputProductsById;
    }

    @OneToMany(mappedBy = "operationByOperationId")
    public Collection<RecyclingModel> getRecyclingsById() {
        return recyclingsById;
    }

    public void setRecyclingsById(Collection<RecyclingModel> recyclingsById) {
        this.recyclingsById = recyclingsById;
    }
}
