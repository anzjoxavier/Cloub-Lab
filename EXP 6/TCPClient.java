import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        final String SERVER_IP = "127.0.0.1"; 
        final int SERVER_PORT = 12345;

        try {
	Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("Connected to server: " + SERVER_IP + ":" + SERVER_PORT);

	BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

	PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

	BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String userInput = "";
            while (true) {
		System.out.print("Enter message: ");
		userInput = consoleReader.readLine();
		if(userInput.equals("exit")) {
			break;
		}
                writer.println(userInput);

	    String serverResponse = reader.readLine();
                System.out.println("Server: " + serverResponse);
            }

	consoleReader.close();
            reader.close();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



