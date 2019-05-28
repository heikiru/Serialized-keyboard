import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;

// -30 |5
public class PanelTeclas extends JPanel{

	private final String[] nomesTeclas = {"~", "1", "2", "3", "4", "5", "6", "7", "8", "9",
		"0", "-", "+", "Backspace", "Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P",
		"[", "]", "\\", "Caps", "A", "S", "D", "F", "G", "H", "J", "K", "L", ":", "*",
		"Enter", "Shift", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "?", "^", " ", "<",
		"v", ">"};
	private Teclas[] teclas;
	private JButton[] buttons;
    private GridBagConstraints c;
    private GridBagLayout gbl;

    public PanelTeclas(){
    	super();
    	Teclas aux = new Teclas();
    	teclas = aux.keyboardConstructor();

    	gbl = new GridBagLayout();
		c = new GridBagConstraints();
		setLayout( gbl );

		buttons = new JButton[nomesTeclas.length];
		c.fill = GridBagConstraints.BOTH;
    	c.weightx = 1;
    	c.weighty = 0;
    	//System.out.println("nomesTeclas.length: "+nomesTeclas.length);
    	//System.out.println("buttons.length: "+buttons.length+"\n");
    	
		for(int i=0; i<nomesTeclas.length; i++){
			//System.out.println("i: "+i);
			if(i <= 13){
				/*
				if(i == 13){
					buttons[i] = new JButton(nomesTeclas[i]);
					addComponent(buttons[i], 0, (i*2), 4, 1);
				}else{
					buttons[i] = new JButton(nomesTeclas[i]);
					addComponent(buttons[i], 0, (i*2), 2, 1);
				}
				*/
				buttons[i] = new JButton(nomesTeclas[i]);
				addComponent(buttons[i], 0, (i*2), 2, 1);
			}
			if(i>13 && i<=27){
				/*
				int pos = i-15;
				if(i == 14){
					buttons[i] = new JButton(nomesTeclas[i]);
					addComponent(buttons[i], 1, 0, 3, 1);
				}else{
					//System.out.println("else");
					buttons[i] = new JButton(nomesTeclas[i]);
					addComponent(buttons[i], 1, (pos*2)+3, 2, 1);
					//System.out.println("posMod: "+(pos*2)+3);
				}
				*/
				buttons[i] = new JButton(nomesTeclas[i]);
				addComponent(buttons[i], 1, ((i-14)*2), 2, 1);
			}
			if(i>27 && i<=40){
				buttons[i] = new JButton(nomesTeclas[i]);
				addComponent(buttons[i], 2, ((i-28)*2), 2, 1);
			}
			if(i>40 && i<=52){
				buttons[i] = new JButton(nomesTeclas[i]);
				addComponent(buttons[i], 3, ((i-41)*2), 2, 1);

			}
			if(i>52){
				buttons[i] = new JButton(nomesTeclas[i]);
				addComponent(buttons[i], 4, ((i-44)*2), 2, 1);
			}

			
		}

    }

    private void addComponent( Component component, int row, int column, int width,
	  int height ){
    	c.gridx = column;
    	c.gridy = row;
    	c.gridwidth = width;
    	c.gridheight = height;
    	gbl.setConstraints( component, c );
		add( component );
	}

	public void changeBackground(int vk){
		buttons[teclas.getIDbyVk(vk)].setBackground(Color.RED);
	}
}