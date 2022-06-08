package modele;

public class Transport extends Frais{

    public Transport() {
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
