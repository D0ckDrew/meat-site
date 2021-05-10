package com.meatSite.meatSiteBackend.databaseModels;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "production_output", schema = "meat_site_db", catalog = "")
public class ProductionOutputModel {
    private Long id;
    private Timestamp date;
    private int recyclingId;
    private int productReceiptsLogId;
    private int userId;
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
    public int getRecyclingId() {
        return recyclingId;
    }

    public void setRecyclingId(int recyclingId) {
        this.recyclingId = recyclingId;
    }

    @Basic
    @Column(name = "productReceiptsLogId")
    public int getProductReceiptsLogId() {
        return productReceiptsLogId;
    }

    public void setProductReceiptsLogId(int productReceiptsLogId) {
        this.productReceiptsLogId = productReceiptsLogId;
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

        ProductionOutputModel that = (ProductionOutputModel) o;

        if (recyclingId != that.recyclingId) return false;
        if (productReceiptsLogId != that.productReceiptsLogId) return false;
        if (userId != that.userId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + recyclingId;
        result = 31 * result + productReceiptsLogId;
        result = 31 * result + userId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "recyclingId", referencedColumnName = "id", nullable = false)
    public RecyclingModel getRecyclingByRecyclingId() {
        return recyclingByRecyclingId;
    }

    public void setRecyclingByRecyclingId(RecyclingModel recyclingByRecyclingId) {
        this.recyclingByRecyclingId = recyclingByRecyclingId;
    }

    @ManyToOne
    @JoinColumn(name = "productReceiptsLogId", referencedColumnName = "id", nullable = false)
    public ProductReceiptsLogModel getProductReceiptsLogByProductReceiptsLogId() {
        return productReceiptsLogByProductReceiptsLogId;
    }

    public void setProductReceiptsLogByProductReceiptsLogId(ProductReceiptsLogModel productReceiptsLogByProductReceiptsLogId) {
        this.productReceiptsLogByProductReceiptsLogId = productReceiptsLogByProductReceiptsLogId;
    }

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    public UserModel getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserModel userByUserId) {
        this.userByUserId = userByUserId;
    }
}
