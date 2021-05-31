package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "material", schema = "meat_site_db", catalog = "")
public class MaterialModel {
    private Long id;
    private String name;
    private Integer photo;
    private Integer typeMaterialId;
    private Integer unitId;
    private Collection<InputMaterialsModel> inputMaterialsById;
    private Collection<ItemsInMaterialsWarehouseModel> itemsInMaterialsWarehousesById;
    private TypeMaterialModel typeMaterialByTypeMaterialId;
    private UnitModel unitByUnitId;
    private Collection<MaterialExpenseLogModel> materialExpenseLogsById;
    private Collection<MaterialReceiptsLogModel> materialReceiptsLogsById;
    private Collection<OutputMaterialsModel> outputMaterialsById;

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
    @Column(name = "photo")
    public Integer getPhoto() {
        return photo;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "typeMaterialId")
    public Integer getTypeMaterialId() {
        return typeMaterialId;
    }

    public void setTypeMaterialId(Integer typeMaterialId) {
        this.typeMaterialId = typeMaterialId;
    }

    @Basic
    @Column(name = "unitId")
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

    @OneToMany(mappedBy = "materialByMaterialId")
    public Collection<InputMaterialsModel> getInputMaterialsById() {
        return inputMaterialsById;
    }

    public void setInputMaterialsById(Collection<InputMaterialsModel> inputMaterialsById) {
        this.inputMaterialsById = inputMaterialsById;
    }

    @OneToMany(mappedBy = "materialByMaterialId")
    public Collection<ItemsInMaterialsWarehouseModel> getItemsInMaterialsWarehousesById() {
        return itemsInMaterialsWarehousesById;
    }

    public void setItemsInMaterialsWarehousesById(Collection<ItemsInMaterialsWarehouseModel> itemsInMaterialsWarehousesById) {
        this.itemsInMaterialsWarehousesById = itemsInMaterialsWarehousesById;
    }

    @ManyToOne
    @JoinColumn(name = "typeMaterialId", referencedColumnName = "id", insertable = false, updatable = false)
    public TypeMaterialModel getTypeMaterialByTypeMaterialId() {
        return typeMaterialByTypeMaterialId;
    }

    public void setTypeMaterialByTypeMaterialId(TypeMaterialModel typeMaterialByTypeMaterialId) {
        this.typeMaterialByTypeMaterialId = typeMaterialByTypeMaterialId;
    }

    @ManyToOne
    @JoinColumn(name = "unitId", referencedColumnName = "id", insertable = false, updatable = false)
    public UnitModel getUnitByUnitId() {
        return unitByUnitId;
    }

    public void setUnitByUnitId(UnitModel unitByUnitId) {
        this.unitByUnitId = unitByUnitId;
    }

    @OneToMany(mappedBy = "materialByMaterialId")
    public Collection<MaterialExpenseLogModel> getMaterialExpenseLogsById() {
        return materialExpenseLogsById;
    }

    public void setMaterialExpenseLogsById(Collection<MaterialExpenseLogModel> materialExpenseLogsById) {
        this.materialExpenseLogsById = materialExpenseLogsById;
    }

    @OneToMany(mappedBy = "materialByMaterialId")
    public Collection<MaterialReceiptsLogModel> getMaterialReceiptsLogsById() {
        return materialReceiptsLogsById;
    }

    public void setMaterialReceiptsLogsById(Collection<MaterialReceiptsLogModel> materialReceiptsLogsById) {
        this.materialReceiptsLogsById = materialReceiptsLogsById;
    }

    @OneToMany(mappedBy = "materialByMaterialId")
    public Collection<OutputMaterialsModel> getOutputMaterialsById() {
        return outputMaterialsById;
    }

    public void setOutputMaterialsById(Collection<OutputMaterialsModel> outputMaterialsById) {
        this.outputMaterialsById = outputMaterialsById;
    }
}
