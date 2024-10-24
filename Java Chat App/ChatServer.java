import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static Set<PrintWriter> clientWriters = new HashSet<>();
    private static int userID = 0;

    public static void main(String[] args) throws Exception {
        System.out.println("Chat server started...");
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                userID++;
                new ClientHandler(clientSocket, userID).start();
            }
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private int userID;

        public ClientHandler(Socket socket, int userID) {
            this.socket = socket;
            this.userID = userID;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                synchronized (clientWriters) {
                    clientWriters.add(out);
                }

                out.println("User" + userID + " connected.");

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    for (PrintWriter writer : clientWriters) {
                        writer.println("User" + userID + ": " + message);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error handling client #" + userID);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("Could not close socket");
                }
                synchronized (clientWriters) {
                    clientWriters.remove(out);
                }
                System.out.println("User" + userID + " disconnected.");
            }
        }
    }
}