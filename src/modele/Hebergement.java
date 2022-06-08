package modele;

public class Hebergement extends Frais{


    public Hebergement() {
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
    public Commerciaux getTypeCommerciaux() {
        return super.getTypeCommerciaux();
    }

    @Override
    public void setTypeCommerciaux(Commerciaux typeCommerciaux) {
        super.setTypeCommerciaux(typeCommerciaux);
    }

    @Override
    public String getDate() {
        return super.getDate();
    }

    @Override
    public void setDate(String date) {
        super.setDate(date);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
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
