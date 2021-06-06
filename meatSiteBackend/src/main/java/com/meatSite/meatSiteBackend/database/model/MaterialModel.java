package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;

@Entity
@Table(name = "material", schema = "meat_site_db", catalog = "")
public class MaterialModel {
    private Long id;
    private String name;
    private Integer photo;
    private Integer typeMaterialId;
    private Integer unitId;

    private TypeMaterialModel typeMaterialById;
    private UnitModel unitById;

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
    @Column(name = "type_material_id", nullable = false)
    public Integer getTypeMaterialId() {
        return typeMaterialId;
    }

    public void setTypeMaterialId(Integer typeMaterialId) {
        this.typeMaterialId = typeMaterialId;
    }

    @Basic
    @Column(name = "unit_id", nullable = false)
    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaterialModel that = (MaterialModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (photo != null ? !photo.equals(that.photo) : that.photo != null) return false;
        if (typeMaterialId != null ? !typeMaterialId.equals(that.typeMaterialId) : that.typeMaterialId != null)
            return false;
        if (unitId != null ? !unitId.equals(that.unitId) : that.unitId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (typeMaterialId != null ? typeMaterialId.hashCode() : 0);
        result = 31 * result + (unitId != null ? unitId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "type_material_id", referencedColumnName = "id", insertable = false, updatable = false)
    public TypeMaterialModel getTypeMaterialById() {
        return typeMaterialById;
    }

    public void setTypeMaterialById(TypeMaterialModel typeMaterialById) {
        this.typeMaterialById = typeMaterialById;
    }

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "id", insertable = false, updatable = false)
    public UnitModel getUnitById() {
        return unitById;
    }

    public void setUnitById(UnitModel unitById) {
        this.unitById = unitById;
    }
}
