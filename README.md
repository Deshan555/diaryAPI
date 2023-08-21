# Daybook API Documentation 📔

Welcome to the Daybook API documentation! 🚀 This API allows you to manage your daybook entries, recording your thoughts, moods, and experiences. Keep track of your journey with ease! 🌟

## Introduction 📝

The Daybook API empowers you to capture your daily experiences, emotions, and reflections. Each entry contains essential details like title, content, timestamp, location, mood, and a unique entry code.

## Getting Started 🚀

### Prerequisites 🛠️

- Postman or any other API testing tool for testing the endpoints.

### Installation 💻

1. Clone the Daybook API repository from GitHub: `git clone https://github.com/yourusername/daybook-api.git`
2. Navigate to the project directory: `cd daybook-api`
3. Run the Spring Boot application: `./mvnw spring-boot:run`

The API is now up and running! 🎉

## API Endpoints 🛤️

### Update Entry ✏️

Update an existing daybook entry.

- **Endpoint:** PUT `/api/v1/daybook/update`
- **Request Body:**
    ```json
    {
        "id": 1,
        "title": "Updated Entry",
        "content": "This is an updated entry...",
        "timestamp": "2023-08-21T15:30:00Z",
        "location": "City",
        "mood": "Happy",
        "entryCode": "ABCDE12345"
    }
    ```
- **Response:** Updated entry details.

### Add Entry 📝

Add a new daybook entry.

- **Endpoint:** POST `/api/v1/daybook/add`
- **Request Body:**
    ```json
    {
        "title": "New Entry",
        "content": "This is a new entry...",
        "timestamp": "2023-08-22T10:00:00Z",
        "location": "Suburb",
        "mood": "Excited",
        "entryCode": "FGHIJ67890"
    }
    ```
- **Response:** Newly created entry details.

### Find Entry by ID 🔍

Retrieve a specific daybook entry by its ID.

- **Endpoint:** GET `/api/v1/daybook/find/{id}`
- **Response:** Found entry details.

### Get All Entries 📋

Retrieve a list of all daybook entries.

- **Endpoint:** GET `/api/v1/daybook/all`
- **Response:** List of all entries.

### Delete Entry 🗑️

Delete a daybook entry by its ID.

- **Endpoint:** DELETE `/api/v1/daybook/drop/{id}`
- **Response:** No content.

## Swagger Documentation 📖

Explore and test the API using the interactive Swagger documentation. Access it by navigating to [Swagger UI](http://localhost:8080/swagger-ui.html) once the API is running.

## Error Codes ❌

The API may return the following error codes:

- 400 Bad Request: Invalid request format or parameters.
- 404 Not Found: Resource not found.
- 500 Internal Server Error: Server-side errors.

## Contributing 👥

We welcome contributions to enhance the Daybook API! Feel free to submit pull requests or open issues.

## License 📜

This project is licensed under the [MIT License](LICENSE).

---

Thank you for using the Daybook API! 📔 If you have any questions or suggestions, please don't hesitate to reach out. Happy journaling! 🌈
