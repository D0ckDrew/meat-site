package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "product_receipts_log", schema = "meat_site_db", catalog = "")
public class ProductReceiptsLogModel {
    private Long id;
    private Double quantity;
    private Timestamp date;
    private Integer productId;
    private Integer productReceiptsReasonId;
    private Integer userId;
    private ProductModel productByProductId;
    private ProductReceiptsReasonModel productReceiptsReasonByProductReceiptsReasonId;
    private UserModel userByUserId;
    private Collection<ProductionOutputModel> productionOutputsById;

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
    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "productId")
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "productReceiptsReasonId")
    public Integer getProductReceiptsReasonId() {
        return productReceiptsReasonId;
    }

    public void setProductReceiptsReasonId(Integer productReceiptsReasonId) {
        this.productReceiptsReasonId = productReceiptsReasonId;
    }

    @Basic
    @Column(name = "userId")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductReceiptsLogModel that = (ProductReceiptsLogModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (productReceiptsReasonId != null ? !productReceiptsReasonId.equals(that.productReceiptsReasonId) : that.productReceiptsReasonId != null)
            return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (productReceiptsReasonId != null ? productReceiptsReasonId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "productReceiptsReasonId", referencedColumnName = "id", insertable = false, updatable = false)
    public ProductReceiptsReasonModel getProductReceiptsReasonByProductReceiptsReasonId() {
        return productReceiptsReasonByProductReceiptsReasonId;
    }

    public void setProductReceiptsReasonByProductReceiptsReasonId(ProductReceiptsReasonModel productReceiptsReasonByProductReceiptsReasonId) {
        this.productReceiptsReasonByProductReceiptsReasonId = productReceiptsReasonByProductReceiptsReasonId;
    }

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    public UserModel getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserModel userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "productReceiptsLogByProductReceiptsLogId")
    public Collection<ProductionOutputModel> getProductionOutputsById() {
        return productionOutputsById;
    }

    public void setProductionOutputsById(Collection<ProductionOutputModel> productionOutputsById) {
        this.productionOutputsById = productionOutputsById;
    }
}
