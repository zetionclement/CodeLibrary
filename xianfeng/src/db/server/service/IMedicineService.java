package db.server.service;

import java.math.BigDecimal;
import java.util.List;

import entity.Medicine;

public interface IMedicineService {
	/**
	 * 通过药名查找药价
	 */
	public BigDecimal findFreeByMedicinesName(String MedicineName);
	/**
	 * 查找到所以药品名
	 * @return 
	 */
	public  List FindMedicineName();	
}
