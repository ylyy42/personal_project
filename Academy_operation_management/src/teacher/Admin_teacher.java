package teacher;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import database.admin.StudentsVo;
import database.admin.TeacherDao;
import database.admin.TeacherService;
import database.admin.TeacherVo;
import main.Main;
import student.Lecture_registration;

public class Admin_teacher extends JFrame {
	private Container con;
	private TeacherService teacherService;
	private JPanel contentPanel;
	private JPanel panel;
	static JTextField textField_1;
	static JTextField textField_2;
	static JTextField textField_3;
	static JTextField textField_4;
	static JTextField textField_5;
	static JTextField textField_6;
	static JTextField textField_7;
	static JTextField textField_8;
	static JTextField textField_10;
	private JTabbedPane pane;
	private JPanel pannel1;
	private JPanel pannel2;
	private String[] tHeader = new String[] {"코드", "이름", "과목" };
	private String[][] tConts;
	static DefaultTableModel model = new DefaultTableModel();
	private DefaultTableModel model1 = new DefaultTableModel();
	private DefaultTableModel model2 = new DefaultTableModel();
	private JScrollPane jscp;
	private JScrollPane jscp1;
	private JScrollPane jscp2;
	static JTable jtable;
	private JTable jtable1;
	private JTable jtable2;
	private int row;
	static String code;
	private List<TeacherVo> teacherInfo;
	private String[][] teacherLecInfo;
	private String[][] teacherStuInfo;
	private String[] oneH = { "강의명","강의시작날짜","강의학생수"};
	private String[] twoH = new String[] {"학생명", "수강중인 강의", "상태" };
	private Button button;
	private Button button_2;
	
	Admin_teacher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1125, 650);
		setLocationRelativeTo(null);
		teacherService = new TeacherService(new TeacherDao());
		contentPanel = new JPanel();
		contentPanel.setBackground(UIManager.getColor("InternalFrame.minimizeIconBackground"));
		contentPanel.setBounds(51, 84, 280, 433);
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPanel.setLayout(null);
		
		tConts = teacherService.listAll();
		model.setDataVector(tConts, tHeader);

		jtable = new JTable(model){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		jtable.getTableHeader().setReorderingAllowed(false);
		jscp = new JScrollPane(jtable);
		jscp.setBounds(12, 31, 251, 392);
		jtable.addMouseListener(new MouseListener() {

			@SuppressWarnings("serial")
			@Override
			public void mouseClicked(MouseEvent e) {
				row = jtable.getSelectedRow();
				code = (String) jtable.getModel().getValueAt(row, 0);
				teacherInfo = teacherService.infor(code);
				
				textField_1.setText(teacherInfo.get(0).getName());
				textField_2.setText(teacherInfo.get(0).getResidentId());
				textField_3.setText(teacherInfo.get(0).getPhone());
				textField_4.setText(teacherInfo.get(0).getEmail());
				textField_5.setText(teacherInfo.get(0).getYear());
				textField_6.setText(teacherInfo.get(0).getSal());
				textField_7.setText(teacherInfo.get(0).getMajor());
				textField_8.setText(teacherInfo.get(0).getAccountNumber());
				textField_10.setText(teacherInfo.get(0).getAddress());

				teacherLecInfo = teacherService.listLec(code);
				model1.setDataVector(teacherLecInfo, oneH);
				jtable1 = new JTable(model1) {
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				jtable1.getTableHeader().setReorderingAllowed(false);
				jscp1 = new JScrollPane(jtable1);
				jscp1.setBorder(null);
				jscp1.setBounds(0, 0, 630, 117);
				pannel1.add(jscp1);
				
				teacherStuInfo = teacherService.listStu(code);
				model2.setDataVector(teacherStuInfo, twoH);
				jtable2 = new JTable(model2) {
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				jtable2.getTableHeader().setReorderingAllowed(false);
				jscp2 = new JScrollPane(jtable2);
				jscp2.setBorder(null);
				jscp2.setBounds(0, 0, 630, 117);
				pannel2.add(jscp2);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		contentPanel.add(jscp);

		con = getContentPane();
		getContentPane().setLayout(null);
		con.add(contentPanel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC120\uC0DD\uB2D8\uBAA9\uB85D");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(12, 10, 65, 15);
		contentPanel.add(lblNewLabel_1);
		
		JPanel contentPanel_1 = new JPanel();
		contentPanel_1.setLayout(null);
		contentPanel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPanel_1.setBackground(UIManager.getColor("Button.background"));
		contentPanel_1.setBounds(370, 84, 663, 485);
		getContentPane().add(contentPanel_1);

		panel = new JPanel();
		panel.setBackground(UIManager.getColor("List.selectionBackground"));
		panel.setBounds(26, 24, 250, 210);
		panel.setLayout(null);
		contentPanel_1.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("\uC774\uB984");
		lblNewLabel_2.setBounds(342, 24, 57, 15);
		contentPanel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638");
		lblNewLabel_2_1.setLabelFor(lblNewLabel_2_1);
		lblNewLabel_2_1.setBounds(342, 52, 82, 15);
		contentPanel_1.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("\uD734\uB300\uD3F0\uBC88\uD638");
		lblNewLabel_2_1_1.setBounds(342, 80, 72, 15);
		contentPanel_1.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_2_1_1_1.setBounds(342, 108, 57, 15);
		contentPanel_1.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_2_1_1_2 = new JLabel("\uADFC\uBB34\uC5F0\uCC28");
		lblNewLabel_2_1_1_2.setBounds(342, 136, 57, 15);
		contentPanel_1.add(lblNewLabel_2_1_1_2);

		JLabel lblNewLabel_2_1_1_3 = new JLabel("\uC5F0\uBD09");
		lblNewLabel_2_1_1_3.setBounds(342, 164, 57, 15);
		contentPanel_1.add(lblNewLabel_2_1_1_3);

		JLabel lblNewLabel_2_1_1_4 = new JLabel("\uC804\uACF5");
		lblNewLabel_2_1_1_4.setBounds(342, 192, 72, 15);
		contentPanel_1.add(lblNewLabel_2_1_1_4);
		
		JLabel lblNewLabel_2_1_1_5 = new JLabel("\uACC4\uC88C\uBC88\uD638");
		lblNewLabel_2_1_1_5.setBounds(342, 220, 82, 15);
		contentPanel_1.add(lblNewLabel_2_1_1_5);

		JLabel lblNewLabel_2_1_1_7 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_2_1_1_7.setBounds(239, 278, 57, 15);
		contentPanel_1.add(lblNewLabel_2_1_1_7);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		lblNewLabel_2.setLabelFor(textField_1);
		textField_1.setBounds(450, 20, 171, 21);
		contentPanel_1.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(450, 49, 171, 21);
		contentPanel_1.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		lblNewLabel_2_1_1.setLabelFor(textField_3);
		textField_3.setColumns(10);
		textField_3.setBounds(450, 77, 171, 21);
		contentPanel_1.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		lblNewLabel_2_1_1_1.setLabelFor(textField_4);
		textField_4.setColumns(10);
		textField_4.setBounds(450, 105, 171, 21);
		contentPanel_1.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		lblNewLabel_2_1_1_2.setLabelFor(textField_5);
		textField_5.setColumns(10);
		textField_5.setBounds(450, 133, 171, 21);
		contentPanel_1.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		lblNewLabel_2_1_1_3.setLabelFor(textField_6);
		textField_6.setColumns(10);
		textField_6.setBounds(450, 161, 171, 21);
		contentPanel_1.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setEditable(false);
		lblNewLabel_2_1_1_4.setLabelFor(textField_7);
		textField_7.setColumns(10);
		textField_7.setBounds(450, 189, 171, 21);
		contentPanel_1.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		lblNewLabel_2_1_1_5.setLabelFor(textField_8);
		textField_8.setColumns(10);
		textField_8.setBounds(450, 217, 171, 21);
		contentPanel_1.add(textField_8);


		textField_10 = new JTextField();
		textField_10.setEditable(false);
		lblNewLabel_2_1_1_7.setLabelFor(textField_10);
		textField_10.setColumns(10);
		textField_10.setBounds(273, 273, 348, 21);
		contentPanel_1.add(textField_10);
		
		JLabel lblNewLabel = new JLabel("\uC120\uC0DD\uB2D8 \uAD00\uB9AC \uD398\uC774\uC9C0");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setBounds(51, 52, 186, 22);
		getContentPane().add(lblNewLabel);

		pane = createTabbedPane();
		contentPanel_1.add(pane);

		Button button_1 = new Button("\uAC1C\uC778\uC815\uBCF4\uC218\uC815");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Modify_teacher();
			}
		});
		button_1.setBounds(99, 246, 106, 23);
		contentPanel_1.add(button_1);
		
		button = new Button("\uBA54\uC778");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main();
				dispose();
			}
		});
		button.setBounds(28, 18, 80, 25);
		getContentPane().add(button);
		
		button_2 = new Button("\uC2E0\uADDC\uB4F1\uB85D");
		button_2.setBounds(944, 52, 76, 23);
		getContentPane().add(button_2);
		
		setVisible(true);
	}
	
	public JTabbedPane createTabbedPane() {
		pannel1 = new JPanel();
		pannel1.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		pannel1.setBorder(null);
		pannel1.setLayout(null);

		pannel2 = new JPanel();
		pannel2.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		pannel2.setBorder(null);
		pannel2.setLayout(null);

		pane = new JTabbedPane();
		pane.setBorder(null);
		pane.setLocation(15, 289);
		pane.setSize(635, 191);

		pane.addTab("담당강좌", pannel1);
		pane.addTab("수강생현황", pannel2);
		
		return pane;
	}
	
	public static void main(String[] args) {
		Admin_teacher frame = new Admin_teacher();
	}
}
