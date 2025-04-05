# nmr_data_extractor_API

**nmr_data_extractor_API** is the backend API of the **nmr_data_extractor** project, developed using **Spring Boot** and **Java**. This API serves as the intermediary between the frontend (UI), the Python API for data processing, and the molecular generation engine. It handles data exchange, user management, and facilitates communication between various components of the system.

## Features

- **Integration** with the Python API for spectroscopic data processing and analysis.
- **Molecular generation engine** for structural elucidation of organic molecules.
- **User management system**, including authentication and user roles.
- **Data handling** to ensure smooth communication between the frontend, the Python API, and the molecular generation engine.

## Technologies Used

- **Spring Boot** for the backend application framework.
- **Java** for the implementation of business logic.
- **RESTful API** to handle communication between the frontend, backend, and external systems (Python API and molecular generation engine).
- **User management system** for authentication and authorization (JWT or other mechanisms).
  
## Installation

1. **Clone the repository:**
    ```bash
    git clone https://github.com/your-repository/nmr_data_extractor_API.git
    ```
2. **Navigate to the project folder:**
    ```bash
    cd nmr_data_extractor_API
    ```
3. **Build the project using Maven or Gradle:**

    - With Maven:
      ```bash
      mvn clean install
      ```

    - With Gradle:
      ```bash
      gradle build
      ```

4. **Run the application:**
    After building, you can run the Spring Boot application:
    ```bash
    java -jar target/nmr_data_extractor_API.jar
    ```

5. **Access the API:**
    Once the server is running, the API will be available at `http://localhost:8080` (or your configured port).

## Usage

- The **nmr_data_extractor_API** acts as the intermediary to handle requests from the frontend, such as uploading spectroscopic images, processing the data, and generating molecular structures.
- **User management** features include authentication (login/registration) and role-based access.
- The API communicates with the Python model and molecular generation engine to facilitate the analysis and elucidation of NMR data.

### Example of API calls:

- **POST /api/v1/auth/login** - User login and token generation.
- **POST /api/v1/spectra/upload** - Upload spectroscopic image for processing.
- **POST /api/v1/molecule/generate** - Generate a molecular structure from processed data.

For detailed API documentation, refer to the **Swagger** or Postman collection (if included in the project).

## Contributing

Feel free to fork this project and submit pull requests for improvements or bug fixes. Contributions are welcome!

### Steps to contribute:

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Open a pull request.

## License

This project is licensed under the MIT License.


