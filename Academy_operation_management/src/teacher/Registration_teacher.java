package teacher;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import database.admin.TeacherDao;
import database.admin.TeacherService;
import database.admin.TeacherVo;
import student.Admin_students;

public class Registration_teacher extends JFrame {
	private JPanel contentPanel;
	private TeacherService teacherService;
	private String[][] tConts;
	private String[] tHeader = new String[] { "ÄÚµå", "ÀÌ¸§", "°ú¸ñ" };

	public Registration_teacher() {
		teacherService = new TeacherService(new TeacherDao());
		setBounds(new Rectangle(0, 0, 1000, 0));
		setSize(669, 560);
		setLocationRelativeTo(null);

		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(40, 56, 565, 415);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setBounds(87, 59, 57, 15);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638");
		lblNewLabel_1_1.setBounds(87, 88, 85, 15);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("\uD734\uB300\uD3F0\uBC88\uD638");
		lblNewLabel_1_1_1.setBounds(87, 114, 72, 15);
		panel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_1_1_1_1.setBounds(87, 143, 57, 15);
		panel.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("\uC785\uC0AC\uC5F0\uB3C4");
		lblNewLabel_1_1_1_2.setBounds(87, 171, 57, 15);
		panel.add(lblNewLabel_1_1_1_2);

		JLabel lblNewLabel_1_1_1_3 = new JLabel("\uC5F0\uBD09");
		lblNewLabel_1_1_1_3.setBounds(87, 201, 57, 15);
		panel.add(lblNewLabel_1_1_1_3);

		JLabel lblNewLabel_1_1_1_4 = new JLabel("\uC804\uACF5");
		lblNewLabel_1_1_1_4.setBounds(87, 233, 72, 15);
		panel.add(lblNewLabel_1_1_1_4);

		JLabel lblNewLabel_1_1_1_5 = new JLabel("\uACC4\uC88C\uBC88\uD638");
		lblNewLabel_1_1_1_5.setToolTipText("");
		lblNewLabel_1_1_1_5.setBounds(87, 265, 85, 15);
		panel.add(lblNewLabel_1_1_1_5);

		JLabel lblNewLabel_1_1_1_7 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_1_1_1_7.setBounds(87, 294, 57, 15);
		panel.add(lblNewLabel_1_1_1_7);

		TextField textField = new TextField();
		textField.setBounds(189, 55, 171, 23);
		panel.add(textField);

		TextField textField_1 = new TextField();
		textField_1.setBounds(189, 82, 171, 23);
		panel.add(textField_1);

		TextField textField_1_1 = new TextField();
		textField_1_1.setBounds(189, 110, 171, 23);
		panel.add(textField_1_1);

		TextField textField_1_1_1 = new TextField();
		textField_1_1_1.setBounds(189, 139, 171, 23);
		panel.add(textField_1_1_1);

		TextField textField_1_1_1_1 = new TextField();
		textField_1_1_1_1.setBounds(189, 167, 171, 23);
		panel.add(textField_1_1_1_1);

		TextField textField_1_1_1_2 = new TextField();
		textField_1_1_1_2.setBounds(189, 197, 171, 23);
		panel.add(textField_1_1_1_2);

		TextField textField_1_1_1_3 = new TextField();
		textField_1_1_1_3.setBounds(189, 227, 171, 23);
		panel.add(textField_1_1_1_3);

		TextField textField_1_1_1_4 = new TextField();
		textField_1_1_1_4.setBounds(189, 258, 171, 23);
		panel.add(textField_1_1_1_4);

		TextField textField_1_1_1_6 = new TextField();
		textField_1_1_1_6.setBounds(189, 290, 307, 23);
		panel.add(textField_1_1_1_6);

		Button button_1 = new Button("\uB4F1\uB85D\uD558\uAE30");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherVo vo = new TeacherVo("1", textField.getText(), textField_1.getText(), textField_1_1.getText(),
						textField_1_1_1.getText(), textField_1_1_1_1.getText(), textField_1_1_1_2.getText(),
						textField_1_1_1_3.getText(), textField_1_1_1_6.getText(), textField_1_1_1_4.getText());

				if (teacherService.regist(vo) == 1) {
					Admin_teacher.model.setRowCount(0);
					tConts = teacherService.listAll();
					Admin_teacher.model.setDataVector(tConts, tHeader);
					dispose();
				}

			}
		});
		button_1.setBounds(438, 360, 105, 34);
		panel.add(button_1);

		JLabel lblNewLabel = new JLabel("\uC120\uC0DD\uB2D8\uC2E0\uADDC\uB4F1\uB85D");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		lblNewLabel.setBounds(40, 31, 117, 15);
		contentPanel.add(lblNewLabel);

		Button button_1_1 = new Button("\uCDE8\uC18C");
		button_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1_1.setBounds(500, 16, 105, 34);
		contentPanel.add(button_1_1);

		setVisible(true);
	}
}
