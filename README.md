# WebSocket Chat Application

## Overview
This WebSocket Chat Application allows users to communicate with each other in real-time within a chat room environment. It supports user authentication, creation of a single chat room upon server startup, persistent storage of chat messages in a database, sending and receiving messages in the chat room, WebSocket support for real-time communication, and deletion of messages by clients.

## Implementation Steps

### Step 1: Set Up the Project
1. Create a new Spring Boot project using Spring Initializr.
2. Add dependencies for Spring Web, Spring Security, Spring Data JPA, H2 Database, Lombok, and WebSocket.

### Step 2: User Authentication
1. Configure Spring Security to handle user authentication with basic username/password login.
2. Hardcode credentials for initial user authentication.

### Step 3: Single Chat Room Creation
1. Create a ChatRoom entity to represent a chat room.
2. Implement logic to create a single chat room upon server startup.
3. Store the chat room details in the PostgreSQL database.

### Step 4: Persistent Storage of Chat Messages
1. Create a Message entity to represent chat messages.
2. Configure Spring Data JPA to store chat messages in the database.
3. Implement methods to save and retrieve messages from the database.

### Step 5: WebSocket Support
1. Create a WebSocket controller to handle WebSocket connections and message exchange.
2. Implement methods to send and receive messages in real-time using WebSocket communication.

### Step 6: Deletion of Messages
1. Implement logic to allow clients to delete their own messages.
2. Add functionality to the WebSocket controller to handle message deletion requests.

## Execution Steps
1. Run the Spring Boot application.
2. Connect to the WebSocket endpoint using a WebSocket client or tool.
3. Authenticate using the hardcoded credentials.
4. Send and receive messages in the chat room.
5. Test message deletion functionality.

## Testing Approach
- Use WebSocket client tools or browser-based WebSocket clients to connect to the WebSocket endpoint and send/receive messages.
- Write unit tests for WebSocket controllers, service methods, and repository methods using testing frameworks like JUnit and Mockito.
- Test authentication, message storage, retrieval, and deletion functionalities manually and automate where possible.


# Cloud deployment 
# WebSocket Chat App Deployment

This guide outlines the steps to deploy the WebSocket Chat App to Azure using GitHub Actions CI/CD.

## Prerequisites

- An Azure subscription
- A GitHub repository containing the WebSocket Chat App source code
- Azure CLI installed locally (for Azure configuration)

## Step 1: Set Up Azure Resources

1. Provision an Azure App Service for deploying the WebSocket Chat App.
2. Create a PostgreSQL database in Azure for storing chat messages.

## Step 2: Configure GitHub Secrets

1. In the GitHub repository, navigate to Settings > Secrets.
2. Add the following secrets:
    - `AZURE_CREDENTIALS`: Azure Service Principal credentials with permissions to deploy to Azure.
    - `AZURE_RESOURCE_GROUP`: Name of the Azure resource group.
    - `AZURE_APP_NAME`: Name of the Azure App Service.
    - `DATABASE_URL`: Connection string for the PostgreSQL database.

## Step 3: Create GitHub Actions Workflow

1. Create a new YAML file (e.g., deploy.yml) in the `.github/workflows` directory.
2. Define the deployment workflow in the YAML file, specifying steps to build and deploy the app.

## Step 4: Build and Deploy the App

1. Push your changes to the main branch of the GitHub repository.
2. GitHub Actions will automatically trigger the deployment workflow.
3. Monitor the workflow execution in the GitHub Actions tab.
4. Once the workflow completes successfully, the WebSocket Chat App will be deployed to Azure App Service.

## Step 5: Test the Deployment

1. Access the deployed WebSocket Chat App through the Azure App Service URL.
2. Test the chat functionality to ensure that messages are sent and received correctly.
3. Check the PostgreSQL database to verify that chat messages are being stored properly.

## Step 6: Monitor and Maintain

1. Set up Azure monitoring and logging to monitor the performance and health of the deployed app.
2. Regularly update and maintain the WebSocket Chat App as needed.

## Troubleshooting

- If the deployment fails, check the GitHub Actions logs for error messages.
- Ensure that all necessary configurations and secrets are correctly set up in GitHub and Azure.

