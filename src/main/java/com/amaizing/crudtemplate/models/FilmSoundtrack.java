package com.amaizing.crudtemplate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "film_soundtracks")
@Getter
@Setter
@NoArgsConstructor
public class FilmSoundtrack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "song_name")
    private String songName;

    @Column(name = "performer")
    private String performer;

}
