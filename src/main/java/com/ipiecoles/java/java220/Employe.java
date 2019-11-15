package com.ipiecoles.java.java220;
import java.util.Objects;
import org.joda.time.LocalDate;
public abstract class Employe {
	private String nom;
	private String prenom;
	private String matricule;
	private LocalDate dateEmbauche;
	protected Double salaire;

	public Employe() {
		setNom("nom");
		setPrenom("prenom");
		setMatricule("matricule");
		setDateEmbauche(LocalDate.now());
		setSalaire((double) 500);

	}

	public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.dateEmbauche = dateEmbauche;
		this.salaire = salaire;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(LocalDate dateEmbauche) {
		if (dateEmbauche.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("La date d'embauche ne peut être postérieure à la date courante");
		} else
			this.dateEmbauche = dateEmbauche;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

	public final Integer getNombreAnneeAnciennete() {
		return (Integer) LocalDate.now().getYear() - this.getDateEmbauche().getYear();

	}

	public Integer getNbConges() {
		return Entreprise.NB_CONGES_BASE;
	}

	public String toString() {
		return "Employe{nom='" + this.getNom() + "', prenom='" + this.getPrenom() + "', matricule='"
				+ this.getMatricule() + "', dateEmbauche=" + this.getDateEmbauche() + ", salaire=" + this.getSalaire()
				+ "}";
	}



	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateEmbauche == null) ? 0 : dateEmbauche.hashCode());
		result = prime * result + ((matricule == null) ? 0 : matricule.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((salaire == null) ? 0 : salaire.hashCode());
		return result;
	}*/
	

	@Override
	public int hashCode() {
		return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employe other = (Employe) obj;
		return Objects.equals(dateEmbauche, other.dateEmbauche) && Objects.equals(matricule, other.matricule)
				&& Objects.equals(nom, other.nom) && Objects.equals(prenom, other.prenom)
				&& Objects.equals(salaire, other.salaire);
	}
	public void augmenterSalaire(Double pourcentage) {
		Double t=this.salaire;
		this.salaire=t*(1+pourcentage);
	}
	public abstract Double getPrimeAnnuelle();


}
