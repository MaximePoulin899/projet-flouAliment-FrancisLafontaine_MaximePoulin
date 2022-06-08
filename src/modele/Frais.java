package modele;

import java.util.Objects;

public abstract class Frais {
    private double prixFacture;
    private double remboDispo;
    private Commerciaux typeCommerciaux;
    private String date;


    public Frais() {
    }

    public Frais(double prixFacture,  Commerciaux typeCommerciaux, String date) {
        this.prixFacture = prixFacture;
        this.remboDispo = remboDispo; //CRÉER LA MÉTHODE
        this.typeCommerciaux = typeCommerciaux;
        this.date = date;
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

    public Commerciaux getTypeCommerciaux() {
        return typeCommerciaux;
    }

    public void setTypeCommerciaux(Commerciaux typeCommerciaux) {
        this.typeCommerciaux = typeCommerciaux;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Frais{" +
                "prixFacture=" + prixFacture +
                ", remboDispo=" + remboDispo +
                ", typeCommerciaux=" + typeCommerciaux +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Frais)) return false;
        Frais frais = (Frais) o;
        return Double.compare(frais.getPrixFacture(), getPrixFacture()) == 0 && Double.compare(frais.getRemboDispo(), getRemboDispo()) == 0 && Objects.equals(getTypeCommerciaux(), frais.getTypeCommerciaux()) && Objects.equals(getDate(), frais.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrixFacture(), getRemboDispo(), getTypeCommerciaux(), getDate());
    }

    public void calculerLimiteMensuel() {
    }

    public void validerMontant() {
    }

    public void validerMontantRemo() {
    }
}
