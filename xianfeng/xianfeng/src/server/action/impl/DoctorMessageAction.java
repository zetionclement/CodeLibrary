package server.action.impl;

import db.server.service.IDoctorclientService;
import db.server.service.impl.DoctorLoginImpl;
import dto.ActionMessage;
import dto.HandleMessage;
import entity.Doctor;
import server.action.IAction;


public class DoctorMessageAction implements IAction {
	private IDoctorclientService doctorService = new DoctorLoginImpl();
	@Override
	public HandleMessage handle(ActionMessage am) {
		String doctorNo = String.valueOf(am.getData().get("doctorNo"));
		Doctor doctor = doctorService.queryByDoctorNo(doctorNo);
		HandleMessage hm = new HandleMessage();
		hm.getData().put("doctorName", doctor.getDoctorName());
		hm.getData().put("doctorSex", doctor.getDoctorSex());
		hm.getData().put("doctorAge", doctor.getDoctorAge());
		hm.getData().put("sectionName", doctor.getSectionName());	
		return hm;
	}


}
