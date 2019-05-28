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

	public Timer() {
		super(":D");

		tPanel = new JPanel();
		tPanel.setLayout(new BorderLayout());

		tFrame = new JFrame();
		tFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		label = new JLabel("Seconds remaining: 0");
		label.setHorizontalAlignment(SwingConstants.CENTER);

		tButton = new JButton("Start counter");
		tButton.addActionListener((e) -> {

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
		});

		tPanel.add(label, BorderLayout.LINE_START);
		tPanel.add(tButton, BorderLayout.EAST);
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
