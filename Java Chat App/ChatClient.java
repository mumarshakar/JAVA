import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter server address: ");
        String serverAddress = reader.readLine();

        Socket socket = new Socket(serverAddress, 12345);
        new ReadThread(socket).start();
        new WriteThread(socket).start();
    }

    private static class ReadThread extends Thread {
        private Socket socket;
        private BufferedReader in;

        public ReadThread(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                System.err.println("Error getting input stream");
            }
        }

        public void run() {
            try {
                String response;
                while ((response = in.readLine()) != null) {
                    System.out.println(response);
                }
            } catch (IOException e) {
                System.err.println("Error reading from server");
            }
        }
    }

    private static class WriteThread extends Thread {
        private PrintWriter out;
        private BufferedReader consoleReader;

        public WriteThread(Socket socket) {
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                consoleReader = new BufferedReader(new InputStreamReader(System.in));
            } catch (IOException e) {
                System.err.println("Error getting output stream");
            }
        }

        public void run() {
            try {
                String userInput;
                while ((userInput = consoleReader.readLine()) != null) {
                    out.println(userInput);
                }
            } catch (IOException e) {
                System.err.println("Error writing to server");
            }
        }
    }
}
