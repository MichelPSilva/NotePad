import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class NotePad extends JFrame{
	private JMenu arquivo;
	private JMenuBar barMenu;
	private JMenuItem miSair;
	private TextArea taText;
	private JTextField tfResposta;
	private JPanel pPrinci, pAcoes;
	private ImageIcon imgSalvar;
	private JButton btnSalvar;
	private FileDialog fdSalvar;
	
	private String nome_do_arquivo;
	
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
		// Configurando a Janela
		setTitle("NotePad Crackeado");
		setLayout(null);
		setSize(500, 450);
		setResizable(false);
		
		// Configurando Menus
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
		
		// Painel Principal
		pPrinci = new JPanel(null);
		pPrinci.setBounds(0, 0, 600, 500);
		pPrinci.setBackground(new Color(70,130,180));
		add(pPrinci);
	
		// Painel das Ações
		pAcoes = new JPanel(null);
		pAcoes.setBounds(5, 10, 472, 45);
		pAcoes.setBackground(new Color(242,242,242));
		pPrinci.add(pAcoes);
		
		// Botão de Salvar
		imgSalvar = new ImageIcon("imgSalvar.png");
		btnSalvar = new JButton(imgSalvar);
		btnSalvar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.setBounds(5, 5, 35, 35);
		pAcoes.add(btnSalvar);

		// Configurando janela de Salvar
		fdSalvar = new FileDialog(this, "Salvar arquivo", FileDialog.SAVE);
		
		// Configurando o TextArea 
		taText = new TextArea();
		taText.setBounds(5, 65, 472, 270);
		taText.setBackground(new Color (238,232,170));
		pPrinci.add(taText);
		
		// Configurando Tf de resposta
		tfResposta = new JTextField ("Resposta: ");
		tfResposta.setBounds(5, 340, 472, 40);
		tfResposta.setBackground(new Color(242,242,242));
		tfResposta.setEditable(false);
		pPrinci.add(tfResposta);
		
	}
	
	public void Eventos() {
		miSair.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		});
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fdSalvar.setVisible(true);
					if (fdSalvar.getFile() == null) {
						return;
					}
					nome_do_arquivo = fdSalvar.getDirectory()
							+ fdSalvar.getFile();
					FileWriter out = new FileWriter(nome_do_arquivo);
					out.write(taText.getText());
					out.close();
					tfResposta.setText("Resposta: Arquivo gravado com sucesso");
				} catch (IOException erro) {
					tfResposta.setText("Resposta: Erro ao gravar no arquivo"
							+ erro.toString());
				}

			}
		});
		
	}
	
}