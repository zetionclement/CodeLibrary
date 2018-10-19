package doctorclient.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;

import doctorclient.net.NetImpl;
import doctorclient.net.INet;
import dto.ActionEnum;
import dto.ActionMessage;
import dto.ClientEnum;
import dto.HandleMessage;
import exception.NetException;

public class LoginUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2696725998762708092L;

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (NetException e) {
					e.printStackTrace();
				}			
			}
		});
	}
	private JPanel contentpane=new JPanel();
	private JTextField DoctorNoJT=new JTextField(10);
	private JPasswordField passwordJT=new JPasswordField(10);
	private JButton loginBtn=new JButton("登录");
	private JButton resetBtn=new JButton("重置");	
	private JLabel DoctorLB=new JLabel("医生号");
	private JLabel passwordLB=new JLabel("密码"); 
	private INet net;
	
	public LoginUI() throws NetException {
		net=NetImpl.getNetImpl();
		
		setTitle("员工登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(680,350,500,300);
		setContentPane(contentpane);
		contentpane.setLayout(null);
		
		DoctorLB.setBounds(150, 20, 200,40 );
		DoctorNoJT.setBounds(150,60,200,40);
		passwordLB.setBounds(150, 100, 200, 40);
		passwordJT.setBounds(150,140,200,40);
		loginBtn.setBounds(150,200,90,30);
		resetBtn.setBounds(260,200,90,30);
		
		contentpane.add(DoctorLB);
		contentpane.add(DoctorNoJT);
		contentpane.add(passwordLB);
		contentpane.add(passwordJT);
		contentpane.add(loginBtn);
		contentpane.add(resetBtn);
		
		resetBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				DoctorNoJT.setText("");
				passwordJT.setText("");
			}
		});
		
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		
		passwordJT.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char x=e.getKeyChar();
				if(x=='\n') {
					login();
				}
			}
		});
			
	}
	
	public void login() {
		if(DoctorNoJT.getText()==""||DoctorNoJT.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"医生编号不能为空");
		}
		else if(passwordJT.getPassword()==null||passwordJT.getPassword().length<=0) {
			JOptionPane.showMessageDialog(this,"密码不能为空");
		}
		else {
			ActionMessage am=new ActionMessage();
			am.setAction(ActionEnum.CALL_LOGIN);
			am.setClient(ClientEnum.DOCTOR_CLIENT);
			am.getData().put("LoginNo",String.valueOf(DoctorNoJT.getText()));
			am.getData().put("LoginPw",String.valueOf(passwordJT.getPassword()));
			try {
				net.send(am);
				HandleMessage hm=net.receive();
				boolean isLogin = (boolean) hm.getData().get("isLogin");
				if (isLogin) {
					JOptionPane.showMessageDialog(this,"登录成功");				
					try {
						DoctorClientUI frame;
						frame = new DoctorClientUI(DoctorNoJT.getText());
						frame.setVisible(true);
					} catch (ClassNotFoundException e) {					
						e.printStackTrace();
					} catch (InstantiationException e) {					
						e.printStackTrace();
					} catch (IllegalAccessException e) {					
						e.printStackTrace();
					} catch (UnsupportedLookAndFeelException e) {					
						e.printStackTrace();
					} 			    
				    dispose();				
				 }
				else {
					JOptionPane.showMessageDialog(this, "登录失败：工号或者密码错误！");
				}
			}
				    catch (NetException e1){
					e1.printStackTrace();
					JOptionPane.showMessageDialog(this,e1.getMessage());
				}
			
		}
	}
}