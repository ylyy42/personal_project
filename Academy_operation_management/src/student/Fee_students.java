package student;

import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.admin.StudentsDao;
import database.admin.StudentsFeeVo;
import database.admin.StudentsService;

public class Fee_students extends JFrame {
	
	private StudentsService studentsService;
	private JTable table;
	private DefaultTableModel model = new DefaultTableModel();
	private String[] Header = {"학생코드", "학생이름","수납일","수걍료", "수납여부" };
	private String[][] conts;
	
	public Fee_students() {
		studentsService = new StudentsService(new StudentsDao());
		setBounds(new Rectangle(0, 0, 1000, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(795, 560);
		getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(110, 88, 569, 364);
		getContentPane().add(panel);
		setLocationRelativeTo(null);
		
		conts = studentsService.Feelist();
		model.setDataVector(conts, Header);
		table = new JTable(model){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JScrollPane jscp = new JScrollPane(table);
		jscp.setBounds(0, 0, 569, 364);
		table.getTableHeader().setReorderingAllowed(false);
		panel.setLayout(null);
		table.setBounds(142, 119, 499, 330);
		panel.add(jscp);
		
		Label label = new Label("\uD559\uC6D0\uBE44\uC218\uB0A9\uD604\uD669");
		label.setBounds(43, 35, 103, 23);
		getContentPane().add(label);
		
		Button button = new Button("\uC218\uB0A9\uC644\uB8CC");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String code = (String) table.getModel().getValueAt(row, 0);
				String name = (String) table.getModel().getValueAt(row, 0);
				String giveDate = (String) table.getModel().getValueAt(row, 0);
				String fee = (String) table.getModel().getValueAt(row, 0);
				String giving = (String) table.getModel().getValueAt(row, 0);
				StudentsFeeVo vo = new StudentsFeeVo(code, name, giveDate, fee, giving);
				
				studentsService.updateFee(vo);
				
				JOptionPane.showMessageDialog(null, "납부 완료되었습니다.");
				conts = studentsService.Feelist();
				model.setDataVector(conts, Header);
				table = new JTable(model){
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
			}
		});
		button.setBounds(637, 466, 103, 40);
		getContentPane().add(button);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		Fee_students frame = new Fee_students();
	}
}
