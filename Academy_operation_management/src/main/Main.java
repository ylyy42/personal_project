package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import student.Admin_students;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {
	
	private JPanel contentPanel;
	
	
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1125, 650);
		setLocationRelativeTo(null);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("\uD559\uC0DD\uAD00\uB9AC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin_students();
				dispose();
			}
		});
		btnNewButton.setBounds(182, 143, 182, 119);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uAD50\uC7AC\uAD00\uB9AC");
		btnNewButton_1.setBounds(760, 143, 182, 119);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uC120\uC0DD\uB2D8\uAD00\uB9AC");
		btnNewButton_2.setBounds(472, 143, 182, 119);
		contentPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\uD559\uC6D0\uBE44 \uC218\uB0A9\uD604\uD669");
		btnNewButton_3.setBounds(138, 399, 182, 119);
		contentPanel.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("\uD559\uC0DD \uC785/\uD1F4\uC2E4");
		btnNewButton_3_1.setBounds(354, 399, 182, 119);
		contentPanel.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_1_1 = new JButton("\uAC15\uC88C\uD604\uD669");
		btnNewButton_3_1_1.setBounds(790, 399, 182, 119);
		contentPanel.add(btnNewButton_3_1_1);
		
		JButton btnNewButton_3_1_1_1 = new JButton("\uC120\uC0DD\uB2D8 \uCD9C/\uD1F4\uADFC");
		btnNewButton_3_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3_1_1_1.setBounds(571, 399, 182, 119);
		contentPanel.add(btnNewButton_3_1_1_1);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Main frame = new Main();
	}
}
