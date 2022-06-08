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
        /**
         * Avec Boucle if
         */
//        if (emp.getType().equalsIgnoreCase("junior")) {
//            return 1200;
//        } else if (emp.getType().equalsIgnoreCase("senior")) {
//            return 1600;
//        } else if (emp.getType().equalsIgnoreCase("super")) {
//            return 3000;
//        } else {
//            return 0;
//        }
//        }
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

}