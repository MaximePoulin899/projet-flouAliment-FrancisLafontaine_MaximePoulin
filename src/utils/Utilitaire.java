package utils;

import modele.Employe;
import modele.Frais;
import modele.RegistreFrais2;

import javax.swing.*;

public class Utilitaire {


    public static double calculRemboursementMaxHebergement(Employe emp, RegistreFrais2 listingFrais, Frais frais) {
        double montantRembourse = 0;

        switch (emp.getType()) {

            case "junior":
                double remboDispoTotal = 1200;
                double montantUtilise = 0;
                double montantUtilisePrealable =0;

                montantUtilise += frais.getPrixFacture();



                for (Frais tmp : listingFrais.getRegistreFrais2()) {
                    if (frais.getDate().getMonth() == tmp.getDate().getMonth()
                            && frais.getDate().getYear() == tmp.getDate().getYear()) {
                        montantUtilisePrealable += tmp.getPrixFacture();
                    }
                }






//                   if (remboDispoTotal > montantUtilise){
//                    montantRembourse = frais.getPrixFacture();
//                } else if (remboDispoTotal < montantUtilise){
//                    montantRembourse = montantUtilisePrealable - remboDispoTotal;
//                    JOptionPane.showMessageDialog(null, "Remboursement disponible dépassé.\n Voici le montant auquel " + emp.getPrenom() + " " + emp.getNom() + " aura droit: " + montantRembourse,
//                            "Saisie de valeurs",
//                            JOptionPane.ERROR_MESSAGE);
//                }


//                remboDispo = remboDispoTotal - montantUtilise;
//                if (remboDispo < 0) {
//                    remboDispo = 0;
//                }



                if (montantUtilise > remboDispoTotal || frais.getPrixFacture() > remboDispoTotal) {

                    JOptionPane.showMessageDialog(null, "Remboursement disponible dépassé.\n Voici le montant auquel " + emp.getPrenom() + " " + emp.getNom() + " aura droit: " + montantRembourse,
                            "Saisie de valeurs",
                            JOptionPane.ERROR_MESSAGE);
                }




                break;
            case "senior":
                montantRembourse = 1600;
                break;
            case "super":
                montantRembourse = 3000;
                break;
        }
        return montantRembourse;

    }

    public static double calculRemboursementMaxRestaurant(Employe emp) {
        double remboDispo = 0;

        switch (emp.getType()) {
            case "junior":
                remboDispo = 25;
                break;
            case "senior":
                remboDispo = 40;
                break;
            case "super":
                remboDispo = 60;
                break;
        }
        return remboDispo;
    }

    public static double calculRemboursementMaxTransport(Employe emp) {
        double remboDispo = 0;

        switch (emp.getType()) {
            case "junior":
                remboDispo = 50;
                break;
            case "senior":
                remboDispo = 80;
                break;
            case "super":
                remboDispo = 150;
                break;
        }
        return remboDispo;
    }

    public static double calculRemboursementMaxTransportAvion(Employe emp) {
        double remboDispoMois = 2000;

        return remboDispoMois;
    }

}