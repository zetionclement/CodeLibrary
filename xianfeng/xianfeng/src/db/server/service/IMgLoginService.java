package db.server.service;

import java.rmi.ServerException;

import entity.ManageLogin;

public interface IMgLoginService {
	public boolean login(ManageLogin managelogin) throws ServerException;

}
