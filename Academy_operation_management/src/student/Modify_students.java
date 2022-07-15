package student;

import java.awt.Button;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import database.admin.StudentsDao;
import database.admin.StudentsService;
import database.admin.StudentsVo;

public class Modify_students extends JFrame {
	
	private StudentsService studentsService;
	private String code = Admin_students.code;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private List<StudentsVo> stuInfo;
	private int realCode;
	private String[] tHeader = new String[] {"코드", "이름", "학교", "학년" };
	private String[][] tConts;
	
	public int RealCode(String code) {
		realCode = Integer.parseInt(code);
		return realCode;
	}
	
	public Modify_students() throws SQLException {
		studentsService = new StudentsService(new StudentsDao());
		RealCode(code);
		
		setBounds(new Rectangle(0, 0, 1000, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(629, 560);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\uC774\uB984");
		lblNewLabel_2.setBounds(169, 110, 57, 15);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField(studentsService.inforNotList(code)[0]);
		textField.setColumns(10);
		textField.setBounds(292, 107, 171, 21);
		getContentPane().add(textField);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638");
		lblNewLabel_2_1.setBounds(169, 139, 82, 15);
		getContentPane().add(lblNewLabel_2_1);
		
		textField_1 = new JTextField(studentsService.inforNotList(code)[1]);
		textField_1.setColumns(10);
		textField_1.setBounds(292, 136, 171, 21);
		getContentPane().add(textField_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("\uD734\uB300\uD3F0\uBC88\uD638");
		lblNewLabel_2_1_1.setBounds(169, 167, 72, 15);
		getContentPane().add(lblNewLabel_2_1_1);
		
		textField_2 = new JTextField(studentsService.inforNotList(code)[2]);
		textField_2.setColumns(10);
		textField_2.setBounds(292, 164, 171, 21);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_2_1_1_1.setBounds(169, 195, 57, 15);
		getContentPane().add(lblNewLabel_2_1_1_1);
		
		textField_3 = new JTextField(studentsService.inforNotList(code)[7]);
		textField_3.setColumns(10);
		textField_3.setBounds(292, 192, 171, 21);
		getContentPane().add(textField_3);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("\uD559\uAD50");
		lblNewLabel_2_1_1_2.setBounds(169, 223, 57, 15);
		getContentPane().add(lblNewLabel_2_1_1_2);
		
		textField_4 = new JTextField(studentsService.inforNotList(code)[3]);
		textField_4.setColumns(10);
		textField_4.setBounds(292, 220, 171, 21);
		getContentPane().add(textField_4);
		
		JLabel lblNewLabel_2_1_1_3 = new JLabel("\uD559\uB144");
		lblNewLabel_2_1_1_3.setBounds(169, 251, 57, 15);
		getContentPane().add(lblNewLabel_2_1_1_3);
		
		textField_5 = new JTextField(studentsService.inforNotList(code)[4]);
		textField_5.setColumns(10);
		textField_5.setBounds(292, 248, 171, 21);
		getContentPane().add(textField_5);
		
		JLabel lblNewLabel_2_1_1_4 = new JLabel("\uD559\uBD80\uBAA8\uC774\uB984");
		lblNewLabel_2_1_1_4.setBounds(169, 279, 72, 15);
		getContentPane().add(lblNewLabel_2_1_1_4);
		
		textField_6 = new JTextField(studentsService.inforNotList(code)[5]);
		textField_6.setColumns(10);
		textField_6.setBounds(292, 276, 171, 21);
		getContentPane().add(textField_6);
		
		JLabel lblNewLabel_2_1_1_5 = new JLabel("\uD559\uBD80\uBAA8\uC5F0\uB77D\uCC98");
		lblNewLabel_2_1_1_5.setBounds(168, 308, 82, 15);
		getContentPane().add(lblNewLabel_2_1_1_5);
		
		textField_7 = new JTextField(studentsService.inforNotList(code)[6]);
		textField_7.setColumns(10);
		textField_7.setBounds(292, 304, 171, 21);
		getContentPane().add(textField_7);
		
		JLabel lblNewLabel_2_1_1_7 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_2_1_1_7.setBounds(81, 338, 57, 15);
		getContentPane().add(lblNewLabel_2_1_1_7);
		
		textField_8 = new JTextField(studentsService.inforNotList(code)[8]);
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
				StudentsVo vo = new StudentsVo(1 ,textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText() , textField_5.getText(), textField_6.getText(),
						textField_7.getText(), textField_8.getText());
				int realCode = RealCode(code);
				if(studentsService.updatestu(vo, realCode) == 1) {
					Admin_students.model.setRowCount(0);
					tConts = studentsService.listAll();
					Admin_students.model.setDataVector(tConts, tHeader);
					
					stuInfo = studentsService.infor(code);
					
					Admin_students.textField_1.setText(stuInfo.get(0).getName());
					Admin_students.textField_2.setText(stuInfo.get(0).getResidentId());
					Admin_students.textField_3.setText(stuInfo.get(0).getPhone());
					Admin_students.textField_4.setText(stuInfo.get(0).getEmail());
					Admin_students.textField_5.setText(stuInfo.get(0).getSchool());
					Admin_students.textField_6.setText(stuInfo.get(0).getGrade());
					Admin_students.textField_7.setText(stuInfo.get(0).getParentsName());
					Admin_students.textField_8.setText(stuInfo.get(0).getParentsPhone());
					Admin_students.textField_10.setText(stuInfo.get(0).getAddress());
					
					
					JOptionPane.showMessageDialog(null, "정보 수정이 완료되었습니다.");
					dispose();
				}
			}
		});
		button.setBounds(437, 439, 95, 37);
		getContentPane().add(button);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		try {
			Modify_students frame = new Modify_students();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
