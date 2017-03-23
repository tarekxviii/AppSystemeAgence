package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="clients")
@XmlRootElement
public class Client implements Serializable{

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id_client")
		private int id_client;
		@Column(name="nom_client")
		private String nom_client;
		@Column(name="prenom_client")
		private String prenom_client;
		@Column(name="tel_client")
		private String tel_client;
		@Column(name="mdp_client")
		private String mdp_client;
		
		
		@OneToOne(fetch=FetchType.EAGER,mappedBy="cClient")
		private Contrat cContrat;
		
		@OneToMany(mappedBy="vClient",fetch=FetchType.EAGER)
		@Fetch(FetchMode.SUBSELECT)
		private List<Visite> cListeVisite;
		
		@ManyToMany(fetch=FetchType.EAGER)
		@Fetch(FetchMode.SUBSELECT)
		@JoinTable(name = "table_jointure_client_visite",joinColumns=@JoinColumn(name="client_id_fk"),inverseJoinColumns=@JoinColumn(name="visite_id_fk"))
		private List<Categorie> cListeInteret;
		
		
		/**
		 * Ctor vide
		 */
		public Client() {
			super();
		}
		/**
		 * Ctor sans ID
		 * @param nom_client
		 * @param prenom_client
		 * @param tel_client
		 * @param mdp_client
		 */
		public Client(String nom_client, String prenom_client, String tel_client, String mdp_client) {
			super();
			this.nom_client = nom_client;
			this.prenom_client = prenom_client;
			this.tel_client = tel_client;
			this.mdp_client = mdp_client;
		}
		/**
		 * Ctor avec ID
		 * @param id_client
		 * @param nom_client
		 * @param prenom_client
		 * @param tel_client
		 * @param mdp_client
		 */
		public Client(int id_client, String nom_client, String prenom_client, String tel_client, String mdp_client) {
			super();
			this.id_client = id_client;
			this.nom_client = nom_client;
			this.prenom_client = prenom_client;
			this.tel_client = tel_client;
			this.mdp_client = mdp_client;
		}
		/**
		 * @return the id_client
		 */
		@XmlElement
		public int getId_client() {
			return id_client;
		}
		/**
		 * @param id_client the id_client to set
		 */
		public void setId_client(int id_client) {
			this.id_client = id_client;
		}
		/**
		 * @return the nom_client
		 */
		@XmlElement
		public String getNom_client() {
			return nom_client;
		}
		/**
		 * @param nom_client the nom_client to set
		 */
		public void setNom_client(String nom_client) {
			this.nom_client = nom_client;
		}
		/**
		 * @return the prenom_client
		 */
		@XmlElement
		public String getPrenom_client() {
			return prenom_client;
		}
		/**
		 * @param prenom_client the prenom_client to set
		 */
		public void setPrenom_client(String prenom_client) {
			this.prenom_client = prenom_client;
		}
		/**
		 * @return the tel_client
		 */
		@XmlElement
		public String getTel_client() {
			return tel_client;
		}
		/**
		 * @param tel_client the tel_client to set
		 */
		public void setTel_client(String tel_client) {
			this.tel_client = tel_client;
		}
		/**
		 * @return the mdp_client
		 */
		@XmlElement
		public String getMdp_client() {
			return mdp_client;
		}
		/**
		 * @param mdp_client the mdp_client to set
		 */
		public void setMdp_client(String mdp_client) {
			this.mdp_client = mdp_client;
		}
		
		
		@XmlTransient
		public Contrat getcContrat() {
			return cContrat;
		}
		public void setcContrat(Contrat cContrat) {
			this.cContrat = cContrat;
		}
		
		@XmlTransient
		public List<Visite> getcListeVisite() {
			return cListeVisite;
		}
		public void setcListeVisite(List<Visite> cListeVisite) {
			this.cListeVisite = cListeVisite;
		}
		
		@XmlElement
		public List<Categorie> getcListeInteret() {
			return cListeInteret;
		}
		public void setcListeInteret(List<Categorie> cListeInteret) {
			this.cListeInteret = cListeInteret;
		}
		
		
		
		
		
		
		
		

}
