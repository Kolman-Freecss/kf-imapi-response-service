# Incident Management API with Microservices
## Project Overview
This project is a RESTful API built in Java to manage incidents within an organization. 
The API will implement CRUD (Create, Read, Update, Delete) operations for three main entities: Incident, ResponseTeam, and Notification. 
Each microservice will handle one of these entities and communicate with the others through Kafka message events.

## Project Architecture
The project is designed in a microservices architecture connected via Apache Kafka:

- Incident Service: Manages reported incidents.
- Response Team Service: Manages the response teams assigned to each incident.
- Notification Service: Sends notifications about incident status updates to users.
- Authentication Gateway Service: Manages user authentication and authorization.

## Microservice 2: Response Team Service
- Entity: ResponseTeam
- Fields: id, teamName, members (list of members), incidentId (foreign key to Incident).
- Requirements:
  - Register and manage incidents through a specific lifecycle (reported, in progress, resolved, closed).
  - Associate response teams with incidents, prioritizing assignment based on incident severity.
  - Listen for Kafka events when an incident status changes (e.g., to IN_PROGRESS or RESOLVED).
- API Endpoints:
  - GET /teams: Retrieve all response teams.
  - GET /teams/{id}: Retrieve details of a response team.
  - POST /teams: Create a new response team (input: teamName, members).
  - PUT /teams/{id}: Update a response team (modify members).
  - DELETE /teams/{id}: Delete a response team.
  - PUT /teams/assign/{teamId}/{incidentId}: Assign a team to a specific incident.

___


## Kafka Event Handling
Each microservice listens to and produces events on Kafka:

1. Incident Service: Produces events whenever an incident is created or its status changes.
2. Response Team Service: Listens for events to automatically assign response teams to critical incidents, producing events when a team is assigned.
3. Notification Service: Listens for events and sends automatic notifications when an incident is created or changes status.

___ 
## Technical Requirements
- Data Validation: Each service should include data validation and detailed error handling.
- Swagger/OpenAPI: Automatic documentation generation for each microservice.
- Security: Basic authentication implementation for the microservices' endpoints.
- Logging and Monitoring: Services will generate structured logs to monitor event activity and operation status.

___

This architecture and structure will allow high scalability and modularity in incident management, distributing responsibilities across three well-defined microservices connected through Kafka. It facilitates a clear separation of business logic and maintains a low coupling between services, making it ideal for production environments where stability and performance are essential.
