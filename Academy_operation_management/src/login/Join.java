package login;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import database.manager.ManagerDao;
import database.manager.ManagerService;
import database.manager.ManagerVo;

public class Join extends JFrame {

	private JPanel contentPane;
	private JLabel lblJoin;
	private JButton joinCompleteBtn;
	private JTextField tfUsername;
	private JPasswordField tfPassword;
	private JTextField tfName;
	private JTextField tfEmail;
	private JTextField tfPhone;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private boolean idCheck = false;

	public Join() {
		ManagerService managerService = new ManagerService(new ManagerDao());
		
		setSize(430, 509);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblJoin = new JLabel("회원가입");
		Font f1 = new Font("돋움", Font.BOLD, 20); //궁서 바탕 돋움
		lblJoin.setFont(new Font("돋움", Font.BOLD, 25)); 
		lblJoin.setBounds(148, 34, 131, 35);
		contentPane.add(lblJoin);
		
		JLabel lblUsername = new JLabel("비밀번호");
		lblUsername.setBounds(69, 212, 69, 20);
		contentPane.add(lblUsername);
		
		JLabel label = new JLabel("이름");
		label.setBounds(69, 122, 69, 20);
		contentPane.add(label);
		
		JLabel lblName = new JLabel("아이디");
		lblName.setBounds(69, 167, 69, 20);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setBounds(69, 349, 69, 20);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("휴대폰번호");
		lblPhone.setBounds(69, 304, 69, 20);
		contentPane.add(lblPhone);
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(148, 115, 164, 35);
		contentPane.add(tfUsername);
		
		tfPassword = new JPasswordField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(148, 205, 164, 35);
		tfPassword.setEchoChar('*');
		contentPane.add(tfPassword);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(148, 160, 164, 35);
		contentPane.add(tfName);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(148, 342, 164, 35);
		contentPane.add(tfEmail);
		
		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(148, 297, 164, 35);
		contentPane.add(tfPhone);
		
		joinCompleteBtn = new JButton("회원가입완료");
		joinCompleteBtn.setBounds(140, 410, 139, 29);
		contentPane.add(joinCompleteBtn);
		
		lblNewLabel_1 = new JLabel("주민등록번호");
		lblNewLabel_1.setBounds(69, 260, 77, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(148, 250, 164, 35);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("\uC911\uBCF5\uD655\uC778");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerVo vo = new ManagerVo(tfName.getText());
				
				if(vo.getId().equals("")) {
					idCheck = false;
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
				} else if(managerService.check(vo) == false) {
					idCheck = false;
					JOptionPane.showMessageDialog(null, "중복되는 아이디가 있습니다. 아이디를 변경해주세요");
				} else {
					idCheck = true;
					JOptionPane.showMessageDialog(null, "아이디 사용이 가능합니다.");
				}
			}
		});
		btnNewButton.setBounds(321, 167, 81, 20);
		contentPane.add(btnNewButton);
		
		setVisible(true);
		
		
		//회원가입완료 액션
		joinCompleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pw = "";
				char[] secret_pw = tfPassword.getPassword();
				
				for(char cha : secret_pw) {
					Character.toString(cha);
					
					pw += (pw.equals("")) ? "" + cha + "" : "" + cha + "";
				}
				
				
				if(idCheck == true) {
					ManagerVo vo = new ManagerVo(1, tfUsername.getText(), tfName.getText(), pw, textField.getText(),
							tfPhone.getText(), tfEmail.getText());
					managerService.regist(vo);
					JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "아이디 중복체크를 해주세요.");
				}
				
			}
		});

	}
}
