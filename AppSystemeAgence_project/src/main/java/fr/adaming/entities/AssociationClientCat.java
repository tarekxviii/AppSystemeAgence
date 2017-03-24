package fr.adaming.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AssociationClientCat {
	
	private int idClient;
	
	private String typeCat;

	/**
	 * 
	 */
	public AssociationClientCat() {
		super();
	}

	/**
	 * @param idClient
	 * @param typeCat
	 */
	public AssociationClientCat(int idClient, String typeCat) {
		super();
		this.idClient = idClient;
		this.typeCat = typeCat;
	}

	/**
	 * @return the idClient
	 */
	@XmlElement
	public int getIdClient() {
		return idClient;
	}

	/**
	 * @param idClient the idClient to set
	 */
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	/**
	 * @return the typeCat
	 */
	@XmlElement
	public String getTypeCat() {
		return typeCat;
	}

	/**
	 * @param typeCat the typeCat to set
	 */
	public void setTypeCat(String typeCat) {
		this.typeCat = typeCat;
	}
	
	

}
