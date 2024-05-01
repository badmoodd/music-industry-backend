package com.amaizing.crudtemplate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "song_sales")
@Getter
@Setter
@NoArgsConstructor
public class SongSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Long id;

    @Column(name = "song")
    private String song;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "sale_date")
    private String saleDate;

    @Column(name = "total_sale")
    private Double totalSale;

    @Column(name = "platform")
    private String platform;

}
