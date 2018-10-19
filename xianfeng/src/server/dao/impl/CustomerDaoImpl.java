package server.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Bingli;
import entity.Customer;
import server.dao.ICustomerDao;
import server.rowsMapper.BingliRowsMapper;
import server.rowsMapper.CustomerRowsMapper;
import server.rowsMapper.DoctorRowsMapper;
import server.rowsMapper.RowsMapper;
import util.JdbcUtils;

public class CustomerDaoImpl implements ICustomerDao {

	@Override
	public Customer queryByCustomerNo(String CustomerNo) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_customer where C_No = ?";
			Object[] paramsList = {CustomerNo};
			RowsMapper rm = new CustomerRowsMapper();
			List<Customer> list = JdbcUtils.executeQuery(conn, sql, paramsList, rm);
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
	public List queryAlldate(String CustomerNo) {
		Connection conn =null;
		List time = new ArrayList();
		try {
			conn =JdbcUtils.getConnection();
			String sql = "select * from t_bingli where C_No = ?";
			Object[] paramsList = {CustomerNo};
			RowsMapper rm = new BingliRowsMapper();
			List<Bingli> list = JdbcUtils.executeQuery(conn, sql, paramsList, rm);
			for(Bingli e :list) {
				time.add(e.getTime());
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return time;
	}

	@Override
	public void add(Customer customerEntity) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into t_customer (C_ID,C_No,C_Name,C_Age,C_Sex,C_Pcard,C_Tel,C_Both,C_Address,C_RoomID)";
			sql += " value (?,?,?,?,?,?,?,?,?,?)";
			Object[] params = { null,customerEntity.getCustomerNo(),customerEntity.getCustomerName(),
					customerEntity.getAge(),customerEntity.getCustomerSex(),customerEntity.getCustomerPcard(),
					customerEntity.getCustomerTel(),customerEntity.getCustomerBoth(),customerEntity.getCustomerAddress(),
					customerEntity.getCustomerRoomID()};
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
			String sql = "delete from t_customer where 1 = 1";
			sql += " and C_ID in (";
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
	public Customer findByNo(String customerNo) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_customer where C_No = ?";
			Object[] paramslist = { customerNo };
			RowsMapper rm = new DoctorRowsMapper();
			List<Customer> list = JdbcUtils.executeQuery(conn, sql, paramslist, rm);
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
	public Customer findByID(Integer id) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_customer where C_ID = ?";
			Object[] paramslist = { id };
			RowsMapper rm = new CustomerRowsMapper();
			List<Customer> list = JdbcUtils.executeQuery(conn, sql, paramslist, rm);
			return list.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		return null;
	}

	@Override
	public void edit(Customer customerEntity) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update t_customer set C_ID = ?,C_No = ?,C_Name = ?,"
					+ "C_Age = ?,C_Sex = ?,C_Pcard = ?,C_Tel = ?,C_Both = ?,"
					+ "C_Address = ?,C_RoomID = ? where C_ID = ?";
			Object[] params = { customerEntity.getId(),customerEntity.getCustomerNo(),
					customerEntity.getCustomerName(),customerEntity.getAge(),customerEntity.getCustomerSex(),
					customerEntity.getCustomerPcard(),customerEntity.getCustomerTel(),customerEntity.getCustomerBoth(),
					customerEntity.getCustomerAddress(),customerEntity.getCustomerRoomID(),customerEntity.getId()};
			JdbcUtils.insert(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		
	}	
	}





