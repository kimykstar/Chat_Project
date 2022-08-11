import java.net.*;
import java.util.*;
import java.io.*;

public class ChatServerSocket {
	private ServerSocket server;
	private Socket sock;
	private BufferedReader in;
	private BufferedWriter out;
	
	public ChatServerSocket() {
		try {
			server = new ServerSocket(9090);
			System.out.println("Waiting Connection");
			sock = server.accept();
			System.out.println("Connected with Client");
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Send message to Client 
	public void sendMessage(String text) {
		try {
			out.write(text + "\n");
			out.flush();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Get message from Client
	public String getMessage() {
		String text = null;
		try {
				text = in.readLine();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return text;
	}
}