package com.example.socialnetwork.repository;

import com.example.socialnetwork.model.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    public void setUp() {
        postRepository.save(new Post(null, LocalDate.of(2024, 2, 22), "Music", "Eve", "My concert was amazing last night!", 2850));
        postRepository.save(new Post(null, LocalDate.of(2024, 1, 15), "Music", "Alice", "Check out my new song!", 1570));
    }

    @Test
    public void testFindTop10ByPostCategoryOrderByViewCountDesc() {
        List<Post> posts = postRepository.findTop10ByPostCategoryOrderByViewCountDesc("Music", PageRequest.of(0, 10));
        assertThat(posts).isNotEmpty();
        assertThat(posts.get(0).getAuthor()).isEqualTo("Eve");
    }
}
