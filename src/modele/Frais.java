package modele;

import java.util.Date;

public abstract class Frais {
    private Employe employe;
    private String typeFrais;
    private double prixFacture;
    private double remboDispo;
    private Date date;

    public Frais() {
    }

    public Frais(Employe employe, String typeFrais, double prixFacture, Date date) {
        this.employe = employe;
        this.typeFrais = typeFrais;
        this.prixFacture = prixFacture;
        this.date = date;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public String getTypeFrais() {
        return typeFrais;
    }

    public void setTypeFrais(String typeFrais) {
        this.typeFrais = typeFrais;
    }

    public double getPrixFacture() {
        return prixFacture;
    }

    public void setPrixFacture(double prixFacture) {
        this.prixFacture = prixFacture;
    }

    public double getRemboDispo() {
        return remboDispo;
    }

    public void setRemboDispo(double remboDispo) {
        this.remboDispo = remboDispo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{" +
                "employe=" + employe +
                ", typeFrais='" + typeFrais + '\'' +
                ", prixFacture=" + prixFacture +
                ", remboDispo=" + remboDispo +
                ", date=" + date +
                '}';
    }

    public abstract void calculerLimiteMensuel();

    public abstract void validerMontant();

    public abstract void validerMontantRemo();
}
