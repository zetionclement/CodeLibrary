package server.rowsMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import entity.ManageLogin;

public class ManageLoginRowsMapper implements RowsMapper<ManageLogin> {
	public ManageLogin getEntity(ResultSet rs) throws SQLException {
		ManageLogin managelogin = new ManageLogin();
		managelogin.setId(rs.getInt("A_ID"));
		managelogin.setLNo(rs.getString("A_No"));
		managelogin.setLPw(rs.getString("A_Pw"));
		managelogin.setLNA(rs.getString("A_Name"));
		return managelogin;
	}

}
