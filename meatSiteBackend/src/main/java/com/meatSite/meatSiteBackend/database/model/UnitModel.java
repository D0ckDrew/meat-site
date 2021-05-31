package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "unit", schema = "meat_site_db", catalog = "")
public class UnitModel {
    private Long id;
    private String name;
    private Collection<MaterialModel> materialsById;
    private Collection<ProductModel> productsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnitModel unitModel = (UnitModel) o;

        if (id != null ? !id.equals(unitModel.id) : unitModel.id != null) return false;
        if (name != null ? !name.equals(unitModel.name) : unitModel.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "unitByUnitId")
    public Collection<MaterialModel> getMaterialsById() {
        return materialsById;
    }

    public void setMaterialsById(Collection<MaterialModel> materialsById) {
        this.materialsById = materialsById;
    }

    @OneToMany(mappedBy = "unitByUnitId")
    public Collection<ProductModel> getProductsById() {
        return productsById;
    }

    public void setProductsById(Collection<ProductModel> productsById) {
        this.productsById = productsById;
    }
}
