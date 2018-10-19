package doctorclient.ui;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import doctorclient.net.INet;
import doctorclient.net.NetImpl;
import dto.ActionEnum;
import dto.ActionMessage;
import dto.ClientEnum;
import dto.HandleMessage;
import entity.Bingli;
import entity.Medicine;
import exception.NetException;


public class DoctorClientPane extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 33269834629593416L;

	private INet net;
	private JPanel  centerpane=new JPanel();
	
	private JLabel doctor=new JLabel("就诊医生");
	private JLabel keshi=new JLabel("就诊科室");
	private JLabel doctor_sex=new JLabel("性别");
	private JLabel doctor_age=new JLabel("年龄");
	private JLabel current_time=new JLabel("当前时间");
	private JLabel people_num=new JLabel("当前排队人数");	
	private JLabel customer=new JLabel("姓名");
	private JLabel customer_sex=new JLabel("性别");
	private JLabel age=new JLabel("年龄");
	private JLabel birthdate=new JLabel("出生年月");
	private JLabel sickroom_num=new JLabel("病房编号");
	private JLabel once_visited=new JLabel("曾经就诊时间");
	private JLabel card_num=new JLabel("就诊卡号");
	
	
	private JButton nextone=new JButton("下一个");
	private JButton recall=new JButton("重叫");
	private JButton exit=new JButton("退出");
	private JButton confirm=new JButton("确定");
	
		
	private JTextField doctor_jt=new JTextField(5);
	private JTextField keshi_jt=new JTextField(5);
	private JTextField doctor_sex_jt=new JTextField(1);
	private JTextField doctor_age_jt=new JTextField(1);
	private JTextField people_num_jt=new JTextField(2);
	private JTextField customer_jt=new JTextField(5);
	private JTextField customer_sex_jt=new JTextField(1);
	private JTextField age_jt=new JTextField(2);
	private JTextField birthdate_jt=new JTextField(10);
	private JTextField sickroom_num_jt=new JTextField(6);
	private JTextField card_num_jt=new JTextField();
	private Choice once_visited_choice=new Choice();

	private SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd-HH:mm:ss");
	private JLabel timeLb=new JLabel(getDate().toString());
	
	private JLabel title1=new JLabel("处方");
	private JLabel yaoming=new JLabel("药名"),shuliang=new JLabel("数量");
	private JLabel price =new JLabel("单价");
	private JButton yaofang=new JButton("药房");
	private JLabel title2=new JLabel("诊断结果");
	private JTextField cost_jt=new JTextField(5);    //总费用
	private JButton cost=new JButton("总费用");
	private JButton success=new JButton("办理完成");
	private JButton fail=new JButton("办理失败");
	private JLabel rights=new JLabel("xxx市人民医院");
	private JLabel maohao=new JLabel(":");
	private JLabel RMB=new JLabel("元");
	private JTextArea textarea=new JTextArea();
	private JTextField jt1=new JTextField(10);
	private JTextField jt2=new JTextField(10);
	private JTextField jt3=new JTextField(10);
	private JTextField jt4=new JTextField(10);
	private JTextField jt5=new JTextField(10);
	private JTextField jt6=new JTextField(10);
	private JTextField jt7=new JTextField(10);
	private JTextField jt8=new JTextField(10);
	private JTextField jt9=new JTextField(10);
	private JTextField jt10=new JTextField(5);
	private JTextField jt11=new JTextField(5);
	private JTextField jt12=new JTextField(5);
	private JTextField jt13=new JTextField(5);
	private JTextField jt14=new JTextField(5);
	private JTextField jt15=new JTextField(5);
	private JTextField jt16=new JTextField(5);
	private JTextField jt17=new JTextField(5);
	private JTextField jt18=new JTextField(5);
	private JTextField jt19=new JTextField(5);
	private JTextField jt20=new JTextField(5);
	private JTextField jt21=new JTextField(5);
	private JTextField jt22=new JTextField(5);
	private JTextField jt23=new JTextField(5);
	private JTextField jt24=new JTextField(5);
	private JTextField jt25=new JTextField(5);
	private JTextField jt26=new JTextField(5);
	private JTextField jt27=new JTextField(5);
	private JTextField jt28=new JTextField(5);
	private JTextField jt29=new JTextField(5);
	private JTextField jt30=new JTextField(5);
	
	private JTextField JT1[]=new JTextField[11];
	private JTextField JT2[]=new JTextField[11];
	private JTextField JT3[]=new JTextField[11];
	
	public DoctorClientPane(String DoctorNo) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, NetException {
		net=NetImpl.getNetImpl();
	    centerpane.setLayout(null);
	    centerpane.setBounds(90, 10, 1500, 700);
	    
        startTimer();
		
		doctor.setBounds(1,30,100,40);
		doctor_jt.setBounds(60,30,100,40);
		doctor_jt.setHorizontalAlignment(JTextField.CENTER);
		doctor_jt.setEditable(false);
		doctor_sex.setBounds(180,30,50,40);
		doctor_sex_jt.setBounds(210,30,50,40);
		doctor_sex_jt.setEditable(false);
		doctor_sex_jt.setHorizontalAlignment(JTextField.CENTER);
		doctor_age.setBounds(180, 100, 50, 40);
		doctor_age_jt.setBounds(210,100,50,40);
		doctor_age_jt.setHorizontalAlignment(JTextField.CENTER);
		doctor_age_jt.setEditable(false);
	    keshi.setBounds(1,100 , 100, 40);
	    keshi_jt.setBounds(60,100,100,40);
	    keshi_jt.setHorizontalAlignment(JTextField.CENTER);
	    keshi_jt.setEditable(false);
	    current_time.setBounds(360, 70, 60, 30);
	    timeLb.setBounds(300, 100, 200, 30);
	    centerpane.add(doctor);
	    centerpane.add(doctor_jt);
	    centerpane.add(doctor_sex);
	    centerpane.add(doctor_sex_jt);
	    centerpane.add(doctor_age);
	    centerpane.add(doctor_age_jt);
	    centerpane.add(keshi);
	    centerpane.add(keshi_jt);
	    centerpane.add(current_time);
	    centerpane.add(timeLb);    
		
		people_num.setBounds(500,1,100,30);
		people_num_jt.setBounds(500,30,100,40);
		people_num_jt.setHorizontalAlignment(JTextField.CENTER);
		people_num_jt.setEditable(false);
		nextone.setBounds(500,85,100,40);
		recall.setBounds(500, 140, 100,40);
		centerpane.add(people_num);
		centerpane.add(people_num_jt);
		centerpane.add(nextone);
		centerpane.add(recall);
		
		customer.setBounds(700,60,80,40);
		customer_jt.setBounds(730,60 ,100 ,40 );
		customer_jt.setHorizontalAlignment(JTextField.CENTER);
		customer_jt.setEditable(false);
		customer_sex.setBounds(850,60,80,40);
		customer_sex_jt.setBounds(880,60,50,40);
		customer_sex_jt.setHorizontalAlignment(JTextField.CENTER);
		customer_sex_jt.setEditable(false);
		age.setBounds(950,60,50,40);
		age_jt.setBounds(980, 60, 30, 40);
		age_jt.setHorizontalAlignment(JTextField.CENTER);
		age_jt.setEditable(false);
		birthdate.setBounds(1045,60,70,40);
		birthdate_jt.setBounds(1105,60,100,40);
		birthdate_jt.setHorizontalAlignment(JTextField.CENTER);
		birthdate_jt.setEditable(false);
		sickroom_num.setBounds(700,120 ,70 ,40);
		sickroom_num_jt.setBounds(760,120 ,100 ,40);
		sickroom_num_jt.setHorizontalAlignment(JTextField.CENTER);
		sickroom_num_jt.setEditable(false);
		once_visited.setBounds(900, 120, 80, 40);
		once_visited_choice.setBounds(990,127,130,50);
		card_num.setBounds(820,10,100,40);
		card_num_jt.setBounds(880, 10, 100, 40);
		card_num_jt.setHorizontalAlignment(JTextField.CENTER);
		confirm.setBounds(990,10,80,40);
		exit.setBounds(1200, 1, 130, 40);
		
		centerpane.add(customer);
		centerpane.add(customer_jt);
		centerpane.add(customer_sex);
		centerpane.add(customer_sex_jt);
		centerpane.add(age);
		centerpane.add(age_jt);		
		centerpane.add(birthdate);
		centerpane.add(birthdate_jt);
		centerpane.add(sickroom_num);
		centerpane.add(sickroom_num_jt);
		centerpane.add(once_visited);
		centerpane.add(once_visited_choice);
		centerpane.add(card_num);
		centerpane.add(card_num_jt);
		centerpane.add(confirm);
		centerpane.add(exit);
		
		JT1[1]=jt1;
		JT1[2]=jt2;
		JT1[3]=jt3;
		JT1[4]=jt4;
		JT1[5]=jt5;
		JT1[6]=jt6;
		JT1[7]=jt7;
		JT1[8]=jt8;
		JT1[9]=jt9;
		JT1[10]=jt10;
		JT2[1]=jt11;
		JT2[2]=jt12;
		JT2[3]=jt13;
		JT2[4]=jt14;
		JT2[5]=jt15;
		JT2[6]=jt16;
		JT2[7]=jt17;
		JT2[8]=jt18;
		JT2[9]=jt19;
		JT2[10]=jt20;
		JT3[1]=jt21;
		JT3[2]=jt22;
		JT3[3]=jt23;
		JT3[4]=jt24;
		JT3[5]=jt25;
		JT3[6]=jt26;
		JT3[7]=jt27;
		JT3[8]=jt28;
		JT3[9]=jt29;
		JT3[10]=jt30;

		
		//显示医生个人信息
		showDoctorMessage(DoctorNo);
	    
	    title1.setBounds(190,200,50,20);
	    yaoming.setBounds(100, 220,50,20);
	    shuliang.setBounds(264,220,50,20);
	    price.setBounds(348, 220, 50, 20);
	    yaofang.setBounds(450, 370, 60, 40);
	    cost.setBounds(120, 560, 100, 40);
		maohao.setBounds(230,560,50,40);
		cost_jt.setBounds(240,560,100,40 );
		cost_jt.setHorizontalAlignment(JTextField.CENTER);
		cost_jt.setEditable(false);
		RMB.setBounds(350,560 ,100 ,40 );
		success.setBounds(900,560,100,40);
		fail.setBounds(1100, 560, 100, 40);
		rights.setBounds(600,590,130,50);
	    jt1.setBounds(10,240,200,20);
	    jt2.setBounds(10,270,200,20);
	    jt3.setBounds(10,300,200,20);
	    jt4.setBounds(10,330,200,20);
	    jt5.setBounds(10,360,200,20);
	    jt6.setBounds(10,390,200,20);
	    jt7.setBounds(10,420,200,20);
	    jt8.setBounds(10,450,200,20);
	    jt9.setBounds(10,480,200,20);
	    jt10.setBounds(10,510,200,20);
	    jt11.setBounds(250,240,50,20);
	    jt12.setBounds(250,270,50,20);
	    jt13.setBounds(250,300,50,20);
	    jt14.setBounds(250,330,50,20);
	    jt15.setBounds(250,360,50,20);
	    jt16.setBounds(250,390,50,20);
	    jt17.setBounds(250,420,50,20);
	    jt18.setBounds(250,450,50,20);
	    jt19.setBounds(250,480,50,20);
	    jt20.setBounds(250,510,50,20);
	    jt21.setBounds(335,240,50,20);
	    jt22.setBounds(335,270,50,20);
	    jt23.setBounds(335,300,50,20);
	    jt24.setBounds(335,330,50,20);
	    jt25.setBounds(335,360,50,20);
	    jt26.setBounds(335,390,50,20);
	    jt27.setBounds(335,420,50,20);
	    jt28.setBounds(335,450,50,20);
	    jt29.setBounds(335,480,50,20);
	    jt30.setBounds(335,510,50,20);
	    jt1.setHorizontalAlignment(JTextField.CENTER);
	    jt2.setHorizontalAlignment(JTextField.CENTER); 
	    jt3.setHorizontalAlignment(JTextField.CENTER);
	    jt4.setHorizontalAlignment(JTextField.CENTER);
	    jt5.setHorizontalAlignment(JTextField.CENTER);
	    jt6.setHorizontalAlignment(JTextField.CENTER);
	    jt7.setHorizontalAlignment(JTextField.CENTER);
	    jt8.setHorizontalAlignment(JTextField.CENTER);
	    jt9.setHorizontalAlignment(JTextField.CENTER);
	    jt10.setHorizontalAlignment(JTextField.CENTER);
	    jt11.setHorizontalAlignment(JTextField.CENTER);
	    jt12.setHorizontalAlignment(JTextField.CENTER);
	    jt13.setHorizontalAlignment(JTextField.CENTER);
	    jt14.setHorizontalAlignment(JTextField.CENTER);
	    jt15.setHorizontalAlignment(JTextField.CENTER);
	    jt16.setHorizontalAlignment(JTextField.CENTER);
	    jt17.setHorizontalAlignment(JTextField.CENTER);
	    jt18.setHorizontalAlignment(JTextField.CENTER);
	    jt19.setHorizontalAlignment(JTextField.CENTER);
	    jt20.setHorizontalAlignment(JTextField.CENTER);
	    jt21.setHorizontalAlignment(JTextField.CENTER);
	    jt22.setHorizontalAlignment(JTextField.CENTER);
	    jt23.setHorizontalAlignment(JTextField.CENTER);
	    jt24.setHorizontalAlignment(JTextField.CENTER);
	    jt25.setHorizontalAlignment(JTextField.CENTER);
	    jt26.setHorizontalAlignment(JTextField.CENTER);
	    jt27.setHorizontalAlignment(JTextField.CENTER);
	    jt28.setHorizontalAlignment(JTextField.CENTER);
	    jt29.setHorizontalAlignment(JTextField.CENTER);
	    jt30.setHorizontalAlignment(JTextField.CENTER);
	    
	    jt21.setEditable(false);
	    jt22.setEditable(false);
	    jt23.setEditable(false);
	    jt24.setEditable(false);
	    jt25.setEditable(false);
	    jt26.setEditable(false);
	    jt27.setEditable(false);
	    jt28.setEditable(false);
	    jt29.setEditable(false);
	    jt30.setEditable(false);
	    title2.setBounds(960,210,100,20);
	    textarea.setBounds(700,240,600,300);
	    textarea.setLineWrap(true); 
	    textarea.setWrapStyleWord(true);	    
	    
	    centerpane.add(title1);
		centerpane.add(title2);
		centerpane.add(yaoming);
		centerpane.add(shuliang);
		centerpane.add(price);
		centerpane.add(jt1);
		centerpane.add(jt2);
		centerpane.add(jt3);
		centerpane.add(jt4);
		centerpane.add(jt5);
		centerpane.add(jt6);
		centerpane.add(jt7);
		centerpane.add(jt8);
		centerpane.add(jt9);
		centerpane.add(jt10);
		centerpane.add(jt11);
		centerpane.add(jt12);
		centerpane.add(jt13);
		centerpane.add(jt14);
		centerpane.add(jt15);
		centerpane.add(jt16);
		centerpane.add(jt17);
		centerpane.add(jt18);
		centerpane.add(jt19);
		centerpane.add(jt20);
		centerpane.add(jt21);
		centerpane.add(jt22);
		centerpane.add(jt23);
		centerpane.add(jt24);
		centerpane.add(jt25);
		centerpane.add(jt26);
		centerpane.add(jt27);
		centerpane.add(jt28);
		centerpane.add(jt29);
		centerpane.add(jt30);
		centerpane.add(yaofang);
		centerpane.add(textarea);
		centerpane.add(cost);
		centerpane.add(maohao);
		centerpane.add(cost_jt);
		centerpane.add(RMB);
		centerpane.add(success);
		centerpane.add(fail);
		centerpane.add(rights);
		this.add(centerpane);
		
		
		ArrayList<String>items =new ArrayList<String>();
		List<Medicine>  list=getMedicine();
		for(int i=0;i<list.size();i++) {
			items.add(String.valueOf(list.get(i)));
		}
		
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        setupAutoComplete(jt1,items);
        setupAutoComplete(jt2,items);
        setupAutoComplete(jt3,items);
        setupAutoComplete(jt4,items);
        setupAutoComplete(jt5,items);
        setupAutoComplete(jt6,items);
        setupAutoComplete(jt7,items);
        setupAutoComplete(jt8,items);
        setupAutoComplete(jt9,items);
        setupAutoComplete(jt10,items);
        
      //输入就诊卡号点击确定
      		confirm.addActionListener(new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
      				ActionMessage am=new ActionMessage();
      				am.setAction(ActionEnum.GET_CUSTOMER);
      				am.setClient(ClientEnum.DOCTOR_CLIENT);
      				am.getData().put("customerNo",card_num_jt.getText());
      				try {
      					net.send(am);
      					HandleMessage hm=net.receive();
      					customer_jt.setText(hm.getData().get("customerName").toString());
      					customer_sex_jt.setText(hm.getData().get("customerSex").toString());
      					age_jt.setText(hm.getData().get("customerAge").toString());
      					birthdate_jt.setText(hm.getData().get("customerBoth").toString());
      					if(hm.getData().get("customerRoomID")!=null) {
      					sickroom_num_jt.setText(hm.getData().get("customerRoomID").toString());
      					}
      					else {
      						sickroom_num_jt.setText("无");
      					}
      					List <Bingli> list =(List <Bingli>)hm.getData().get("time");
      					once_visited_choice.removeAll();
      					once_visited_choice.add("");
      					for(int i=0;i<list.size();i++) {
      						once_visited_choice.add(String.valueOf(list.get(i)));
      					}
      				}
      				catch(NetException e1) {
      					e1.printStackTrace();
      				}
      			}
      		});
      		
      		//点击曾经就诊时间，显示曾经就诊病例
      		once_visited_choice.addItemListener(new ItemListener() {
    			public void itemStateChanged(ItemEvent e) {
    				    String selectedTime=once_visited_choice.getSelectedItem().toString();
    				    if(selectedTime!="") {
    				    ActionMessage am = new ActionMessage();	
    					am.setClient(ClientEnum.DOCTOR_CLIENT);	// 设置客户端
    					am.setAction(ActionEnum.GET_RESULT);	// 设置动作
    					am.getData().put("CustomerNo", card_num_jt.getText());	// 将病人就诊卡号传进去
    					am.getData().put("Time", selectedTime);	// 将时间传进去   					
    					try {
    						net.send(am);    						
    						HandleMessage hm = net.receive();   						
    				        Once_visited_bingli bingli=new Once_visited_bingli(hm.getData().get("Result").toString(),hm.getData().get("Plan").toString());
    				        bingli.setBounds(450,350,1000,500);
    				        bingli.setVisible(true);
    					}catch (NetException e1) {
    						e1.printStackTrace();
    				  }
    				}
    			}
    		});
      		
        //计算总费用
        cost.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {        		        		
        		int i=1,j=1;
        		for(i=1;i<=10;i++) {
        			String medicineName=JT1[i].getText();       			
        			if(!medicineName.equals("")) {
        				ActionMessage am=new ActionMessage();
        				am.setClient(ClientEnum.DOCTOR_CLIENT);
        				am.setAction(ActionEnum.GET_MEDICINEFREE);
        				am.getData().put("medicineName", medicineName);
        				try {
        					net.send(am);
        					HandleMessage hm=net.receive();
        					JT3[i].setText(hm.getData().get("freeName").toString());        							
        				}catch(NetException e1) {
        					e1.printStackTrace();
        				}
        			}
        			else {
        				break;
        			}
        		}
        		
        		BigDecimal AllCost=new BigDecimal("0");
        		for(j=1;j<=i-1;j++) {
        			AllCost=AllCost.add(new BigDecimal(JT2[j].getText().toString()).multiply(new BigDecimal(JT3[j].getText().toString())));       			
        		}
        		cost_jt.setText(AllCost.toString());
        	}
        });
        
        //办理成功
        success.addActionListener(new ActionListener() {
        	public void actionPerformed( ActionEvent e) {
        		String cardNum=card_num_jt.getText().toString();
        		ActionMessage am=new ActionMessage();
        		am.setClient(ClientEnum.DOCTOR_CLIENT);
        		am.setAction(ActionEnum.BINGLI_SUCCESS);
        		am.getData().put("doctorNo", DoctorNo);
        		am.getData().put("customerNo",cardNum );        		
        		String plan="";
        		for(int i=1;i<=10;i++) {
        			String medicineName=JT1[i].getText().toString();
        			if(!medicineName.equals("")) {
        				String num=JT2[i].getText().toString();
        				plan=plan+"，"+medicineName+"x"+num;
        			}
        			else {
        				plan=plan.replaceFirst("，", "");
        				break;
        			}
        		}
        		am.getData().put("doctorNo", DoctorNo);
        		am.getData().put("customerNo",cardNum );
        		am.getData().put("plan", plan);
        		am.getData().put("free",new BigDecimal(cost_jt.getText()));
        		am.getData().put("result", textarea.getText());
        		am.getData().put("reason", null);
        		am.getData().put("time", getDate());
        		am.getData().put("issuccess", "是");
        		try {       		
        		net.send(am);        		
				HandleMessage hm=net.receive();
				String isSuccess="Yes";
				if(isSuccess.equals("Yes")) {
					JDialog Dialog=new JDialog();										
					Dialog.setLayout(null);
					Dialog.setBounds(800,470,300,150);			               			  			        
					Dialog.setModalityType(ModalityType.APPLICATION_MODAL);					
					JLabel jl=new JLabel("办理成功");
					jl.setBounds(115,10,150,50);
					Dialog.add(jl);
					JButton jb=new JButton("确定");
					jb.setBounds(90, 70, 100, 30);
					jb.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Dialog.dispose();
							for(int i=1;i<=10;i++) {
								JT1[i].setText("");
								JT2[i].setText("");
								JT3[i].setText("");
							}
							cost_jt.setText("");
							textarea.setText("");
							ActionMessage am=new ActionMessage();
		      				am.setAction(ActionEnum.GET_CUSTOMER);
		      				am.setClient(ClientEnum.DOCTOR_CLIENT);
		      				am.getData().put("customerNo",card_num_jt.getText());
		      				try {
		      					net.send(am);
		      					HandleMessage hm=net.receive();
		      					List <Bingli> list =(List <Bingli>)hm.getData().get("time");
		      					once_visited_choice.removeAll();
		      					once_visited_choice.add("  ");
		      					for(int i=0;i<list.size();i++) {
		      						once_visited_choice.add(String.valueOf(list.get(i)));
		      					}
		      				}
		      				catch(NetException e1) {
		      					e1.printStackTrace();
		      				}
						}
					});
					Dialog.add(jb);
					Dialog.setVisible(true);
				}				
        	  }catch(NetException e1) {
        		  e1.printStackTrace();
        	  }
           }
       });
      
        //办理失败
        fail.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String reason = JOptionPane.showInputDialog("办理失败原因");
        		String cardNum=card_num_jt.getText().toString();
        		ActionMessage am=new ActionMessage();
        		am.setClient(ClientEnum.DOCTOR_CLIENT);
        		am.setAction(ActionEnum.BINGLI_FAIL);
        		am.getData().put("doctorNo", DoctorNo);
        		am.getData().put("customerNo",cardNum);
        		am.getData().put("free",new BigDecimal("0"));
        		am.getData().put("plan", "");
        		am.getData().put("time", getDate());
        		am.getData().put("result", "");
        		am.getData().put("Success", "否");
        		am.getData().put("reason", reason);
        		try {
        			net.send(am);
        			HandleMessage hm=net.receive();
        		}
        		catch(NetException e1) {
        			e1.printStackTrace();
        		}
        	}
        });
        
        
	}
	
	//显示医生个人信息
		public void showDoctorMessage(String doctorNo) {
			ActionMessage am=new ActionMessage();
			am.setAction(ActionEnum.GET_DOCTOR);
			am.setClient(ClientEnum.DOCTOR_CLIENT);
			am.getData().put("doctorNo", doctorNo);
			try {
				net.send(am);
				HandleMessage hm=net.receive();
				doctor_jt.setText(hm.getData().get("doctorName").toString());
				doctor_sex_jt.setText(hm.getData().get("doctorSex").toString());
				doctor_age_jt.setText(hm.getData().get("doctorAge").toString());
				keshi_jt.setText(hm.getData().get("sectionName").toString());
			}catch (NetException e) {
	   		 e.printStackTrace();
	   	    }
		}
		
		//获取所有药名
	     public  List<Medicine> getMedicine() {
	       	 ActionMessage am=new ActionMessage();
	       	 am.setClient(ClientEnum.DOCTOR_CLIENT);
	       	 am.setAction(ActionEnum.GET_MEDICINENAME);
	       	 try {
	       		 net.send(am);
	       		 HandleMessage hm=net.receive();
	       		 List<Medicine>list =(List<Medicine>)hm.getData().get("MedicineName");	       	
	       		 return list;
	       	 }catch(NetException e) {
	       		 e.printStackTrace();
	       	 }
	       	return null;
	     }
				
		
		private Date getDate() {
			
			String str= df.format(new Date());
		    try {
				Date date= df.parse(str);
				return date;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		    return null;
		}

		/**
		 * 定时器
		 */
		private void startTimer() {
			Timer t = new Timer(1000,new ActionListener() {				
			public void actionPerformed(ActionEvent e) {
					timeLb.setText(getDate().toString());
				}
			});
			t.start();
		}
	
	 private static boolean isAdjusting(JComboBox cbInput) {
         if (cbInput.getClientProperty("is_adjusting") instanceof Boolean) {
             return (Boolean) cbInput.getClientProperty("is_adjusting");
         }
         return false;
     }
 
     private static void setAdjusting(JComboBox cbInput, boolean adjusting) {
         cbInput.putClientProperty("is_adjusting", adjusting);
     }
 
     public static void setupAutoComplete(final JTextField txtInput, final ArrayList<String> items1) {
         final DefaultComboBoxModel model = new DefaultComboBoxModel();
         final JComboBox cbInput = new JComboBox(model) {
             public Dimension getPreferredSize() {
                 return new Dimension(super.getPreferredSize().width, 0);
             }
         };
         setAdjusting(cbInput, false);
         for (String item : items1) {
            model.addElement(item);
        }
         cbInput.setSelectedItem(null);
         cbInput.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 if (!isAdjusting(cbInput)) {
                     if (cbInput.getSelectedItem() != null) {
                         txtInput.setText(cbInput.getSelectedItem().toString());
                    }
                 }
            }
         });
 
         txtInput.addKeyListener(new KeyAdapter() {

             @Override
            public void keyPressed(KeyEvent e) {
                 setAdjusting(cbInput, true);
                 if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                     if (cbInput.isPopupVisible()) {
                        e.setKeyCode(KeyEvent.VK_ENTER);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    e.setSource(cbInput);
                  cbInput.dispatchEvent(e);
                     if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                      txtInput.setText(cbInput.getSelectedItem().toString());
                         cbInput.setPopupVisible(false);
                     }
                 }
               if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                     cbInput.setPopupVisible(false);
                }
                setAdjusting(cbInput, false);
             }
         });
         txtInput.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateList();
             }

         public void removeUpdate(DocumentEvent e) {
               updateList();
             }
 
             public void changedUpdate(DocumentEvent e) {
                 updateList();
             }

            private void updateList() {
                 setAdjusting(cbInput, true);
                model.removeAllElements();
                String input = txtInput.getText();
                 if (!input.isEmpty()) {
                     for (String item : items1) {
                         if (item.toLowerCase().startsWith(input.toLowerCase())) {
                            model.addElement(item);
                         }
                   }
                }
                cbInput.setPopupVisible(model.getSize() > 0);
                 setAdjusting(cbInput, false);
             }
         });
         txtInput.setLayout(new BorderLayout());
         txtInput.add(cbInput, BorderLayout.SOUTH);
     }
     
     
     
 }
