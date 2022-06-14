package modele;

import utils.EmployeDejaEmployeException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class RegistreEmploye {
    private TreeSet<Employe> registre;

    public RegistreEmploye() {
        this.registre = new TreeSet<>(new EmployeComparator());//------------------fair un choix comparator ou comparable
    }

    public TreeSet<Employe> getRegistre() {
        return registre;
    }

    public void setRegistre(TreeSet<Employe> registre) {
        this.registre = registre;
    }

    public void ajouterEmploye(Employe employe) throws EmployeDejaEmployeException {

        if (validerEmp(employe)){//----------------------------il faut vérifier si il existe déja dans la liste
            System.out.println("Erreur");
            throw new EmployeDejaEmployeException("Un employé doublon trouvé ", employe);
        }else{
            JOptionPane.showMessageDialog(null, "Ajout d'un employé avec succès",
                    "Edition", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Good");
            this.registre.add(employe);

        }












    }

    private boolean validerEmp(Employe employe) {
        for (Employe temp : registre
             ) {
            if (temp.equals(employe)){
                return true;
            }
        }
        return false;
    }
    public void listerEmployes(){
        for (Employe tmp : registre
             ) {
            System.out.println(tmp);
        }
    }




    public String afficherEmploye() {
        StringBuilder sb = new StringBuilder();
        for (Employe tmp : registre){
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

    public void supprimerEmploye(Employe emp) {
        registre.remove(emp);
    }


}
