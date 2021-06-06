package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;

@Entity
@Table(name = "sale_content", schema = "meat_site_db", catalog = "")
public class SaleContentModel {
    private Long id;
    private Integer productExpenseLogId;
    private Double costPerUnit;
    private Integer saleId;

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
    @Column(name = "product_expense_log_id", nullable = false)
    public Integer getProductExpenseLogId() {
        return productExpenseLogId;
    }

    public void setProductExpenseLogId(Integer productExpenseLogId) {
        this.productExpenseLogId = productExpenseLogId;
    }

    @Basic
    @Column(name = "cost_per_unit", nullable = false, precision = 2)
    public Double getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(Double costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    @Basic
    @Column(name = "sale_id", nullable = false)
    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaleContentModel that = (SaleContentModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (productExpenseLogId != null ? !productExpenseLogId.equals(that.productExpenseLogId) : that.productExpenseLogId != null)
            return false;
        if (costPerUnit != null ? !costPerUnit.equals(that.costPerUnit) : that.costPerUnit != null) return false;
        if (saleId != null ? !saleId.equals(that.saleId) : that.saleId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productExpenseLogId != null ? productExpenseLogId.hashCode() : 0);
        result = 31 * result + (costPerUnit != null ? costPerUnit.hashCode() : 0);
        result = 31 * result + (saleId != null ? saleId.hashCode() : 0);
        return result;
    }
}
