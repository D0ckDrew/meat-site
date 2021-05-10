package com.meatSite.meatSiteBackend.databaseModels;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "product_expense_log", schema = "meat_site_db", catalog = "")
public class ProductExpenseLogModel {
    private Long id;
    private double quantity;
    private Timestamp date;
    private int productId;
    private int productExpenseReasonId;
    private int userId;
    private ProductModel productByProductId;
    private ProductExpenseReasonModel productExpenseReasonByProductExpenseReasonId;
    private UserModel userByUserId;
    private Collection<SaleContentModel> saleContentsById;

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
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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
    @Column(name = "productExpenseReasonId")
    public int getProductExpenseReasonId() {
        return productExpenseReasonId;
    }

    public void setProductExpenseReasonId(int productExpenseReasonId) {
        this.productExpenseReasonId = productExpenseReasonId;
    }

    @Basic
    @Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductExpenseLogModel that = (ProductExpenseLogModel) o;

        if (Double.compare(that.quantity, quantity) != 0) return false;
        if (productId != that.productId) return false;
        if (productExpenseReasonId != that.productExpenseReasonId) return false;
        if (userId != that.userId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        temp = Double.doubleToLongBits(quantity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + productId;
        result = 31 * result + productExpenseReasonId;
        result = 31 * result + userId;
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
    @JoinColumn(name = "productExpenseReasonId", referencedColumnName = "id", nullable = false)
    public ProductExpenseReasonModel getProductExpenseReasonByProductExpenseReasonId() {
        return productExpenseReasonByProductExpenseReasonId;
    }

    public void setProductExpenseReasonByProductExpenseReasonId(ProductExpenseReasonModel productExpenseReasonByProductExpenseReasonId) {
        this.productExpenseReasonByProductExpenseReasonId = productExpenseReasonByProductExpenseReasonId;
    }

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    public UserModel getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserModel userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "productExpenseLogByProductExpenseLogId")
    public Collection<SaleContentModel> getSaleContentsById() {
        return saleContentsById;
    }

    public void setSaleContentsById(Collection<SaleContentModel> saleContentsById) {
        this.saleContentsById = saleContentsById;
    }
}
