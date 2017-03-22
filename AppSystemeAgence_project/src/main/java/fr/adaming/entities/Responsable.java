package fr.adaming.entities;

import java.util.List;

public class Responsable {
	
	private int id_resp;
	
	private String mail_resp;
	
	private String password_resp;
	
	//ManyToOne
	private List<Visite> rListeVisite;

	/**
	 * constructeur vide
	 */
	public Responsable() {
		super();
	}

	/**
	 * @param mail_resp
	 * @param password_resp
	 * @param rListeVisite
	 */
	public Responsable(String mail_resp, String password_resp, List<Visite> rListeVisite) {
		super();
		this.mail_resp = mail_resp;
		this.password_resp = password_resp;
		this.rListeVisite = rListeVisite;
	}

	/**
	 * @param id_resp
	 * @param mail_resp
	 * @param password_resp
	 * @param rListeVisite
	 */
	public Responsable(int id_resp, String mail_resp, String password_resp, List<Visite> rListeVisite) {
		super();
		this.id_resp = id_resp;
		this.mail_resp = mail_resp;
		this.password_resp = password_resp;
		this.rListeVisite = rListeVisite;
	}

	/**
	 * @return the id_resp
	 */
	public int getId_resp() {
		return id_resp;
	}

	/**
	 * @param id_resp the id_resp to set
	 */
	public void setId_resp(int id_resp) {
		this.id_resp = id_resp;
	}

	/**
	 * @return the mail_resp
	 */
	public String getMail_resp() {
		return mail_resp;
	}

	/**
	 * @param mail_resp the mail_resp to set
	 */
	public void setMail_resp(String mail_resp) {
		this.mail_resp = mail_resp;
	}

	/**
	 * @return the password_resp
	 */
	public String getPassword_resp() {
		return password_resp;
	}

	/**
	 * @param password_resp the password_resp to set
	 */
	public void setPassword_resp(String password_resp) {
		this.password_resp = password_resp;
	}

	/**
	 * @return the rListeVisite
	 */
	public List<Visite> getrListeVisite() {
		return rListeVisite;
	}

	/**
	 * @param rListeVisite the rListeVisite to set
	 */
	public void setrListeVisite(List<Visite> rListeVisite) {
		this.rListeVisite = rListeVisite;
	}
	
	

}
