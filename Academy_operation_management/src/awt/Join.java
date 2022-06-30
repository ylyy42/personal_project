package awt;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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

	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Join frame = new Join();
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		Join frame = new Join();
	}

	public Join() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(430, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblJoin = new JLabel("ȸ������");
		Font f1 = new Font("����", Font.BOLD, 20); //�ü� ���� ����
		lblJoin.setFont(f1); 
		lblJoin.setBounds(159, 41, 101, 20);
		contentPane.add(lblJoin);
		
		JLabel lblUsername = new JLabel("��й�ȣ");
		lblUsername.setBounds(69, 212, 69, 20);
		contentPane.add(lblUsername);
		
		JLabel label = new JLabel("�̸�");
		label.setBounds(69, 122, 69, 20);
		contentPane.add(label);
		
		JLabel lblName = new JLabel("���̵�");
		lblName.setBounds(69, 167, 69, 20);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("�̸���");
		lblEmail.setBounds(69, 349, 69, 20);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("�޴�����ȣ");
		lblPhone.setBounds(69, 304, 69, 20);
		contentPane.add(lblPhone);
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(159, 115, 186, 35);
		contentPane.add(tfUsername);
		
		tfPassword = new JPasswordField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(159, 205, 186, 35);
		tfPassword.setEchoChar('*');
		contentPane.add(tfPassword);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(159, 160, 186, 35);
		contentPane.add(tfName);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(159, 342, 186, 35);
		contentPane.add(tfEmail);
		
		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(159, 297, 186, 35);
		contentPane.add(tfPhone);
		
		joinCompleteBtn = new JButton("ȸ�����ԿϷ�");
		joinCompleteBtn.setBounds(206, 504, 139, 29);
		contentPane.add(joinCompleteBtn);
		
		lblNewLabel_1 = new JLabel("�ֹε�Ϲ�ȣ");
		lblNewLabel_1.setBounds(69, 260, 77, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(159, 250, 186, 35);
		contentPane.add(textField);
		
		setVisible(true);
		
		
		//ȸ�����ԿϷ� �׼�
		joinCompleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pw = "";
				char[] secret_pw = tfPassword.getPassword();
				
				for(char cha : secret_pw) {
					Character.toString(cha);
					
					pw += (pw.equals("")) ? "" + cha + "" : "" + cha + "";
				}
				
				ManagerService managerService = new ManagerService(new ManagerDao());
				ManagerVo vo = new ManagerVo(1, tfUsername.getText(), tfName.getText(), pw, textField.getText(),
						tfPhone.getText(), tfEmail.getText());
				System.out.println(vo.getEmail());
				managerService.regist(vo);
				
				JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�.");
				dispose();
			}
		});

	}
}
