package teacher;

import java.awt.Button;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import database.admin.TeacherDao;
import database.admin.TeacherService;
import database.admin.TeacherVo;
import student.Admin_students;

public class Modify_teacher extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private TeacherService teacherService;
	private String code = Admin_teacher.code;
	private List<TeacherVo> teacherInfo;
	private String[][] tConts;
	private String[] tHeader = new String[] {"코드", "이름", "과목" };
	
	public Modify_teacher() {
		setBounds(new Rectangle(0, 0, 1000, 0));
		setSize(629, 560);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		teacherService = new TeacherService(new TeacherDao());
		
		JLabel lblNewLabel_2 = new JLabel("\uC774\uB984");
		lblNewLabel_2.setBounds(169, 110, 57, 15);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField(teacherService.inforNotList(code)[0]);
		textField.setColumns(10);
		textField.setBounds(292, 107, 171, 21);
		getContentPane().add(textField);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638");
		lblNewLabel_2_1.setBounds(169, 139, 82, 15);
		getContentPane().add(lblNewLabel_2_1);
		
		textField_1 = new JTextField(teacherService.inforNotList(code)[1]);
		textField_1.setColumns(10);
		textField_1.setBounds(292, 136, 171, 21);
		getContentPane().add(textField_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("\uD734\uB300\uD3F0\uBC88\uD638");
		lblNewLabel_2_1_1.setBounds(169, 167, 72, 15);
		getContentPane().add(lblNewLabel_2_1_1);
		
		textField_2 = new JTextField(teacherService.inforNotList(code)[2]);
		textField_2.setColumns(10);
		textField_2.setBounds(292, 164, 171, 21);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_2_1_1_1.setBounds(169, 195, 57, 15);
		getContentPane().add(lblNewLabel_2_1_1_1);
		
		textField_3 = new JTextField(teacherService.inforNotList(code)[3]);
		textField_3.setColumns(10);
		textField_3.setBounds(292, 192, 171, 21);
		getContentPane().add(textField_3);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("\uC785\uC0AC\uB144\uB3C4");
		lblNewLabel_2_1_1_2.setBounds(169, 223, 57, 15);
		getContentPane().add(lblNewLabel_2_1_1_2);
		
		textField_4 = new JTextField(teacherService.inforNotList(code)[4]);
		textField_4.setColumns(10);
		textField_4.setBounds(292, 220, 171, 21);
		getContentPane().add(textField_4);
		
		JLabel lblNewLabel_2_1_1_3 = new JLabel("\uC5F0\uBD09");
		lblNewLabel_2_1_1_3.setBounds(169, 251, 57, 15);
		getContentPane().add(lblNewLabel_2_1_1_3);
		
		textField_5 = new JTextField(teacherService.inforNotList(code)[5]);
		textField_5.setColumns(10);
		textField_5.setBounds(292, 248, 171, 21);
		getContentPane().add(textField_5);
		
		JLabel lblNewLabel_2_1_1_4 = new JLabel("\uB2F4\uB2F9\uACFC\uBAA9");
		lblNewLabel_2_1_1_4.setBounds(169, 279, 72, 15);
		getContentPane().add(lblNewLabel_2_1_1_4);
		
		textField_6 = new JTextField(teacherService.inforNotList(code)[6]);
		textField_6.setColumns(10);
		textField_6.setBounds(292, 276, 171, 21);
		getContentPane().add(textField_6);
		
		JLabel lblNewLabel_2_1_1_5 = new JLabel("\uACC4\uC88C\uBC88\uD638");
		lblNewLabel_2_1_1_5.setBounds(168, 308, 82, 15);
		getContentPane().add(lblNewLabel_2_1_1_5);
		
		textField_7 = new JTextField(teacherService.inforNotList(code)[7]);
		textField_7.setColumns(10);
		textField_7.setBounds(292, 304, 171, 21);
		getContentPane().add(textField_7);
		
		JLabel lblNewLabel_2_1_1_7 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_2_1_1_7.setBounds(81, 338, 57, 15);
		getContentPane().add(lblNewLabel_2_1_1_7);
		
		textField_8 = new JTextField(teacherService.inforNotList(code)[8]);
		textField_8.setColumns(10);
		textField_8.setBounds(115, 333, 348, 21);
		getContentPane().add(textField_8);
		
		JLabel lblNewLabel = new JLabel("\uD559\uC0DD\uC815\uBCF4\uC218\uC815");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		lblNewLabel.setBounds(237, 35, 123, 26);
		getContentPane().add(lblNewLabel);
		
		Button button = new Button("\uC218\uC815\uC644\uB8CC");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherVo vo = new TeacherVo("1",textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText(),
						textField_6.getText(), textField_7.getText(), textField_8.getText());
				
				if(teacherService.updatetea(vo, code) == 1) {
					Admin_teacher.model.setRowCount(0);
					tConts = teacherService.listAll();
					
					Admin_teacher.model.setDataVector(tConts, tHeader);
					
					teacherInfo = teacherService.infor(code);
					
					Admin_teacher.textField_1.setText(teacherInfo.get(0).getName());
					Admin_teacher.textField_2.setText(teacherInfo.get(0).getResidentId());
					Admin_teacher.textField_3.setText(teacherInfo.get(0).getPhone());
					Admin_teacher.textField_4.setText(teacherInfo.get(0).getEmail());
					Admin_teacher.textField_5.setText(teacherInfo.get(0).getYear());
					Admin_teacher.textField_6.setText(teacherInfo.get(0).getSal());
					Admin_teacher.textField_7.setText(teacherInfo.get(0).getMajor());
					Admin_teacher.textField_8.setText(teacherInfo.get(0).getAccountNumber());
					Admin_teacher.textField_10.setText(teacherInfo.get(0).getAddress());
					
					JOptionPane.showMessageDialog(null, "정보 수정이 완료되었습니다.");
					dispose();
				}
				
			}
		});
		button.setBounds(449, 428, 95, 37);
		getContentPane().add(button);
		
		setVisible(true);
	}
}
