import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NotePad extends JFrame{

	public static void main(String args[]) {
		JFrame frame = new NotePad();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public NotePad() {
		Componentes();
		Eventos();
	}
	
	public void Componentes() {
		setTitle("NotePad Crackeado");
		setLayout(null);
		setSize(600, 500);
		setResizable(false);
	}
	
	public void Eventos() {
		
	}
	
}
