package ch.fhnw.pizza.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "product")
public class Product {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private int productPrice;

    @Column(name = "product_group")
    private String productGroup;

    @Column(name = "product_description")
    private String productDescription;

    @ManyToOne
    private Catalogue catalogue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    } 
    
    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

}
