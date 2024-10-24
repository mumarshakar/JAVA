import java.net.*;
import java.io.*;

public class test {
    public static void main(String[] args) {
        // Server
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(1234)) {
                Socket clientSocket = serverSocket.accept();  // Accept client connection
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("Received: " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // Client
        new Thread(() -> {
            try (Socket socket = new Socket("localhost", 1234)) {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Hello, Server!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}