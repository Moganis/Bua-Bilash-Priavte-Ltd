

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class about extends JFrame{
	private JPanel p1;

	public about() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(new Rectangle(00, 00, 1280, 720));
		setLocationRelativeTo(null);
		p1 = new JPanel();
		p1.setBackground(new Color(13, 30, 49));
		setContentPane(p1);
		p1.setLayout(null);
		
		JButton lblNewLabel = new JButton("BACK");
		lblNewLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEADING);
		lblNewLabel.setBackground(new Color(13, 30, 49));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(0, 590, 70, 37);
		p1.add(lblNewLabel);
		
		JLabel l1 = new JLabel("");
		l1.setIcon(new ImageIcon("Images/about.png"));
		l1.setBounds(00, 00, 1280, 720);
		p1.add(l1);
	}
}