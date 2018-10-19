package server.action.impl;

import java.math.BigDecimal;

import db.server.service.IMedicineService;
import db.server.service.impl.MedicineServiceImpl;
import dto.ActionMessage;
import dto.HandleMessage;
import server.action.IAction;



public class MedicineAction implements IAction {
    private IMedicineService medicineService = new MedicineServiceImpl();
	public HandleMessage handle(ActionMessage am) {
		String MedicineName = String.valueOf(am.getData().get("medicineName"));
		BigDecimal Free = medicineService.findFreeByMedicinesName(MedicineName);
		HandleMessage hm = new HandleMessage();		
		hm.getData().put("freeName", Free.toString());		
		return hm;
	}
}
