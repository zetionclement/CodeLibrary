package manange.ui.loginPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.ServerException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import entity.Login;
import server.service.IMgLoginService;
import server.service.impl.MgLoginServiceImpl;


public class LoginEditDialog extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private Login ce;
	private LoginPane cp;
	private IMgLoginService cs = new MgLoginServiceImpl();
	private JTextField loginNoJt;
	private JTextField loginpwJt;

	
	public LoginEditDialog(Login ce, LoginPane cp) {
		this.ce = ce;
		this.cp = cp;
		setModal(true);//把窗口设置为模态
		setResizable(false);//用户不能拖动大小
		setTitle("修改登录信息");
		setBounds(100, 100, 352, 700);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton okBtn = new JButton("\u786E\u5B9A");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit();
			}
		});
		okBtn.setActionCommand("OK");
		okBtn.setBounds(89, 600, 69, 23);
		contentPanel.add(okBtn);
		
		JButton resetBtn = new JButton("\u91CD\u7F6E");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		resetBtn.setActionCommand("Cancel");
		resetBtn.setBounds(182, 600, 69, 23);
		contentPanel.add(resetBtn);
		
		JLabel loginNoJl = new JLabel("登录编号:");
		loginNoJl.setHorizontalAlignment(SwingConstants.RIGHT);
		loginNoJl.setBounds(36, 29, 79, 15);
		contentPanel.add(loginNoJl);
		
		loginNoJt = new JTextField();
		loginNoJt.setColumns(4);
		loginNoJt.setBounds(134, 26, 136, 21);
		contentPanel.add(loginNoJt);
		
		JLabel loginpwJl = new JLabel("登录密码:");
		loginpwJl.setHorizontalAlignment(SwingConstants.RIGHT);
		loginpwJl.setBounds(36, 70, 79, 15);
		contentPanel.add(loginpwJl);
		
		loginpwJt = new JTextField();
		loginpwJt.setColumns(3);
		loginpwJt.setBounds(134, 67, 136, 21);
		contentPanel.add(loginpwJt);
		
		
		
		
	
		showInfo();
	}
	/**
	 * 重置方法
	 */
	public void reset(){
		loginNoJt.setText("");
		loginpwJt.setText("");
	}
	/**
	 * 显示方法
	 */
	public void showInfo(){
		loginNoJt.setText(ce.getLoginNo());
		loginpwJt.setText(ce.getLoginPw());

	}
	/**
	 * 修改方法
	 */
	public void edit(){
		if(null == loginNoJt.getText() || "".equals(loginNoJt.getText())){
			JOptionPane.showMessageDialog(this, "登录编号不能为空！");
		}else if(null == loginpwJt.getText() || "".equals(loginpwJt.getText())){
			JOptionPane.showMessageDialog(this, "登录密码不能为空！");
		}else {
			

			
			ce.setLoginNo(loginNoJt.getText());
			ce.setLoginPw(loginpwJt.getText());


			
			try {
				cs.edit(ce);
				JOptionPane.showMessageDialog(this, "修改成功！");
				dispose();
				cp.reflesh();
			} catch (ServerException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}	
	}

}
