package server.action.impl;

import java.util.List;

import db.server.service.IMedicineService;
import db.server.service.impl.MedicineServiceImpl;
import dto.ActionMessage;
import dto.HandleMessage;
import server.action.IAction;

public class GetMedicneNameAction implements IAction {
	private IMedicineService medicineService = new MedicineServiceImpl();
	@Override
	public HandleMessage handle(ActionMessage am) {
		List MedicineName=  medicineService.FindMedicineName();
		HandleMessage hm = new HandleMessage();
		hm.getData().put("MedicineName",MedicineName);
		return hm;
	}

}
