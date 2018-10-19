package db.server.service.impl;

import java.math.BigDecimal;
import java.util.List;

import entity.Medicine;
import server.dao.IMedicineDao;
import server.dao.impl.MedicineDaoImpl;
import db.server.service.IMedicineService;

public class MedicineServiceImpl implements IMedicineService {
    private IMedicineDao medicinedao = new MedicineDaoImpl(); 
	public BigDecimal findFreeByMedicinesName(String MedicineName) {
		return medicinedao.findFreeByMedicinesName(MedicineName);
	}
	@Override
	public List FindMedicineName() {
		return medicinedao.FindMedicineName();
				}

}
