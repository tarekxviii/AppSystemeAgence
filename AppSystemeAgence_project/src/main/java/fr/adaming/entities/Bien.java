package fr.adaming.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="biens")
@XmlRootElement
public class Bien {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_bien")
	private int id_bien;
	
	@Column(name="hab0_Com1")
	private boolean hab0_Com1;
	
	@Column(name="loc0_Ach1")
	private boolean loc0_Ach1;
	
	@Column(name="revenuCadastral")
	private double revenuCadastral;
	
	@Column(name="type_bien")
	private String type_bien;
	
	@Column(name="disponibilite")
	private boolean disponibilite;
	
	@Column(name="inscription")
	private Date inscription;
	
	@Column(name="cautionLoc")
	private double cautionLoc;
	
	@Column(name="loyerMensuel")
	private double loyerMensuel;
	
	@Column(name="charges")
	private double charges;
	
	@Column(name="prixAchat")
	private double prixAchat;
	
	@Column(name="etat")
	private String etat;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn (name="categorie_id_fk",referencedColumnName="id_cat")
	private Categorie bCategorie;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn (name="propriettaire_id_fk",referencedColumnName="id_prop")
	private Proprietaire bProprietaire;
	
	@OneToMany(mappedBy="vBien",fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Visite> bListeVisite;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="cBien")
	private Contrat bContrat;
	
	/**
	 * constructeur vide
	 */
	public Bien() {
		super();
	}

	

	/**
	 * @param hab0_Com1
	 * @param loc0_Ach1
	 * @param revenuCadastral
	 * @param type_bien
	 * @param disponibilite
	 * @param inscription
	 * @param cautionLoc
	 * @param loyerMensuel
	 * @param charges
	 * @param prixAchat
	 * @param etat
	 */
	public Bien(boolean hab0_Com1, boolean loc0_Ach1, double revenuCadastral, String type_bien, boolean disponibilite,
			Date inscription, double cautionLoc, double loyerMensuel, double charges, double prixAchat, String etat) {
		super();
		this.hab0_Com1 = hab0_Com1;
		this.loc0_Ach1 = loc0_Ach1;
		this.revenuCadastral = revenuCadastral;
		this.type_bien = type_bien;
		this.disponibilite = disponibilite;
		this.inscription = inscription;
		this.cautionLoc = cautionLoc;
		this.loyerMensuel = loyerMensuel;
		this.charges = charges;
		this.prixAchat = prixAchat;
		this.etat = etat;
	}



	/**
	 * @param id_bien
	 * @param hab0_Com1
	 * @param loc0_Ach1
	 * @param revenuCadastral
	 * @param type_bien
	 * @param disponibilite
	 * @param inscription
	 * @param cautionLoc
	 * @param loyerMensuel
	 * @param charges
	 * @param prixAchat
	 * @param etat
	 */
	public Bien(int id_bien, boolean hab0_Com1, boolean loc0_Ach1, double revenuCadastral, String type_bien,
			boolean disponibilite, Date inscription, double cautionLoc, double loyerMensuel, double charges,
			double prixAchat, String etat) {
		super();
		this.id_bien = id_bien;
		this.hab0_Com1 = hab0_Com1;
		this.loc0_Ach1 = loc0_Ach1;
		this.revenuCadastral = revenuCadastral;
		this.type_bien = type_bien;
		this.disponibilite = disponibilite;
		this.inscription = inscription;
		this.cautionLoc = cautionLoc;
		this.loyerMensuel = loyerMensuel;
		this.charges = charges;
		this.prixAchat = prixAchat;
		this.etat = etat;
	}



	/**
	 * @return the id_bien
	 */
	@XmlElement
	public int getId_bien() {
		return id_bien;
	}

	/**
	 * @param id_bien the id_bien to set
	 */
	public void setId_bien(int id_bien) {
		this.id_bien = id_bien;
	}

	/**
	 * @return the hab0_Com1
	 */
	@XmlElement
	public boolean isHab0_Com1() {
		return hab0_Com1;
	}

	/**
	 * @param hab0_Com1 the hab0_Com1 to set
	 */
	public void setHab0_Com1(boolean hab0_Com1) {
		this.hab0_Com1 = hab0_Com1;
	}

	/**
	 * @return the loc0_Ach1
	 */
	@XmlElement
	public boolean isLoc0_Ach1() {
		return loc0_Ach1;
	}

	/**
	 * @param loc0_Ach1 the loc0_Ach1 to set
	 */
	
	public void setLoc0_Ach1(boolean loc0_Ach1) {
		this.loc0_Ach1 = loc0_Ach1;
	}

	/**
	 * @return the revenuCadastral
	 */
	@XmlElement
	public double getRevenuCadastral() {
		return revenuCadastral;
	}

	/**
	 * @param revenuCadastral the revenuCadastral to set
	 */
	
	public void setRevenuCadastral(double revenuCadastral) {
		this.revenuCadastral = revenuCadastral;
	}

	/**
	 * @return the type_bien
	 */
	@XmlElement
	public String getType_bien() {
		return type_bien;
	}

	/**
	 * @param type_bien the type_bien to set
	 */
	public void setType_bien(String type_bien) {
		this.type_bien = type_bien;
	}

	/**
	 * @return the disponibilite
	 */
	@XmlElement
	public boolean isDisponibilite() {
		return disponibilite;
	}

	/**
	 * @param disponibilite the disponibilite to set
	 */
	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}

	/**
	 * @return the inscription
	 */
	@XmlElement
	public Date getInscription() {
		return inscription;
	}

	/**
	 * @param inscription the inscription to set
	 */
	public void setInscription(Date inscription) {
		this.inscription = inscription;
	}

	/**
	 * @return the cautionLoc
	 */
	@XmlElement
	public double getCautionLoc() {
		return cautionLoc;
	}

	/**
	 * @param cautionLoc the cautionLoc to set
	 */
	public void setCautionLoc(double cautionLoc) {
		this.cautionLoc = cautionLoc;
	}

	/**
	 * @return the loyerMensuel
	 */
	@XmlElement
	public double getLoyerMensuel() {
		return loyerMensuel;
	}

	/**
	 * @param loyerMensuel the loyerMensuel to set
	 */
	public void setLoyerMensuel(double loyerMensuel) {
		this.loyerMensuel = loyerMensuel;
	}

	/**
	 * @return the charges
	 */
	@XmlElement
	public double getCharges() {
		return charges;
	}

	/**
	 * @param charges the charges to set
	 */
	public void setCharges(double charges) {
		this.charges = charges;
	}

	/**
	 * @return the prixAchat
	 */
	@XmlElement
	public double getPrixAchat() {
		return prixAchat;
	}

	/**
	 * @param prixAchat the prixAchat to set
	 */
	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	/**
	 * @return the etat
	 */
	@XmlElement
	public String getEtat() {
		return etat;
	}

	/**
	 * @param etat the etat to set
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}

	/**
	 * @return the bCategorie
	 */
	@XmlTransient
	public Categorie getbCategorie() {
		return bCategorie;
	}

	/**
	 * @param bCategorie the bCategorie to set
	 */
	public void setbCategorie(Categorie bCategorie) {
		this.bCategorie = bCategorie;
	}

	/**
	 * @return the bProprietaire
	 */
	@XmlTransient
	public Proprietaire getbProprietaire() {
		return bProprietaire;
	}

	/**
	 * @param bProprietaire the bProprietaire to set
	 */
	public void setbProprietaire(Proprietaire bProprietaire) {
		this.bProprietaire = bProprietaire;
	}

	/**
	 * @return the bListeVisite
	 */
	@XmlTransient
	public List<Visite> getbListeVisite() {
		return bListeVisite;
	}

	/**
	 * @param bListeVisite the bListeVisite to set
	 */
	public void setbListeVisite(List<Visite> bListeVisite) {
		this.bListeVisite = bListeVisite;
	}

	/**
	 * @return the bContrat
	 */
	@XmlTransient
	public Contrat getbContrat() {
		return bContrat;
	}

	/**
	 * @param bContrat the bContrat to set
	 */
	public void setbContrat(Contrat bContrat) {
		this.bContrat = bContrat;
	}
	
	
}
