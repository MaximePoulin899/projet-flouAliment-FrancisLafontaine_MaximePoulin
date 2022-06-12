package utils;

import modele.Employe;
import modele.Frais;

public class Utilitaire {


    public static double calculRemboursementMaxHebergement(Employe emp) {
        double remboDispo = 0;

        switch (emp.getType()) {
            case "junior":
                remboDispo = 1200;
                break;
            case "senior":
                remboDispo = 1600;
                break;
            case "super":
                remboDispo = 3000;
                break;
        }
        return remboDispo;

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