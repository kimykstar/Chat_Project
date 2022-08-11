import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Swing extends JFrame{
	private ChatPanel panel = new ChatPanel();
	
	public Swing() {
		setTitle("Chat Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setVisible(true);
		setSize(250, 300);
	}
	
	public static void main(String[] args) {
		new Swing();
	}

}