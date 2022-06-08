package modele;

public class Employe {
    private String nom;
    private String prenom;
    private String type;

    public Employe() {
    }

    public Employe(String nom, String prenom, String type) {
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Commerciaux{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
