# DigitalAssistantService
Code Challenge: Digital Assistant Service.
This Spring Boot application provides an HTTP API for managing digital assistants and sending messages to them.

## Technologies Used

- Spring Boot 3.2.5
- Java 17
- H2 In-Memory Database

## Endpoints

### Define a Digital Assistant
- Description: Define a digital assistant with the specified name and response text.
- URL: `http://localhost:8081/digital-assistant`
- Method: `POST`
- Request Body:
  ```json
  {
    "name": "AssistantName",
    "text": "ResponseText"
  }

### Send a Message to a Digital Assistant
- Description: Send a text message to the digital assistant with the specified name and receive its response.
- URL: `http://localhost:8081/digital-assistant/send?assistant-name=assistant1`
- Method: `GET`
- Query Parameter:
  - assistant-name: Name of the digital assistant to send the message to.
- Response:
  ```json
  {
    "code": 1000,
    "msg": "Success",
    "data": "Hello i am assistant1"
  }


## Setup Locally

To run this project locally, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/RuchiraGamage/DigitalAssistantService.git

2. Run the application locally:
  - There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.sap.digitalassistantservice.Application class from your IDE.
    - Alternatively you can use the Spring Boot Maven plugin :
    ```bash
    mvn spring-boot:run


## Testing with Postman

You can test the endpoints using Postman. Here's how to do it:

1. Open Postman.

2. Set the request URL and method for the desired endpoint (define or send).

3. Add request parameters or body as described in the endpoint descriptions above.

4. Send the request and observe the response.


**Note**: H2 database is included in the project directory, so there's no need to configure it separately as all configurations are included in the application properties file.
****
