package com.meatSite.meatSiteBackend.databaseModels;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "delivery", schema = "meat_site_db", catalog = "")
public class DeliveryModel {
    private Long id;
    private Timestamp date;
    private String note;
    private int suppliersId;
    private int userId;
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
    public int getSuppliersId() {
        return suppliersId;
    }

    public void setSuppliersId(int suppliersId) {
        this.suppliersId = suppliersId;
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

        DeliveryModel that = (DeliveryModel) o;

        if (suppliersId != that.suppliersId) return false;
        if (userId != that.userId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + suppliersId;
        result = 31 * result + userId;
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
