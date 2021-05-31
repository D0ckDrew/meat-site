package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "production_output", schema = "meat_site_db", catalog = "")
public class ProductionOutputModel {
    private Long id;
    private Timestamp date;
    private Integer recyclingId;
    private Integer productReceiptsLogId;
    private Integer userId;
    private RecyclingModel recyclingByRecyclingId;
    private ProductReceiptsLogModel productReceiptsLogByProductReceiptsLogId;
    private UserModel userByUserId;

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
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "recyclingId")
    public Integer getRecyclingId() {
        return recyclingId;
    }

    public void setRecyclingId(Integer recyclingId) {
        this.recyclingId = recyclingId;
    }

    @Basic
    @Column(name = "productReceiptsLogId")
    public Integer getProductReceiptsLogId() {
        return productReceiptsLogId;
    }

    public void setProductReceiptsLogId(Integer productReceiptsLogId) {
        this.productReceiptsLogId = productReceiptsLogId;
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

        ProductionOutputModel that = (ProductionOutputModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (recyclingId != null ? !recyclingId.equals(that.recyclingId) : that.recyclingId != null) return false;
        if (productReceiptsLogId != null ? !productReceiptsLogId.equals(that.productReceiptsLogId) : that.productReceiptsLogId != null)
            return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (recyclingId != null ? recyclingId.hashCode() : 0);
        result = 31 * result + (productReceiptsLogId != null ? productReceiptsLogId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "recyclingId", referencedColumnName = "id", insertable = false, updatable = false)
    public RecyclingModel getRecyclingByRecyclingId() {
        return recyclingByRecyclingId;
    }

    public void setRecyclingByRecyclingId(RecyclingModel recyclingByRecyclingId) {
        this.recyclingByRecyclingId = recyclingByRecyclingId;
    }

    @ManyToOne
    @JoinColumn(name = "productReceiptsLogId", referencedColumnName = "id", insertable = false, updatable = false)
    public ProductReceiptsLogModel getProductReceiptsLogByProductReceiptsLogId() {
        return productReceiptsLogByProductReceiptsLogId;
    }

    public void setProductReceiptsLogByProductReceiptsLogId(ProductReceiptsLogModel productReceiptsLogByProductReceiptsLogId) {
        this.productReceiptsLogByProductReceiptsLogId = productReceiptsLogByProductReceiptsLogId;
    }

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    public UserModel getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserModel userByUserId) {
        this.userByUserId = userByUserId;
    }
}
