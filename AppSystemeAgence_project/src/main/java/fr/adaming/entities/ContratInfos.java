package fr.adaming.entities;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ContratInfos {

	
	private Date contratDate;
	
	private Double contratMontant;
	
	private int respId;
	
	private int bienId;
	
	private int clientId;

	
	/**
	 * 
	 */
	public ContratInfos() {
		super();
	}

	/**
	 * @param contratDate
	 * @param contratMontant
	 * @param respId
	 * @param bienId
	 * @param clientId
	 */
	public ContratInfos(Date contratDate, Double contratMontant, int respId, int bienId, int clientId) {
		super();
		this.contratDate = contratDate;
		this.contratMontant = contratMontant;
		this.respId = respId;
		this.bienId = bienId;
		this.clientId = clientId;
	}

	/**
	 * @return the contratDate
	 */
	@XmlElement
	public Date getContratDate() {
		return contratDate;
	}

	/**
	 * @param contratDate the contratDate to set
	 */
	public void setContratDate(Date contratDate) {
		this.contratDate = contratDate;
	}

	/**
	 * @return the contratMontant
	 */
	@XmlElement
	public Double getContratMontant() {
		return contratMontant;
	}

	/**
	 * @param contratMontant the contratMontant to set
	 */
	public void setContratMontant(Double contratMontant) {
		this.contratMontant = contratMontant;
	}

	/**
	 * @return the respId
	 */
	@XmlElement
	public int getRespId() {
		return respId;
	}

	/**
	 * @param respId the respId to set
	 */
	public void setRespId(int respId) {
		this.respId = respId;
	}

	/**
	 * @return the bienId
	 */
	@XmlElement
	public int getBienId() {
		return bienId;
	}

	/**
	 * @param bienId the bienId to set
	 */
	public void setBienId(int bienId) {
		this.bienId = bienId;
	}

	/**
	 * @return the clientId
	 */
	@XmlElement
	public int getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	
	
	
	
}
	