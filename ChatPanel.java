import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ChatPanel extends JPanel{
	private ChatServerSocket server = new ChatServerSocket();
	private JTextField field = new JTextField(10);
	private JTextArea area = new JTextArea(10, 20);
	private JButton sendB = new JButton("send");
	private MyThread th = new MyThread();
	
	public ChatPanel() {
		setLayout(new FlowLayout());
		sendB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = field.getText();
				server.sendMessage(text);
				area.append("Server : " + text + "\n");
				field.setText("");
			}
		});
		add(area);
		add(field);
		add(sendB);
		th.start();
	}
	
	class MyThread extends Thread{
		@Override
		public void run() {
			while(true) {
				String text = server.getMessage();
				area.append("Client : " + text + "\n");
			}
		}
	}
}