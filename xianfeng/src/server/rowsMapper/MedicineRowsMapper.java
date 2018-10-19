package server.rowsMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Medicine;

public class MedicineRowsMapper implements RowsMapper<Medicine> {
	public Medicine getEntity(ResultSet rs) throws SQLException{
		
		Medicine medicine = new Medicine();
		medicine.setId(rs.getInt("M_ID"));
		medicine.setMedicineNo(rs.getString("M_No"));
		medicine.setMedicineName(rs.getString("M_Name"));
		medicine.setMedicineType(rs.getString("M_Type"));
		medicine.setFreeName(rs.getString("M_FreeName"));
		medicine.setMedicineGuige(rs.getString("M_Guige"));
		medicine.setStock(rs.getInt("M_Stock"));
		medicine.setMedicineFree(rs.getBigDecimal("M_Free"));
		medicine.setMedicineJixing(rs.getString("M_Jixing"));
		medicine.setMedicineWay(rs.getString("M_Way"));
		medicine.setMedicineFunction(rs.getString("M_Function"));
		
		return medicine;
	}

}
