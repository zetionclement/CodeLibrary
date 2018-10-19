package util;




import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entity.Bingli;
import entity.Login;
import entity.Medicine;
import server.dao.IMgLoginDao;


import server.dao.impl.MgLoginDaoImpl;
import server.rowsMapper.BingliRowsMapper;
import server.rowsMapper.MedicineRowsMapper;
import server.rowsMapper.RowsMapper;


public class JdbcutilsTest {

	public static void main(String[] args) throws Exception {
		List time1 = new ArrayList();
		time1 = select2();
		System.out.println(time1.get(0));
	
	
	}
	


	public static void select1() {
		String LoginNo ="a001";
		IMgLoginDao login = new MgLoginDaoImpl();
		Login lo = login.findLoginPw(LoginNo);
		System.out.println(lo.getLoginPw());
	}
	public static  List select2() {
			Connection conn =null;
			List time = new ArrayList();
			try {
				conn =JdbcUtils.getConnection();
				String sql = "select * from t_medicines where 1=?";
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

