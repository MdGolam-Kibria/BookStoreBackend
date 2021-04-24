package com.crackcode.creack_code_bd;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private String name;
    private String description;
    private BigDecimal quantity;
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @Column(name = "image_url")
    private String imageUrl;

    private Boolean isActive;
    @Column(name = "units_in_stock")
    private Integer unitsInStock;
    @Column(name = "date_created")
    private Date createdOn;
    @Column(name = "date_updated")
    private Date updatedOn;


    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @ToString.Exclude
    private BookCategory bookCategory;

}
