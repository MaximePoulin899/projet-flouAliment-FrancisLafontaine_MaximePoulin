package oi;


import modele.Employe;
import modele.Frais;

import modele.RegistreEmploye;
import modele.RegistreFrais2;
import utils.ExceptionEmployeDejaEmploye;


import javax.swing.*;
import java.io.*;

public class ManipFichierFrais {

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
                //Transformer une ligne en objet de type article
                Employe employe = parserLigne(ligne);
                //ajouter dans le registre ArrayList

            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Employe parserLigne(String ligne) {
        String[] tokens =  ligne.split(" ");
        String nom = (tokens[0]);
        String prenom = (tokens[1]);
        String type = (tokens[2]);
        double montantTransport = Double.parseDouble((tokens[3]));
        double montantHebergement = Double.parseDouble((tokens[4]));
        double montantRestaurant = Double.parseDouble((tokens[5]));

        return new Employe(tokens[0], prenom, type,montantTransport,montantHebergement,montantRestaurant);
    }


    public static void ecriture(String fichier, RegistreFrais2 listingFrais) {
        File file = new File(fichier);
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            //ecriture
            for (Frais Frais : listingFrais.getRegistreFrais2()) {
                //transformer article en string
                String ligne = formerLigne(Frais);//serialisation
                bw.write(ligne);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String formerLigne(Frais frais) {
        return frais.getEmploye().getNom() + ";" + frais.getEmploye().getPrenom() + ";" + frais.getEmploye().getType() + ";" + frais.getTypeFrais() + ";" + frais.getPrixFacture() + ";" + frais.getRemboDispo() + ";" + frais.getDate() + "\n";
    }
}
