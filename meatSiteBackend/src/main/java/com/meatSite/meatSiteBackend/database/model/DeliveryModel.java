package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "delivery", schema = "meat_site_db", catalog = "")
public class DeliveryModel {
    private Long id;
    private Timestamp date;
    private String note;
    private Integer suppliersId;
    private Integer userId;
    private SuppliersModel suppliersBySuppliersId;
    private UserModel userByUserId;
    private Collection<ReceiptsModel> receiptsById;

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
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "suppliersId")
    public Integer getSuppliersId() {
        return suppliersId;
    }

    public void setSuppliersId(Integer suppliersId) {
        this.suppliersId = suppliersId;
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

        DeliveryModel that = (DeliveryModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (suppliersId != null ? !suppliersId.equals(that.suppliersId) : that.suppliersId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (suppliersId != null ? suppliersId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "suppliersId", referencedColumnName = "id", insertable = false, updatable = false)
    public SuppliersModel getSuppliersBySuppliersId() {
        return suppliersBySuppliersId;
    }

    public void setSuppliersBySuppliersId(SuppliersModel suppliersBySuppliersId) {
        this.suppliersBySuppliersId = suppliersBySuppliersId;
    }

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    public UserModel getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserModel userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "deliveryByDeliveryId")
    public Collection<ReceiptsModel> getReceiptsById() {
        return receiptsById;
    }

    public void setReceiptsById(Collection<ReceiptsModel> receiptsById) {
        this.receiptsById = receiptsById;
    }
}
