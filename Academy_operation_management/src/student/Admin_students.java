package student;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import database.admin.StudentsDao;
import database.admin.StudentsService;
import database.admin.StudentsVo;
import main.Main;

public class Admin_students extends JFrame implements MouseListener {

	private StudentsService studentsService;

	private Container con;
	private JPanel contentPanel;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_10;
	private JPanel panel;
	private JTable jtable;
	private JTabbedPane pane;
	private String[] tHeader;
	private String[][] tConts;
	static String code;
	private List<StudentsVo> stuInfo;
	private String[][] stuLecInfo;
	private String[][] stuAttInfo;
	private String[][] stuScoInfo;
	private JPanel pannel1;
	private JPanel pannel2;
	private JPanel pannel3;
	private JTable jtable1;
	private JTable jtable2;
	private JTable jtable3;
	private String[] oneH = { "강좌명","담당 선생님", "수강료청구일", "수납여부", "수강상태" };
	private String[] twoH = { "입실", "퇴실", "조퇴", "조퇴사유" };
	private String[] threeH = { "시험날짜", "시험이름", "점수" };
	private JScrollPane jscp1;
	private JScrollPane jscp2;
	private JScrollPane jscp3;

	public Admin_students() {
		studentsService = new StudentsService(new StudentsDao());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1125, 650);
		setLocationRelativeTo(null);
		contentPanel = new JPanel();
		contentPanel.setBackground(UIManager.getColor("InternalFrame.minimizeIconBackground"));
		contentPanel.setBounds(51, 84, 280, 433);
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPanel.setLayout(null);

		con = getContentPane();
		getContentPane().setLayout(null);
		con.add(contentPanel);

		JLabel lblNewLabel_1 = new JLabel("\uD559\uC0DD\uBAA9\uB85D");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(12, 10, 65, 15);
		contentPanel.add(lblNewLabel_1);

		TextField textField = new TextField();
		textField.setBounds(144, 9, 74, 20);
		contentPanel.add(textField);

		Button button = new Button("\uAC80\uC0C9");
		button.setBounds(224, 8, 39, 20);
		contentPanel.add(button);

		tHeader = new String[] {"코드", "이름", "학교", "학년" };
		tConts = studentsService.listAll();

		jtable = new JTable(tConts, tHeader);
		JScrollPane jscp = new JScrollPane(jtable);
		jscp.setBounds(12, 31, 251, 392);
		contentPanel.add(jscp);

		startEvent();

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

		JLabel lblNewLabel_2_1_1_2 = new JLabel("\uD559\uAD50");
		lblNewLabel_2_1_1_2.setBounds(342, 136, 57, 15);
		contentPanel_1.add(lblNewLabel_2_1_1_2);

		JLabel lblNewLabel_2_1_1_3 = new JLabel("\uD559\uB144");
		lblNewLabel_2_1_1_3.setBounds(342, 164, 57, 15);
		contentPanel_1.add(lblNewLabel_2_1_1_3);

		JLabel lblNewLabel_2_1_1_4 = new JLabel("\uD559\uBD80\uBAA8\uC774\uB984");
		lblNewLabel_2_1_1_4.setBounds(342, 192, 72, 15);
		contentPanel_1.add(lblNewLabel_2_1_1_4);

		JLabel lblNewLabel_2_1_1_5 = new JLabel("\uD559\uBD80\uBAA8\uC5F0\uB77D\uCC98");
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

		JLabel lblNewLabel = new JLabel("\uD559\uC0DD \uAD00\uB9AC \uD398\uC774\uC9C0");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setBounds(51, 52, 186, 22);
		getContentPane().add(lblNewLabel);

		pane = createTabbedPane();
		contentPanel_1.add(pane);

		Button button_1 = new Button("\uAC1C\uC778\uC815\uBCF4\uC218\uC815");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(code != null) {
					try {
						new Modify_students();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "학생을 선택해주세요.");
				}
			}
		});
		button_1.setBounds(35, 246, 106, 23);
		contentPanel_1.add(button_1);

		Button button_1_1 = new Button("\uC0AC\uC9C4\uB4F1\uB85D");
		button_1_1.setBounds(158, 245, 106, 23);
		contentPanel_1.add(button_1_1);

		Button button_2 = new Button("\uC2E0\uADDC\uB4F1\uB85D");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Registration_students();
				dispose();
			}
		});
		button_2.setBounds(946, 52, 76, 23);
		getContentPane().add(button_2);

		Button button_3 = new Button("\uBA54\uC778");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main();
				dispose();
			}
		});
		button_3.setBounds(51, 23, 76, 23);
		getContentPane().add(button_3);

		setVisible(true);
	}

	public JTabbedPane createTabbedPane() {
		String[][] one = { { "", "", "", "", "" } };
		String[][] two = { { "", "", "", "" } };
		String[][] three = { { "", "", "" } };

		pannel1 = new JPanel();
		pannel1.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		pannel1.setBorder(null);
		pannel1.setLayout(null);

		pannel2 = new JPanel();
		pannel2.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		pannel2.setBorder(null);
		pannel2.setLayout(null);

		pannel3 = new JPanel();
		pannel3.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		pannel3.setBorder(null);
		pannel3.setLayout(null);

		jtable1 = new JTable(one, oneH);
		jscp1 = new JScrollPane(jtable1);

		jtable2 = new JTable(two, twoH);
		jscp2 = new JScrollPane(jtable2);

		jtable3 = new JTable(three, threeH);
		jscp3 = new JScrollPane(jtable3);

		pane = new JTabbedPane();
		pane.setBorder(null);
		pane.setLocation(15, 289);
		pane.setSize(635, 191);

		pane.addTab("강좌", pannel1);

		Button button_3 = new Button("\uAC15\uC88C\uB4F1\uB85D");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Lecture_registration();
				dispose();
			}
		});
		button_3.setBounds(533, 129, 87, 23);
		pannel1.add(button_3);

		Button button_4 = new Button("\uAC15\uC88C\uC0AD\uC81C");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_4.setBounds(418, 129, 87, 23);
		pannel1.add(button_4);
		pane.addTab("출결", pannel2);

		Button button_2 = new Button("\uC870\uD1F4");
		button_2.setBounds(503, 129, 117, 23);
		pannel2.add(button_2);
		pane.addTab("성적", pannel3);

		return pane;
	}

	public void startEvent() {
		jtable.addMouseListener(this);
	}

	public static void main(String[] args) throws SQLException {
		Admin_students frame = new Admin_students();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = jtable.getSelectedRow();
		code = (String) jtable.getModel().getValueAt(row, 0);
		stuInfo = studentsService.infor(code);
		System.out.println(studentsService.infor(code));
		
		textField_1.setText(stuInfo.get(0).getName());
		textField_2.setText(stuInfo.get(0).getResidentId());
		textField_3.setText(stuInfo.get(0).getPhone());
		textField_4.setText(stuInfo.get(0).getEmail());
		textField_5.setText(stuInfo.get(0).getSchool());
		textField_6.setText(stuInfo.get(0).getGrade());
		textField_7.setText(stuInfo.get(0).getParentsName());
		textField_8.setText(stuInfo.get(0).getParentsPhone());
		textField_10.setText(stuInfo.get(0).getAddress());

		stuLecInfo = studentsService.listLec(code);
		jtable1 = new JTable(stuLecInfo, oneH);
		jscp1 = new JScrollPane(jtable1);
		jscp1.setBorder(null);
		jscp1.setBounds(0, 0, 630, 117);
		pannel1.add(jscp1);

		stuAttInfo = studentsService.listAtt(code);
		jtable2 = new JTable(stuAttInfo, twoH);
		jscp2 = new JScrollPane(jtable2);
		jscp2.setBorder(null);
		jscp2.setBounds(0, 0, 630, 117);
		pannel2.add(jscp2);

		stuScoInfo = studentsService.listSco(code);
		jtable3 = new JTable(stuScoInfo, threeH);
		jscp3 = new JScrollPane(jtable3);
		jscp3.setBorder(null);
		jscp3.setBounds(0, 0, 630, 117);
		pannel3.add(jscp3);

	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

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
	
}
