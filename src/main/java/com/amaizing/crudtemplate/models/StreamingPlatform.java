package com.amaizing.crudtemplate.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "streaming_platforms")
@Getter
@Setter
@NoArgsConstructor
public class StreamingPlatform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "platform_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "monthly_subscription")
    private Double monthlySubscription;

}