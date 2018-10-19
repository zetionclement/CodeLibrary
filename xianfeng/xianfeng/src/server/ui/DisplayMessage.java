package server.ui;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
	 * Server��������ʾ��Ϣ
	 */
	public class DisplayMessage {
		//������Ϣ����
		public static JTextPane actionMessageTP = null;
		//�к���Ϣ����
		public static JTextPane doctorMessageTP = null;
		
		//��ʾϵͳ������Ϣ
		public static void displayActionMessage(String message) {
			if (null != actionMessageTP) {
				Document doc = actionMessageTP.getDocument();
				try {
					doc.insertString(doc.getLength(), message + "\n", null);
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			}
		}
		//��ʾ�к���Ϣ
		public static void displayCallMessage(String message) {
			if (null != doctorMessageTP) {
				Document doc = doctorMessageTP.getDocument();
				try {
					doc.insertString(doc.getLength(), message + "\n", null);
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			}
		}
}
