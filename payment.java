

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class payment extends JFrame {

	private JPanel p1;
	private JTextField t1;
	private JPasswordField pst;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	
	public payment() {
		setTitle("Payment\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(new Rectangle(00, 00, 900, 600));
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		p1.setLayout(null);
		setContentPane(p1);
		
		JSeparator s = new JSeparator();
		s.setBackground(Color.BLACK);
		s.setForeground(Color.BLACK);
		s.setBounds(450, 10, 2, 539);
		p1.add(s);
		
		JLabel l1 = new JLabel("");
		l1.setIcon(new ImageIcon("Images/Bua.png"));
		l1.setBounds(0, 0, 180, 100);
		p1.add(l1);
		
		JLabel l2 = new JLabel("New label");
		l2.setIcon(new ImageIcon("Images/Visa1.png"));
		l2.setBounds(66, 128, 140, 89);
		p1.add(l2);
		
		JLabel l3 = new JLabel("New label");
		l3.setIcon(new ImageIcon("Images/MasterCard_Logo1.png"));
		l3.setBounds(231, 128, 140, 87);
		p1.add(l3);
		
		JLabel l4 = new JLabel("New label");
		l4.setIcon(new ImageIcon("Images/Bkash-logo1.png"));
		l4.setBounds(532, 128, 140, 96);
		p1.add(l4);
		
		JLabel l5 = new JLabel("I");
		l5.setIcon(new ImageIcon("Images/Nagad-Logo1.png"));
		l5.setBounds(697, 128, 140, 96);
		p1.add(l5);
		
		JLabel l6 = new JLabel("New label");
		l6.setIcon(new ImageIcon("Images/DBBL-Mobile-Banking-Becomes-Rocket.png"));
		l6.setBounds(609, 235, 140, 96);
		p1.add(l6);
		
		t1 = new JTextField();
		t1.setBounds(532, 393, 269, 20);
		p1.add(t1);
		t1.setColumns(10);
		
		pst = new JPasswordField();
		pst.setBounds(532, 474, 219, 20);
		p1.add(pst);
		
		JLabel l7 = new JLabel("Number :");
		l7.setFont(new Font("Arial Black", Font.PLAIN, 14));
		l7.setBounds(532, 368, 91, 14);
		p1.add(l7);
		
		JLabel l8 = new JLabel("PIN :");
		l8.setFont(new Font("Arial Black", Font.PLAIN, 14));
		l8.setBounds(532, 449, 46, 14);
		p1.add(l8);
		
		t2 = new JTextField();
		t2.setBounds(66, 297, 306, 20);
		p1.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(66, 367, 305, 20);
		p1.add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setBounds(66, 448, 150, 20);
		p1.add(t4);
		t4.setColumns(10);
		
		t5 = new JTextField();
		t5.setBounds(231, 448, 140, 20);
		p1.add(t5);
		t5.setColumns(10);
		
		JLabel l9 = new JLabel("Name on Card :\r\n");
		l9.setFont(new Font("Arial Black", Font.PLAIN, 14));
		l9.setBounds(66, 276, 140, 14);
		p1.add(l9);
		
		JLabel l10 = new JLabel("Card Number :");
		l10.setFont(new Font("Arial Black", Font.PLAIN, 14));
		l10.setBounds(66, 342, 114, 14);
		p1.add(l10);
		
		JLabel l11 = new JLabel("Exp. Date :");
		l11.setFont(new Font("Arial Black", Font.PLAIN, 14));
		l11.setBounds(66, 423, 114, 14);
		p1.add(l11);
		
		JLabel l12 = new JLabel("CVC :");
		l12.setFont(new Font("Arial Black", Font.PLAIN, 14));
		l12.setBounds(231, 423, 46, 14);
		p1.add(l12);
		
		JRadioButton rd1 = new JRadioButton("Pay in Cash");
		rd1.setForeground(Color.WHITE);
		rd1.setBackground(Color.BLACK);
		rd1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		rd1.setBounds(411, 49, 122, 51);
		p1.add(rd1);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean choice = rd1.isSelected();
				String pass = pst.getText();
				
				if(choice == true)
				{
					JOptionPane.showMessageDialog(null, "Hired!", "Done!", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
				}
				else if(t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() || t5.getText().isEmpty() || pass.isEmpty() || choice == false)
				{
					JOptionPane.showMessageDialog(null, "Please Fill in the fields!", "Warning!", JOptionPane.WARNING_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, "Hired!", "Done!", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
				}
			
			}
		});
		btnConfirm.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnConfirm.setBackground(new Color(250, 85, 85));
		btnConfirm.setBounds(150, 520, 175, 30);
		p1.add(btnConfirm);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
			
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBackground(new Color(250, 85, 85));
		btnBack.setBounds(697, 520, 175, 30);
		p1.add(btnBack);
	}
}
