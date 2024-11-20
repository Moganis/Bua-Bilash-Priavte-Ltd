

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.lang.*;
import javax.swing.table.*;
import java.nio.file.*;

public class dashboard extends JFrame
{
	private JPanel p1;
	private JLabel l2;
	
	
	
	private JLabel b2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	
	public dashboard() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("2adc61602efe4438897e7cc32ceb4805.png"));
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setTitle("DashBoard");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(new Rectangle(00, 00, 1280, 750));
		setLocationRelativeTo(null);
		p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		p1.setBorder(null);
		setContentPane(p1);
		p1.setLayout(null);
		
		JLabel l1 = new JLabel("");
		l1.setIcon(new ImageIcon("Images/Bua.png"));
		l1.setBounds(10, 11, 180, 100);
		p1.add(l1);
 
        String file1 = ".\\Data\\bua_data.txt";
        
		
		JLabel b1 = new JLabel("Click to choose your Bua");
		b1.setHorizontalAlignment(SwingConstants.CENTER);
		b1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		b1.setBounds(459, 11, 316, 49);
		b1.setForeground(new Color(0,2,0));
		p1.add(b1);
		
		b2 = new JLabel("Log Out");
		b2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Login l = new Login();
				l.setVisible(true);
			}
		});
		b2.setHorizontalAlignment(SwingConstants.CENTER);
		b2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		b2.setBounds(1124, 650, 130, 23);
		b2.setForeground(new Color(0,0,0));
		p1.add(b2);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				profile p = new profile();
				p.setVisible(true);
			}
		});
		lblNewLabel.setIcon(new ImageIcon("Images/avatar.jpg"));
		lblNewLabel.setBounds(307, 125, 200, 200);
		p1.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Fatima Begum");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(307, 334, 130, 23);
		p1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				profile1 p1 = new profile1();
				p1.setVisible(true);
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon("Images/avatar.jpg"));
		lblNewLabel_2.setBounds(689, 125, 200, 200);
		p1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_3.setBounds(689, 334, 166, 23);
		p1.add(lblNewLabel_3);
		
		l2 = new JLabel("");
		l2.setIcon(new ImageIcon("Images/bgd.png"));
		l2.setBounds(0, 0, 1264, 760);
		p1.add(l2);
		
		try {

            BufferedReader reader1 = new BufferedReader(new FileReader(file1));
            int totalLines = 0;
            while (reader1.readLine() != null)
                totalLines++;
            reader1.close();
			
			for (int i = 0; i < totalLines; i++) {
		String line = Files.readAllLines(Paths.get(file1)).get(i);
                            String x = line.substring(0, 6);
                            if (x.equals("2.User")) {
								String userN = Files.readAllLines(Paths.get(file1)).get(i).substring(15);
								lblNewLabel_3.setText(userN);
								
							}
		}

        } catch (Exception ex) {
            return;
        }
	}
}