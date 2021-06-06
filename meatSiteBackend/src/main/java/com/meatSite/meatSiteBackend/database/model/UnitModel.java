package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;

@Entity
@Table(name = "unit", schema = "meat_site_db", catalog = "")
public class UnitModel {
    private Long id;
    private String name;

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
}
