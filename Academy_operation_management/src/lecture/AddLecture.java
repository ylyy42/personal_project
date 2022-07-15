package lecture;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import database.lecture.LectureDao;
import database.lecture.LectureService;
import database.lecture.LectureVo;

import java.awt.Label;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddLecture extends JFrame {
	
	private LectureService lectureService;
	
	public AddLecture() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(537, 494);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		Label label = new Label("\uAC15\uC88C\uCD94\uAC00");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		label.setBounds(210, 28, 133, 35);
		getContentPane().add(label);
		
		Label label_1 = new Label("\uAC15\uC88C\uCF54\uB4DC");
		label_1.setBounds(100, 117, 69, 23);
		getContentPane().add(label_1);
		
		Label label_1_1 = new Label("\uAC15\uC88C\uBA85");
		label_1_1.setBounds(100, 154, 69, 23);
		getContentPane().add(label_1_1);
		
		Label label_1_1_1 = new Label("\uC218\uAC15\uB8CC");
		label_1_1_1.setBounds(100, 194, 69, 23);
		getContentPane().add(label_1_1_1);
		
		Label label_1_1_1_1 = new Label("\uC815\uC6D0");
		label_1_1_1_1.setBounds(100, 232, 69, 23);
		getContentPane().add(label_1_1_1_1);
		
		Label label_1_1_1_1_1 = new Label("\uAC15\uC758\uC77C\uC218");
		label_1_1_1_1_1.setBounds(100, 268, 69, 23);
		getContentPane().add(label_1_1_1_1_1);
		
		Label label_1_1_1_1_2 = new Label("\uB2F4\uB2F9\uC120\uC0DD\uB2D8\uCF54\uB4DC");
		label_1_1_1_1_2.setBounds(100, 301, 92, 23);
		getContentPane().add(label_1_1_1_1_2);
		
		Label label_1_1_1_1_3 = new Label("\uC2DC\uC791\uB0A0\uC9DC");
		label_1_1_1_1_3.setBounds(100, 333, 69, 23);
		getContentPane().add(label_1_1_1_1_3);
		
		TextField textField = new TextField();
		textField.setBounds(210, 117, 163, 23);
		getContentPane().add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(210, 154, 163, 23);
		getContentPane().add(textField_1);
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(210, 192, 163, 23);
		getContentPane().add(textField_2);
		
		TextField textField_3 = new TextField();
		textField_3.setBounds(210, 232, 163, 23);
		getContentPane().add(textField_3);
		
		TextField textField_4 = new TextField();
		textField_4.setBounds(210, 268, 163, 23);
		getContentPane().add(textField_4);
		
		TextField textField_5 = new TextField();
		textField_5.setBounds(210, 301, 163, 23);
		getContentPane().add(textField_5);
		
		TextField textField_6 = new TextField();
		textField_6.setBounds(210, 333, 163, 23);
		getContentPane().add(textField_6);
		
		Button button = new Button("\uB4F1\uB85D");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LectureVo vo = new LectureVo(textField.getText(), textField_1.getText(), textField_2.getText(), 
						textField_3.getText(), textField_4.getText(), textField_5.getText(), textField_6.getText());
				
				if(lectureService.Addlec(vo) == 1) {
					JOptionPane.showMessageDialog(null, "추가완료했습니다.");
					dispose();
					
					Lecture.conts = lectureService.Leclist();
					Lecture.model.setDataVector(Lecture.conts, Lecture.Header);
				}
				
			}
		});
		button.setBounds(210, 393, 103, 28);
		getContentPane().add(button);
		lectureService = new LectureService(new LectureDao());
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
