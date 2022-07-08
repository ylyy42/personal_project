package student;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import database.admin.StudentsDao;
import database.admin.StudentsService;

public class Registration_students extends JFrame {

	private JPanel contentPanel;
	private StudentsService studentsService;

	public Registration_students() {
		studentsService = new StudentsService(new StudentsDao());

		setBounds(new Rectangle(0, 0, 1000, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 560);
		setLocationRelativeTo(null);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(40, 56, 895, 415);
		contentPanel.add(panel);
		panel.setLayout(null);

		Panel panel_1 = new Panel();
		panel_1.setBounds(98, 37, 250, 210);
		panel.add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setBounds(473, 33, 57, 15);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638");
		lblNewLabel_1_1.setBounds(473, 62, 72, 15);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("\uD734\uB300\uD3F0\uBC88\uD638");
		lblNewLabel_1_1_1.setBounds(473, 88, 72, 15);
		panel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_1_1_1_1.setBounds(473, 117, 57, 15);
		panel.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("\uD559\uAD50");
		lblNewLabel_1_1_1_2.setBounds(473, 145, 57, 15);
		panel.add(lblNewLabel_1_1_1_2);

		JLabel lblNewLabel_1_1_1_3 = new JLabel("\uD559\uB144");
		lblNewLabel_1_1_1_3.setBounds(473, 175, 57, 15);
		panel.add(lblNewLabel_1_1_1_3);

		JLabel lblNewLabel_1_1_1_4 = new JLabel("\uD559\uBD80\uBAA8\uC774\uB984");
		lblNewLabel_1_1_1_4.setBounds(473, 207, 72, 15);
		panel.add(lblNewLabel_1_1_1_4);

		JLabel lblNewLabel_1_1_1_5 = new JLabel("\uD559\uBD80\uBAA8\uC5F0\uB77D\uCC98");
		lblNewLabel_1_1_1_5.setBounds(473, 239, 85, 15);
		panel.add(lblNewLabel_1_1_1_5);

		JLabel lblNewLabel_1_1_1_6 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_1_1_1_6.setBounds(473, 268, 57, 15);
		panel.add(lblNewLabel_1_1_1_6);

		JLabel lblNewLabel_1_1_1_7 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_1_1_1_7.setBounds(473, 298, 57, 15);
		panel.add(lblNewLabel_1_1_1_7);

		TextField textField = new TextField();
		textField.setBounds(575, 29, 171, 23);
		panel.add(textField);

		TextField textField_1 = new TextField();
		textField_1.setBounds(575, 56, 171, 23);
		panel.add(textField_1);

		TextField textField_1_1 = new TextField();
		textField_1_1.setBounds(575, 84, 171, 23);
		panel.add(textField_1_1);

		TextField textField_1_1_1 = new TextField();
		textField_1_1_1.setBounds(575, 113, 171, 23);
		panel.add(textField_1_1_1);

		TextField textField_1_1_1_1 = new TextField();
		textField_1_1_1_1.setBounds(575, 141, 171, 23);
		panel.add(textField_1_1_1_1);

		TextField textField_1_1_1_2 = new TextField();
		textField_1_1_1_2.setBounds(575, 171, 171, 23);
		panel.add(textField_1_1_1_2);

		TextField textField_1_1_1_3 = new TextField();
		textField_1_1_1_3.setBounds(575, 201, 171, 23);
		panel.add(textField_1_1_1_3);

		TextField textField_1_1_1_4 = new TextField();
		textField_1_1_1_4.setBounds(575, 232, 171, 23);
		panel.add(textField_1_1_1_4);

		TextField textField_1_1_1_5 = new TextField();
		textField_1_1_1_5.setBounds(575, 264, 171, 23);
		panel.add(textField_1_1_1_5);

		TextField textField_1_1_1_6 = new TextField();
		textField_1_1_1_6.setBounds(575, 294, 307, 23);
		panel.add(textField_1_1_1_6);

		Button button_1 = new Button("\uB4F1\uB85D\uD558\uAE30");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(771, 363, 105, 34);
		panel.add(button_1);

		Label label = new Label("\uB4F1\uB85D\uD6C4 \uC0AC\uC9C4\uC744 \uC124\uC815\uD574\uC8FC\uC138\uC694");
		label.setBounds(149, 283, 190, 23);
		panel.add(label);

		JLabel lblNewLabel = new JLabel("\uD559\uC0DD\uC2E0\uADDC\uB4F1\uB85D");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		lblNewLabel.setBounds(40, 31, 90, 15);
		contentPanel.add(lblNewLabel);

		Button button_1_1 = new Button("\uCDE8\uC18C");
		button_1_1.setBounds(830, 16, 105, 34);
		contentPanel.add(button_1_1);

		setVisible(true);
	}

	public static void main(String[] args) {
		Registration_students rFrame = new Registration_students();
	}
}
