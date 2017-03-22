package fr.adaming.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="contrats")
@XmlRootElement
public class Contrat {
	
	@Column(name="id_contrat")
	private int id_contrat;
	
	@Column(name="prix_contrat")
	private double prix_contrat;
	
	@Column(name="date_contrat")
	private Date dateSignature;
	
	@OneToOne
	@JoinColumn(name="bien_id",referencedColumnName="id_bien")
	private Bien cBien;
	
	@OneToOne
	@JoinColumn(name="client_id",referencedColumnName="id_client")
	private Client cClient;
	
	

	/**
	 * constructeur vide
	 */
	public Contrat() {
		super();
	}

	/**
	 * @param prix_contrat
	 * @param dateSignature
	 * @param cBien
	 * @param cClient
	 */
	public Contrat(double prix_contrat, Date dateSignature, Bien cBien, Client cClient) {
		super();
		this.prix_contrat = prix_contrat;
		this.dateSignature = dateSignature;
		this.cBien = cBien;
		this.cClient = cClient;
	}

	/**
	 * @param id_contrat
	 * @param prix_contrat
	 * @param dateSignature
	 * @param cBien
	 * @param cClient
	 */
	public Contrat(int id_contrat, double prix_contrat, Date dateSignature, Bien cBien, Client cClient) {
		super();
		this.id_contrat = id_contrat;
		this.prix_contrat = prix_contrat;
		this.dateSignature = dateSignature;
		this.cBien = cBien;
		this.cClient = cClient;
	}

	/**
	 * @return the id_contrat
	 */
	@XmlElement
	public int getId_contrat() {
		return id_contrat;
	}

	/**
	 * @param id_contrat the id_contrat to set
	 */
	public void setId_contrat(int id_contrat) {
		this.id_contrat = id_contrat;
	}

	/**
	 * @return the prix_contrat
	 */
	@XmlElement
	public double getPrix_contrat() {
		return prix_contrat;
	}

	/**
	 * @param prix_contrat the prix_contrat to set
	 */
	public void setPrix_contrat(double prix_contrat) {
		this.prix_contrat = prix_contrat;
	}

	/**
	 * @return the dateSignature
	 */
	@XmlElement
	public Date getDateSignature() {
		return dateSignature;
	}

	/**
	 * @param dateSignature the dateSignature to set
	 */
	public void setDateSignature(Date dateSignature) {
		this.dateSignature = dateSignature;
	}

	/**
	 * @return the cBien
	 */
	@XmlElement
	public Bien getcBien() {
		return cBien;
	}

	/**
	 * @param cBien the cBien to set
	 */
	public void setcBien(Bien cBien) {
		this.cBien = cBien;
	}

	/**
	 * @return the cClient
	 */
	@XmlElement
	public Client getcClient() {
		return cClient;
	}

	/**
	 * @param cClient the cClient to set
	 */
	public void setcClient(Client cClient) {
		this.cClient = cClient;
	}

	
	
	
	
	
}
