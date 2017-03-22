package fr.adaming.entities;

import java.util.Date;
import java.util.List;


public class Bien {
	
	private int id_bien;
	
	private boolean hab0_Com1;
	
	private boolean loc0_Ach1;
	
	private double revenuCadastral;
	
	private String type_bien;
	
	private boolean disponibilite;
	
	private Date inscription;
	
	private double cautionLoc;
	
	private double loyerMensuel;
	
	private double charges;
	
	private double prixAchat;
	
	private String etat;
	
	//ManyToOne
	private Categorie bCategorie;
	//ManyToOne
	private Proprietaire bProprietaire;
	//OneToMany
	private List<Visite> bListeVisite;
	//OneToOne
	private Contrat bContrat;
	
	/**
	 * constructeur vide
	 */
	public Bien() {
		super();
	}

	/**
	 * Constructeur sans id
	 * 
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
	 * @param bCategorie
	 * @param bProprietaire
	 * @param bListeVisite
	 * @param bContrat
	 */
	public Bien(boolean hab0_Com1, boolean loc0_Ach1, double revenuCadastral, String type_bien, boolean disponibilite,
			Date inscription, double cautionLoc, double loyerMensuel, double charges, double prixAchat, String etat,
			Categorie bCategorie, Proprietaire bProprietaire, List<Visite> bListeVisite, Contrat bContrat) {
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
		this.bCategorie = bCategorie;
		this.bProprietaire = bProprietaire;
		this.bListeVisite = bListeVisite;
		this.bContrat = bContrat;
	}

	/**
	 * constructeur plein
	 * 
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
	 * @param bCategorie
	 * @param bProprietaire
	 * @param bListeVisite
	 * @param bContrat
	 */
	public Bien(int id_bien, boolean hab0_Com1, boolean loc0_Ach1, double revenuCadastral, String type_bien,
			boolean disponibilite, Date inscription, double cautionLoc, double loyerMensuel, double charges,
			double prixAchat, String etat, Categorie bCategorie, Proprietaire bProprietaire, List<Visite> bListeVisite,
			Contrat bContrat) {
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
		this.bCategorie = bCategorie;
		this.bProprietaire = bProprietaire;
		this.bListeVisite = bListeVisite;
		this.bContrat = bContrat;
	}

	/**
	 * @return the id_bien
	 */
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
