import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Taschenrechner implements ActionListener {
	
	JFrame frame;
	JButton button;
	JLabel label;
	JPanel panel;
	
	public Taschenrechner() {
		
		//Bildschirm, an der man den
		//Inhalt zufügt
		frame = new JFrame();
		
		//Buttons
		button = new JButton();
		label = new JLabel();
		
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout());
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Taschenrechner");
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Taschenrechner();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
