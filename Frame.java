package hey;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Frame extends JFrame{

	private JPanel panelTextArea, panelText, panelTeclas;
	private JTextArea textArea;
	private JLabel pangramaText, pontuacao;
	private boolean enterPressed;
	private JRadioButton[] pangramaButton;
	private JButton jogoButton;
	private ButtonGroup pangramaGroup;
	private Pangrama[] pangrama;
	private String[] pan;
	private StringToChar sc;
	private RadioButtonHandler pangramaButtonHandler;
	private Pangrama selectedPan;
	
	
	
	
	
	public String get_Whole_textArea(){
		String temp = "";
		if(enterPressed) { temp = textArea.getText(); }
		return temp; 
		// Maybe trying to change it later. Could this be better inside another method?
	}
	public Pangrama getSelectedPan() {
		return selectedPan;
	}

	public Frame(){
		super("Aplicativo de Digitação");
		setLayout(new FlowLayout());

		JMenu testePangrama = new JMenu("Teste Pangrama");
		testePangrama.setMnemonic('T');
		JMenu historico = new JMenu("Histórico");
		historico.setMnemonic('H');
		//
		JMenuItem feature = new JMenuItem("Jogo");
		feature.setMnemonic('J');
		//
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(testePangrama);
		bar.add(historico);
		//
		bar.add(feature);
		//
		

		pangramaGroup = new ButtonGroup();
			      
	      sc = new StringToChar();
	      pangrama = new Pangrama[5];
	      pan = new String[5];
	      pan[0]= "Um pequeno	jabuti xereta viu dez cegonhas felizes.";
	      pan[1]= "Quem traz CD, LP, fax, engov e whisky JB?";
	      pan[2]=	"Gazeta publica hoje breve nota de faxina na quermesse.";
	      pan[3]= "Jovem craque belga prediz falhas no xote.";
	      pan[4]= "Bancos fúteis pagavam-lhe queijo, whisky e xadrez.";
	  	
	  	for(int i=0; i<pan.length; i++) {
	  		pangrama[i]= new Pangrama(sc.stringToChar(pan[i]),0);
	  	}
	  	
	  	pangramaButtonHandler = new RadioButtonHandler();
		pangramaButton = new JRadioButton[pan.length];
	      
	      for(int i=0; i<pan.length; i++) {
	    	  pangramaButton[i] = new JRadioButton(pan[i]);
	    	  pangramaButton[i].setMaximumSize(new Dimension(95,25));
	    	  pangramaGroup.add(pangramaButton[i]);
	    	  pangramaButton[i].addItemListener(pangramaButtonHandler);
	      }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		jogoButton = new JButton();
		
		
		//
		panelTextArea = new JPanel( new BorderLayout() );
		panelTextArea.setPreferredSize(new Dimension(900, 200));
		panelTextArea.add(new JTextArea(" "), BorderLayout.CENTER);
		add(panelTextArea);

		panelText = new JPanel( new FlowLayout(FlowLayout.LEFT) );
		panelText.setPreferredSize(new Dimension(900, 100));
		panelText.add(Box.createVerticalStrut(150));
		pangramaText = new JLabel("Label para o pangrama");
		pangramaText.setFont(new Font(pangramaText.getName(), Font.PLAIN, 18));
		pangramaText.setPreferredSize(new Dimension(450, 20));
		panelText.add(pangramaText);
		pontuacao = new JLabel("Pontuação");
		pontuacao.setFont(new Font(pontuacao.getName(), Font.PLAIN, 18));
		panelText.add(pontuacao);
		add(panelText);

		
		panelTeclas = new PanelTeclas();
		panelTeclas.setPreferredSize(new Dimension(900, 250));
		add(panelTeclas);
		
		
	}

//	private class KeyHandler implements KeyAdapter {
//        public void keyPressed(KeyEvent e){
//            if (e.getKeyCode() == 13) // Enter-key
//                enterPressed = true;
//        }
//    }
	
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
