# Online Chat Application

## Introduction
This Java application allows multiple users to connect to a central server, send messages, and receive messages from other users. The server handles multiple client connections using socket programming.

## How to Run

1. **Compile the Server and Client**
2. **Start the Server**
3. **Start the Client**
4. **Connecting Clients**
- Enter the server address when prompted.
- Type messages and press Enter to send them to all connected clients.

## Implementation Details

### Server (ChatServer.java)
- Uses `ServerSocket` to accept incoming client connections.
- Assigns a unique user ID to each client.
- Maintains a list of connected clients and broadcasts received messages to all clients.

### Client (ChatClient.java)
- Connects to the server using a socket.
- Spawns `ReadThread` and `WriteThread` for handling server communication.
- Displays incoming messages and allows sending messages to the server.

### User Interface
- Text-based input and display for client messaging.

## Potential Improvements
- Add GUI for a more user-friendly interface.
- Implement user authentication.
- Add message encryption for secure communication.

