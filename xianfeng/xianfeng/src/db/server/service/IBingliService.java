package db.server.service;

import java.math.BigDecimal;

public interface IBingliService {
	/**
	 * 根据曾经就诊时间找到诊断结果
	 */
	public String findResult(String CustomerNo,String Time);
	/**
	 * 根据曾经就诊时间找到处方信息
	 */
	public String findPlan(String CustomerNo,String Time);
}
