package modele;

import javax.swing.*;
import java.util.Objects;

public class Employe {
    private String nom;
    private String prenom;
    private String type;
    private double montantUtiliserTranportJour;
    private double montantUtiliserHebergementMois;
    private double montantUtiliserRestaurationJour;

    public Employe() {
    }

    public Employe(String nom, String prenom, String type, double montantUtiliserTranportJour, double montantUtiliserHebergementMois, double montantUtiliserRestaurationJour) {
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
        this.montantUtiliserTranportJour = montantUtiliserTranportJour;
        this.montantUtiliserHebergementMois = montantUtiliserHebergementMois;
        this.montantUtiliserRestaurationJour = montantUtiliserRestaurationJour;
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

    public double getMontantUtiliserTranportJour() {
        return montantUtiliserTranportJour;
    }

    public void setMontantUtiliserTranportJour(double montantUtiliserTranportJour) {
        this.montantUtiliserTranportJour = montantUtiliserTranportJour;
    }

    public double getMontantUtiliserHebergementMois() {
        return montantUtiliserHebergementMois;
    }

    public void setMontantUtiliserHebergementMois(double montantUtiliserHebergementMois) {
        this.montantUtiliserHebergementMois = montantUtiliserHebergementMois;
    }

    public double getMontantUtiliserRestaurationJour() {
        return montantUtiliserRestaurationJour;
    }

    public void setMontantUtiliserRestaurationJour(double montantUtiliserRestaurationJour) {
        this.montantUtiliserRestaurationJour = montantUtiliserRestaurationJour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employe)) return false;
        Employe employe = (Employe) o;
        return Objects.equals(getNom().toUpperCase(), employe.getNom().toUpperCase()) && Objects.equals(getPrenom().toUpperCase(), employe.getPrenom().toUpperCase()) && Objects.equals(getType().toUpperCase(), employe.getType().toUpperCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(), getPrenom(), getType());
    }
}
