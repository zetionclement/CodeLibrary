
package server.action;

import dto.ActionEnum;
import dto.ClientEnum;
import server.action.impl.CustomerMessageAction;
import server.action.impl.DealwithfailAction;
import server.action.impl.DealwithsuccessAction;
import server.action.impl.DoctorLoginAction;
import server.action.impl.DoctorMessageAction;
import server.action.impl.GetMedicneNameAction;
import server.action.impl.GetResult;
import server.action.impl.MedicineAction;

public class ActionFactory {
	
		public static IAction getAction(ClientEnum ce, ActionEnum ae){
		//ȡ�Ŷˣ�ȡ�Ŷ���
//���ô�Ϊ������ԣ����ȡ�Ŷ���������˳ɹ����ӣ�����̨����ʾce��ae��
                  if(ce == ClientEnum.DOCTOR_CLIENT && ae == ActionEnum.CALL_LOGIN) {
				return new DoctorLoginAction();
			}			// CallClientActionTestΪ���Ӳ�����
			 else if(ce == ClientEnum.DOCTOR_CLIENT && ae == ActionEnum.GET_DOCTOR){
					return new DoctorMessageAction();
				}
			 else if(ce == ClientEnum.DOCTOR_CLIENT && ae == ActionEnum.GET_CUSTOMER) {
					return new CustomerMessageAction();
				}else if(ce == ClientEnum.DOCTOR_CLIENT && ae == ActionEnum.GET_MEDICINEFREE) {
					return new MedicineAction();
				}else if(ce == ClientEnum.DOCTOR_CLIENT && ae == ActionEnum.GET_MEDICINENAME) {
					return new GetMedicneNameAction();
				}
				else if(ce == ClientEnum.DOCTOR_CLIENT && ae == ActionEnum.BINGLI_FAIL){
					return new DealwithfailAction();
					}
				else if(ce == ClientEnum.DOCTOR_CLIENT && ae == ActionEnum.BINGLI_SUCCESS){
					return new DealwithsuccessAction();
				}
				else if(ce == ClientEnum.DOCTOR_CLIENT && ae == ActionEnum.GET_RESULT) {
					return new GetResult();
				}
		return null;
	}

}
