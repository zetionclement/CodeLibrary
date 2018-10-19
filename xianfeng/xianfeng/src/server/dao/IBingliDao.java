package server.dao;

import java.math.BigDecimal;
import java.util.Date;

import entity.Bingli;

public interface IBingliDao {
	/**
	 * 病人就诊成功或者失败更新数据库
	 */
	public void upDateSuccessorfail(String CustomerNo,String DoctorNo,Date Time,String Result,String Plan,BigDecimal Free,String Success,String Reason);
	/**
	 * 根据曾经就诊时间找到诊断结果
	 */
	public String findResult(String CustomerNo,String Time);
	/**
	 * 根据曾经就诊时间找到处方信息
	 */
	public String findPlan(String CustomerNo,String Time);
	/**
	 * 添加员工
	 */
	public void add(Bingli bingliEntity);
	/**
	 * 根据ID删除信息
	 */
	public void delete(int[] id);
	/**
	 * 根据员工编号查找信息
	 */
	public Bingli findByNo(String customerNo);
	/**
	 * 通过ID查找信息
	 * @param id
	 * @return
	 */
	public Bingli findByID(Integer id);
	/**
	 * 修改信息
	 */
	public void edit(Bingli bingliEntity);

}
