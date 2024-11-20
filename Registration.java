

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;

public class Registration extends JFrame {

	private JPanel p1;
	private JTextField t1;
	private JTextField t2;
	private JPasswordField pst1;
	private JPasswordField pst2;
	private JTextField t3;
	private JTextField t4;
	private JPasswordField psT1;
	private JPasswordField psT2;
	private JTextField t5;
	private JTextField t6;
	
	
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(new Rectangle(00, 00, 1280, 720));
		setLocationRelativeTo(null);
		setResizable(false);
		p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		setContentPane(p1);
		p1.setLayout(null);
		
		JLabel l1 = new JLabel("");
		l1.setIcon(new ImageIcon("Images/Bua.png"));
		l1.setBounds(0, 0, 180, 100);
		p1.add(l1);
		
		JPanel p2 = new JPanel();
		p2.setBackground(new Color(0, 0, 0, 75));
		p2.setBounds(190, 90, 513, 551);
		p1.add(p2);
		p2.setVisible(false);
		p2.setLayout(null);
		
		t1 = new JTextField();
		t1.setBackground(new Color(135, 206, 235));
	
		t1.setBounds(69, 86, 395, 30);
		p2.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBackground(new Color(135, 206, 235));
		
		t2.setColumns(10);
		t2.setBounds(69, 179, 395, 30);
		p2.add(t2);
		
		JLabel l2 = new JLabel("Name :");
		l2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		l2.setForeground(Color.WHITE);
		l2.setBounds(69, 61, 56, 14);
		p2.add(l2);
		
		JLabel l3 = new JLabel("Phone No :");
		l3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		l3.setForeground(Color.WHITE);
		l3.setBounds(69, 154, 122, 14);
		p2.add(l3);
		
		JLabel l4 = new JLabel("Password :");
		l4.setForeground(Color.WHITE);
		l4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		l4.setBounds(69, 247, 122, 14);
		p2.add(l4);
		
		JLabel l5 = new JLabel("Confirm Password :");
		l5.setForeground(Color.WHITE);
		l5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		l5.setBounds(69, 340, 172, 14);
		p2.add(l5);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Uname = t1.getText();
				String em_ph = t2.getText();
				String pass = pst1.getText();
				String pass2 = pst2.getText();
				
				if(Uname.isEmpty() || em_ph.isEmpty() || pass.isEmpty() || pass2.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Fill all of the fields.", "Warning!", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					if(pass.equals(pass2))
					{
						try
						{
							File file = new File(".\\Data\\data.txt");
							if(!file.exists())
							{
								file.createNewFile();
							}
							FileWriter f = new FileWriter(file, true);
							BufferedWriter b = new BufferedWriter(f);
							PrintWriter p = new PrintWriter(b);
							LocalDateTime mdo = LocalDateTime.now();
							DateTimeFormatter mfo = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");
							String tAd = mdo.format(mfo);
							
							p.println("User Name   :"+Uname);
							p.println("Password    :"+pass);
							p.println("Email/Phone :"+em_ph);
							p.println("Time & Date :"+tAd);
							p.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
							p.close();
						}
						catch(Exception ex)
						{
							System.out.print(ex);
						}
						
						JOptionPane.showMessageDialog(null, "Registration Complete.", "Done!", JOptionPane.WARNING_MESSAGE);
						Login nl1 = new Login();
						nl1.setVisible(true);
						setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Passwords Mismatch.", "Warning!", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		btnConfirm.setBackground(new Color(250, 85, 85));
		btnConfirm.setBounds(182, 461, 175, 30);
		p2.add(btnConfirm);
		
		pst1 = new JPasswordField();
		pst1.setBackground(new Color(135, 206, 235));
		pst1.setBounds(69, 272, 395, 30);
		p2.add(pst1);
		
		pst2 = new JPasswordField();
		pst2.setBackground(new Color(135, 206, 235));
		pst2.setBounds(69, 365, 395, 30);
		p2.add(pst2);
		
		JPanel p3 = new JPanel();
		p3.setLayout(null);
		p3.setBackground(new Color(0, 0, 0, 75));
		p3.setBounds(713, 90, 513, 551);
		p3.setVisible(false);
		p1.add(p3);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBackground(new Color(135, 206, 235));
	
		t3.setBounds(23, 36, 395, 30);
		p3.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBackground(new Color(135, 206, 235));
	
		t4.setBounds(23, 100, 395, 30);
		p3.add(t4);
		
		JLabel l1_1 = new JLabel("Name :");
		l1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		l1_1.setForeground(Color.WHITE);
		l1_1.setBounds(23, 11, 56, 14);
		p3.add(l1_1);
		
		JLabel l2_1 = new JLabel("NID / Passport No. :");
		l2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    l2_1.setBounds(23, 75, 145, 14);
		l2_1.setForeground(Color.WHITE);
		p3.add(l2_1);
		
		JLabel l3_1 = new JLabel("Password :");
		l3_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		l3_1.setForeground(Color.WHITE);
		l3_1.setBounds(23, 292, 122, 14);
		p3.add(l3_1);
		
		JLabel l4_1 = new JLabel("Confirm Password :");
		l4_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		l4_1.setForeground(Color.WHITE);
		l4_1.setBounds(23, 358, 172, 14);
		p3.add(l4_1);
	
		psT1 = new JPasswordField();
		psT1.setBackground(new Color(135, 206, 235));
		psT1.setBounds(23, 317, 395, 30);
		p3.add(psT1);
		
		psT2 = new JPasswordField();
		psT2.setBackground(new Color(135, 206, 235));
		psT2.setBounds(23, 383, 395, 30);
		p3.add(psT2);
		
		JLabel l5_1 = new JLabel("Address :");
		l5_1.setForeground(Color.WHITE);
		l5_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l5_1.setBounds(23, 226, 122, 14);
		p3.add(l5_1);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBackground(new Color(135, 206, 235));
	
		t5.setBounds(23, 251, 395, 30);
		p3.add(t5);
		
		JLabel l6_1 = new JLabel("Skills :");
		l6_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l6_1.setForeground(Color.WHITE);
		l6_1.setBounds(23, 141, 122, 14);
		p3.add(l6_1);
		
		JCheckBox ch1 = new JCheckBox("Cooking");
		ch1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ch1.setBackground(new Color(135, 206, 235));
		ch1.setBounds(48, 162, 97, 23);
		p3.add(ch1);
		
		JCheckBox ch2 = new JCheckBox("Clothes Wash");
		ch2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ch2.setBackground(new Color(135, 206, 235));
		ch2.setBounds(48, 196, 97, 23);
		p3.add(ch2);
		
		JCheckBox ch3 = new JCheckBox("House Cleaning");
		ch3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ch3.setBackground(new Color(135, 206, 235));
		ch3.setBounds(156, 162, 107, 23);
		p3.add(ch3);
		
		JCheckBox ch4 = new JCheckBox("Dust clean");
		ch4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ch4.setBackground(new Color(135, 206, 235));
		ch4.setBounds(156, 196, 107, 23);
		p3.add(ch4);
		
		JCheckBox ch5 = new JCheckBox("Bathroom clean");
		ch5.setFont( new Font("Times New Roman",Font.PLAIN, 12));
		ch5.setBackground(new Color(135, 206, 235));
		ch5.setBounds(275, 162, 97, 23);
		p3.add(ch5);
		
		JCheckBox ch6 = new JCheckBox("Floor Clean");
		ch6.setFont( new Font("Times New Roman", Font.PLAIN , 12));
		ch6.setBackground(new Color(135, 206, 235));
		ch6.setBounds(275, 196, 97, 23);
		p3.add(ch6);
		
		t6 = new JTextField();
		t6.setColumns(10);
		t6.setBackground(new Color(135, 206, 235));
	
		t6.setBounds(23, 449, 395, 30);
		p3.add(t6);
		
		JLabel l7 = new JLabel("Salary: ");
		l7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		l7.setForeground(Color.WHITE);
		l7.setBounds(23, 424, 85, 14);
		p3.add(l7);
		
		JButton btnConfirm_1 = new JButton("Confirm");
		btnConfirm_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Uname = t3.getText();
				String em_ph = t4.getText();
				String pass = psT1.getText();
				String pass2 = psT2.getText();
				String add =  t5.getText();
				String pay = t6.getText();
				
				boolean check = ch1.isSelected();
				boolean check1 = ch2.isSelected();
				boolean check2 = ch3.isSelected();
				boolean check3 = ch4.isSelected();
				boolean check4 = ch5.isSelected();
				boolean check5 = ch6.isSelected();
				String op1 = "";
				String op2 = "";
				String op3 = "";
				String op4 = "";
				String op5 = "";
				String op6 = "";
				
				if(check == true)
				{
					op1 = ch1.getText()+", ";
				}
				if(check1 == true)
				{
					op2 = ch2.getText()+", ";
				}
				if(check2 == true)
				{
					op3 = ch3.getText()+", ";
				}
				if(check3 == true)
				{
					op4 = ch4.getText()+", ";
				}
				if(check4 == true)
				{
					op5 = ch5.getText()+", ";
				}
				if(check5 == true)
				{
					op6 = ch6.getText();
				}
				String skill = op1+op2+op3+op4+op5+op6;
				
				if(Uname.isEmpty() || em_ph.isEmpty() || pass.isEmpty() || pass2.isEmpty() || add.isEmpty() || skill == null)
				{
					JOptionPane.showMessageDialog(null, "Fill all of the fields.", "Warning!", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					if(pass.equals(pass2))
					{
						try
						{
							File file = new File(".\\Data\\bua_data.txt");
							if(!file.exists())
							{
								file.createNewFile();
							}
							FileWriter f = new FileWriter(file, true);
							BufferedWriter b = new BufferedWriter(f);
							PrintWriter p = new PrintWriter(b);
							LocalDateTime mdo = LocalDateTime.now();
							DateTimeFormatter mfo = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");
							String tAd = mdo.format(mfo);
							
							p.println("2.User Name   :"+Uname);
							p.println("Password    :"+pass);
							p.println("NID/Passport:"+em_ph);
							p.println("Address     :"+add);
							p.println("Skills      :"+skill);
							p.println("Payment     :"+pay);
							p.println("Time & Date :"+tAd);
							p.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
							p.close();
						}
						catch(Exception ex)
						{
							System.out.print(ex);
						}
						
						JOptionPane.showMessageDialog(null, "Registration Complete.", "Done!", JOptionPane.WARNING_MESSAGE);
						Login nl1 = new Login();
						nl1.setVisible(true);
						setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Passwords Mismatch.", "Warning!", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		btnConfirm_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnConfirm_1.setBackground(new Color(250, 85, 85));
		btnConfirm_1.setBounds(156, 490, 175, 30);
		p3.add(btnConfirm_1);
		
		JToggleButton b1 = new JToggleButton("Register as a User");
		ItemListener itemListener = new ItemListener() {
		    public void itemStateChanged(ItemEvent itemEvent) {
		        int state = itemEvent.getStateChange();
		        if (state == ItemEvent.SELECTED) {
		            p2.setVisible(true); 
		        } else {
		            p2.setVisible(false); 
		        }
		    }
		};
		b1.addItemListener(itemListener);
		b1.setBackground(new Color(250, 85, 85));
		b1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		b1.setBounds(353, 38, 218, 23);
		p1.add(b1);
		
		JToggleButton b2 = new JToggleButton("Apply as a Bua");
		ItemListener itemListener2 = new ItemListener() {
		    public void itemStateChanged(ItemEvent itemEvent) {
		        int state = itemEvent.getStateChange();
		        if (state == ItemEvent.SELECTED) {
		            p3.setVisible(true); 
		        } else {
		            p3.setVisible(false); 
		        }
		    }
		};
		b2.addItemListener(itemListener2);
		b2.setBackground(new Color(250, 85, 85));
		b2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		b2.setBounds(885, 38, 189, 23);
		p1.add(b2);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login nl3 = new Login();
				nl3.setVisible(true);
				setVisible(false);
			}
			
		});
		btnBack.setBackground(new Color(250, 85, 85));
		btnBack.setBounds(10, 640, 175, 30);
		p1.add(btnBack);
		
		JLabel bg = new JLabel("New label");
		bg.setIcon(new ImageIcon("Images/login1.png"));
		bg.setBounds(0, 0, 1264, 700);
		p1.add(bg);
	}
	
}