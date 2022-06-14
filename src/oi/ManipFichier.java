package oi;

import modele.Employe;
import modele.RegistreEmploye;
import utils.EmployeDejaEmployeException;

import javax.swing.*;
import java.io.*;

public class ManipFichier {
    public static void lecture(String fichier, RegistreEmploye listing) {

        File file = new File(fichier);

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            //lecture
            String ligne;
            while ((ligne = br.readLine()) != null) {
                //Transformer une ligne en objet de type employe
                Employe employe = parserLigne(ligne);
                //ajouter dans le registre
                try {
                    listing.ajouterEmploye(employe);
                } catch (EmployeDejaEmployeException e) {
                    JOptionPane.showMessageDialog(null, e.getEmploye().toString(),"Erreur AJout",JOptionPane.ERROR_MESSAGE);
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static Employe parserLigne(String ligne) {
        String[] tokens =  ligne.split(";");
        String nom = (tokens[0]);
        String prenom = (tokens[1]);
        String type = (tokens[2]);



        return new Employe(nom, prenom, type);
    }

    public static void ecriture(String fichier, RegistreEmploye listing) {
        File file = new File(fichier);
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
//ecriture
            for (Employe employe : listing.getRegistre()){
                //transformer article en string
                String ligne = formerLigne(employe);//serialisation
                bw.write(ligne);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String formerLigne(Employe employe) {
        return employe.getNom() + ";"+employe.getPrenom()+";"+ employe.getType();
    }
}
