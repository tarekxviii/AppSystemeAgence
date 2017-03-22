package fr.adaming.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
		
		
		
		
		

}
