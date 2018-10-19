package server.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import entity.Bingli;
import server.dao.IBingliDao;
import server.rowsMapper.BingliRowsMapper;
import server.rowsMapper.RowsMapper;
import util.JdbcUtils;

public class BingliDaoImpl implements IBingliDao {

	@Override
	public void upDateSuccessorfail(String CustomerNo, String DoctorNo, Date Time, String Result, String Plan,
			BigDecimal Free, String Success, String Reason) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into t_bingli values(?,?,?,?,?,?,?,?,?)";
			Object[] paramsList = {null,CustomerNo,DoctorNo,Time,Result,Plan,Free,Success,Reason};
			JdbcUtils.insert(conn, sql, paramsList);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		
	}

	@Override
	public String findResult(String CustomerNo, String Time) {
		Connection conn = null;
		String Result = null;
		try {
			conn =JdbcUtils.getConnection();
			String sql = "select * from t_bingli where C_No = ? and B_Time = ?";
			Object[] paramsList = {CustomerNo,Time};
			RowsMapper rm = new BingliRowsMapper();
			List<Bingli> list = JdbcUtils.executeQuery(conn, sql, paramsList, rm);
			for(Bingli e :list) {
				Result = e.getResult();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return Result;
	}

	@Override
	public String findPlan(String CustomerNo, String Time) {
		Connection conn = null;
		String Plan = null;
		try {
			conn =JdbcUtils.getConnection();
			String sql = "select * from t_bingli where C_No = ? and B_Time = ?";
			Object[] paramsList = {CustomerNo,Time};
			RowsMapper rm = new BingliRowsMapper();
			List<Bingli> list = JdbcUtils.executeQuery(conn, sql, paramsList, rm);
			for(Bingli e :list) {
				Plan = e.getPlan();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return Plan;
	}

	@Override
	public void add(Bingli bingliEntity) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void delete(int[] id) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from b_bingli where 1 = 1";
			sql += " and B_ID in (";
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
	public Bingli findByNo(String customerNo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Bingli findByID(Integer id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void edit(Bingli bingliEntity) {
		// TODO 自动生成的方法存根
		
	}


}
