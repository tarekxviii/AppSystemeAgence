package fr.adaming.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="visites")
@XmlRootElement
public class Visite {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_visite")
	private int id_visite;
	
	@Column(name="date_visite")
	private Date date_visite;
	
	//OneToMany
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="bien_id", referencedColumnName="id_bien")
	private Bien vBien;
	
	//OneToMany
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="client_id", referencedColumnName="id_client")
	private Client vClient;
	
	//OneToMany
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="resp_id", referencedColumnName="id_resp")
	private Responsable vResponsable;

	/**
	 * constructeur vide
	 */
	public Visite() {
		super();
	}


	/**
	 * Constructeur sans id
	 * 
	 * @param date_visite
	 */
	public Visite(Date date_visite) {
		super();
		this.date_visite = date_visite;
	}

	/**
	 * constructeur avec id
	 * 
	 * @param id_visite
	 * @param date_visite
	 */
	public Visite(int id_visite, Date date_visite) {
		super();
		this.id_visite = id_visite;
		this.date_visite = date_visite;
	}

	/**
	 * @return the id_visite
	 */
	@XmlElement
	public int getId_visite() {
		return id_visite;
	}

	/**
	 * @param id_visite the id_visite to set
	 */
	public void setId_visite(int id_visite) {
		this.id_visite = id_visite;
	}

	/**
	 * @return the date_visite
	 */
	@XmlElement
	public Date getDate_visite() {
		return date_visite;
	}

	/**
	 * @param date_visite the date_visite to set
	 */
	public void setDate_visite(Date date_visite) {
		this.date_visite = date_visite;
	}

	/**
	 * @return the vBien
	 */
	@XmlElement
	public Bien getvBien() {
		return vBien;
	}

	/**
	 * @param vBien the vBien to set
	 */
	public void setvBien(Bien vBien) {
		this.vBien = vBien;
	}

	/**
	 * @return the vClient
	 */
	@XmlElement
	public Client getvClient() {
		return vClient;
	}

	/**
	 * @param vClient the vClient to set
	 */
	public void setvClient(Client vClient) {
		this.vClient = vClient;
	}

	/**
	 * @return the vResponsable
	 */
	@XmlTransient
	public Responsable getvResponsable() {
		return vResponsable;
	}

	/**
	 * @param vResponsable the vResponsable to set
	 */
	public void setvResponsable(Responsable vResponsable) {
		this.vResponsable = vResponsable;
	}
	

	
	

}
