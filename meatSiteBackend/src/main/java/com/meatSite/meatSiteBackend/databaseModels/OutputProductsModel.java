package com.meatSite.meatSiteBackend.databaseModels;

import javax.persistence.*;

@Entity
@Table(name = "output_products", schema = "meat_site_db", catalog = "")
public class OutputProductsModel {
    private Long id;
    private int productId;
    private int operationId;
    private ProductModel productByProductId;
    private OperationModel operationByOperationId;

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
    @Column(name = "productId")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "operationId")
    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OutputProductsModel that = (OutputProductsModel) o;

        if (productId != that.productId) return false;
        if (operationId != that.operationId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + productId;
        result = 31 * result + operationId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "id", nullable = false)
    public ProductModel getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(ProductModel productByProductId) {
        this.productByProductId = productByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "operationId", referencedColumnName = "id", nullable = false)
    public OperationModel getOperationByOperationId() {
        return operationByOperationId;
    }

    public void setOperationByOperationId(OperationModel operationByOperationId) {
        this.operationByOperationId = operationByOperationId;
    }
}
