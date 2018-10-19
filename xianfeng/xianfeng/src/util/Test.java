package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Bingli;
import entity.Medicine;
import server.dao.IMedicineDao;
import server.dao.impl.MedicineDaoImpl;
import server.rowsMapper.MedicineRowsMapper;
import server.rowsMapper.RowsMapper;

public class Test {


	public static void main(String[] args) {
		IMedicineDao medao;
		medao = new MedicineDaoImpl();
		List time1 = new ArrayList();
		time1=medao.FindMedicineName();
		System.out.println(time1.get(0));
		System.out.println(time1.get(1));
		System.out.println(time1.get(2));
		System.out.println(time1.get(3));
	}
}
