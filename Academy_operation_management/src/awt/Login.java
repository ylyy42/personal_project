package awt;

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

public class Login extends WindowAdapter implements ActionListener {

	private ManagerDao dao;
	private JFrame f;
	private JButton btn, subtn;
	private Label lid;
	private Label lpwd;
	private TextField id;
	private TextField pwd;
	private TextField tfMsg;

	public Login() {
		dao = new ManagerDao();
		f = new JFrame();
		btn = new JButton("로그인");
		subtn = new JButton("회원가입");
		f.setSize(650, 120);
		f.setLayout(new FlowLayout());
		lid = new Label("ID : ", Label.RIGHT);
		lpwd = new Label("Password : ", Label.RIGHT);
		id = new TextField(10);
		pwd = new TextField(10);
		tfMsg = new TextField(40);
		tfMsg.setEditable(false);
		tfMsg.setFocusable(false);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void start() {
		pwd.setEchoChar('*');
		btn.addActionListener(this);
		subtn.addActionListener(this);
		f.addWindowListener(this);
		f.add(lid);
		f.add(id);
		f.add(lpwd);
		f.add(pwd);
		f.add(btn);
		f.add(subtn);
		f.add(tfMsg);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("로그인")) {
			if (id.getText().equals("")) {
				tfMsg.setText("ID를 입력하세요.");
			} else if (pwd.getText().equals("")) {
				tfMsg.setText("Password를 입력하세요");
			} else {
				System.out.println(id.getText());
				System.out.println(pwd.getText());

				ManagerService managerService = new ManagerService(new ManagerDao());
				ManagerVo vo = new ManagerVo(id.getText(), pwd.getText());
				
				if(managerService.login(vo) == true) {
					tfMsg.setText("로그인 성공");
				} else {
					tfMsg.setText("아이디/비밀번호가 일치하지 않습니다.");
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
