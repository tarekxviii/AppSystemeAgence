package fr.adaming.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="categories")
@XmlRootElement
public class Categorie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cat")
	private int id_cat;
	@Column(name="loyerMin")
	private double loyerMin;
	@Column(name="loyerMax")
	private double loyerMax;
	@Column(name="prixMin")
	private double prixMin;
	@Column(name="prixMax")
	private double prixMax;
	@Column(name="typeBien")
	private String typeBien;
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="cListeInteret")
	@Fetch(FetchMode.SUBSELECT)
	@JsonIgnore
	private List<Client> cListeClient;
	
	@OneToMany(mappedBy="bCategorie",fetch=FetchType.LAZY)
	@Fetch(FetchMode.SUBSELECT)
	@JsonIgnore
	private List<Bien> cListeBien;

	/**
	 * constructeur vide
	 */
	public Categorie() {
		super();
	}

	

	/**
	 * @param loyerMin
	 * @param loyerMax
	 * @param prixMin
	 * @param prixMax
	 * @param typeBien
	 */
	public Categorie(double loyerMin, double loyerMax, double prixMin, double prixMax, String typeBien) {
		super();
		this.loyerMin = loyerMin;
		this.loyerMax = loyerMax;
		this.prixMin = prixMin;
		this.prixMax = prixMax;
		this.typeBien = typeBien;
	}



	/**
	 * @param id_cat
	 * @param loyerMin
	 * @param loyerMax
	 * @param prixMin
	 * @param prixMax
	 * @param typeBien
	 */
	public Categorie(int id_cat, double loyerMin, double loyerMax, double prixMin, double prixMax, String typeBien) {
		super();
		this.id_cat = id_cat;
		this.loyerMin = loyerMin;
		this.loyerMax = loyerMax;
		this.prixMin = prixMin;
		this.prixMax = prixMax;
		this.typeBien = typeBien;
	}



	/**
	 * @return the id_cat
	 */
	@XmlElement
	public int getId_cat() {
		return id_cat;
	}

	/**
	 * @param id_cat the id_cat to set
	 */
	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
	}

	/**
	 * @return the loyerMin
	 */
	@XmlElement
	public double getLoyerMin() {
		return loyerMin;
	}

	/**
	 * @param loyerMin the loyerMin to set
	 */
	public void setLoyerMin(double loyerMin) {
		this.loyerMin = loyerMin;
	}

	/**
	 * @return the loyerMax
	 */
	@XmlElement
	public double getLoyerMax() {
		return loyerMax;
	}

	/**
	 * @param loyerMax the loyerMax to set
	 */
	public void setLoyerMax(double loyerMax) {
		this.loyerMax = loyerMax;
	}

	/**
	 * @return the prixMin
	 */
	@XmlElement
	public double getPrixMin() {
		return prixMin;
	}

	/**
	 * @param prixMin the prixMin to set
	 */
	public void setPrixMin(double prixMin) {
		this.prixMin = prixMin;
	}

	/**
	 * @return the prixMax
	 */
	@XmlElement
	public double getPrixMax() {
		return prixMax;
	}

	/**
	 * @param prixMax the prixMax to set
	 */
	public void setPrixMax(double prixMax) {
		this.prixMax = prixMax;
	}

	/**
	 * @return the typeBien
	 */
	@XmlElement
	public String getTypeBien() {
		return typeBien;
	}

	/**
	 * @param typeBien the typeBien to set
	 */
	public void setTypeBien(String typeBien) {
		this.typeBien = typeBien;
	}

	/**
	 * @return the cListeClient
	 */
	@XmlTransient
	public List<Client> getcListeClient() {
		return cListeClient;
	}

	/**
	 * @param cListeClient the cListeClient to set
	 */
	public void setcListeClient(List<Client> cListeClient) {
		this.cListeClient = cListeClient;
	}

	/**
	 * @return the cListeBien
	 */
	@XmlElement
	public List<Bien> getcListeBien() {
		return cListeBien;
	}

	/**
	 * @param cListeBien the cListeBien to set
	 */
	public void setcListeBien(List<Bien> cListeBien) {
		this.cListeBien = cListeBien;
	}
	
	

}
