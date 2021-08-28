import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.io.*;

public class NotePad extends JFrame{
	private JMenu arquivo;
	private JMenuBar barMenu;
	private JMenuItem miSair;
	private JTextArea taText;
	private JScrollPane scrollPanel;
	private JSpinner fontSize;
	private JTextField tfResposta;
	private JPanel pPrinci, pAcoes;
	private ImageIcon imgSalvar, imgAbrir, imgColor;
	private JButton btnSalvar, btnAbrir, btnColor;
	private FileDialog fdSalvar, fdAbrir;
	private JComboBox cbFontes;
	
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
		
		// Botão de Abrir
		imgAbrir = new ImageIcon("imgAbrir.png");
		btnAbrir = new JButton(imgAbrir);
		btnAbrir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAbrir.setToolTipText("Abrir");
		btnAbrir.setBounds(45, 5, 35, 35);
		pAcoes.add(btnAbrir);

		// Configurando janela de Salvar e Abrir
		fdSalvar = new FileDialog(this, "Salvar arquivo", FileDialog.SAVE);
		fdAbrir = new FileDialog(this, "Abrir arquivo", FileDialog.LOAD);
		
		// Configurando o TextArea 
		taText = new JTextArea();
		taText.setBackground(new Color (238,232,170));
		taText.setLineWrap(true);
		taText.setWrapStyleWord(true);
		taText.setFont(new Font("Arial", Font.PLAIN, 12));
		taText.setForeground(Color.black);
		scrollPanel = new JScrollPane(taText);
		scrollPanel.setBounds(5, 65, 472, 270);
		pPrinci.add(scrollPanel);
		
		// Configurando input do tamanho da fonte
		fontSize = new JSpinner();
		fontSize.setBounds(85, 5, 45, 35);
		fontSize.setToolTipText("Tamanho");
		fontSize.setValue(12);
		pAcoes.add(fontSize);
		
		// Configurando o botão para trocar de cor
		imgColor = new ImageIcon("imgColor.png");
		btnColor = new JButton(imgColor);
		btnColor.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnColor.setToolTipText("Cor");
		btnColor.setBounds(135, 5, 35, 35);
		pAcoes.add(btnColor);
		
		// Configurando ComboBox para trocar fonte
		String[] fontes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		cbFontes = new JComboBox(fontes);
		cbFontes.setBounds(175, 5, 150, 32);
		cbFontes.setSelectedItem("Arial");
		pAcoes.add(cbFontes);
		
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
		
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fdAbrir.setVisible(true);
					if (fdAbrir.getFile() == null) {
						return;
					}
					nome_do_arquivo = fdAbrir.getDirectory()
							+ fdAbrir.getFile();
					FileReader in = new FileReader(nome_do_arquivo);
					String s = "";
					int i = in.read();
					while (i != -1) {
						s = s + (char) i;
						i = in.read();
					}
					taText.setText(s);
					in.close();
					tfResposta.setText("Resposta: Arquivo aberto com sucesso");
				} catch (IOException erro) {
					tfResposta.setText("Resposta: Erro ao abrir no arquivo"
							+ erro.toString());
				}
				
			}
		});
		
		fontSize.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				taText.setFont(new Font(taText.getFont().getFamily(), Font.PLAIN,(int) fontSize.getValue()));
				
			}
		});
		
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser colorChooser = new JColorChooser();
				Color color = colorChooser.showDialog(null, "Escolha sua cor", Color.pink);
				taText.setForeground(color);
			}
		});
		
		cbFontes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taText.setFont(new Font((String) cbFontes.getSelectedItem(), Font.PLAIN, taText.getFont().getSize()));
			}
		});
		
		
	}
	
}