package doctorclient.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import exception.NetException;

public class DoctorClientUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5489148389162161525L;
    private JPanel contentPane;
    private DoctorClientPane doctor_client_pane;
    
    
	public DoctorClientUI(String DoctorNo) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, NetException {
		setTitle("Ò½Éú¶Ë");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(200,200,1500,700);
        contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
				
		doctor_client_pane=new DoctorClientPane(DoctorNo);		
		doctor_client_pane.setLayout(null);
		doctor_client_pane.setBounds(0, 10, 1500, 700);	
		contentPane.add(doctor_client_pane);
		
	}	
}