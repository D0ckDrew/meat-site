package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "material_receipts_reason", schema = "meat_site_db", catalog = "")
public class MaterialReceiptsReasonModel {
    private Long id;
    private String name;
    private Collection<MaterialReceiptsLogModel> materialReceiptsLogsById;

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

        MaterialReceiptsReasonModel that = (MaterialReceiptsReasonModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "materialReceiptsReasonByMaterialReceiptsReasonId")
    public Collection<MaterialReceiptsLogModel> getMaterialReceiptsLogsById() {
        return materialReceiptsLogsById;
    }

    public void setMaterialReceiptsLogsById(Collection<MaterialReceiptsLogModel> materialReceiptsLogsById) {
        this.materialReceiptsLogsById = materialReceiptsLogsById;
    }
}
