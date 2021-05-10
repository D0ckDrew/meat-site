package com.meatSite.meatSiteBackend.databaseModels;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "items_in_product_warehouse", schema = "meat_site_db", catalog = "")
public class ItemsInProductWarehouseModel {
    private Long id;
    private double quantity;
    private int productId;
    private ProductModel productByProductId;

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
    @Column(name = "quantity")
    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "productId")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemsInProductWarehouseModel that = (ItemsInProductWarehouseModel) o;

        if (Double.compare(that.quantity, quantity) != 0) return false;
        if (productId != that.productId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        temp = Double.doubleToLongBits(quantity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + productId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "id", insertable = false, updatable = false)
    public ProductModel getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(ProductModel productByProductId) {
        this.productByProductId = productByProductId;
    }
}
