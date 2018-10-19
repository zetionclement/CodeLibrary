package server.action.impl;

import db.server.service.IDoctorclientService;
import db.server.service.impl.DoctorLoginImpl;
import dto.ActionMessage;
import dto.HandleMessage;
import server.action.IAction;
import server.ui.DisplayMessage;

public class DoctorLoginAction implements IAction {
	private IDoctorclientService doctorclientService = new DoctorLoginImpl();
	@Override
		public HandleMessage handle(ActionMessage am) {
			HandleMessage hm = new HandleMessage();
			boolean isLogin = doctorclientService.login(String.valueOf(am.getData().get("LoginNo")),String.valueOf(am.getData().get("LoginPw")));			
			hm.getData().put("isLogin", isLogin);
			hm.getData().put("IP", am.getClientIP());
			if(isLogin) {
				DisplayMessage.displayActionMessage(am.getClientIP() + "��¼�ɹ�");
			}else{
				DisplayMessage.displayActionMessage(am.getClientIP() + "��¼ʧ�ܣ����Ż����������");			
			}
			return hm;
		}
}