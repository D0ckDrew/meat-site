package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "product_expense_log", schema = "meat_site_db", catalog = "")
public class ProductExpenseLogModel {
    private Long id;
    private Double quantity;
    private Timestamp date;
    private Integer productId;
    private Integer productExpenseReasonId;
    private Integer userId;

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
    @Column(name = "quantity", nullable = false, precision = 3)
    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "product_id", nullable = false)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "product_expense_reason_id", nullable = false)
    public Integer getProductExpenseReasonId() {
        return productExpenseReasonId;
    }

    public void setProductExpenseReasonId(Integer productExpenseReasonId) {
        this.productExpenseReasonId = productExpenseReasonId;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
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

        ProductExpenseLogModel that = (ProductExpenseLogModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (productExpenseReasonId != null ? !productExpenseReasonId.equals(that.productExpenseReasonId) : that.productExpenseReasonId != null)
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
        result = 31 * result + (productExpenseReasonId != null ? productExpenseReasonId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
