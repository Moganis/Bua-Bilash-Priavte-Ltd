
import java.awt.*;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.table.*;
import javax.swing.*;

public class admin extends JFrame {

	private JPanel p1;
	private JScrollPane scroll;
	private JTable table;
	private DefaultTableModel model;
	private JTable table1;
	private DefaultTableModel model1;
	
	 private String[] column = { "User Name", "Password", "Email/Phone", "Date and Time" };
	 private String[] column1 = { "User Name", "Password", "NID/Passport", "Address", "Skills", "Payment", "Date and Time" };
	 private String[] rows = new String[20];
	 
	 public admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(new Rectangle(00, 00, 1280, 720));
		setLocationRelativeTo(null);
		setResizable(false);
		p1 = new JPanel();
		p1.setBackground(Color.PINK);
		setContentPane(p1);
		p1.setLayout(null);
		
		JLabel l3 = new JLabel("Buas Data");
		l3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		l3.setBounds(750, 117, 158, 24);
		p1.add(l3);
		
		JLabel l2 = new JLabel("Customers Data");
		l2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		l2.setBounds(40, 111, 150, 30);
		p1.add(l2);
		
		JLabel l1 = new JLabel("");
		l1.setIcon(new ImageIcon("Images/Bua.png"));
		l1.setBounds(0, 0, 180, 100);
		p1.add(l1);
		
		table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);

        table.setModel(model);
        table.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        table.setSelectionBackground(Color.decode("#8AC5FF"));
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(300);
        table.getColumnModel().getColumn(3).setPreferredWidth(220);

        String file = ".\\Data\\data.txt";
		
		scroll = new JScrollPane(table);
        scroll.setBounds(10, 166, 578, 376);
        scroll.setBackground(Color.WHITE);
        p1.add(scroll);
        
        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int totalLines = 0;
            while (reader.readLine() != null)
                totalLines++;
            reader.close();

            for (int i = 0; i < totalLines; i++) {
                String line = Files.readAllLines(Paths.get(file)).get(i);
                String x = line.substring(0, 4);
                if (x.equals("User")) {
                    rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(13); // User Name
                    rows[1] = Files.readAllLines(Paths.get(file)).get((i + 1)).substring(13); // Password
                    rows[2] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(13); // Email
                    rows[3] = Files.readAllLines(Paths.get(file)).get((i + 3)).substring(13); // Date and Time
                    model.addRow(rows);
                }
            }

        } catch (Exception ex) {
            return;
        }
        
        table1 = new JTable();
        model1 = new DefaultTableModel();
        model1.setColumnIdentifiers(column1);
        table1.setModel(model1);
        table1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        table1.setSelectionBackground(Color.decode("#8AC5FF"));
        table1.setBackground(Color.WHITE);
        table1.setRowHeight(30);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table1.getColumnModel().getColumn(0).setPreferredWidth(120);
        table1.getColumnModel().getColumn(1).setPreferredWidth(120);
        table1.getColumnModel().getColumn(2).setPreferredWidth(300);
        table1.getColumnModel().getColumn(3).setPreferredWidth(300);
        table1.getColumnModel().getColumn(4).setPreferredWidth(300);
        table1.getColumnModel().getColumn(5).setPreferredWidth(120);
        table1.getColumnModel().getColumn(6).setPreferredWidth(220);

        String file1 = ".\\Data\\bua_data.txt";
        String temp = ".\\Data\\temp.txt";
        String temp1 = ".\\Data\\temp1.txt";
        
        JScrollPane scroll1 = new JScrollPane(table1);
        scroll1.setBackground(Color.WHITE);
        scroll1.setBounds(676, 166, 578, 376);
        p1.add(scroll1);
        
        JButton b1 = new JButton("Delete User");
        b1.setBackground(Color.WHITE);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                if (table.getSelectionModel().isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select a user to delete", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    String removeUser = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();

                    File oldFile = new File(file);
                    File newFile = new File(temp);

                    int q = 0;

                    try {

                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        int totalLines = 0;
                        while (reader.readLine() != null)
                            totalLines++;
                        reader.close();

                        for (int i = 0; i < totalLines; i++) {
                            String line = Files.readAllLines(Paths.get(file)).get(i);
                            String x = line.substring(0, 4);
                            if (x.equals("User")) {
                                String userName = Files.readAllLines(Paths.get(file)).get(i);
                                if (userName.substring(14).equals(removeUser)) {
                                    q = i;
                                }
                            }
                        }
                    } catch (Exception ex) {
                        return;
                    }

                    try {

                        FileWriter fw = new FileWriter(temp, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);

                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);

                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        int totalLines = 0;
                        while (reader.readLine() != null)
                            totalLines++;
                        reader.close();

                        for (int j = 0; j < totalLines; j++) {
                            String line = Files.readAllLines(Paths.get(file)).get(j);
                            String x = line.substring(0, 4);

                            if (q != 0 && (j == q || j == (q + 1) || j == (q + 2) || j == (q + 3) || j == (q + 4) )) {
                                String userName = Files.readAllLines(Paths.get(file)).get(j);
                                pw.println("#Removed! " + userName);
                            } else {
                                String userName = Files.readAllLines(Paths.get(file)).get(j);
                                pw.println(userName);
                            }
                        }
                        pw.flush();
                        pw.close();
                        fr.close();
                        br.close();
                        bw.close();
                        fw.close();

                    } catch (Exception ex) {
                        System.out.print(ex);
                    }

                    oldFile.delete();
                    File dump = new File(file);
                    newFile.renameTo(dump);

                    setVisible(false);
                    admin frame = new admin();
                    frame.setVisible(true);
                }

            }
        });
        b1.setBounds(249, 553, 122, 49);
        p1.add(b1);
        
        JButton b2 = new JButton("Delete Bua");
        b2.setBackground(Color.WHITE);
        b2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (table1.getSelectionModel().isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select a bua to delete", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    String removeUser = table1.getModel().getValueAt(table1.getSelectedRow(), 0).toString();

                    File oldFile = new File(file1);
                    File newFile = new File(temp1);

                    int q = 0;

                    try {

                        BufferedReader reader = new BufferedReader(new FileReader(file1));
                        int totalLines = 0;
                        while (reader.readLine() != null)
                            totalLines++;
                        reader.close();

                        for (int i = 0; i < totalLines; i++) {
                            String line = Files.readAllLines(Paths.get(file1)).get(i);
                            String x = line.substring(0, 4);
                            if (x.equals("User")) {
                                String userName = Files.readAllLines(Paths.get(file1)).get(i);
                                if (userName.substring(13).equals(removeUser)) {
                                    q = i;
                                }
                            }
                        }
                    } catch (Exception ex) {
                        return;
                    }

                    try {

                        FileWriter fw = new FileWriter(temp1, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);

                        FileReader fr = new FileReader(file1);
                        BufferedReader br = new BufferedReader(fr);

                        BufferedReader reader = new BufferedReader(new FileReader(file1));
                        int totalLines = 0;
                        while (reader.readLine() != null)
                            totalLines++;
                        reader.close();

                        for (int j = 0; j < totalLines; j++) {
                            String line = Files.readAllLines(Paths.get(file1)).get(j);
                            String x = line.substring(0, 4);

                            if (q != 0 && (j == q || j == (q + 1) || j == (q + 2) || j == (q + 3) || j == (q + 4) || j == (q + 5) || j == (q + 6) || j == (q + 7))) {
                                String userName = Files.readAllLines(Paths.get(file1)).get(j);
                                pw.println("#Removed! " + userName);
                            } else {
                                String userName = Files.readAllLines(Paths.get(file1)).get(j);
                                pw.println(userName);
                            }
                        }
                        pw.flush();
                        pw.close();
                        fr.close();
                        br.close();
                        bw.close();
                        fw.close();

                    } catch (Exception ex) {
                        System.out.print(ex);
                    }

                    oldFile.delete();
                    File dump = new File(file1);
                    newFile.renameTo(dump);

                    setVisible(false);
                    admin frame = new admin();
                    frame.setVisible(true);
                }
        	}
        });
        b2.setBounds(928, 553, 122, 49);
        p1.add(b2);
        
        JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login l = new Login();
				l.setVisible(true);
        	}
        });
        btnLogOut.setBackground(Color.WHITE);
        btnLogOut.setBounds(1132, 11, 122, 49);
        p1.add(btnLogOut);
        
        try {

            BufferedReader reader1 = new BufferedReader(new FileReader(file1));
            int totalLines = 0;
            while (reader1.readLine() != null)
                totalLines++;
            reader1.close();

            for (int i = 0; i < totalLines; i++) {
                String line = Files.readAllLines(Paths.get(file1)).get(i);
                String x = line.substring(0, 4);
				String y = line.substring(0, 6);
                if (x.equals("User") || y.equals("2.User")) {
                    rows[0] = Files.readAllLines(Paths.get(file1)).get(i).substring(13); 
                    rows[1] = Files.readAllLines(Paths.get(file1)).get((i + 1)).substring(13); 
                    rows[2] = Files.readAllLines(Paths.get(file1)).get((i + 2)).substring(13); 
                    rows[3] = Files.readAllLines(Paths.get(file1)).get((i + 3)).substring(13);
                    rows[4] = Files.readAllLines(Paths.get(file1)).get((i + 4)).substring(13);
                    rows[5] = Files.readAllLines(Paths.get(file1)).get((i + 5)).substring(13);
                    rows[6] = Files.readAllLines(Paths.get(file1)).get((i + 6)).substring(13);
                    model1.addRow(rows);
                }
            }

        } catch (Exception ex) {
            return;
        }
	}
}