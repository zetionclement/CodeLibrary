package server.ui;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
	 * Server界面中显示信息
	 */
	public class DisplayMessage {
		//动作信息界面
		public static JTextPane actionMessageTP = null;
		//叫号信息界面
		public static JTextPane doctorMessageTP = null;
		
		//显示系统操作信息
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
		//显示叫号信息
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
