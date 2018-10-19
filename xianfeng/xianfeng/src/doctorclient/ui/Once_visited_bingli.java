package doctorclient.ui;


import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import doctorclient.net.INet;
import doctorclient.net.NetImpl;
import dto.ActionEnum;
import dto.ActionMessage;
import dto.ClientEnum;
import dto.HandleMessage;
import exception.NetException;

public class Once_visited_bingli extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6003040740938461109L;

	private JPanel contentpane =new JPanel();
	private JLabel chufang=new JLabel("处方");
	private JLabel yaoming=new JLabel("药名");
	private JLabel shuliang =new JLabel("数量");
	private JLabel danjia=new JLabel("单价");
	private JLabel zhenduanresult=new JLabel("诊断结果");
	private JPanel chufangpane=new JPanel();
	private JTextArea textarea=new JTextArea();
	private INet net;
	
	public Once_visited_bingli(String Result,String Plan) throws NetException {
		net=NetImpl.getNetImpl();
		contentpane.setLayout(null);
		contentpane.setBounds(250,350,1000,500);
		setContentPane(contentpane);
		chufang.setBounds(160, 10, 50, 30);
		yaoming.setBounds(80, 60, 50, 30);
		shuliang.setBounds(180,60,50,30);
		danjia.setBounds(270, 60, 50, 30);
		chufangpane.setLayout(null);
		chufangpane.setBounds(60, 100, 350, 500);
		zhenduanresult.setBounds(665,10,100,30);
		textarea.setBounds(450, 50, 500, 360);
		textarea.setText(Result);
		textarea.setEditable(false);
		
		/*JLabel jb1=new JLabel("消炎眼药水");
		jb1.setBounds(5, 10, 60, 20);
		chufangpane.add(jb1);
		JLabel jb2=new JLabel("1");
		jb2.setBounds(130, 10, 60, 20);
		chufangpane.add(jb2);
		JLabel jb3=new JLabel("15.5");
		jb3.setBounds(210,10,60,20);
		chufangpane.add(jb3);
		JLabel jb4=new JLabel("狂犬病疫苗");
		jb4.setBounds(5,40 ,60 ,20 );
		chufangpane.add(jb4);
		JLabel jb5=new JLabel("1");
		jb5.setBounds(130, 40, 60, 20);
		chufangpane.add(jb5);
		JLabel jb6=new JLabel("402");
		jb6.setBounds(210,40,60,20);
		chufangpane.add(jb6);*/
		String temp="";
		for(int i=0,x=5,y=130,z=210,h=10;i<Plan.length();i++) {
			char X=Plan.charAt(i);
			if(X=='x') {
				JLabel jbx=new JLabel (temp);								
				jbx.setBounds(x, h, 80, 20);				
				chufangpane.add(jbx);
				ActionMessage am=new ActionMessage();
				am.setClient(ClientEnum.DOCTOR_CLIENT);
				am.setAction(ActionEnum.GET_MEDICINEFREE);
				am.getData().put("medicineName", temp);
				try {
					net.send(am);
					HandleMessage hm=net.receive();
					JLabel jbz=new JLabel (hm.getData().get("freeName").toString());
					jbz.setBounds(z, h, 60, 20);
					chufangpane.add(jbz);			   							
				}catch(NetException e1) {
					e1.printStackTrace();
				}
			}
			else if(X>='1'&&X<='9') {
				if(i==Plan.length()-1) {
					JLabel jby=new JLabel (String.valueOf(X));
					jby.setBounds(y, h, 60, 20);
					chufangpane.add(jby);
				}
			   else  {
				JLabel jby=new JLabel (String.valueOf(X));
				jby.setBounds(y, h, 60, 20);
				chufangpane.add(jby);
				}
			}
			else if(X=='，') {
				JLabel jbx=new JLabel (temp);								
				jbx.setBounds(x, h, 80, 20);				
				chufangpane.add(jbx);
				h+=30;
				temp="";
			}
			else {
			    temp+=X;			
			}
		}
		
		
		contentpane.add(chufang);
		contentpane.add(yaoming);
		contentpane.add(shuliang);
		contentpane.add(danjia);
		contentpane.add(chufangpane);
		contentpane.add(zhenduanresult);
		contentpane.add(chufangpane);
		contentpane.add(textarea);
		
	}
}
