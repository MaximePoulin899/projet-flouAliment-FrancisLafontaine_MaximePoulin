package oi;

import modele.*;
import modele.Frais;
import modele.RegistreFrais2;
import utils.ExceptionFraisExisteDeja;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;

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

                Hebergement hebergement = parserLigne(ligne);
                //ajouter dans le registre
                try {
                    listingFrais.ajouterFrais2(hebergement);

                } catch (ExceptionFraisExisteDeja e) {
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
        String nom = (tokens[0]);
        String prenom = (tokens[1]);
        String type = (tokens[2]);
        String typeFrais = (tokens[3]);
        double prixFacture = Double.parseDouble((tokens[4]));
        System.out.println(nom+prenom+type+typeFrais+prixFacture);

        LocalDate date1 = parserTxtDate(tokens[5]);
        System.out.println(tokens[4]);
        System.out.println(date1);

        LocalDate date = LocalDate.parse((tokens[5]));//-------------------bloquer ici

//        System.out.println(nom+prenom+type+typeFrais+prixFacture+date);

        Employe emp = new Employe(nom, prenom, type);

//        if (typeFrais == "hebergement") {
//            new Hebergement(emp, typeFrais, prixFacture, date);
//        }else if(typeFrais == "transport"){
//            return new Transport(emp, typeFrais, prixFacture, date);
//        }else if (typeFrais == "restauration"){
//            return new Restauration(emp, typeFrais, prixFacture, date);
//        }


        return new Hebergement(emp, typeFrais, prixFacture,date);
    }

    private static LocalDate parserTxtDate(String text) {
        String[] tokens = text.split("-");
        int year = (Integer.parseInt(tokens[0]));
        System.out.println(year);
        int month = (Integer.parseInt(tokens[1]));//--------------- ici aussi sa bloque
        int day = (Integer.parseInt(tokens[2]));

        return LocalDate.of(year, month, day);

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

//    public static void lecture(String fichier, RegistreFrais2 listingFrais) {
//
//        File file = new File(fichier);
//
//        FileReader fr = null;
//        BufferedReader br = null;
//
//        try {
//            fr = new FileReader(file);
//            br = new BufferedReader(fr);
//            //lecture
//            String ligne;
//            while ((ligne = br.readLine()) != null) {
//                //Transformer une ligne en objet de type frais
//
//                Frais frais = parserLigne(ligne);
//                //ajouter dans le registre
//                try {
//                    listingFrais.ajouterFrais2(frais);
//                } catch (ExceptionFraisExisteDeja e) {
//                    JOptionPane.showMessageDialog(null, e.getFrais().toString(),"Erreur AJout",JOptionPane.ERROR_MESSAGE);
//                }
//
//            }
//            br.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
}
