package student;

import java.awt.Button;
import java.awt.Font;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import database.admin.StudentsAttVo;
import database.admin.StudentsDao;
import database.admin.StudentsService;
import main.Main;

public class Attendance_students extends JFrame {
	private TextField textField_1;
	private TextField textField;
	private StudentsService studentsService;
	private String sName;
	
	public Attendance_students() {
		setBounds(new Rectangle(0, 0, 1000, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(795, 560);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		studentsService = new StudentsService(new StudentsDao());
		
		JButton btnNewButton = new JButton("\uC785\uC2E4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sName = textField.getText();
				StudentsAttVo vo = new StudentsAttVo(sName, "입실", "퇴실");
				
				studentsService.Checkin(vo);
				textField_1.setText(textField.getText() + "번 학생 입실체크되었습니다.");
			}
		});
		btnNewButton.setBounds(149, 230, 150, 150);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uD1F4\uC2E4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sName = textField.getText();
				StudentsAttVo vo = new StudentsAttVo(sName, "입실", "퇴실");
				
				studentsService.Checkout(vo);
				textField_1.setText(textField.getText() + "번 학생 퇴실체크되었습니다.");
			}
		});
		btnNewButton_1.setBounds(460, 230, 150, 150);
		getContentPane().add(btnNewButton_1);
		
		Label label = new Label("\uD559\uC0DD\uCF54\uB4DC");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label.setBounds(65, 73, 70, 23);
		getContentPane().add(label);
		
		textField = new TextField();
		textField.setBounds(148, 73, 109, 23);
		getContentPane().add(textField);
		
		textField_1 = new TextField();
		textField_1.setEditable(false);
		textField_1.setBounds(285, 177, 185, 23);
		getContentPane().add(textField_1);
		
		Label label_1 = new Label("\uD559\uC0DD\uC785\uD1F4\uC2E4\uCCB4\uD06C");
		label_1.setBounds(25, 27, 109, 23);
		getContentPane().add(label_1);
		
		Button button = new Button("\uBA54\uC778");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main();
				dispose();
			}
		});
		button.setBounds(589, 27, 132, 69);
		getContentPane().add(button);
		
		setVisible(true);
	}
}
