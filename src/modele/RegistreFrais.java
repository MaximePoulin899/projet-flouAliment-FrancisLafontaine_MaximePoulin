package modele;


import utils.ExceptionFraisExisteDeja;
import javax.swing.*;
import java.util.TreeSet;

public class RegistreFrais {
    public TreeSet<Frais> registreFrais;

    public RegistreFrais() {
        this.registreFrais = new TreeSet<>(new FraisComparator());
    }

    public TreeSet<Frais> getRegistreFrais() {
        return registreFrais;
    }

    public void setRegistreFrais(TreeSet<Frais> registreFrais) {
        this.registreFrais = registreFrais;
    }

    public void ajouterFrais(Frais frais) throws ExceptionFraisExisteDeja {
        if (validerDoublonFrais(frais)) {
            System.out.println("Erreur");
            throw new ExceptionFraisExisteDeja("Un frais doublon trouvé", frais);
        } else {
            JOptionPane.showMessageDialog(null, "Ajout du frais de votre employé avec succès ", "Edition", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("good Frais");
            this.registreFrais.add(frais);
        }
    }



    public void supprimerFrais(Frais frais) {
        this.registreFrais.remove(frais);
    }

    public void listerFrais() {
        for (Frais tmp : registreFrais) {
            System.out.println(tmp);
        }
    }


    //
//    public String afficherFrais() {
//        }
//    }
//
    public boolean validerDoublonFrais(Frais frais) {
        for (Frais tmp : registreFrais) {
            if (tmp.equals(frais)) {
                return true;
            }
        }
        return false;
    }
}
