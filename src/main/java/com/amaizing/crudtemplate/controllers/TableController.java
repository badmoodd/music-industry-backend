package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.TableEntry;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/api/v1/tables")
@AllArgsConstructor
public class TableController {

    @GetMapping
    public List<TableEntry> getTables() {
        List<TableEntry> tables = new ArrayList<>();

        tables.add(new TableEntry("Альбомы", "/api/v1/tables/albums", "albums"));
        tables.add(new TableEntry("Продажи альбомов", "/api/v1/tables/album_sales", "album_sales"));
        tables.add(new TableEntry("Артисты", "/api/v1/tables/artists", "artists"));
        tables.add(new TableEntry("Концерты", "/api/v1/tables/concerts", "concerts"));
        tables.add(new TableEntry("Саундтреки к фильмам", "/api/v1/tables/film_soundtracks", "film_soundtracks"));
        tables.add(new TableEntry("Жанры", "/api/v1/tables/genres", "genres"));
        tables.add(new TableEntry("Плейлисты", "/api/v1/tables/playlists", "playlists"));
        tables.add(new TableEntry("Песни", "/api/v1/tables/songs", "songs"));
        tables.add(new TableEntry("Продажи песен", "/api/v1/tables/song_sales", "song_sales"));
        tables.add(new TableEntry("Стриминг платформы", "/api/v1/tables/streaming_platforms", "streaming_platforms"));

        return tables;
    }


}