import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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
	ArrayList<String> lines = new ArrayList<>();
	private JPanel panelTextArea, panelText, panelTotal, panelJogo;
	private PanelTeclas panelTeclas;
	private JTextArea textArea;
	private JLabel pangramaText, pontuacao, seta, labelPontJogo;;
	private JRadioButton[] pangramaButton;
	private JButton[] jogoButton;
	private ButtonGroup pangramaGroup;
	private Pangrama[] pangrama;
	private String[] pan;
	private StringToChar sc;
	private Pangrama selectedPan;
	private int points;
	private String text;
	private JLabel historyLabel;
	private PanelHistorico panelHistorico;
	private Sort s;

	private int pontJogo;

	public JTextArea get_Whole_textArea(){
		return textArea;
	}

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
		super("Aplicativo de Digitação");
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
		pan = new String[] {
			"Um pequeno jabuti xereta viu dez cegonhas felizes.",
			"Quem traz CD, LP, fax, engov e whisky JB?",
			"Gazeta publica hoje breve nota de faxina na quermesse.",
			"Jovem craque belga prediz falhas no xote.",
			"Bancos futeis pagavam-lhe queijo, whisky e xadrez.",
		};
	  	
	  	for(int i = 0; i < pan.length; i++) {
	  		pangrama[i]= new Pangrama(sc.stringToChar(pan[i]),0);
	  	}
	  	
		pangramaButton = new JRadioButton[pan.length];
		Box box = Box.createVerticalBox();
	      
      	for(int i = 0; i < pan.length; i++) {
	    	  pangramaButton[i] = new JRadioButton(pan[i]);
	    	  pangramaButton[i].setFont(new Font(pangramaButton[i].getName(), Font.PLAIN, 18));
	    	  pangramaGroup.add(pangramaButton[i]);
	    	  box.add(pangramaButton[i]);
	    	  pangramaButton[i].addItemListener((e) -> {
				for (int u = 0; u < pangramaButton.length; u++) {
					if(pangramaButton[u].isSelected()) {
						selectedPan = pangrama[u];
					}
				}
			  });
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
		
		panelHistorico = new PanelHistorico();
		
		try {
			Deserializer deserial = new Deserializer();
			lines.addAll(deserial.readRecords());
			panelHistorico.update(lines);
			deserial.closeFile();
		} catch (FileNotFoundException e) {
			System.out.println("ok: " + e.getMessage());
		}
		
		tabbedPane.addTab("Historico", null, panelHistorico);
	
		s = new Sort();
		pontJogo = 0;
		JPanel p = new JPanel(new FlowLayout());
		p.setSize(1000,1000);
		
		seta = new JLabel(s.random_char());
		JPanel panelSeta= new JPanel();
		labelPontJogo = new JLabel("0");
		p.add(labelPontJogo);
		panelSeta.add(seta);
		
		panelJogo = new JPanel(new BorderLayout());
		panelJogo.setSize(new Dimension(100,100));
		
		jogoButton = new JButton[] {
			new JButton("^"),
			new JButton("v"),
			new JButton("<"),
			new JButton(">")
		};
		jogoButton[0].addKeyListener(new KeyboardListener());
		jogoButton[1].addKeyListener(new KeyboardListener());
		jogoButton[2].addKeyListener(new KeyboardListener());
		jogoButton[3].addKeyListener(new KeyboardListener());
		
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
				Serializer serial = new Serializer();
				serial.addRecord(textArea.getText());
				serial.closeFile();
				lines.addAll(List.of(textArea.getText().split("\n")));
				panelHistorico.update(lines);
			}
			panelTeclas.changeBackground(e.getKeyCode());
			//System.out.println(e.getKeyChar() + " " + e.getKeyCode() + " " + KeyEvent.getKeyText(e.getKeyCode()));
			
			if(e.getKeyCode() == 38 || e.getKeyCode() == 37 || e.getKeyCode() == 40 || e.getKeyCode() == 39){
				String aux = "";
				if(e.getKeyCode() == 38){ aux = "^"; }
				if(e.getKeyCode() == 37){ aux = "<"; }
				if(e.getKeyCode() == 40){ aux = "v"; }
				if(e.getKeyCode() == 39){ aux = ">"; }

				if(seta.getText().equals(aux)){
					pontJogo = pontJogo+1;
				}
				else{
					pontJogo = 0;
				}
				labelPontJogo.setText(Integer.toString(pontJogo));
				seta.setText(s.random_char());
			}
		}

		public void keyTyped(KeyEvent e){}

		public void keyReleased(KeyEvent e){
			panelTeclas.changeBack(e.getKeyCode());
		}
	}
}