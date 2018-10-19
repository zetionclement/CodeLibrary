package server.action.impl;

import db.server.service.IBingliService;
import db.server.service.impl.BingliServiceImpl;
import dto.ActionMessage;
import dto.HandleMessage;
import server.action.IAction;
import server.dao.IBingliDao;
import server.dao.impl.BingliDaoImpl;


public class GetResult implements IAction {
	private IBingliDao binglidao = new BingliDaoImpl(); 
	private IBingliService bingliservice = new BingliServiceImpl();
	@Override
	public HandleMessage handle(ActionMessage am) {
		//String DoctorNo = String.valueOf(am.getData().get("doctorNo"));
	
		String CustomerNo =String.valueOf(am.getData().get("CustomerNo"));		
		String Time = String.valueOf(am.getData().get("Time"));
		//System.out.println(CustomerNo+"\n"+Time);
		String Plan = bingliservice.findPlan(CustomerNo, Time);
		String Result = bingliservice.findResult(CustomerNo, Time);
		HandleMessage hm = new HandleMessage();
		hm.getData().put("Plan",Plan);
		hm.getData().put("Result",Result);
		return hm;
	}

}
