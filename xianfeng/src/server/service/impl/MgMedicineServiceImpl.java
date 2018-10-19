package server.service.impl;

import java.rmi.ServerException;

import entity.Customer;
import entity.Medicine;
import server.dao.IMedicineDao;
import server.dao.impl.MedicineDaoImpl;
import server.service.IMgMedicineService;

public class MgMedicineServiceImpl implements IMgMedicineService {
	private IMedicineDao medicineDao = new MedicineDaoImpl();

	@Override
	public void delete(int[] id) {
		medicineDao.delete(id);

	}

	@Override
	public void add(Medicine medicineEntity) throws ServerException {
		if(null!=medicineDao.findByNo(medicineEntity.getMedicineNo())) {
			throw new ServerException("�ñ���Ѵ��ڣ���˶���Ϣ");
		}else {
			medicineDao.add(medicineEntity);
		}

	}

	@Override
	public Medicine findByID(Integer id) {
		Medicine ce = medicineDao.findByID(id);
		return ce;
	}

	@Override
	public void edit(Medicine medicineEntity) throws ServerException {
		if(null == medicineDao.findByID(medicineEntity.getId())) {
			throw new ServerException("��Ա��������");
		}else {
			medicineDao.edit(medicineEntity);
		}

	}

	}


