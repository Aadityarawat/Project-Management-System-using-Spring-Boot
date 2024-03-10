Project Management System
  **Setup Instructions**
    Clone the repository.
    Ensure you have Java and Maven installed.
    Run mvn clean install to build the project.
    Execute java -jar target/ProjectManagementSystem-0.0.1-SNAPSHOT.jar to start the application.
    The application will be accessible at http://localhost:8081.
  
  API Usage
  
    Get All Projects
      Endpoint: GET /getAllProjects
      Description: Retrieve all projects.
      Response:
      Status Code: 200 OK
      Body: List of projects
    
    Get Project by ID
      Endpoint: GET /getProjectById/{id}
      Description: Retrieve a project by its ID.
      Parameters:
      {id}: ID of the project to retrieve.
      Response:
      Status Code: 200 OK if found, 500 Internal Server Error if not found.
      
    Add Project
      Endpoint: POST /addProject
      Description: Add a new project.
      Request Body: Project object
      Response:
      Status Code: 200 OK if added successfully, 500 Internal Server Error if failed.
      
    Update Project by ID
      Endpoint: POST /updateProject/{id}
      Description: Update an existing project.
      Parameters:
      {id}: ID of the project to update.
      Request Body: Updated Project object
      Response:
      Status Code: 200 OK if updated successfully, 500 Internal Server Error if failed.
      
    **Delete Project by ID**
      Endpoint: DELETE /deleteProject/{id}
      Description: Delete a project by its ID.
      Parameters:
      {id}: ID of the project to delete.
      Response:
      Status Code: 204 No Content if deleted successfully, 500 Internal Server Error if failed.
