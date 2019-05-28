package keyboard;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class Timer extends JFrame implements ActionListener{

	private JFrame tFrame;
	private JButton tButton;
	private JLabel label;
	private JPanel tPanel;
//	private JMenu menu;
	
	
	public Timer() {
		super(":D");
		
		tFrame = new JFrame();
		tFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tPanel = new JPanel();
		tPanel.setLayout(new BorderLayout());
		
		label = new JLabel("Seconds remaining: 0");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		tButton = new JButton("Start counter");
		tButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

                    @Override
                    protected Void doInBackground() throws Exception {
                        for (int i = 20; i >= 0; i--) {
                            Thread.sleep(1000);
                            System.out.println(i);
                            label.setText("Seconds remainig: " + i);
                        }

                        return null;
                    }
                };
                worker.execute();
			}
		});
		tPanel.add(label, BorderLayout.CENTER);
		tPanel.add(tButton, BorderLayout.SOUTH);
		tFrame.add(tPanel);
		tFrame.pack();
		
		tFrame.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Timer view = new Timer();
                
            }
        });
	}
}
