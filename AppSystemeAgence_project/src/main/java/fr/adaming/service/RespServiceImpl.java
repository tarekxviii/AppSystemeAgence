package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IRespDao;
import fr.adaming.entities.Responsable;

@Service
@Transactional
public class RespServiceImpl implements IRespService {

	/**
	 * 
	 */
	@Autowired
	IRespDao respdao;

	/**
	 * @param respdao
	 */
	public void setRespdao(IRespDao respdao) {
		this.respdao = respdao;
	}

	/* (non-Javadoc)
	 * @see fr.adaming.service.IRespService#addService(fr.adaming.entities.Responsable)
	 */
	@Override
	public void addService(Responsable resp) {
		respdao.addDao(resp);

	}

	/* (non-Javadoc)
	 * @see fr.adaming.service.IRespService#deleteService(int)
	 */
	@Override
	public void deleteService(int id) {
		respdao.deleteDao(id);

	}

	/* (non-Javadoc)
	 * @see fr.adaming.service.IRespService#updateService(fr.adaming.entities.Responsable)
	 */
	@Override
	public void updateService(Responsable resp) {
		respdao.updateDao(resp);

	}

	/* (non-Javadoc)
	 * @see fr.adaming.service.IRespService#getAllResponsable()
	 */
	@Override
	public List<Responsable> getAllResponsable() {

		return respdao.getAllResponsable();
	}

	/* (non-Javadoc)
	 * @see fr.adaming.service.IRespService#getResponsableById(int)
	 */
	@Override
	public Responsable getResponsableById(int id) {

		return respdao.getResponsableById(id);
	}

}
