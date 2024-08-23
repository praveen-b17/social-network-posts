package com.example.socialnetwork;

import com.example.socialnetwork.model.Post;
import com.example.socialnetwork.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    private final PostRepository postRepository;

    public DataInitializer(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) {
        postRepository.saveAll(Arrays.asList(
                new Post(null, LocalDate.of(2024, 1, 15), "Music", "Alice", "Check out my new song!", 1570),
                new Post(null, LocalDate.of(2024, 2, 22), "Gaming", "Bob", "Just finished an epic gaming session!", 2215),
                new Post(null, LocalDate.of(2024, 3, 10), "News", "Charlie", "Breaking news: Major event happening now!", 3050),
                new Post(null, LocalDate.of(2024, 4, 18), "Entertainment", "Diana", "Top 10 movies to watch this summer.", 1725),
                new Post(null, LocalDate.of(2024, 5, 5), "Music", "Eve", "My concert was amazing last night!", 2850),
                new Post(null, LocalDate.of(2024, 6, 23), "Gaming", "Frank", "Tips and tricks for the latest game.", 2380),
                new Post(null, LocalDate.of(2024, 7, 1), "News", "Grace", "Election results are in.", 3190),
                new Post(null, LocalDate.of(2024, 8, 14), "Entertainment", "Heidi", "Best TV shows to binge-watch.", 1920),
                new Post(null, LocalDate.of(2024, 9, 9), "Music", "Ivan", "Album release date announced!", 2125),
                new Post(null, LocalDate.of(2024, 10, 25), "Gaming", "Judy", "Game review: The best and the worst.", 2480),
                new Post(null, LocalDate.of(2024, 11, 11), "News", "Karl", "Weather update: Severe storm approaching.", 2730),
                new Post(null, LocalDate.of(2024, 12, 5), "Entertainment", "Laura", "Celebrity gossip: Who wore it best?", 1650),
                new Post(null, LocalDate.of(2024, 1, 20), "Music", "Mallory", "Join me live for a music session.", 2340),
                new Post(null, LocalDate.of(2024, 2, 14), "Gaming", "Nina", "Top 5 games to play this month.", 2650),
                new Post(null, LocalDate.of(2024, 3, 18), "News", "Oscar", "Tech news: Latest gadget reviews.", 3130),
                new Post(null, LocalDate.of(2024, 4, 27), "Entertainment", "Paul", "Must-see theater performances.", 1840),
                new Post(null, LocalDate.of(2024, 5, 30), "Music", "Quinn", "New single dropping soon!", 2910),
                new Post(null, LocalDate.of(2024, 6, 15), "Gaming", "Rita", "Livestreaming my gameplay now!", 2320),
                new Post(null, LocalDate.of(2024, 7, 23), "News", "Sam", "Local news: Community event highlights.", 2690),
                new Post(null, LocalDate.of(2024, 8, 10), "Entertainment", "Tina", "Behind the scenes of my latest video.", 2025)
        ));
    }
}
