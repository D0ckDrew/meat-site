package com.meatSite.meatSiteBackend.databaseModels;

import javax.persistence.*;

@Entity
@Table(name = "sale_content", schema = "meat_site_db", catalog = "")
public class SaleContentModel {
    private Long id;
    private double costPerUnit;
    private double amount;
    private ProductExpenseLogModel productExpenseLogByProductExpenseLogId;

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
    @Column(name = "costPerUnit")
    public double getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(double costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    @Basic
    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaleContentModel that = (SaleContentModel) o;

        if (Double.compare(that.costPerUnit, costPerUnit) != 0) return false;
        if (Double.compare(that.amount, amount) != 0) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        temp = Double.doubleToLongBits(costPerUnit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "productExpenseLogId", referencedColumnName = "id", nullable = false)
    public ProductExpenseLogModel getProductExpenseLogByProductExpenseLogId() {
        return productExpenseLogByProductExpenseLogId;
    }

    public void setProductExpenseLogByProductExpenseLogId(ProductExpenseLogModel productExpenseLogByProductExpenseLogId) {
        this.productExpenseLogByProductExpenseLogId = productExpenseLogByProductExpenseLogId;
    }
}
