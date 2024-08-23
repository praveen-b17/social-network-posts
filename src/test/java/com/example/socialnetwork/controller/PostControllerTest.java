package com.example.socialnetwork.controller;

import com.example.socialnetwork.model.Post;
import com.example.socialnetwork.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(PostController.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostRepository postRepository;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new PostController(postRepository)).build();
    }

    @Test
    public void testGetTop10PostsByCategory() throws Exception {
        when(postRepository.findTop10ByPostCategoryOrderByViewCountDesc(eq("Music"), any(Pageable.class)))
                .thenReturn(List.of(
                        new Post(2L, LocalDate.of(2024, 2, 22), "Music", "Eve", "My concert was amazing last night!", 2850),
                        new Post(1L, LocalDate.of(2024, 1, 15), "Music", "Alice", "Check out my new song!", 1570)
                ));

        mockMvc.perform(get("/posts/top10/Music")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].author").value("Eve"))
                .andExpect(jsonPath("$[1].author").value("Alice"));
    }

    @Test
    public void testSearchPostsByAuthor() throws Exception {
        when(postRepository.findByAuthorContaining(any()))
                .thenReturn(List.of(
                        new Post(1L, LocalDate.of(2024, 1, 15), "Music", "Alice", "Check out my new song!", 1570),
                        new Post(13L, LocalDate.of(2024, 1, 20), "Music", "Alice", "Join me live for a music session.", 2340)
                ));

        mockMvc.perform(get("/posts/search")
                        .param("author", "Alice")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].author").value("Alice"))
                .andExpect(jsonPath("$[1].author").value("Alice"));
    }
}
