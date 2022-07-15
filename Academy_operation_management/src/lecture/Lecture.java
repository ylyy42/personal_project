package lecture;

import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.lecture.LectureDao;
import database.lecture.LectureService;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lecture extends JFrame {
	
	static DefaultTableModel model = new DefaultTableModel();
	static String[] Header = {"강좌코드","강좌명", "수업시작날짜","담당선생님"};
	static String[][] conts;
	private JTable table;
	private LectureService lectureService;
	private int row;
	private String lCode;
	
	public Lecture() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		lectureService = new LectureService(new LectureDao());
		
		Panel panel = new Panel();
		panel.setBounds(75, 52, 569, 318);
		getContentPane().add(panel);
		setLocationRelativeTo(null);
		
		conts = lectureService.Leclist();
		model.setDataVector(conts, Header);
		table = new JTable(model){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JScrollPane jscp = new JScrollPane(table);
		jscp.setBounds(0, 0, 569, 318);
		table.getTableHeader().setReorderingAllowed(false);
		panel.setLayout(null);
		table.setBounds(142, 119, 499, 330);
		panel.add(jscp);
		
		Label label = new Label("\uAC15\uC88C\uBAA9\uB85D");
		label.setBounds(34, 22, 69, 23);
		getContentPane().add(label);
		
		Button button = new Button("\uAC15\uC88C\uCD94\uAC00");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddLecture();
			}
		});
		button.setBounds(578, 402, 100, 30);
		getContentPane().add(button);
		
		Button button_1 = new Button("\uAC15\uC88C\uC0AD\uC81C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row = table.getSelectedRow();
				lCode = (String) table.getModel().getValueAt(row, 0);
				lectureService.Deletelec(lCode);
				JOptionPane.showMessageDialog(null, "삭제완료되었습니다.");
				
				conts = lectureService.Leclist();
				model.setDataVector(conts, Header);
			}
		});
		button_1.setBounds(448, 402, 100, 30);
		getContentPane().add(button_1);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Lecture frame = new Lecture();
	}
}
