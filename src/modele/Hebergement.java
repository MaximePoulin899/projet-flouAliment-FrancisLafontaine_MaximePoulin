package modele;

import java.util.Date;

public class Hebergement extends Frais{


    public Hebergement() {
    }


    public Hebergement(Employe employe, String typeFrais, double prixFacture, double remboDispo, Date date) {
        super(employe, typeFrais, prixFacture, remboDispo, date);
    }

    @Override
    public Employe getEmploye() {
        return super.getEmploye();
    }

    @Override
    public void setEmploye(Employe employe) {
        super.setEmploye(employe);
    }

    @Override
    public String getTypeFrais() {
        return super.getTypeFrais();
    }

    @Override
    public void setTypeFrais(String typeFrais) {
        super.setTypeFrais(typeFrais);
    }

    @Override
    public double getPrixFacture() {
        return super.getPrixFacture();
    }

    @Override
    public void setPrixFacture(double prixFacture) {
        super.setPrixFacture(prixFacture);
    }

    @Override
    public double getRemboDispo() {
        return super.getRemboDispo();
    }

    @Override
    public void setRemboDispo(double remboDispo) {
        super.setRemboDispo(remboDispo);
    }

    @Override
    public Date getDate() {
        return super.getDate();
    }

    @Override
    public void setDate(Date date) {
        super.setDate(date);
    }

    //    À voir si on a besoin de overide la méthode to String ---> C'EST UN TEST IÇI À VÉRIFIER ET NON FAIT DANS LES AUTRES CLASSES
    @Override
    public String toString() {
        return "Hebergement{" +super.toString();
    }

    @Override
    public void calculerLimiteMensuel() {

    }

    @Override
    public void validerMontant() {

    }

    @Override
    public void validerMontantRemo() {

    }
}
