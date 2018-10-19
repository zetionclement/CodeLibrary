package doctorclient.net;

import dto.ActionMessage;
import dto.HandleMessage;
import exception.NetException;

public interface INet {

	/**
	 * ���Ͷ�����Ϣ�������
	 */
	public void send(ActionMessage am) throws NetException;
	/**
	 * ���շ���˵���Ϣ
	 */
	public HandleMessage receive() throws NetException;	
}
