import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NotePad extends JFrame{
	private JMenu arquivo;
	private JMenuBar barMenu;
	private JMenuItem miSair;
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
		setSize(500, 400);
		setResizable(false);
		
		barMenu = new JMenuBar();
		barMenu.setBackground(Color.white);
		arquivo = new JMenu("Arquivo");
		arquivo.setBackground(Color.white);
		miSair = new JMenuItem("Sair");
		miSair.setBackground(Color.white);
		miSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		arquivo.add(miSair);
		barMenu.add(arquivo);
		setJMenuBar(barMenu);
		
		
		pPrinci = new JPanel(null);
		pPrinci.setBounds(0, 0, 600, 500);
		pPrinci.setBackground(new Color(70,130,180));
		add(pPrinci);
		
		taText = new TextArea();
		taText.setBounds(5, 65, 472, 270);
		taText.setBackground(new Color (238,232,170));
		pPrinci.add(taText);
		
	}
	
	public void Eventos() {
		miSair.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		});
	}
	
}