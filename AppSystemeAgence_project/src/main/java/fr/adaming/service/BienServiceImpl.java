package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBienDao;
import fr.adaming.entities.Bien;

@Service
@Transactional
public class BienServiceImpl implements IBienService {

	@Autowired
	IBienDao bienDao;

	public void setBienService(IBienDao bienDao) {
		this.bienDao = bienDao;
	}

	@Override
	public void addService(Bien bien) {
		bienDao.addDao(bien);

	}

	@Override
	public void deleteService(int id) {
		bienDao.deleteDao(id);

	}

	@Override
	public void updateService(Bien bien) {
		bienDao.updateDao(bien);

	}

	@Override
	public List<Bien> getAllBien() {

		return bienDao.getAllBien();
	}

}
