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


public class LoginAddDialog extends JDialog {
	private IMgLoginService cs = new MgLoginServiceImpl();
	private JTextField loginNoJt;
	private JTextField loginpwJt;
	private LoginPane cp;
	
	/**
	 * Create the dialog.
	 */
	public LoginAddDialog(LoginPane cp) {
		this.cp = cp;
		setModal(true);//�Ѵ�������Ϊģ̬
		setResizable(false);//�û������϶���С
		setTitle("��ӵ�¼");
		setBounds(100, 100, 352, 700);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton okBtn = new JButton("\u786E\u5B9A");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		okBtn.setActionCommand("OK");
		okBtn.setBounds(89, 600, 69, 23);
		panel.add(okBtn);
		
		JButton resetBtn = new JButton("\u91CD\u7F6E");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		resetBtn.setActionCommand("Cancel");
		resetBtn.setBounds(182, 600, 69, 23);
		panel.add(resetBtn);
		
		JLabel loginNoJl = new JLabel("��¼���:");
		loginNoJl.setHorizontalAlignment(SwingConstants.RIGHT);
		loginNoJl.setBounds(36, 29, 79, 15);
		panel.add(loginNoJl);
		
		loginNoJt = new JTextField();
		loginNoJt.setColumns(4);
		loginNoJt.setBounds(134, 26, 136, 21);
		panel.add(loginNoJt);
		
		JLabel loginpwJl = new JLabel("��¼����:");
		loginpwJl.setHorizontalAlignment(SwingConstants.RIGHT);
		loginpwJl.setBounds(36, 70, 79, 15);
		panel.add(loginpwJl);
		
		loginpwJt = new JTextField();
		loginpwJt.setColumns(3);
		loginpwJt.setBounds(134, 67, 136, 21);
		panel.add(loginpwJt);
				

	}
	/**
	 * ���÷���
	 */
	public void reset(){
		loginNoJt.setText("");
		loginpwJt.setText("");
	}
	/**
	 * ��ӵ�¼�˺�
	 */
	public void add(){
		Login ce = new Login();
		if(null == loginNoJt.getText() || "".equals(loginNoJt.getText())){
			JOptionPane.showMessageDialog(this, "��¼�˺Ų���Ϊ�գ�");
		}else if(null == loginpwJt.getText() || "".equals(loginpwJt.getText())){
			JOptionPane.showMessageDialog(this, "��¼���벻��Ϊ�գ�");
		}else {

			}

			
			ce.setLoginNo(loginNoJt.getText());
			ce.setLoginPw(loginpwJt.getText());

			try {
				cs.add(ce);
				JOptionPane.showMessageDialog(this, "��ӳɹ���");
				dispose();
				cp.reflesh();
			} catch (ServerException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
	}

