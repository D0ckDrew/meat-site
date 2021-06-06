package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sale", schema = "meat_site_db", catalog = "")
public class SaleModel {
    private Long id;
    private Integer userId;
    private Timestamp date;
    private Integer paymentMethodId;
    private Double amount;
    private Double payment;
    private Double change;

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
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
    @Column(name = "payment_method_id", nullable = false)
    public Integer getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    @Basic
    @Column(name = "amount", nullable = false, precision = 2)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "payment", nullable = false, precision = 2)
    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    @Basic
    @Column(name = "change", nullable = false, precision = 2)
    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaleModel saleModel = (SaleModel) o;

        if (id != null ? !id.equals(saleModel.id) : saleModel.id != null) return false;
        if (userId != null ? !userId.equals(saleModel.userId) : saleModel.userId != null) return false;
        if (date != null ? !date.equals(saleModel.date) : saleModel.date != null) return false;
        if (paymentMethodId != null ? !paymentMethodId.equals(saleModel.paymentMethodId) : saleModel.paymentMethodId != null)
            return false;
        if (amount != null ? !amount.equals(saleModel.amount) : saleModel.amount != null) return false;
        if (payment != null ? !payment.equals(saleModel.payment) : saleModel.payment != null) return false;
        if (change != null ? !change.equals(saleModel.change) : saleModel.change != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (paymentMethodId != null ? paymentMethodId.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (payment != null ? payment.hashCode() : 0);
        result = 31 * result + (change != null ? change.hashCode() : 0);
        return result;
    }
}
