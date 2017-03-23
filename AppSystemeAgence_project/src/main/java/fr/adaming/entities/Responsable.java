package fr.adaming.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="responsables")
@XmlRootElement
public class Responsable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_resp")
	private int id_resp;
	
	@Column(name="mail_resp")
	private String mail_resp;
	
	@Column(name="password_resp")
	private String password_resp;
	
	@OneToMany(mappedBy="vResponsable", fetch=FetchType.LAZY)
	private List<Visite> rListeVisite;
	
	@OneToMany(mappedBy="cResponsable", fetch=FetchType.LAZY)
	private List<Contrat> rListeContrat;
 
	/**
	 * constructeur vide
	 */
	public Responsable() {
		super();
	}

	/**
	 * constructeur sans id
	 * 
	 * @param mail_resp
	 * @param password_resp
	 */
	public Responsable(String mail_resp, String password_resp) {
		super();
		this.mail_resp = mail_resp;
		this.password_resp = password_resp;
	}

	/**
	 * constructeur avec id
	 * 
	 * @param id_resp
	 * @param mail_resp
	 * @param password_resp
	 */
	public Responsable(int id_resp, String mail_resp, String password_resp) {
		super();
		this.id_resp = id_resp;
		this.mail_resp = mail_resp;
		this.password_resp = password_resp;
	}

	/**
	 * @return the id_resp
	 */
	@XmlElement
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
	@XmlElement
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
	@XmlElement
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
	@XmlElement
	public List<Visite> getrListeVisite() {
		return rListeVisite;
	}

	/**
	 * @param rListeVisite the rListeVisite to set
	 */
	public void setrListeVisite(List<Visite> rListeVisite) {
		this.rListeVisite = rListeVisite;
	}


	/**
	 * @return the rListeContrat
	 */
	@XmlElement
	public List<Contrat> getrListeContrat() {
		return rListeContrat;
	}


	/**
	 * @param rListeContrat the rListeContrat to set
	 */
	public void setrListeContrat(List<Contrat> rListeContrat) {
		this.rListeContrat = rListeContrat;
	}
	
	
	
	

}
