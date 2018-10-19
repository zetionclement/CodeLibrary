package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import server.rowsMapper.RowsMapper;

public class JdbcUtils {
	
	private static String driverClass = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/xianfeng?useUnicode=true&characterEncoding=utf8";
	private static String user = "root";
	private static String password = "password";  //��Ҫ���ĵĵط�
	
	static{
		try {
			Class.forName(driverClass);//ע���������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	
	public static void close(ResultSet rs){
		if(null != rs){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(Statement stmt){
		if(null != stmt){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(Connection conn){
		if(null != conn){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs,Statement stmt,Connection conn){
		close(rs);
		close(stmt);
		close(conn);
	}
	
	public static int insert(Connection conn,String sql,Object[] parems) throws SQLException{
		PreparedStatement stmt = null;
		try{
			stmt = conn.prepareStatement(sql);
			if(null != parems && parems.length>0){//�ж��Ƿ�����Ϣ����
				for(int i = 0;i<parems.length;i++){
					stmt.setObject(i+1, parems[i]);//ʹ�ø�����������ָ��������ֵ
				}
			}
			int count = stmt.executeUpdate();
			
			return count;
		}finally{
			close(stmt);
		}
	}
	
	public static <T> List<T> executeQuery(Connection conn,String sql,Object[] paramsList,RowsMapper<T> rm) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>(); 
		try{
			stmt = conn.prepareStatement(sql);
			if(null != paramsList && paramsList.length>0){//�ж��Ƿ�����Ϣ����
				for(int i = 0;i<paramsList.length;i++){
					stmt.setObject(i+1, paramsList[i]);
				}
			}
			rs = stmt.executeQuery();
			while(rs.next()){
				T t = rm.getEntity(rs);
				list.add(t);
			}
			return list;
		}finally{
			close(rs);
			close(stmt);
		}
	}
	public static List<Object[]> executeQuery(Connection conn,String sql,Object[] parems) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Object[]> list = new ArrayList<Object[]>();
		try{
			stmt = conn.prepareStatement(sql);
			if(null != parems && parems.length>0){//�ж��Ƿ�����Ϣ����
				for(int i = 0;i<parems.length;i++){
					stmt.setObject(i+1, parems[i]);
				}
			}
		rs = stmt.executeQuery();
		int colCount = rs.getMetaData().getColumnCount();//�õ��е�����
		while(rs.next()){//���ϴ���һ��oArr����
			Object[] oArr = new Object[colCount];
			for (int i = 0; i < oArr.length; i++) {
				oArr[i] = rs.getObject(i+1);//��ȡָ���е�ֵ��
				
			}
			list.add(oArr);//��Ӳ�ͬ������,ÿһ�е�����
		}
		return list;
		}finally{
			close(rs);
			close(stmt);
		}
	}
	


}
