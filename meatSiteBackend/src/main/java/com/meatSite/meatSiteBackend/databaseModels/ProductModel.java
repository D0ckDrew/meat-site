package com.meatSite.meatSiteBackend.databaseModels;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "product", schema = "meat_site_db", catalog = "")
public class ProductModel {
    private Long id;
    private String name;
    private int photo;
    private double cost;
    private int unitId;
    private int typeProductId;
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
    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "cost")
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "unitId")
    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "typeProductId")
    public int getTypeProductId() {
        return typeProductId;
    }

    public void setTypeProductId(int typeProductId) {
        this.typeProductId = typeProductId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductModel that = (ProductModel) o;

        if (photo != that.photo) return false;
        if (Double.compare(that.cost, cost) != 0) return false;
        if (unitId != that.unitId) return false;
        if (typeProductId != that.typeProductId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + photo;
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + unitId;
        result = 31 * result + typeProductId;
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
    @JoinColumn(name = "unitId", referencedColumnName = "id", nullable = false)
    public UnitModel getUnitByUnitId() {
        return unitByUnitId;
    }

    public void setUnitByUnitId(UnitModel unitByUnitId) {
        this.unitByUnitId = unitByUnitId;
    }

    @ManyToOne
    @JoinColumn(name = "typeProductId", referencedColumnName = "id", nullable = false)
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
