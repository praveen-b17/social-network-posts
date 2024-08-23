package com.example.socialnetwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocialNetworkProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialNetworkProjectApplication.class, args);
		/* Note: Error handling has been intentionally not done by me for simplicity in this project.
		   In a production, proper error handling, customised messages to the user and validation would be necessary.
		*/
	}

}
