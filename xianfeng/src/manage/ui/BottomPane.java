package manage.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BottomPane extends JPanel {
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
	private JLabel cpLb;
	private JLabel timeLb;
	
	public BottomPane(){
		initComponents();
		layoutComponents();
		startTimer();
	}
	
	/**
	 * ��ʼ�����
	 */
	public void initComponents(){
		
	}
	
	/**
	 * �������
	 */
	public void layoutComponents (){
		setLayout(new GridLayout(2,1));
		JPanel copytightPane = new JPanel();
		JPanel timePane = new JPanel();
		
		cpLb = new JLabel("�ȷ��Ŷ�");
		timeLb = new JLabel(getDateStr());
		
		copytightPane.add(cpLb);
		timePane.add(timeLb);
		
		add(copytightPane);
		add(timePane);
	}
	
	/**
	 * ��ȡָ����ʱ���ʽ
	 */
	private String getDateStr() {
		
		return df.format(new Date());
	}
	/**
	 * ��ʱ��
	 */
	private void startTimer() {
		Timer t = new Timer(1000,new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				timeLb.setText(getDateStr());
			}
		});
		t.start();
	}

}
