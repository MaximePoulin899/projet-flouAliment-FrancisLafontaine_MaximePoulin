package utils;

import modele.Employe;
import modele.Frais;
import modele.RegistreFrais2;

import javax.swing.*;

public class Utilitaire {


    public static double calculRemboursementMaxHebergement(Employe emp, RegistreFrais2 listingFrais, Frais frais) {
        double montantRembourse = 0;
        double montantUtilisePrealable = 0;
        double remboDispoTotal = 0;

        switch (emp.getType()) {
            case "junior":
                remboDispoTotal = 1200;

                montantUtilisePrealable = calculerMontantUtiliseMois(listingFrais, frais, montantUtilisePrealable, emp);

                montantRembourse = caculerMontantRembourse(montantUtilisePrealable, remboDispoTotal, emp, frais);

                break;
            case "senior":
                remboDispoTotal = 1600;

                montantUtilisePrealable = calculerMontantUtiliseMois(listingFrais, frais, montantUtilisePrealable, emp);

                montantRembourse = caculerMontantRembourse(montantUtilisePrealable, remboDispoTotal, emp, frais);
                break;
            case "super":
                remboDispoTotal = 3000;

                montantUtilisePrealable = calculerMontantUtiliseMois(listingFrais, frais, montantUtilisePrealable, emp);

                montantRembourse = caculerMontantRembourse(montantUtilisePrealable, remboDispoTotal, emp, frais);

                break;
        }
        return montantRembourse;
    }


    public static double calculRemboursementMaxRestaurant(Employe emp, RegistreFrais2 listingFrais, Frais frais) {
        double montantRembourse = 0;
        double montantUtilisePrealable = 0;
        double remboDispoTotal;

        switch (emp.getType()) {
            case "junior":
                remboDispoTotal = 25;

                montantUtilisePrealable = calculerMontantUtiliseJour(listingFrais, frais, montantUtilisePrealable, emp);

                montantRembourse = caculerMontantRembourse(montantUtilisePrealable, remboDispoTotal, emp, frais);

                break;
            case "senior":
                remboDispoTotal = 40;

                montantUtilisePrealable = calculerMontantUtiliseJour(listingFrais, frais, montantUtilisePrealable, emp);

                montantRembourse = caculerMontantRembourse(montantUtilisePrealable, remboDispoTotal, emp, frais);
                break;


            case "super":
                remboDispoTotal = 60;

                montantUtilisePrealable = calculerMontantUtiliseJour(listingFrais, frais, montantUtilisePrealable, emp);

                montantRembourse = caculerMontantRembourse(montantUtilisePrealable, remboDispoTotal, emp, frais);
                break;
        }
        return montantRembourse;
    }


    public static double calculRemboursementMaxTransport(Employe emp, RegistreFrais2 listingFrais, Frais frais) {
        double montantRembourse = 0;
        double montantUtilisePrealable = 0;
        double remboDispoTotal;

        switch (emp.getType()) {
            case "junior":
                remboDispoTotal = 50;

                montantUtilisePrealable = calculerMontantUtiliseJour(listingFrais, frais, montantUtilisePrealable, emp);

                montantRembourse = caculerMontantRembourse(montantUtilisePrealable, remboDispoTotal, emp, frais);


                break;
            case "senior":
                remboDispoTotal = 80;

                montantUtilisePrealable = calculerMontantUtiliseJour(listingFrais, frais, montantUtilisePrealable, emp);

                montantRembourse = caculerMontantRembourse(montantUtilisePrealable, remboDispoTotal, emp, frais);

                break;
            case "super":
                remboDispoTotal = 150;

                montantUtilisePrealable = calculerMontantUtiliseJour(listingFrais, frais, montantUtilisePrealable, emp);

                montantRembourse = caculerMontantRembourse(montantUtilisePrealable, remboDispoTotal, emp, frais);

                break;
        }
        return montantRembourse;
    }

    public static double calculRemboursementMaxTransportAvion(Employe emp) {
        double remboDispoMois = 2000;

        return remboDispoMois;
    }


    /**
     *
     * @param listingFrais
     * @param frais
     * @param montantUtilisePrealable
     * @param emp
     * @return Le montant utilié au préalable par l'employé dans l'espace temps de un mois
     */
    private static double calculerMontantUtiliseMois(RegistreFrais2 listingFrais, Frais frais, double montantUtilisePrealable, Employe emp) {
        for (Frais tmp : listingFrais.getRegistreFrais2()) {
            if (frais.getDate().getYear() == tmp.getDate().getYear()
                    && frais.getDate().getMonth() == tmp.getDate().getMonth()) {
                montantUtilisePrealable += tmp.getPrixFacture();
            }
        }
        return montantUtilisePrealable;
    }

    /**
     *
     * @param listingFrais
     * @param frais
     * @param montantUtilisePrealable
     * @param emp
     * @return Le montant utilié au préalable par l'employé dans l'espace temps de un jour
     */
    private static double calculerMontantUtiliseJour(RegistreFrais2 listingFrais, Frais frais, double montantUtilisePrealable, Employe emp) {
        for (Frais tmp : listingFrais.getRegistreFrais2()) {
            if (frais.getDate().getYear() == tmp.getDate().getYear()
                    && frais.getDate().getMonth() == tmp.getDate().getMonth()
                    &&frais.getDate().getDayOfMonth() == tmp.getDate().getDayOfMonth()) {
                montantUtilisePrealable += tmp.getPrixFacture();
            }
        }
        return montantUtilisePrealable;
    }

    /**
     *
     * @param montantUtilisePrealable
     * @param remboDispoTotal
     * @param emp
     * @param frais
     * @return Calcule le montant à remboursé selon le type d'employé et renvoie un message pour avertir le comptable du montant à rembourser
     * // Je sais, cette fonction fait plus qu'une chose
     */
    private static double caculerMontantRembourse(double montantUtilisePrealable, double remboDispoTotal, Employe emp, Frais frais) {
        double montantRembourse = 0;
        if (montantUtilisePrealable > remboDispoTotal) {
            alertDepassementRemboursement(emp, montantRembourse);
            return montantRembourse = 0;
        } else if ((montantUtilisePrealable + frais.getPrixFacture()) > remboDispoTotal) {
            montantRembourse = remboDispoTotal - montantUtilisePrealable;
            alertDepassementRemboursement(emp, montantRembourse);
            return montantRembourse;
        } else
            return montantRembourse = frais.getPrixFacture();
    }

    /**
     * Afficher message d'avertissement
     * @param emp
     * @param montantRembourse
     */
    private static void alertDepassementRemboursement(Employe emp, double montantRembourse) {
        JOptionPane.showMessageDialog(null, "Remboursement disponible dépassé.\n Voici le montant auquel " + emp.getPrenom() + " " + emp.getNom() + " aura droit: " + montantRembourse,
                "Saisie de valeurs",
                JOptionPane.ERROR_MESSAGE);
    }

}