

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.nio.file.*;

public class Login extends JFrame {

	private JPanel p1;
	private JTextField t1;
	private JPasswordField t2;
	private JTextField textField;
	private JPasswordField textField_1;

	public Login() {
		setTitle("Bua Bilash Private Ltd");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(new Rectangle(00, 00, 1280, 720));
		setLocationRelativeTo(null);
		p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		setContentPane(p1);
		p1.setLayout(null);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("Images/Background.png"));
		background.setBounds(530, 0, 752, 681);
		p1.add(background);
		

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 530, 681);
		p1.add(panel);
		panel.setLayout(null);
		
		JPanel p2 = new JPanel();
		p2.setVisible(false);
		p2.setBackground(Color.PINK);
		p2.setBounds(0, 0, 530, 681);
		p1.add(p2);
		p2.setLayout(null);
		
		JLabel l2_1 = new JLabel("");

		l2_1.setBounds(0, 0, 180, 100);
		l2_1.setBounds(0, 0, 300,300);
		p2.add(l2_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBackground(new Color(250,85,85));
		textField.setBounds(70, 186, 350, 30);
		p2.add(textField);
		
		textField_1 = new JPasswordField();
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(250,85,85));
		textField_1.setBounds(70, 277, 350, 30);
		p2.add(textField_1);
		
		JLabel l1_1 = new JLabel("Name:");
		l1_1.setForeground(Color.WHITE);
		l1_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		l1_1.setBounds(70, 161, 110, 14);
		p2.add(l1_1);
		
		JLabel l3_1 = new JLabel("Password :");
		l3_1.setForeground(Color.WHITE);
		l3_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		l3_1.setBounds(70, 252, 110, 14);
		p2.add(l3_1);
		
		JButton btnEnter = new JButton("Login");
		btnEnter.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user1 = textField.getText();
				String pass1 = textField_1.getText();
				
				if(user1.isEmpty() || pass1.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Fill all fields.", "Warning!", JOptionPane.WARNING_MESSAGE);
				}
				else if(user1.equals("admin") && pass1.equals("admin"))
				{
					admin a = new admin();
					a.setVisible(true);
					setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(null, "Wrong Name/Password.", "Warning!", JOptionPane.WARNING_MESSAGE);
				}
			}
			});
		btnEnter.setBackground(new Color(135, 206, 235));
		btnEnter.setBounds(157, 337, 175, 30);
		p2.add(btnEnter);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p2.setVisible(false);
				panel.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(10, 647, 89, 23);
		btnBack.setBackground(new Color(135, 206, 235));
		p2.add(btnBack);
		
	
		
		t1 = new JTextField();
		t1.setBackground(new Color(135, 206, 235));
		t1.setBounds(70, 186, 350, 30);
		panel.add(t1);
		t1.setColumns(10);
		
		t2 = new JPasswordField();
		t2.setBackground(new Color(135, 206, 235));
		t2.setColumns(10);
		t2.setBounds(70, 277, 350, 30);
		panel.add(t2);
		
		
		
		JLabel l1 = new JLabel("Name :");
		l1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		l1.setBounds(70, 161, 110, 14);
		panel.add(l1);
		
		JLabel l3 = new JLabel("Password :");
		l3.setFont(new Font("Arial Black", Font.PLAIN, 15));
		l3.setBounds(70, 252, 110, 14);
		panel.add(l3);
		
		JButton b1 = new JButton("Log in ");
		b1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		b1.setBounds(157, 337, 175, 30);
		b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String ts1 = t1.getText();
			String ps1 = t2.getText();
			
			if(ts1.isEmpty() || ps1.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Fill all fields.", "Warning!", JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				try
				{
					String user = "User Name   :"+ts1;
					String pass = "Password    :"+ps1;
					BufferedReader r = new BufferedReader(new FileReader(".\\Data\\data.txt"));
					
					int tl = 0;
					while(r.readLine() != null)
					{
						tl++;
					}
					r.close();
					
					for(int i = 0; i <= tl; i++)
					{
						String line = Files.readAllLines(Paths.get(".\\Data\\data.txt")).get(i);
						if(line.equals(user))
						{
							String line2 = Files.readAllLines(Paths.get(".\\Data\\data.txt")).get(i+1);
							if(line2.equals(pass))
							{
								JOptionPane.showMessageDialog(null, "Login Successful.", "Bua Bilash Private Ltd", JOptionPane.WARNING_MESSAGE);
								dashboard nl2 = new dashboard();
								nl2.setVisible(true);
								setVisible(false);
								break;
							}
						}
						
					}
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
			
				
			}
			
		});
		b1.setBackground(new Color(250, 85, 85));
		panel.add(b1);
		
		JLabel l4 = new JLabel("Don't have an account?");
		l4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		l4.setBounds(157, 378, 126, 14);
		panel.add(l4);
		
		JLabel lb1 = new JLabel("Sign Up");
		lb1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registration r1 = new Registration();
				r1.setVisible(true);
				setVisible(false);
			}
		});
		Cursor cur = new Cursor(Cursor.HAND_CURSOR);
		lb1.setCursor(cur);
		lb1.setForeground(new Color(30, 144, 255));
		lb1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lb1.setBounds(286, 378, 46, 14);
		panel.add(lb1);
		
		JLabel lb2 = new JLabel("Admin Login");
		lb2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setVisible(false);
				p2.setVisible(true);
				JOptionPane.showMessageDialog(null, " Default User Name : admin\nDefault Password : admin", "Reminder!!", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		lb2.setForeground(new Color(30, 144, 255));
		lb2.setHorizontalAlignment(SwingConstants.CENTER);
		lb2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb2.setBounds(70, 640, 126, 30);
		panel.add(lb2);
		
		JLabel lb3 = new JLabel("About ");
		lb3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				about  a = new about ();
				a.setVisible(true);
			}
		});
		lb3.setHorizontalAlignment(SwingConstants.CENTER);
		lb3.setForeground(new Color(30, 144, 255));
		lb3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb3.setBounds(286, 640, 126, 30);
		panel.add(lb3);
	}
}
