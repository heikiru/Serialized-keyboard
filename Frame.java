import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class Frame extends JFrame{

	private JPanel panelTextArea, panelText;
	private PanelTeclas panelTeclas;
	private JTextArea textArea;
	private JLabel pangramaText, pontuacao;

	public Frame(){
		super("Aplicativo de Digitação");
		setLayout(new FlowLayout());

		JMenu testePangrama = new JMenu("Teste Pangrama");
		testePangrama.setMnemonic('T');
		JMenu historico = new JMenu("Histórico");
		testePangrama.setMnemonic('H');

		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(testePangrama);
		bar.add(historico);

		panelTextArea = new JPanel( new BorderLayout() );
		panelTextArea.setPreferredSize(new Dimension(900, 200));
		textArea = new JTextArea(" ");
		textArea.addKeyListener(new keyboardListener());
		panelTextArea.add(textArea, BorderLayout.CENTER);
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

}