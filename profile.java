

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class profile extends JFrame {

	private JPanel p1;
	private JTextField txtFatimaBegum;
	private JTextField txtCooking;
	private JTextField txtStreetRoadDhaka;
	private JTextField txtTk;
	
	public profile() {
		setTitle("Profile");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(new Rectangle(00, 00, 1280,750));
		setLocationRelativeTo(null);
		p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		setContentPane(p1);
		p1.setLayout(null);
		
		JLabel l1 = new JLabel("");
		l1.setIcon(new ImageIcon("Images/avatar.jpg"));
		l1.setBackground(Color.WHITE);
		l1.setBounds(320, 30, 180, 180);
		p1.add(l1);
		
		JLabel b1 = new JLabel("Hire");
		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				payment p = new payment();
				p.setVisible(true);
			}
		});
		b1.setHorizontalAlignment(SwingConstants.CENTER);
		b1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		b1.setBounds(343, 680, 121, 25);
		
		b1.setForeground(new Color(0,0,0));
		p1.add(b1);
		
		JLabel l6 = new JLabel("");
		l6.setIcon(new ImageIcon("Images/Bua.png"));
		l6.setBounds(0, 0, 180, 100);
		p1.add(l6);
		
		JLabel btnBack = new JLabel("BACK");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnBack.setHorizontalAlignment(SwingConstants.CENTER);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setForeground(new Color(0,0,0));
		btnBack.setBounds(650, 680, 77, 30);
		p1.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(320, 270, 101, 14);
		p1.add(lblNewLabel);
		
		txtFatimaBegum = new JTextField();
		txtFatimaBegum.setBackground(Color.WHITE);
		txtFatimaBegum.setEditable(false);
		txtFatimaBegum.setText("Fatima Begum");
		txtFatimaBegum.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtFatimaBegum.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txtFatimaBegum.setBounds(320, 295, 270, 20);
		p1.add(txtFatimaBegum);
		txtFatimaBegum.setColumns(10);
		
		txtCooking = new JTextField();
		txtCooking.setBackground(Color.WHITE);
		txtCooking.setEditable(false);
		txtCooking.setText("Cooking, Cloths Wash, House Cleaning");
		txtCooking.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtCooking.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txtCooking.setColumns(10);
		txtCooking.setBounds(320, 404, 270, 20);
		p1.add(txtCooking);
		
		JLabel lblSkills = new JLabel("Skills : ");
		lblSkills.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSkills.setBounds(320, 379, 112, 14);
		p1.add(lblSkills);
		
		txtStreetRoadDhaka = new JTextField();
		txtStreetRoadDhaka.setBackground(Color.WHITE);
		txtStreetRoadDhaka.setEditable(false);
		txtStreetRoadDhaka.setText("Street, Road, Dhaka");
		txtStreetRoadDhaka.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtStreetRoadDhaka.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txtStreetRoadDhaka.setColumns(10);
		txtStreetRoadDhaka.setBounds(320, 513, 270, 20);
		p1.add(txtStreetRoadDhaka);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAddress.setBounds(320, 488, 158, 14);
		p1.add(lblAddress);
		
		txtTk = new JTextField();
		txtTk.setBackground(Color.WHITE);
		txtTk.setEditable(false);
		txtTk.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtTk.setText("400 TK");
		txtTk.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txtTk.setColumns(10);
		txtTk.setBounds(320, 618, 270, 20);
		p1.add(txtTk);
		
		JLabel lblPayHour = new JLabel("Pay / Hour :");
		lblPayHour.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPayHour.setBounds(320, 593, 144, 14);
		p1.add(lblPayHour);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("Images/bgd.png"));
		background.setBounds(00, 00, 1280, 750);
		p1.add(background);
	}
}