package server.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import server.exception.StartException;
import server.net.server;

public class serverlayout extends JFrame {
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					serverlayout frame = new serverlayout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public serverlayout() { 
	//�����������˴���
      //JFrame window = new JFrame("ҽԺϵͳ������");
     //Container con = window.getContentPane();
      setBounds(100,100,500,500);
      //window.setVisible(true);
      //window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      JPanel contentPane=new JPanel( );
      contentPane.setBorder(new EmptyBorder(2, 150, 5, 150));
      contentPane.setLayout(new BorderLayout(0, 0));
      setContentPane(contentPane);
       //������ť�����ҽ���ť��ӵ����������
      JButton runBtn = new JButton("����������");
      contentPane.add(runBtn, BorderLayout.SOUTH);
      //ע�������
      
      runBtn.addActionListener(new ActionListener() {
    	  int i=1;
	     server Server = new server();
	  //ActionListener�ӿ���Ψһ��һ��������������������
	public void actionPerformed(ActionEvent e) {
		 if ("����������".equals(e.getActionCommand())) {
			 runBtn.setText("ֹͣ������");
			if(i==1) { 
			i--;
			Server = new server();			
			Server.start();			
			}
			else {
			Server.onPauseRecover();	
			}
		} else {
			runBtn.setText("����������");
			Server.stopServer();
		}
	}
});
}

}








