package db.server.service;

import java.math.BigDecimal;

public interface IBingliService {
	/**
	 * ������������ʱ���ҵ���Ͻ��
	 */
	public String findResult(String CustomerNo,String Time);
	/**
	 * ������������ʱ���ҵ�������Ϣ
	 */
	public String findPlan(String CustomerNo,String Time);
}
