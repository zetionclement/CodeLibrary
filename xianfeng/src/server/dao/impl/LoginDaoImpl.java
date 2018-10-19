package server.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entity.Login;
import server.dao.ILoginDao;
import server.rowsMapper.CustomerRowsMapper;
import server.rowsMapper.LoginRowsMapper;
import server.rowsMapper.RowsMapper;
import util.JdbcUtils;

public class LoginDaoImpl implements ILoginDao {

	@Override
	public Login findLoginPw(String LoginNo) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql ="select * from t_login where L_No = ?";
			Object[] paramsList = {LoginNo};
			RowsMapper rm = new LoginRowsMapper();
			List<Login> list= JdbcUtils.executeQuery(conn, sql, paramsList, rm);
			if(null != list && list.size() > 0) {
				return list.get(0);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return null;
	}

}
