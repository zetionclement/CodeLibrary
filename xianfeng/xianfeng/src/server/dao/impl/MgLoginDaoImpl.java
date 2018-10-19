package server.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import entity.Login;
import entity.ManageLogin;
import server.dao.IMgLoginDao;
import server.rowsMapper.LoginRowsMapper;
import server.rowsMapper.ManageLoginRowsMapper;
import server.rowsMapper.RowsMapper;
import util.JdbcUtils;

public class MgLoginDaoImpl implements IMgLoginDao {
	/**
	 * 通过用户名查找信息
	 */

	@Override
	public ManageLogin findByName(String adminNo) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_admin where A_No = ?";
			Object[] paramsList = { adminNo };
			RowsMapper rm = new ManageLoginRowsMapper();
			List<ManageLogin> list = JdbcUtils.executeQuery(conn, sql, paramsList, rm);
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
	
	public void add(Login loginEntity) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into t_login (L_ID,L_No,L_Pw)";
			sql += " value (?,?,?)";
			Object[] params = { null,loginEntity.getLoginNo(),loginEntity.getLoginPw() };
			JdbcUtils.insert(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		
	}

	@Override
	public void delete(int[] id) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from t_login where 1 = 1";
			sql += " and L_ID in (";
			Object[] params = new Object[id.length];
			for (int i = 0; i < id.length; i++) {
				if (i == id.length - 1) {
					sql += " ?";
				} else {
					sql += " ?,";
				}
				params[i] = id[i];
			}
			sql += " )";
			JdbcUtils.insert(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		
	}

	@Override
	public Login findByNo(String loginNo) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_login where L_No = ?";
			Object[] paramslist = { loginNo };
			RowsMapper rm = new LoginRowsMapper();
			List<Login> list = JdbcUtils.executeQuery(conn, sql, paramslist, rm);
			if (null != list && list.size() > 0) {
				return list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		return null;
	}

	@Override
	public Login findByID(Integer id) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_login where L_ID = ?";
			Object[] paramslist = { id };
			RowsMapper rm = new LoginRowsMapper();
			List<Login> list = JdbcUtils.executeQuery(conn, sql, paramslist, rm);
			return list.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		return null;
	}

	@Override
	public void edit(Login loginEntity) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update t_login set L_ID = ?,L_No = ?,L_Pw = ? where L_ID = ?";
			Object[] params = { loginEntity.getId(),loginEntity.getLoginNo(),loginEntity.getLoginPw(),
					loginEntity.getId()};
			JdbcUtils.insert(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		
	}

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
