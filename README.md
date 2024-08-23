# Social Network Posts Project

A Spring Boot project that exposes APIs to interact with social network posts. The project allows users to fetch the top 10 posts by view count per category, search posts by author, and perform CRUD operations on posts.

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- Git
- An IDE like IntelliJ IDEA or Eclipse
- H2 Database (integrated in-memory database)

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/social-network-post-api.git
cd social-network-post-api
```


### 2. Build the Project

Navigate to the project directory and run the following command to build the project using Maven:

```bash
mvn clean install
```

### 3. Run the Project

To start and run the application, follow these steps:

1. **Run the Application Using Your IDE**
   - In IntelliJ IDEA, locate the main class that contains the `@SpringBootApplication` annotation (usually named `Application.java` or similar).
   - Right-click on the main class and select "Run `<ClassName>`."

2. **Run the Application Using Maven**
   - Open a terminal or command prompt.
   - Navigate to the root directory of the project.
   - Execute the following Maven command to start the application:
     ```bash
     mvn spring-boot:run
     ```

3. **Access the Application**
   - Once the application starts, it will be running on the default port `8080`. You can access it using a web browser or API client.
   - For example, open a web browser and navigate to:
     ```
     http://localhost:8080
     ```

4. **Verify Application is Running**
   - Check the terminal or IDE console for logs indicating that the application has started successfully.
   - Test the application endpoints using tools like Postman or a web browser to ensure that they are functioning correctly.

Running the application allows you to interact with the APIs and verify that the application behaves as expected in a live environment.


### 4. Access the API Endpoints

Once the application is running, you can interact with the API endpoints using tools like Postman or cURL. Below are some example endpoints you can test:

- **Get Top 10 Posts by Category**
  - **Endpoint:** `GET /posts/top10/{category}`
  - **Example Request:** `GET http://localhost:8080/posts/top10/Music`
  - **Description:** Returns the top 10 posts with the highest view counts for the specified category.

- **Search Posts by Author**
  - **Endpoint:** `GET /posts/search/{author}`
  - **Example Request:** `GET http://localhost:8080/posts/search/Alice`
  - **Description:** Searches for posts written by the specified author.

- **Get All Posts**
  - **Endpoint:** `GET /posts`
  - **Example Request:** `GET http://localhost:8080/posts`
  - **Description:** Retrieves all posts from the database.

- **Get Post by ID**
  - **Endpoint:** `GET /posts/{id}`
  - **Example Request:** `GET http://localhost:8080/posts/1`
  - **Description:** Retrieves a specific post by its ID.

- **Create a New Post**
  - **Endpoint:** `POST /posts`
  - **Request Body Example:**
    ```json
    {
      "postDate": "2024-08-23",
      "postCategory": "Music",
      "author": "John",
      "content": "Check out my latest song!",
      "viewCount": 1234
    }
    ```
  - **Description:** Creates a new post with the provided details.

- **Update an Existing Post**
  - **Endpoint:** `PUT /posts/{id}`
  - **Request Body Example:**
    ```json
    {
      "postDate": "2024-08-23",
      "postCategory": "Music",
      "author": "John",
      "content": "Updated content",
      "viewCount": 5678
    }
    ```
  - **Description:** Updates an existing post with the specified ID using the provided details.

- **Delete a Post**
  - **Endpoint:** `DELETE /posts/{id}`
  - **Example Request:** `DELETE http://localhost:8080/posts/1`
  - **Description:** Deletes a specific post by its ID.

### 5. Run the Tests

To ensure that the application is working as expected, you should run the test cases. The project uses JUnit for testing. Follow these steps to run the tests:

1. **Open the Project in Your IDE**
   - Open your IDE (e.g., IntelliJ IDEA, Eclipse) and load the project.

2. **Run Tests Using Your IDE**
   - In IntelliJ IDEA, right-click on the `src/test/java` directory or on the test classes in the Project view, and select "Run All Tests."
   - In Eclipse, right-click on the `src/test/java` directory or on the test classes, and select "Run As" -> "JUnit Test."

3. **Run Tests Using Maven**
   - Open a terminal or command prompt.
   - Navigate to the root directory of the project.
   - Execute the following Maven command to run all tests:
     ```bash
     mvn test
     ```

4. **Verify Test Results**
   - Check the test results in the IDE's test runner or in the terminal output. Ensure that all tests pass successfully.
   - Review any failed tests and address issues if necessary.

Running tests helps to confirm that your application behaves as expected and that changes have not introduced any regressions.

