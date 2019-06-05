import javax.swing.*;
import java.util.ArrayList;

public class PanelHistorico extends JPanel {

    private JLabel label;

    public PanelHistorico() {
        label = new JLabel();
        add(label);
    }

    public void update(ArrayList<String> list) {
        label.setText(String.join("\n", list));
    }
}