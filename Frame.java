import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;


public class Frame extends JFrame{

	private JPanel panelTextArea, panelText, panelTotal, panelHistorico, panelJogo;
	private PanelTeclas panelTeclas;
	private JTextArea textArea;
	private JLabel pangramaText, pontuacao;
	private JRadioButton[] pangramaButton;
	private JButton[] jogoButton;
	private ButtonGroup pangramaGroup;
	private Pangrama[] pangrama;
	private String[] pan;
	private StringToChar sc;
	private RadioButtonHandler pangramaButtonHandler;
	private Pangrama selectedPan;
	private int points;
	private String text;
	private Deserializer deserial;
	private Serializer serial;
	private JLabel historyLabel;

	public int getPoints() {
		return points;
	}
	public void setPoints(int erros) {
		this.points = erros;
	}
	
	public String getText(){
		return text; 
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Pangrama getSelectedPan() {
		return selectedPan;
	}

	public Frame(){
		super("Aplicativo de DigitaÃ§Ã£o");
		setLayout(new FlowLayout());
		
		panelTotal= new JPanel(new BorderLayout());

		panelTextArea = new JPanel( new BorderLayout() );
		panelTextArea.setPreferredSize(new Dimension(900, 200));
		textArea = new JTextArea(" ");
		textArea.addKeyListener(new KeyboardListener());
		
		panelTextArea.add(textArea, BorderLayout.CENTER);
		panelTotal.add(panelTextArea, BorderLayout.NORTH);

		panelText = new JPanel( new FlowLayout(FlowLayout.LEFT) );
		panelText.setPreferredSize(new Dimension(900, 175));
		panelText.add(Box.createVerticalStrut(150));
		
		pangramaGroup = new ButtonGroup();
	      
	      sc = new StringToChar();
	      pangrama = new Pangrama[5];
	      pan = new String[5];
	      pan[0]= "Um pequeno jabuti xereta viu dez cegonhas felizes.";
	      pan[1]= "Quem traz CD, LP, fax, engov e whisky JB?";
	      pan[2]= "Gazeta publica hoje breve nota de faxina na quermesse.";
	      pan[3]= "Jovem craque belga prediz falhas no xote.";
	      pan[4]= "Bancos futeis pagavam-lhe queijo, whisky e xadrez.";
	  	
	  	for(int i=0; i<pan.length; i++) {
	  		pangrama[i]= new Pangrama(sc.stringToChar(pan[i]),0);
	  	}
	  	
	  	pangramaButtonHandler = new RadioButtonHandler();
		pangramaButton = new JRadioButton[pan.length];
		Box box = Box.createVerticalBox();
	      
      	for(int i=0; i<pan.length; i++) {
	    	  pangramaButton[i] = new JRadioButton(pan[i]);
	    	  pangramaButton[i].setFont(new Font(pangramaButton[i].getName(), Font.PLAIN, 18));
	    	  pangramaGroup.add(pangramaButton[i]);
	    	  box.add(pangramaButton[i]);
	    	  pangramaButton[i].addItemListener(pangramaButtonHandler);
      	}
		
		pangramaText = new JLabel("Label para o pangrama");
		pangramaText.setFont(new Font(pangramaText.getName(), Font.PLAIN, 16));
		box.setPreferredSize(new Dimension(600, 250));
		panelText.add(box);
		
		pontuacao = new JLabel("Pontuacao: " + this.points);
		pontuacao.setFont(new Font(pontuacao.getName(), Font.PLAIN, 18));
		pontuacao.setPreferredSize(new Dimension(150, 50));
		panelText.add(pontuacao);
		panelTotal.add(panelText, BorderLayout.WEST);
		
		panelTeclas = new PanelTeclas();

		panelTeclas.setPreferredSize(new Dimension(900, 250));
		panelTotal.add(panelTeclas, BorderLayout.SOUTH);
		
		JTabbedPane tabbedPane = new JTabbedPane(); // create JTabbedPane
		tabbedPane.addTab("Teste Pangrama", null, panelTotal, "Primeiro Panel");
		
		panelHistorico = new JPanel();
		
		tabbedPane.addTab("Historico", null, panelHistorico);
	
		Sort s = new Sort();
		JPanel p = new JPanel(new FlowLayout());
		p.setSize(1000,1000);
		
		JLabel seta = new JLabel(s.random_seta());
		JPanel panelSeta= new JPanel();
		panelSeta.add(seta);
		
		panelJogo = new JPanel(new BorderLayout());
		panelJogo.setSize(new Dimension(100,100));
		
		jogoButton = new JButton[4];
		
		jogoButton[0] = new JButton("^"); 
		jogoButton[1] = new JButton("v"); 
		jogoButton[2] = new JButton("<"); 
		jogoButton[3] = new JButton(">"); 
		
		panelJogo.add(jogoButton[0], BorderLayout.NORTH);
		panelJogo.add(jogoButton[1], BorderLayout.SOUTH);
		panelJogo.add(jogoButton[2], BorderLayout.WEST);
		panelJogo.add(jogoButton[3], BorderLayout.EAST);
		panelJogo.add(panelSeta, BorderLayout.CENTER);
		
		p.add(panelJogo);
		
		tabbedPane.addTab("Jogo", null, p);
		add(tabbedPane);
	}

	private class KeyboardListener extends KeyAdapter {
		public void keyPressed(KeyEvent e){
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				serial.openFile();
				serial.addRecord();
			}
		}
	}

	public void keyTyped(KeyEvent e){}

	public void keyPressed(KeyEvent e){
		System.out.println(e.getKeyChar()+" "+e.getKeyCode()+" "+KeyEvent.getKeyText(e.getKeyCode()));
		panelTeclas.changeBackground(e.getKeyCode());
	}

	public void keyReleased(KeyEvent e){
		panelTeclas.changeBack(e.getKeyCode());
	}
	
	private class RadioButtonHandler implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
							
			for (int i = 0; i < pangramaButton.length; i++) {
				if(pangramaButton[i].isSelected()) {
					selectedPan = pangrama[i];
				}
			}
		}
	}
}
