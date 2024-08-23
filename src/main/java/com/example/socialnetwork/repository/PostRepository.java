package com.example.socialnetwork.repository;

import com.example.socialnetwork.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    // SQL to get the top 10 posts based on view count
    @Query("SELECT p FROM Post p ORDER BY p.viewCount DESC")
    List<Post> findTop10ByOrderByViewCountDesc(Pageable pageable);

    List<Post> findTop10ByPostCategoryOrderByViewCountDesc(String postCategory, Pageable pageable);

    List<Post> findByAuthorContaining(String author);

}
