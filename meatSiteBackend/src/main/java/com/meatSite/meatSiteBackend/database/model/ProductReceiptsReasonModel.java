package com.meatSite.meatSiteBackend.database.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "product_receipts_reason", schema = "meat_site_db", catalog = "")
public class ProductReceiptsReasonModel {
    private Long id;
    private String name;
    private Collection<ProductReceiptsLogModel> productReceiptsLogsById;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductReceiptsReasonModel that = (ProductReceiptsReasonModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "productReceiptsReasonByProductReceiptsReasonId")
    public Collection<ProductReceiptsLogModel> getProductReceiptsLogsById() {
        return productReceiptsLogsById;
    }

    public void setProductReceiptsLogsById(Collection<ProductReceiptsLogModel> productReceiptsLogsById) {
        this.productReceiptsLogsById = productReceiptsLogsById;
    }
}
