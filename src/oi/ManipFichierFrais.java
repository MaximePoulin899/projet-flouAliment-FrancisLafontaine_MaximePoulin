package oi;


import modele.Frais;

import modele.RegistreFrais2;


import java.io.*;

public class ManipFichierFrais {


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
