package server.rowsMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Bingli;

public class BingliRowsMapper implements RowsMapper<Bingli> {
	public Bingli getEntity(ResultSet rs) throws SQLException{
		
		Bingli bingli = new Bingli();
		bingli.setId(rs.getInt("B_ID"));
		bingli.setCustomerNo(rs.getString("C_No"));
		bingli.setDoctorNo(rs.getString("D_No"));
		bingli.setTime(rs.getDate("B_Time"));
		bingli.setResult(rs.getString("B_Result"));
		bingli.setPlan(rs.getString("B_Plan"));
		bingli.setFree(rs.getBigDecimal("B_Free"));
		bingli.setIsscuccess(rs.getString("B_Success"));
		bingli.setReason(rs.getString("B_Reason"));
		
		return bingli;
	}

}
