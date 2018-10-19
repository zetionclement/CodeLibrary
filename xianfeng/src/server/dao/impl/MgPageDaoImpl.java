package server.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import server.dao.IMgPageDao;
import util.JdbcUtils;

public class MgPageDaoImpl implements IMgPageDao {

	@Override
	public List<Object[]> show(Map<String, Object> condition, int page, int pageSize, String tableName,
			String requireName1, String requireName2) {
		//将要查询的表的名字和字段作为参数传进来，使show方法可以多次使用
				List<Object> params = new ArrayList<Object>();
				String sql = "select * from " + tableName + " where 1 = 1";
				Connection conn = null;
				if (null != condition.get("key1") && !"".equals(condition.get("key1"))) {
					sql = sql + " and (" + requireName1 + " = ? or " + requireName2
							+ " like ?)";
					System.out.println(sql);
					Object val = condition.get("key1");
					params.add(val);
					params.add("%" + val + "%");
				}
				if (page > 0 && pageSize > 0) {
					sql += " limit ?,?";
					int start = (page - 1) * pageSize;
					params.add(start);
					params.add(pageSize);
				}

				try {
					conn = JdbcUtils.getConnection();
					List<Object[]> list = new ArrayList<Object[]>();
					list = JdbcUtils.executeQuery(conn, sql.toString(),
							params.toArray());
					return list;
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JdbcUtils.close(conn);
				}
				return null;
	}

	@Override
	public Long getTotalPage(Map<String, Object> condition, String tableName, String requireName1,
			String requireName2) {
		List<Object> params = new ArrayList<Object>();
		String sql = "select count(*) from ";
		sql += tableName;
		sql += " where 1 = 1";
		Connection conn = null;
		if (null != condition.get("key1") && !"".equals(condition.get("key1"))) {
			sql = sql + " and (" + requireName1 + " = ? or " + requireName2
					+ " like ?)";
			Object val = condition.get("key1");
			params.add(val);
			params.add("%" + val + "%");
		}

		try {
			conn = JdbcUtils.getConnection();
			List<Object[]> list = new ArrayList<Object[]>();
			list = JdbcUtils.executeQuery(conn, sql.toString(),
					params.toArray());
			return (long) list.get(0)[0];
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		return null;
	}

}
