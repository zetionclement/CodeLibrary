package server.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entity.Doctor;
import server.dao.IDoctorDao;
import server.rowsMapper.DoctorRowsMapper;
import server.rowsMapper.RowsMapper;
import util.JdbcUtils;

public class DoctorDaoImpl implements IDoctorDao {

	@Override
	public Doctor queryByDoctorNo(String DoctorNo) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_doctor where D_No = ?";
			Object[] paramsList= {DoctorNo};
			RowsMapper rm = new DoctorRowsMapper();
			List<Doctor> list = JdbcUtils.executeQuery(conn, sql, paramsList, rm);
			if(null !=list &&list.size() > 0) {
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

	@Override
	public void add(Doctor doctorEntity) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into t_doctor (D_ID,D_No,D_Name,D_Age,D_Sex,D_Tel,D_Pcard,S_Name,D_Education,D_Introduce,D_hiredate)";
			sql += " value (?,?,?,?,?,?,?,?,?,?,?)";
			Object[] params = { null,doctorEntity.getDoctorNo(),
					doctorEntity.getDoctorName(), doctorEntity.getDoctorAge(),
					doctorEntity.getDoctorSex(), doctorEntity.getDoctorTel(),
					doctorEntity.getDoctorPcard(), doctorEntity.getSectionName(),
					doctorEntity.getDoctorEduction(),doctorEntity.getDoctorIntroduce(),doctorEntity.getDootorHiredate() };
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
			String sql = "delete from t_doctor where 1 = 1";
			sql += " and D_ID in (";
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
	public Doctor findByNo(String doctorNo) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_doctor where D_No = ?";
			Object[] paramslist = { doctorNo };
			RowsMapper rm = new DoctorRowsMapper();
			List<Doctor> list = JdbcUtils.executeQuery(conn, sql, paramslist, rm);
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
	public Doctor findByID(Integer id) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_doctor where D_ID = ?";
			Object[] paramslist = { id };
			RowsMapper rm = new DoctorRowsMapper();
			List<Doctor> list = JdbcUtils.executeQuery(conn, sql, paramslist, rm);
			return list.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		return null;
	}

	@Override
	public void edit(Doctor doctorEntity) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update t_doctor set D_ID = ?,D_No = ?,D_Name = ?,"
					+ "D_Age = ?,D_Sex = ?,D_Tel = ?,D_Pcard = ?,S_Name = ?,"
					+ "D_Education = ?,D_Introduce = ?,D_hiredate = ? where D_ID = ?";
			Object[] params = { doctorEntity.getId(),doctorEntity.getDoctorNo(),doctorEntity.getDoctorName(),
					doctorEntity.getDoctorAge(),doctorEntity.getDoctorSex(),
					doctorEntity.getDoctorTel(),doctorEntity.getDoctorPcard(),
					doctorEntity.getSectionName(),doctorEntity.getDoctorEduction(),
					doctorEntity.getDoctorIntroduce(),doctorEntity.getDootorHiredate(),
					doctorEntity.getId()};
			JdbcUtils.insert(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		
	}

}
