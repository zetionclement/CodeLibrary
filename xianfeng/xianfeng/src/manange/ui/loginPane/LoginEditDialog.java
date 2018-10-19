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
		setModal(true);//�Ѵ�������Ϊģ̬
		setResizable(false);//�û������϶���С
		setTitle("�޸ĵ�¼��Ϣ");
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
		
		JLabel loginNoJl = new JLabel("��¼���:");
		loginNoJl.setHorizontalAlignment(SwingConstants.RIGHT);
		loginNoJl.setBounds(36, 29, 79, 15);
		contentPanel.add(loginNoJl);
		
		loginNoJt = new JTextField();
		loginNoJt.setColumns(4);
		loginNoJt.setBounds(134, 26, 136, 21);
		contentPanel.add(loginNoJt);
		
		JLabel loginpwJl = new JLabel("��¼����:");
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
	 * ���÷���
	 */
	public void reset(){
		loginNoJt.setText("");
		loginpwJt.setText("");
	}
	/**
	 * ��ʾ����
	 */
	public void showInfo(){
		loginNoJt.setText(ce.getLoginNo());
		loginpwJt.setText(ce.getLoginPw());

	}
	/**
	 * �޸ķ���
	 */
	public void edit(){
		if(null == loginNoJt.getText() || "".equals(loginNoJt.getText())){
			JOptionPane.showMessageDialog(this, "��¼��Ų���Ϊ�գ�");
		}else if(null == loginpwJt.getText() || "".equals(loginpwJt.getText())){
			JOptionPane.showMessageDialog(this, "��¼���벻��Ϊ�գ�");
		}else {
			

			
			ce.setLoginNo(loginNoJt.getText());
			ce.setLoginPw(loginpwJt.getText());


			
			try {
				cs.edit(ce);
				JOptionPane.showMessageDialog(this, "�޸ĳɹ���");
				dispose();
				cp.reflesh();
			} catch (ServerException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}	
	}

}
