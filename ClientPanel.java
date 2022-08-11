import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ClientPanel extends JPanel{
	private JTextArea area = new JTextArea(10, 20);
	private JTextField field = new JTextField(10);
	private JButton btn = new JButton("send");
	private ClientSocket client = new ClientSocket();
	private MyThread th = new MyThread();
	
	public ClientPanel() {
		setLayout(new FlowLayout());
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = field.getText();
				client.sendMessage(message);
				area.append("Client : " + message + "\n");
				field.setText("");
			}
		});
		add(area);
		add(field);
		add(btn);
		th.start();
	}
	
	class MyThread extends Thread{
		@Override
		public void run() {
			while(true) {
				String text = client.getMessage();
				area.append("Server : " + text + "\n");
			}
		}
	}
}