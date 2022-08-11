import java.net.*;
import java.io.*;

public class ClientSocket {
	private Socket sock;
	private BufferedReader in;
	private BufferedWriter out;
	
	public ClientSocket() {
		try {
			sock = new Socket("localhost", 9090);
			System.out.println("Connected with Server");
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void sendMessage(String text) {
		try {
			out.write(text + "\n");
			out.flush();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
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