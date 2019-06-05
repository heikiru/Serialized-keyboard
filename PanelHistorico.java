import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Color;
import java.util.ArrayList;

public class PanelHistorico extends JPanel {
    JTextArea text = new JTextArea();
    public PanelHistorico() {
        text.setBackground(new Color(0, 0, 0, 0));
        text.setEditable(false);
        add(text);
    }

    public void update(ArrayList<String> list) {
        text.setText(String.join("\n", list));
    }
}