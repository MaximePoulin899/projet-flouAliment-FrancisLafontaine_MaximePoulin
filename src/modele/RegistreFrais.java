package modele;


import utils.ExceptionFraisExisteDeja;

import javax.swing.*;
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

//    public void ajouterFrais(Frais frais) throws ExceptionFraisExisteDeja {
//        if (validerDoublonFrais(frais)){
//            System.out.println("Erreur");
//            throw new ExceptionFraisExisteDeja("Un frais doublon trouvé", frais);
//        }else {
//            JOptionPane.showMessageDialog(null,"Ajout du frais de votre employé avec succès ","Edition", JOptionPane.INFORMATION_MESSAGE);
//            System.out.println("good Frais");
//            this.registreFrais.add(frais);
//        }
//    }

    public void ajouterFrais2(Frais frais){
        this.registreFrais.add(frais);
    }

    public void supprimerFrais(Frais frais) {
        this.registreFrais.remove(frais);
    }

    public void listerFrais() {
        Iterator iterateur = registreFrais.iterator();
        while (iterateur.hasNext()){
            System.out.println(iterateur.next());
        }
    }


//
//    public String afficherFrais() {
//        StringBuilder sb = new StringBuilder();
//        for (Frais tmp : registreFrais  ) {
//
//        }
//    }
//
    public boolean validerDoublonFrais(Frais frais) {
        Iterator iterateur = registreFrais.iterator();
        while (iterateur.hasNext()){
            if(iterateur.equals(frais)){
                return true;
            }
        }
        return false;
    }
}
