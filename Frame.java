package keyboard;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.KeyListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;


public class Frame extends JFrame{

	private JPanel panelTextArea, panelText, panelPangrama;
	private PanelTeclas panelTeclas;
	private JTextArea textArea;
	private JLabel pangramaText, pontuacao;
	private JRadioButton[] pangramaButton;
	private JButton jogoButton;
	private ButtonGroup pangramaGroup;
	private Pangrama[] pangrama;
	private String[] pan;
	private StringToChar sc;
	private RadioButtonHandler pangramaButtonHandler;
	private Pangrama selectedPan;
	private int points;
	
	
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int erros) {
		this.points=erros;
	}
	
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
		super("Aplicativo de DigitaÃ§Ã£o");
		setLayout(new FlowLayout());

		JMenu testePangrama = new JMenu("Teste Pangrama");
		testePangrama.setMnemonic('T');
		JMenu historico = new JMenu("HistÃ³rico");
		testePangrama.setMnemonic('H');

		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(testePangrama);
		bar.add(historico);
		
		
		
		
		
		
		
		jogoButton = new JButton();
		
		
		//
		
		
		

		panelTextArea = new JPanel( new BorderLayout() );
		panelTextArea.setPreferredSize(new Dimension(900, 200));
		textArea = new JTextArea(" ");
		textArea.addKeyListener(new keyboardListener());
		panelTextArea.add(textArea, BorderLayout.CENTER);
		add(panelTextArea);

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
	      pan[4]= "Bancos fúteis pagavam-lhe queijo, whisky e xadrez.";
	  	
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
		
		
		
		
		pontuacao = new JLabel("Pontuação: " + this.points);
		pontuacao.setFont(new Font(pontuacao.getName(), Font.PLAIN, 18));
		pontuacao.setPreferredSize(new Dimension(150, 50));
		panelText.add(pontuacao);
		add(panelText);

		
		panelTeclas = new PanelTeclas();
		panelTeclas.setPreferredSize(new Dimension(900, 250));
		add(panelTeclas);
		
		

	}

	public static void main(String args[]){
		Frame f = new Frame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000, 1000);
		f.setVisible(true);
	}

	private class keyboardListener implements KeyListener{

	public void keyTyped(KeyEvent e){

	}

	public void keyPressed(KeyEvent e){
		System.out.println(e.getKeyChar()+" "+e.getKeyCode()+" "+KeyEvent.getKeyText(e.getKeyCode()));

		panelTeclas.changeBackground(e.getKeyCode());

	}

	public void keyReleased(KeyEvent e){
		panelTeclas.changeBack(e.getKeyCode());
	}
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
