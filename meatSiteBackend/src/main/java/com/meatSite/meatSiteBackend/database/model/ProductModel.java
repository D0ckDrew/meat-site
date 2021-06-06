package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;

@Entity
@Table(name = "product", schema = "meat_site_db", catalog = "")
public class ProductModel {
    private Long id;
    private String name;
    private Integer photo;
    private Double cost;
    private Integer unitId;
    private Integer typeProductId;

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
    @Column(name = "photo", nullable = false)
    public Integer getPhoto() {
        return photo;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "cost", nullable = false, precision = 2)
    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "unit_id", nullable = false)
    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "type_product_id", nullable = false)
    public Integer getTypeProductId() {
        return typeProductId;
    }

    public void setTypeProductId(Integer typeProductId) {
        this.typeProductId = typeProductId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductModel that = (ProductModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (photo != null ? !photo.equals(that.photo) : that.photo != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;
        if (unitId != null ? !unitId.equals(that.unitId) : that.unitId != null) return false;
        if (typeProductId != null ? !typeProductId.equals(that.typeProductId) : that.typeProductId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (unitId != null ? unitId.hashCode() : 0);
        result = 31 * result + (typeProductId != null ? typeProductId.hashCode() : 0);
        return result;
    }
}
