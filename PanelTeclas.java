import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;


// -30 |5
public class PanelTeclas extends JPanel{

	private Teclas[] teclas;
	private Teclado teclado;
	private JButton[] buttons;
    private GridBagConstraints c;
    private GridBagLayout gbl;

    private Color buttonDefaultColor;

    public PanelTeclas(){
    	super();

    	teclado = new Teclado();
    	teclas = teclado.keyboardConstructor();

    	gbl = new GridBagLayout();
			c = new GridBagConstraints();
			setLayout( gbl );

		buttons = new JButton[teclas.length];
		c.fill = GridBagConstraints.BOTH;
    	c.weightx = 1;
    	c.weighty = 0;
    	
		for(int i=0; i<teclas.length; i++){
			if(i <= 13){
				buttons[i] = new JButton(teclas[i].getNome());
				addComponent(buttons[i], 0, (i*2), 2, 1);
			}
			if(i>13 && i<=27){
				buttons[i] = new JButton(teclas[i].getNome());
				addComponent(buttons[i], 1, ((i-14)*2), 2, 1);
			}
			if(i>27 && i<=40){
				buttons[i] = new JButton(teclas[i].getNome());
				addComponent(buttons[i], 2, ((i-28)*2), 2, 1);
			}
			if(i>40 && i<=52){
				buttons[i] = new JButton(teclas[i].getNome());
				addComponent(buttons[i], 3, ((i-41)*2), 2, 1);

			}
			if(i>52){
				buttons[i] = new JButton(teclas[i].getNome());
				addComponent(buttons[i], 4, ((i-44)*2), 2, 1);
			}
		}

			buttonDefaultColor = buttons[0].getBackground();

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
		buttons[teclado.getIDbyVk(vk)].setBackground(Color.RED);
	}

	public void changeBack(int vk){
		buttons[teclado.getIDbyVk(vk)].setBackground(buttonDefaultColor);
	}
}