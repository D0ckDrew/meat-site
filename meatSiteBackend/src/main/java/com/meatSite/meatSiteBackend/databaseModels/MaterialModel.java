package com.meatSite.meatSiteBackend.databaseModels;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "material", schema = "meat_site_db", catalog = "")
public class MaterialModel {
    private Long id;
    private String name;
    private int photo;
    private int typeMaterialId;
    private int unitId;
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
    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "typeMaterialId")
    public int getTypeMaterialId() {
        return typeMaterialId;
    }

    public void setTypeMaterialId(int typeMaterialId) {
        this.typeMaterialId = typeMaterialId;
    }

    @Basic
    @Column(name = "unitId")
    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaterialModel that = (MaterialModel) o;

        if (photo != that.photo) return false;
        if (typeMaterialId != that.typeMaterialId) return false;
        if (unitId != that.unitId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + photo;
        result = 31 * result + typeMaterialId;
        result = 31 * result + unitId;
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
    @JoinColumn(name = "typeMaterialId", referencedColumnName = "id", nullable = false)
    public TypeMaterialModel getTypeMaterialByTypeMaterialId() {
        return typeMaterialByTypeMaterialId;
    }

    public void setTypeMaterialByTypeMaterialId(TypeMaterialModel typeMaterialByTypeMaterialId) {
        this.typeMaterialByTypeMaterialId = typeMaterialByTypeMaterialId;
    }

    @ManyToOne
    @JoinColumn(name = "unitId", referencedColumnName = "id", nullable = false)
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
