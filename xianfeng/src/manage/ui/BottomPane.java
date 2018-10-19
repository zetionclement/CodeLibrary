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
	 * 初始化组件
	 */
	public void initComponents(){
		
	}
	
	/**
	 * 组件布局
	 */
	public void layoutComponents (){
		setLayout(new GridLayout(2,1));
		JPanel copytightPane = new JPanel();
		JPanel timePane = new JPanel();
		
		cpLb = new JLabel("先锋团队");
		timeLb = new JLabel(getDateStr());
		
		copytightPane.add(cpLb);
		timePane.add(timeLb);
		
		add(copytightPane);
		add(timePane);
	}
	
	/**
	 * 获取指定的时间格式
	 */
	private String getDateStr() {
		
		return df.format(new Date());
	}
	/**
	 * 定时器
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
