package com.amaizing.crudtemplate;

import com.amaizing.crudtemplate.controllers.AlbumController;
import com.amaizing.crudtemplate.models.Album;
import com.amaizing.crudtemplate.repositories.AlbumRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class AlbumControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AlbumRepository repository;

    @InjectMocks
    private AlbumController controller;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testGetAllAlbums() throws Exception {
        List<Album> albums = new ArrayList<>();
        albums.add(new Album(1L, "Album 1", "Artist 1", "2022-01-01", "Label 1"));
        albums.add(new Album(2L, "Album 2", "Artist 2", "2022-02-01", "Label 2"));

        when(repository.findAllByOrderByIdAsc()).thenReturn(albums);

        mockMvc.perform(get("/api/v1/tables/albums"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title").value("Album 1"))
                .andExpect(jsonPath("$[1].title").value("Album 2"));

        verify(repository, times(1)).findAllByOrderByIdAsc();
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testCreateAlbum() throws Exception {
        Album album = new Album(1L, "New Album", "New Artist", "2024-01-01", "New Label");

        when(repository.save(any(Album.class))).thenReturn(album);

        mockMvc.perform(post("/api/v1/tables/albums")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"title\": \"New Album\", \"artist\": \"New Artist\", \"releaseDate\": \"2024-01-01\", \"recordLabel\": \"New Label\" }"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value("New Album"))
                .andExpect(jsonPath("$.artist").value("New Artist"))
                .andExpect(jsonPath("$.releaseDate").value("2024-01-01"))
                .andExpect(jsonPath("$.recordLabel").value("New Label"));

        verify(repository, times(1)).save(any(Album.class));
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testUpdateAlbum() throws Exception {
        Album existingAlbum = new Album(1L, "Existing Album", "Existing Artist", "2023-01-01", "Existing Label");
        Album updatedAlbum = new Album(1L, "Updated Album", "Updated Artist", "2023-01-01", "Updated Label");

        when(repository.findById(1L)).thenReturn(Optional.of(existingAlbum));
        when(repository.save(any(Album.class))).thenReturn(updatedAlbum);

        mockMvc.perform(post("/api/v1/tables/albums/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"title\": \"Updated Album\", \"artist\": \"Updated Artist\", \"releaseDate\": \"2023-01-01\", \"recordLabel\": \"Updated Label\" }"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value("Updated Album"))
                .andExpect(jsonPath("$.artist").value("Updated Artist"))
                .andExpect(jsonPath("$.releaseDate").value("2023-01-01"))
                .andExpect(jsonPath("$.recordLabel").value("Updated Label"));

        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(any(Album.class));
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testDeleteAlbum() throws Exception {
        mockMvc.perform(delete("/api/v1/tables/albums/1"))
                .andExpect(status().isOk());

        verify(repository, times(1)).deleteById(1L);
        verifyNoMoreInteractions(repository);
    }
}