package dto;
public enum ActionEnum {
	//取号
	GET_BUSINESS,//获取业务类型
	TAKES_TICKET,//取号
		
	//叫号
	GET_DOCTOR,//获取柜员信息
	CALL_TICKET,//叫号
	CALL_LOGIN,//叫号登录
	CALL_FAIL,//叫号失败
	CALL_RECALL,//重叫
	GET_WAITCOUNT,//获取实时等待人数
	GET_CUSTOMER,//获取病人信息
	GET_MEDICINENAME,//获取药名
	GET_MEDICINEFREE,//获取药价
	BINGLI_FAIL,//办理失败
	GET_RESULT,//获取病例
	BINGLI_SUCCESS//办理成功
}