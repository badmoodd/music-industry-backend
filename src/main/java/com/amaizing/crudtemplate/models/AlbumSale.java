package com.amaizing.crudtemplate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "album_sales")
@Getter
@Setter
@NoArgsConstructor
public class AlbumSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Long id;

    @Column(name = "album")
    private String album;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "sale_date")
    private String saleDate;

    @Column(name = "total_sale")
    private Double totalSale;

    @Column(name = "platform")
    private String platform;

    // getters and setters
}
