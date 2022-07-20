package student;

import java.awt.Button;
import java.awt.Font;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.admin.StudentsDao;
import database.admin.StudentsService;

public class Delete_lecture extends JFrame {
	
	private StudentsService studentsService;
	private DefaultTableModel model1 = new DefaultTableModel();
	private String code = Admin_students.code;
	private String[] oneH = { "강좌번호","강좌명","담당 선생님", "수강료청구일", "수납여부" };
	private JTable jtable1;
	private JScrollPane jscp1;
	private JPanel pannel1;
	private int row;
	private int row2;
	private int lCode;
	private int sCode = Admin_students.sCode;
	private JTable jtable = Admin_students.jtable;
	
	public Delete_lecture() {
		setBounds(new Rectangle(0, 0, 1000, 0));
		setSize(567, 538);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		studentsService = new StudentsService(new StudentsDao());
		pannel1 = new JPanel();
		pannel1.setLocation(0, 0);
		pannel1.setSize(551, 499);
		
		String[][] stuLecInfo = studentsService.listLec(code);
		model1.setDataVector(stuLecInfo, oneH);
		jtable1 = new JTable(model1) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		jtable1.getTableHeader().setReorderingAllowed(false);
		pannel1.setLayout(null);
		jscp1 = new JScrollPane(jtable1);
		jscp1.setBorder(null);
		jscp1.setBounds(52, 43, 452, 402);
		pannel1.add(jscp1);
		
		getContentPane().add(pannel1);
		
		Button button = new Button("\uC0AD\uC81C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row = jtable.getSelectedRow();
				row2 = jtable1.getSelectedRow();
				
				sCode = Integer.parseInt((String) jtable.getModel().getValueAt(row, 0));
				lCode = Integer.parseInt((String) jtable1.getModel().getValueAt(row2, 0));
				
				if(studentsService.stuLecDelete(sCode, lCode) == 1) {
					JOptionPane.showMessageDialog(null, "강의 삭제가 완료됬습니다.");
					Admin_students.model1.setRowCount(0);
					String[][] stuLecInfo = studentsService.listLec(code);
					Admin_students.model1.setDataVector(stuLecInfo, oneH);
					dispose();
				}
			}
		});
		button.setBounds(447, 460, 76, 23);
		pannel1.add(button);
		
		Label label = new Label("\uAC15\uC88C\uC0AD\uC81C");
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		label.setBounds(18, 11, 69, 23);
		pannel1.add(label);
		setVisible(true);
	}
	
}
