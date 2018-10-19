package server.dao;

import java.math.BigDecimal;
import java.util.Date;

import entity.Bingli;

public interface IBingliDao {
	/**
	 * ���˾���ɹ�����ʧ�ܸ������ݿ�
	 */
	public void upDateSuccessorfail(String CustomerNo,String DoctorNo,Date Time,String Result,String Plan,BigDecimal Free,String Success,String Reason);
	/**
	 * ������������ʱ���ҵ���Ͻ��
	 */
	public String findResult(String CustomerNo,String Time);
	/**
	 * ������������ʱ���ҵ�������Ϣ
	 */
	public String findPlan(String CustomerNo,String Time);
	/**
	 * ���Ա��
	 */
	public void add(Bingli bingliEntity);
	/**
	 * ����IDɾ����Ϣ
	 */
	public void delete(int[] id);
	/**
	 * ����Ա����Ų�����Ϣ
	 */
	public Bingli findByNo(String customerNo);
	/**
	 * ͨ��ID������Ϣ
	 * @param id
	 * @return
	 */
	public Bingli findByID(Integer id);
	/**
	 * �޸���Ϣ
	 */
	public void edit(Bingli bingliEntity);

}
