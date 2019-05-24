import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.*;

public class Frame extends JFrame{

	private JPanel panelTextArea, panelText, panelTeclas;
	private JTextArea textArea;

	public Frame(){
		super("Aplicativo de Digitação");
		setLayout(new FlowLayout());

		panelTextArea = new JPanel( new BorderLayout() );
		panelTextArea.setPreferredSize(new Dimension(550, 200));
		panelTextArea.add(new JTextArea(" "), BorderLayout.CENTER);
		add(panelTextArea);

		
		panelTeclas = new PanelTeclas();
		panelTeclas.setPreferredSize(new Dimension(900, 900));
		panelTeclas.setBackground(Color.BLACK);
		add(panelTeclas);

	}

	public static void main(String args[]){
		Frame f = new Frame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000, 1000);
		f.setVisible(true);
	}
}