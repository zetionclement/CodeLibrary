package manage.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.ServerException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entity.ManageLogin;
import server.service.IMgLoginService;
import server.service.impl.MgLoginServiceImpl;

public class ManageLoginUI extends JFrame {
	private JPanel contentPane;
	private JTextField administratorsJt;
	private JPasswordField passwordJt;
	private IMgLoginService mLogin = new MgLoginServiceImpl();
	private ManageLogin mle = new ManageLogin();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				ManageLoginUI frame = new ManageLoginUI();
				frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	
    public ManageLoginUI() {
		
		setTitle("管理员登录");  //\u7BA1\u7406\u5458\u767B\u5F55
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//管理员名称
		JLabel administratorsJl = new JLabel("管理员名称：");  //\u7BA1\u7406\u5458\u540D\u79F0\uFF1A
		administratorsJl.setHorizontalAlignment(SwingConstants.RIGHT);
		administratorsJl.setBounds(59, 59, 80, 15);
		contentPane.add(administratorsJl);
		//管理员名称输入框
		administratorsJt = new JTextField();
		administratorsJt.setBounds(170, 56, 191, 21);
		contentPane.add(administratorsJt);
		administratorsJt.setColumns(10);
		//密码
		JLabel passwordJl = new JLabel("密码：");  //\u5BC6\u7801\uFF1A
		passwordJl.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordJl.setBounds(59, 123, 80, 15);
		contentPane.add(passwordJl);
		//密码输入框
		passwordJt = new JPasswordField();
		passwordJt.setBounds(170, 120, 191, 21);
		contentPane.add(passwordJt);
		
		//登录按钮及监听
		JButton loginBtn = new JButton("登录");  //\u767B\u5F55
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		loginBtn.setBounds(170, 181, 69, 23);
		contentPane.add(loginBtn);

		//重置按钮及监听
		JButton resetBtn = new JButton("重置");  //\u91CD\u7F6E
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		resetBtn.setBounds(279, 181, 69, 23);
		contentPane.add(resetBtn);
	
	}
    
    /**
	 * 重置方法
	 */
	public void reset() {
		administratorsJt.setText("");
		passwordJt.setText("");
	}
	
	/**
	 * 登录方法
	 */
	public void login(){
		if(null == administratorsJt.getText() || "".equals(administratorsJt.getText())){
			JOptionPane.showMessageDialog(this, "用户名不能为空！");
		}else if(null == passwordJt.getPassword() || passwordJt.getPassword().length == 0){
			JOptionPane.showMessageDialog(this, "密码不能为空！");
		}else{
			try {
				mle.setLNo(administratorsJt.getText());
				String password = String.valueOf(passwordJt.getPassword());
				mle.setLPw(password);
				boolean login = mLogin.login(mle);
				if(login == true){
					JOptionPane.showMessageDialog(this, "登陆成功");
					this.dispose();
					ManageUI mf = new ManageUI();
					mf.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(this, "登陆失败：密码不正确！");
				}
		
			} catch (ServerException e) {
			JOptionPane.showMessageDialog(this, "登录失败："+e.getMessage());
			}
		}
	}



}
