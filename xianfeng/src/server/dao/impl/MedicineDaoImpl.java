package server.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Bingli;
import entity.Customer;
import entity.Medicine;
import server.dao.IMedicineDao;
import server.rowsMapper.CustomerRowsMapper;
import server.rowsMapper.DoctorRowsMapper;
import server.rowsMapper.MedicineRowsMapper;
import server.rowsMapper.RowsMapper;
import util.JdbcUtils;

public class MedicineDaoImpl implements IMedicineDao {

	@Override
	public BigDecimal findFreeByMedicinesName(String MedicineName) {
		Connection conn = null;
		BigDecimal Free = new BigDecimal("0"); 
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_medicines where M_Name = ?";
			Object[] paramsList = {MedicineName};
			RowsMapper rm = new MedicineRowsMapper();
			List<Medicine> list = JdbcUtils.executeQuery(conn, sql, paramsList, rm);
			for(Medicine e :list) {
				Free = e.getMedicineFree();
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		
		return Free;
	}

	@Override
	public void upDateMedicineStock(String MedicineName, int UseCount) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql ="update t_medicines set M_Stock = M_Stock - ? where M_Name = ?";
			Object[] parems = {UseCount,MedicineName};
			JdbcUtils.insert(conn, sql, parems);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}

	}

	@Override
	public void add(Medicine medicineEntity) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into t_medicines (M_ID,M_No,M_Name,M_Type,M_FreeName,M_Guige,M_Stock,M_Free,M_Jixing,M_Way,M_Function)";
			sql += " value (?,?,?,?,?,?,?,?,?,?,?)";
			Object[] params = { null,medicineEntity.getMedicineNo(),medicineEntity.getMedicineName(),
					medicineEntity.getMedicineType(),medicineEntity.getFreeName(),
					medicineEntity.getMedicineGuige(),medicineEntity.getStock(),
					medicineEntity.getMedicineFree(),medicineEntity.getMedicineJixing(),
					medicineEntity.getMedicineWay(),medicineEntity.getMedicineFunction()};
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
			String sql = "delete from t_medicines where 1 = 1";
			sql += " and M_ID in (";
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
	public Medicine findByNo(String medicineNo) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_medicines where M_No = ?";
			Object[] paramslist = { medicineNo };
			RowsMapper rm = new MedicineRowsMapper();
			List<Medicine> list = JdbcUtils.executeQuery(conn, sql, paramslist, rm);
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
	public Medicine findByID(Integer id) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_medicines where M_ID = ?";
			Object[] paramslist = { id };
			RowsMapper rm = new MedicineRowsMapper();
			List<Medicine> list = JdbcUtils.executeQuery(conn, sql, paramslist, rm);
			return list.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		return null;
	}

	@Override
	public void edit(Medicine medicineEntity) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update t_medicine set M_ID = ?,M_No = ?,M_Name = ?,"
					+ "M_Type = ?,M_FreeName = ?,M_Guige = ?,M_Stock = ?,M_Free = ?,"
					+ "M_Free = ?,M_Free = ?,M_Jixing = ?,M_Way,M_Function where M_ID = ?";
			Object[] params = { medicineEntity.getId(),medicineEntity.getMedicineNo(),
					medicineEntity.getMedicineName(),medicineEntity.getMedicineType(),
					medicineEntity.getFreeName(),medicineEntity.getMedicineGuige(),
					medicineEntity.getStock(),medicineEntity.getMedicineFree(),
					medicineEntity.getMedicineJixing(),medicineEntity.getMedicineWay(),
					medicineEntity.getMedicineFunction(),medicineEntity.getId()};
			JdbcUtils.insert(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		
	}

	@Override
	public List FindMedicineName() {
		Connection conn =null;
		List time = new ArrayList();
		try {
			conn =JdbcUtils.getConnection();
			String sql = "select * from t_medicines where 1 = ?";
			Object[] paramsList = {1};
			RowsMapper rm = new MedicineRowsMapper();
			List<Medicine> list = JdbcUtils.executeQuery(conn, sql, paramsList, rm);
			for(Medicine e :list) {
				time.add(e.getMedicineName());
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return time;
	}

		
	

}
