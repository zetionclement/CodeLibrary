package server.dao;

import entity.Login;

public interface ILoginDao {
	/**
	 * ¸ù¾İµÇÂ½ÕËºÅÕÒµ½µÇÂ½ÃÜÂë
	 */
	public Login findLoginPw(String LoginNo);

}
