package student;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import database.admin.StudentsDao;
import database.admin.StudentsLecVo;
import database.admin.StudentsService;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Font;

public class Lecture_registration extends JFrame {
	private JTable jtable;
	private String[] tHeader;
	private String[][] lecConts;
	private StudentsService studentsService;
	private String code = Admin_students.code;
	private String l_Code;
	private String[] oneH = { "강좌번호","강좌명","담당 선생님", "수강료청구일", "수납여부" };
	
	public int RealCode(String code) {
		int realCode = Integer.parseInt(code);
		return realCode;
	}
	
	public Lecture_registration() {
		studentsService = new StudentsService(new StudentsDao());
		RealCode(code);
		getContentPane().setLayout(null);
		setSize(699, 400);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(69, 48, 553, 244);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		tHeader = new String[] {"강좌코드" ,"강좌명", "강좌가격", "담당선생님" ,"남은자리"};
		lecConts = studentsService.lecAdd();
		jtable = new JTable(lecConts , tHeader);
		JScrollPane jscp = new JScrollPane(jtable);
		jscp.setBounds(0, 10, 553, 233);
		panel.add(jscp);
		
		Button button = new Button("\uB4F1\uB85D\uD558\uAE30");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = jtable.getSelectedRow();
				l_Code = (String) jtable.getModel().getValueAt(row, 0);
				System.out.println(l_Code);
				StudentsLecVo vo = new StudentsLecVo(code, l_Code, "aaa", "미납", "수강전", 1);
				
				if(studentsService.stuLecAdd(vo) == 1) {
					JOptionPane.showMessageDialog(null, "강좌 등록이 완료되었습니다.");
					Admin_students.model1.setRowCount(0);
					String[][] stuLecInfo = studentsService.listLec(code);
					Admin_students.model1.setDataVector(stuLecInfo, oneH);
					dispose();
				}
			}
		});
		button.setBounds(554, 313, 91, 31);
		getContentPane().add(button);
		
		Label label = new Label("\uAC15\uC88C\uB4F1\uB85D");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		label.setBounds(284, 10, 101, 23);
		getContentPane().add(label);
		
		Button button_1 = new Button("\uB4A4\uB85C\uAC00\uAE30");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin_students();
				dispose();
			}
		});
		button_1.setBounds(10, 10, 91, 31);
		getContentPane().add(button_1);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Lecture_registration frame = new Lecture_registration();
	}
}
