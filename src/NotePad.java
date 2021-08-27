import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NotePad extends JFrame{
	private JLabel digText;
	private TextArea taText;
	private JPanel pPrinci;
	
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
		
		pPrinci = new JPanel(null);
		pPrinci.setBounds(0, 0, 600, 500);
		pPrinci.setBackground(new Color(70,130,180));
		add(pPrinci);
		
		digText = new JLabel("Digite seu texto aqui: ");
		digText.setBounds(12, 150, 150, 30);
		pPrinci.add(digText);
		
		taText = new TextArea();
		taText.setBounds(5, 180, 500, 270);
		pPrinci.add(taText);
		
	}
	
	public void Eventos() {
		
	}
	
}