package com.meatSite.meatSiteBackend.databaseModels;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sale", schema = "meat_site_db", catalog = "")
public class SaleModel {
    private Long id;
    private int sellerId;
    private Timestamp date;
    private int paymentMethodId;
    private double amount;
    private double payment;
    private double change;
    private UserModel userBySellerId;
    private PaymentMethodModel paymentMethodByPaymentMethodId;

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
    @Column(name = "sellerId")
    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
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
    @Column(name = "paymentMethodId")
    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    @Basic
    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "payment")
    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    @Basic
    @Column(name = "change")
    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaleModel saleModel = (SaleModel) o;

        if (sellerId != saleModel.sellerId) return false;
        if (paymentMethodId != saleModel.paymentMethodId) return false;
        if (Double.compare(saleModel.amount, amount) != 0) return false;
        if (Double.compare(saleModel.payment, payment) != 0) return false;
        if (Double.compare(saleModel.change, change) != 0) return false;
        if (id != null ? !id.equals(saleModel.id) : saleModel.id != null) return false;
        if (date != null ? !date.equals(saleModel.date) : saleModel.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + sellerId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + paymentMethodId;
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(payment);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(change);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "sellerId", referencedColumnName = "id", nullable = false)
    public UserModel getUserBySellerId() {
        return userBySellerId;
    }

    public void setUserBySellerId(UserModel userBySellerId) {
        this.userBySellerId = userBySellerId;
    }

    @ManyToOne
    @JoinColumn(name = "paymentMethodId", referencedColumnName = "id", nullable = false)
    public PaymentMethodModel getPaymentMethodByPaymentMethodId() {
        return paymentMethodByPaymentMethodId;
    }

    public void setPaymentMethodByPaymentMethodId(PaymentMethodModel paymentMethodByPaymentMethodId) {
        this.paymentMethodByPaymentMethodId = paymentMethodByPaymentMethodId;
    }
}
