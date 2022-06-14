package oi;

import modele.*;
import modele.Frais;
import modele.RegistreFrais2;
import utils.FraisExisteDejaException;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ManipFichierFrais {


    public static void lecture(String fichier, RegistreFrais2 listingFrais) {

        File file = new File(fichier);

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            //lecture
            String ligne;
            while ((ligne = br.readLine()) != null) {
                //Transformer une ligne en objet de type frais

                Hebergement frais = parserLigne(ligne);
                //ajouter dans le registre

               // frais.setRemboDispo(Utilitaire.calculRemboursementMaxHebergement(new Employe("Pou", "Max", "super"), listingFrais, frais));

                try {
                    listingFrais.ajouterFrais2(frais);

                } catch (FraisExisteDejaException e) {
                    JOptionPane.showMessageDialog(null, e.getFrais().toString(), "Erreur AJout", JOptionPane.ERROR_MESSAGE);
                }
            }

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Pou;Max;junior; Transport;100.0;50.0;2022-04-18
//        Employe , String typeFrais, double prixFacture, LocalDate date)
    private static Hebergement parserLigne(String ligne) {


        String[] tokens = ligne.split(";");
        String nom = tokens[0];
        String prenom = tokens[1];//-------------------------------on dirait sa bloque ici------- Index 1 out of bounds for length 1
        String type = tokens[2];
        String typeFrais = tokens[3];
        double prixFacture = Double.parseDouble(tokens[4]);
        LocalDate date = LocalDate.parse(tokens[5], DateTimeFormatter.ISO_DATE);



        Employe emp = new Employe();
        emp.setNom(nom);
        emp.setPrenom(prenom);
        emp.setType(type);



        Hebergement test = new Hebergement(emp, typeFrais, prixFacture, date);


        return test;
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
