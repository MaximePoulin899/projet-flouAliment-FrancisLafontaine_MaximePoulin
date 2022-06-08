package modele;

import javax.swing.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class RegistreEmploye {
    private TreeSet<Employe> registre;

    public RegistreEmploye() {
        registre = new TreeSet<>(new EmployeComparator());//------------------fair un choix comparator ou comparable
    }

    public TreeSet<Employe> getRegistre() {
        return registre;
    }

    public void setRegistre(TreeSet<Employe> registre) {
        this.registre = registre;
    }

    public void ajouterEmploye(Employe employe) {
        registre.add(employe);
        JOptionPane.showMessageDialog(null, "Ajout d'un employé avec succès",
                "Edition", JOptionPane.INFORMATION_MESSAGE);
    }

    public String afficherEmploye() {
        StringBuilder sb = new StringBuilder();
        for (Employe tmp : registre
        ) {
            sb.append(tmp);
            sb.append("\n");
        }
        return sb.toString();
    }

    public ArrayList<Employe> rechercherEmploye(String motCle) {
        ArrayList<Employe> trouve = new ArrayList<>();

        for (Employe tmp : registre
        ) {
            if (tmp.getNom().equals(motCle)) {
                trouve.add(tmp);
            }
        }
        return trouve;
    }
//
//    public void supprimerCommerciaux() {
//    }
//

//
//    public void validerDoublonCommerciaux() {
//    }
}
