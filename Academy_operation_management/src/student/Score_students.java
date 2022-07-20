package student;

import java.awt.Button;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import database.admin.StudentsDao;
import database.admin.StudentsScoVo;
import database.admin.StudentsService;

public class Score_students extends JFrame {
	
	private StudentsService studentsService;
	private TextField textField;
	private TextField textField_1;
	private TextField textField_2;
	private String code = Admin_students.code;
	private String[][] stuScoInfo;
	private String[] threeH = { "시험날짜", "시험이름", "점수" };
	
	public Score_students() {
		setBounds(new Rectangle(0, 0, 1000, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(517, 384);
		getContentPane().setLayout(null);
		studentsService = new StudentsService(new StudentsDao());
		
		Label label = new Label("\uC810\uC218\uB4F1\uB85D");
		label.setBounds(27, 20, 69, 23);
		getContentPane().add(label);
		
		Label label_1 = new Label("\uC2DC\uD5D8\uB0A0\uC9DC");
		label_1.setBounds(83, 103, 69, 23);
		getContentPane().add(label_1);
		
		Label label_1_1 = new Label("\uC2DC\uD5D8\uC774\uB984");
		label_1_1.setBounds(83, 140, 69, 23);
		getContentPane().add(label_1_1);
		
		Label label_1_2 = new Label("\uC2DC\uD5D8\uC810\uC218");
		label_1_2.setBounds(83, 180, 69, 23);
		getContentPane().add(label_1_2);
		
		textField = new TextField();
		textField.setBounds(158, 103, 186, 23);
		getContentPane().add(textField);
		
		textField_1 = new TextField();
		textField_1.setBounds(158, 140, 186, 23);
		getContentPane().add(textField_1);
		
		textField_2 = new TextField();
		textField_2.setBounds(158, 180, 186, 23);
		getContentPane().add(textField_2);
		
		Button button = new Button("\uB4F1\uB85D\uD558\uAE30");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentsScoVo vo = new StudentsScoVo(textField.getText(), textField_1.getText(), textField_2.getText(), code);
				
				if(studentsService.insertScore(vo) == 1) {
					JOptionPane.showMessageDialog(null, "점수등록이 완료되었습니다.");
					dispose();
					stuScoInfo = studentsService.listSco(code);
					Admin_students.model3.setDataVector(stuScoInfo, threeH);
				}
			}
		});
		button.setBounds(363, 270, 94, 39);
		getContentPane().add(button);
		setLocationRelativeTo(null);
		
		setVisible(true);
	}

}
