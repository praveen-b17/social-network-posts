package com.example.socialnetwork.controller;

import com.example.socialnetwork.model.Post;
import com.example.socialnetwork.repository.PostRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//        Note: Error handling has been intentionally not done by me for simplicity in this project.
//        In a production, proper error handling, customised messages to the user and validation would be necessary.


@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // Get all posts
    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Get a post by ID
    @GetMapping("/{id}")
    public Optional<Post> getPostById(@PathVariable Long id) {
        return postRepository.findById(id);
    }

    // For getting top10 posts based on view count
    @GetMapping("/top10")
    public List<Post> getTop10Posts() {
        return postRepository.findTop10ByOrderByViewCountDesc(PageRequest.of(0, 10));
    }

    // Getting top10 by category
    @GetMapping("/top10/{category}")
    public List<Post> getTop10PostsByCategory(@PathVariable String category) {
        return postRepository.findTop10ByPostCategoryOrderByViewCountDesc(category, PageRequest.of(0, 10));
    }

    // Getting by searching the author
    @GetMapping("/search")
    public List<Post> searchPostsByAuthor(@RequestParam String author) {
        return postRepository.findByAuthorContaining(author);
    }

    // Create a new post
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    // Update a post
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        post.setId(id);
        return postRepository.save(post);
    }

    // Delete a post
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
    }
}
