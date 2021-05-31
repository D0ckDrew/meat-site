package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;

@Entity
@Table(name = "sale_content", schema = "meat_site_db", catalog = "")
public class SaleContentModel {
    private Long id;
    private Integer productExpenseLogId;
    private Double costPerUnit;
    private Integer saleId;
    private ProductExpenseLogModel productExpenseLogByProductExpenseLogId;
    private SaleModel saleBySaleId;

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
    @Column(name = "productExpenseLogId")
    public Integer getProductExpenseLogId() {
        return productExpenseLogId;
    }

    public void setProductExpenseLogId(Integer productExpenseLogId) {
        this.productExpenseLogId = productExpenseLogId;
    }

    @Basic
    @Column(name = "costPerUnit")
    public Double getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(Double costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    @Basic
    @Column(name = "saleId")
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

    @ManyToOne
    @JoinColumn(name = "productExpenseLogId", referencedColumnName = "id", insertable = false, updatable = false)
    public ProductExpenseLogModel getProductExpenseLogByProductExpenseLogId() {
        return productExpenseLogByProductExpenseLogId;
    }

    public void setProductExpenseLogByProductExpenseLogId(ProductExpenseLogModel productExpenseLogByProductExpenseLogId) {
        this.productExpenseLogByProductExpenseLogId = productExpenseLogByProductExpenseLogId;
    }

    @ManyToOne
    @JoinColumn(name = "saleId", referencedColumnName = "id", insertable = false, updatable = false)
    public SaleModel getSaleBySaleId() {
        return saleBySaleId;
    }

    public void setSaleBySaleId(SaleModel saleBySaleId) {
        this.saleBySaleId = saleBySaleId;
    }
}
