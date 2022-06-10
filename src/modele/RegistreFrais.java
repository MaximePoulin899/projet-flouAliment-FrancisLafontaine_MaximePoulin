package modele;


import java.time.chrono.HijrahEra;
import java.util.Iterator;
import java.util.TreeSet;

public class RegistreFrais {
    public TreeSet registreFrais;

    public RegistreFrais() {
        this.registreFrais = new TreeSet<>(new FraisComparator());
    }

    public TreeSet getRegistreFrais() {
        return registreFrais;
    }

    public void setRegistreFrais(TreeSet registreFrais) {
        this.registreFrais = registreFrais;
    }

    public void ajouterFrais(Frais frais) {
        this.registreFrais.add(frais);
    }

    public void listerFrais() {
        Iterator iterateur = registreFrais.iterator();
        while (iterateur.hasNext()){
            System.out.println(iterateur.next());
        }
    }

    public void supprimerFrais(Frais frais) {
        this.registreFrais.remove(frais);
    }


//
//    public String afficherFrais() {
//        StringBuilder sb = new StringBuilder();
//        for (Frais tmp : registreFrais  ) {
//
//        }
//
//    }
//
//    public void validerDoublonFrais() {
//    }

}
