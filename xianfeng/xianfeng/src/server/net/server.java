package server.net;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import dto.ActionMessage;
import dto.HandleMessage;
import server.action.ActionFactory;
import server.action.IAction;
import server.exception.StartException;


import util.Config;

public class server extends Thread{
	private boolean isRun = false;
	private boolean close=false;
	private ServerSocket serverSocket;
	private Config config;

	public void run()
	{
		try 
		{
			startServer();
		} 
		catch (StartException e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * ����������
	 * @throws StartException
	 * @throws IOException
	 */
	public void startServer() throws StartException 
	{
		try 
		{
			config = new Config("config/server.properties");//��ȡ�����ļ�
			int port = Integer.valueOf(config.getValue("server.port"));// �������ļ��л�ö˿�
			serverSocket = new ServerSocket(port);//������ָ���˿ڵ�����
			isRun = true;
			//����̨���������Ϣ
			System.out.println("�����������ɹ����ڶ˿�" + port + "����");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new StartException("����ʧ��", e);
		}
		try 
			{
				while (!close) 
				{
					if(isRun)
					{
					// ���Ͻ��տͻ��˵���Ϣ�������ͻ�������
					Socket socket = serverSocket.accept();
					// ÿ�����յ�һ���ͻ������󣬾Ϳ�һ���߳�Ϊ������
					new ServerThread(socket).start();
					}
					else
					{
						wait(1000);
					}
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				throw new StartException("��������������", e);
			}
			finally
			{
				if (null != serverSocket) 
				{
					try 
					{
						serverSocket.close();
					}
					catch (IOException e) 
					{
						e.printStackTrace();
					}
				}
			}
		}
		
		/**
		 * �������ر�
		 */
		public void stopServer() 
		{
			isRun = false;
			//����̨���������Ϣ
			System.out.println("��������ֹͣ");
		}

		/**
		 * ��Ա�ڲ��࣬��������ÿ���ͻ����߳�
		 */
		private class ServerThread extends Thread 
		{
			private Socket socket;

			public ServerThread(Socket socket) 
			{
				this.socket = socket;
			}
			public void run() 
			{
				// ���������������������
				ObjectInputStream ois = null;
				ObjectOutputStream oos = null;
				try 
				{					
					ois = new ObjectInputStream(socket.getInputStream());
					oos = new ObjectOutputStream(socket.getOutputStream());
					while (isRun) 
					{
						// ���տͻ��˷���������Ϣ
						ActionMessage am = (ActionMessage) ois.readObject();
						am.setClientIP(socket.getInetAddress());// ����IP
						// ���ݶ���ö�����ͻ�ö�������
						IAction action = ActionFactory.getAction(am.getClient(),am.getAction());
						// ���ö��������handle��������������Ȼ�󷵻ش�����Ϣ����							
						HandleMessage hm = action.handle(am);
						// �����Ϣ
						oos.writeObject(hm);
						// ˢ��
						oos.flush();
					}
					
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				} 
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				} 
				finally 
				{
					try 
					{
						socket.close();
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
				}
			}
		}
		
		public void onPauseRecover()
		{
			isRun=true;
			System.out.println("�������ָ�����");
		}
}