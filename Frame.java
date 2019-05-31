import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Frame extends JFrame{

	private JPanel panelTextArea, panelText, panelTeclas;
	private JTextArea textArea;
	private JLabel pangramaText, pontuacao;
	private boolean enterPressed;

	public String get_Whole_textArea(){
		String temp = "";
		if(enterPressed) { temp = textArea.getText(); }
		return temp; 
		// Maybe trying to change it later. Could this be better inside another method?
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

	private class KeyHandler implements KeyAdapter {
        public void keyPressed(KeyEvent e){
            if (e.getKeyCode() == 13) // Enter-key
                enterPressed = true;
        }
    }

	public static void main(String args[]){
		Frame f = new Frame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000, 1000);
		f.setVisible(true);
	}
}
