package server.action.impl;

import java.math.BigDecimal;
import java.util.Date;

import dto.ActionMessage;
import dto.HandleMessage;
import server.action.IAction;
import server.dao.IBingliDao;
import server.dao.impl.BingliDaoImpl;
import server.ui.DisplayMessage;

public class DealwithfailAction implements IAction {
		  private IBingliDao binglidao = new BingliDaoImpl();
			@Override
				public HandleMessage handle(ActionMessage am) {
					HandleMessage hm = new HandleMessage();
					String DoctorNo = String.valueOf(am.getData().get("doctorNo"));
					String CustomerNo = String.valueOf(am.getData().get("customerNo"));
					String Plan = String.valueOf(am.getData().get("plan"));
					BigDecimal Free = new BigDecimal(am.getData().get("free").toString());
					Date Time = (Date) am.getData().get("time");
					String Reason = String.valueOf(am.getData().get("reason"));
					String Result = String.valueOf(am.getData().get("result"));
					String Success = String.valueOf(am.getData().get("Success"));					
					binglidao.upDateSuccessorfail(CustomerNo, DoctorNo, Time, Result, Plan, Free, Success, Reason);
					hm.getData().put("issuccess", "Yes");
					return hm;
				}
	}

