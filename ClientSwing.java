import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ClientSwing extends JFrame{
	private ClientPanel panel = new ClientPanel();
	
	public ClientSwing() {
		setTitle("Client Chat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(250, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ClientSwing();
	}

}