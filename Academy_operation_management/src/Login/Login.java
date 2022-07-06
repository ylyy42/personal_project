package Login;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class Login extends WindowAdapter implements ActionListener {

	private ManagerDao dao;
	private JFrame f;
	private JButton btn, subtn;
	private Label lid;
	private Label lpwd;
	private TextField id;
	private TextField pwd;

	public Login() {
		dao = new ManagerDao();
		f = new JFrame();
		btn = new JButton("로그인");
		btn.setSize(100, 30);
		btn.setLocation(143, 174);
		subtn = new JButton("회원가입");
		subtn.setLocation(275, 174);
		subtn.setSize(100, 30);
		f.setSize(543, 287);
		f.getContentPane().setLayout(null);
		lid = new Label("\uC544\uC774\uB514", Label.RIGHT);
		lid.setSize(50, 20);
		lid.setLocation(67, 120);
		lpwd = new Label("\uBE44\uBC00\uBC88\uD638", Label.RIGHT);
		lpwd.setSize(73, 20);
		lpwd.setLocation(233, 120);
		id = new TextField(10);
		id.setSize(100, 20);
		id.setLocation(123, 120);
		pwd = new TextField(10);
		pwd.setSize(100, 20);
		pwd.setLocation(324, 120);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void start() {
		pwd.setEchoChar('*');
		btn.addActionListener(this);
		subtn.addActionListener(this);
		f.addWindowListener(this);
		f.getContentPane().add(lid);
		f.getContentPane().add(id);
		f.getContentPane().add(lpwd);
		f.getContentPane().add(pwd);
		f.getContentPane().add(btn);
		f.getContentPane().add(subtn);
		
		JLabel lblNewLabel = new JLabel("\uD559\uC6D0 \uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setBounds(143, 27, 244, 48);
		f.getContentPane().add(lblNewLabel);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("로그인")) {
			if (id.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "ID를 입력하세요.");
			} else if (pwd.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요");
			} else {
				System.out.println(id.getText());
				System.out.println(pwd.getText());

				ManagerService managerService = new ManagerService(new ManagerDao());
				ManagerVo vo = new ManagerVo(id.getText(), pwd.getText());
				
				if(managerService.login(vo) == true) {
					System.out.println("로그인 성공");
				} else {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 일치하지 않습니다.");
				}
				
				
			}
		}

		if (e.getActionCommand().equals("회원가입")) {
			Join frame = new Join();
		}

	}

	public static void main(String[] args) {
		Login t = new Login();
		t.start();
	}
}
