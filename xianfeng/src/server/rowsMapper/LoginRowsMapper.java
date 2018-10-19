package server.rowsMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Login;

public class LoginRowsMapper implements RowsMapper<Login> {

	@Override
	public Login getEntity(ResultSet rs) throws SQLException {
		Login login = new Login();
		login.setId(rs.getInt("L_ID"));
		login.setLoginNo(rs.getString("L_No"));
		login.setLoginPw(rs.getString("L_Pw"));
		return login;
	}
	

}
