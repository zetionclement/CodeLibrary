package server.rowsMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Customer;

public class CustomerRowsMapper implements RowsMapper<Customer> {
	public Customer getEntity(ResultSet rs) throws SQLException{
		
		Customer customer = new Customer();
		customer.setId(rs.getInt("C_ID"));
		customer.setCustomerNo(rs.getString("C_No"));
		customer.setCustomerName(rs.getString("C_Name"));
		customer.setAge(rs.getInt("C_Age"));
		customer.setCustomerSex(rs.getString("C_Sex"));
		customer.setCustomerPcard(rs.getString("C_Pcard"));
		customer.setCustomerTel(rs.getString("C_Tel"));
		customer.setCustomerBoth(rs.getDate("C_Both"));
		customer.setCustomerAddress(rs.getString("C_Address"));
		customer.setCustomerRoomID(rs.getString("C_RoomID"));
		return customer;
		
	}

}
