import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            System.out.println("Connected to server.");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Thread to read messages from server
            Thread readThread = new Thread(() -> {
                try {
                    String msg;
                    while (true) {
                        msg = dis.readUTF();
                        System.out.println("Server: " + msg);
                        if (msg.equalsIgnoreCase("exit")) break;
                    }
                } catch (IOException e) {
                    System.out.println("Connection closed.");
                }
            });

            // Thread to send messages to server
            Thread writeThread = new Thread(() -> {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                    String msg;
                    while (true) {
                        msg = br.readLine();
                        dos.writeUTF(msg);
                        dos.flush();
                        if (msg.equalsIgnoreCase("exit")) break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            readThread.start();
            writeThread.start();

            readThread.join();
            writeThread.join();

            socket.close();
            System.out.println("Client closed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
