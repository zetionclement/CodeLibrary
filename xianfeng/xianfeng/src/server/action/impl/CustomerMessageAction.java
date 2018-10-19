package server.action.impl;

import java.util.Arrays;
import java.util.List;

import db.server.service.ICustomerService;
import db.server.service.impl.CustomerServiceImpl;
import dto.ActionMessage;
import dto.HandleMessage;
import entity.Customer;
import entity.Doctor;
import server.action.IAction;
import server.dao.ICustomerDao;
import server.dao.impl.CustomerDaoImpl;


public class CustomerMessageAction implements IAction {
	private ICustomerService customerService = new CustomerServiceImpl();
	private ICustomerDao customerDao = new CustomerDaoImpl();
	@Override
	public HandleMessage handle(ActionMessage am) {
		String CustomerNo = String.valueOf(am.getData().get("customerNo"));
		Customer customer = customerService.queryByCustomerNo(CustomerNo);
		List time =  customerService.queryAlldate(CustomerNo);
		
		HandleMessage hm = new HandleMessage();
		hm.getData().put("customerName", customer.getCustomerName());
		hm.getData().put("customerSex", customer.getCustomerSex());
		hm.getData().put("customerAge", customer.getAge());
		hm.getData().put("customerBoth", customer.getCustomerBoth());
		hm.getData().put("customerRoomID",customer.getCustomerRoomID());
		hm.getData().put("time",time);
		return hm;
	}
}
