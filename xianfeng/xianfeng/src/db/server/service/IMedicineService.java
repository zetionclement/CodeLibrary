package db.server.service;

import java.math.BigDecimal;
import java.util.List;

import entity.Medicine;

public interface IMedicineService {
	/**
	 * ͨ��ҩ������ҩ��
	 */
	public BigDecimal findFreeByMedicinesName(String MedicineName);
	/**
	 * ���ҵ�����ҩƷ��
	 * @return 
	 */
	public  List FindMedicineName();	
}
