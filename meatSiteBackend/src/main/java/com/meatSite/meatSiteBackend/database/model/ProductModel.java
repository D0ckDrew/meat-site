package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "product", schema = "meat_site_db", catalog = "")
public class ProductModel {
    private Long id;
    private String name;
    private Integer photo;
    private Double cost;
    private Integer unitId;
    private Integer typeProductId;
    private Collection<ItemsInProductWarehouseModel> itemsInProductWarehousesById;
    private Collection<OutputProductsModel> outputProductsById;
    private UnitModel unitByUnitId;
    private TypeProductModel typeProductByTypeProductId;
    private Collection<ProductExpenseLogModel> productExpenseLogsById;
    private Collection<ProductReceiptsLogModel> productReceiptsLogsById;

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
    @Column(name = "cost")
    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "unitId")
    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "typeProductId")
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

    @OneToMany(mappedBy = "productByProductId")
    public Collection<ItemsInProductWarehouseModel> getItemsInProductWarehousesById() {
        return itemsInProductWarehousesById;
    }

    public void setItemsInProductWarehousesById(Collection<ItemsInProductWarehouseModel> itemsInProductWarehousesById) {
        this.itemsInProductWarehousesById = itemsInProductWarehousesById;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<OutputProductsModel> getOutputProductsById() {
        return outputProductsById;
    }

    public void setOutputProductsById(Collection<OutputProductsModel> outputProductsById) {
        this.outputProductsById = outputProductsById;
    }

    @ManyToOne
    @JoinColumn(name = "unitId", referencedColumnName = "id", insertable = false, updatable = false)
    public UnitModel getUnitByUnitId() {
        return unitByUnitId;
    }

    public void setUnitByUnitId(UnitModel unitByUnitId) {
        this.unitByUnitId = unitByUnitId;
    }

    @ManyToOne
    @JoinColumn(name = "typeProductId", referencedColumnName = "id", insertable = false, updatable = false)
    public TypeProductModel getTypeProductByTypeProductId() {
        return typeProductByTypeProductId;
    }

    public void setTypeProductByTypeProductId(TypeProductModel typeProductByTypeProductId) {
        this.typeProductByTypeProductId = typeProductByTypeProductId;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<ProductExpenseLogModel> getProductExpenseLogsById() {
        return productExpenseLogsById;
    }

    public void setProductExpenseLogsById(Collection<ProductExpenseLogModel> productExpenseLogsById) {
        this.productExpenseLogsById = productExpenseLogsById;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<ProductReceiptsLogModel> getProductReceiptsLogsById() {
        return productReceiptsLogsById;
    }

    public void setProductReceiptsLogsById(Collection<ProductReceiptsLogModel> productReceiptsLogsById) {
        this.productReceiptsLogsById = productReceiptsLogsById;
    }
}
