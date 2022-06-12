package main;

import modele.*;
import oi.ManipFichier;
import ui.FenMenu;
import utils.ExceptionEmployeDejaEmploye;
import utils.ExceptionFraisExisteDeja;
import utils.Utilitaire;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class Main {
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        RegistreEmploye listing = new RegistreEmploye();

        Employe employ1 = new Employe("Flouflou", "Alain", "junior",0.0,0.0,0.0);
        Employe employ5 = new Employe("Flouflou", "Alain", "junior",0.0,0.0,0.0);
        Employe employ2 = new Employe("Lafleur", "Ti-Guy", "senior",0.0,0.0,0.0);
        Employe employ3 = new Employe("Dicoco", "Sergio", "super",0.0,0.0,0.0);
        Employe employ4 = new Employe("Barrest", "Manon", "junior",0.0,0.0,0.0);



        try {
            listing.ajouterEmploye(employ1);
        } catch (ExceptionEmployeDejaEmploye e) {
            JOptionPane.showMessageDialog(null,"Erreur sur employé, en double ! \n" + e.getEmploye().toString(),"Erreur AJout",JOptionPane.ERROR_MESSAGE);
        }


        try {
            listing.ajouterEmploye(employ5);//-------------------------on essaie d'ajout un doublon
        } catch (ExceptionEmployeDejaEmploye e) {
            System.out.println(e.getEmploye().toString());
            JOptionPane.showMessageDialog(null,"Erreur sur employé, en double ! \n" + e.getEmploye().toString(),"Erreur AJout",JOptionPane.ERROR_MESSAGE);
        }


        try {
            listing.ajouterEmploye(employ2);
        } catch (ExceptionEmployeDejaEmploye e) {
            JOptionPane.showMessageDialog(null,"Erreur sur employé, en double ! \n" + e.getEmploye().toString(),"Erreur AJout",JOptionPane.ERROR_MESSAGE);
        }


        try {
            listing.ajouterEmploye(employ3);
        } catch (ExceptionEmployeDejaEmploye e) {
            JOptionPane.showMessageDialog(null,"Erreur sur employé, en double ! \n" + e.getEmploye().toString(),"Erreur AJout",JOptionPane.ERROR_MESSAGE);
        }


        try {
            listing.ajouterEmploye(employ4);
        } catch (ExceptionEmployeDejaEmploye e) {
            JOptionPane.showMessageDialog(null,"Erreur sur employé, en double ! \n" + e.getEmploye().toString(),"Erreur AJout",JOptionPane.ERROR_MESSAGE);
        }

        ManipFichier.lecture("src/data/dataIn.txt", listing);//----------------------cela fonctionne a date si tu as le fichier dans ton ordinateur
        //-----------------------------------------------------------------------------il va falloir que je cherche pour faire passe un chemin relatif

        listing.listerEmployes();


        //----------------Test des RemboDispo Hebergement/Restaurant/Transport-------------------

        Employe empJunior = new Employe("Frank", "Boy", "junior",0,0,0);
        Employe empSenior = new Employe("Max", "Boy", "senior",0,0,0);
        Employe empSuper= new Employe("King", "Pin", "super",0,0,0);
        Employe empSuper2= new Employe("Queen", "Pin", "super",0,0,0);
        Hebergement hebergement1 = new Hebergement(empJunior,"Hebergement",100,LocalDate.of(2021,3,25));
        LocalDate date2;
        Hebergement hebergement2 = new Hebergement(empSenior,"Hebergement",100, LocalDate.now());
        Hebergement hebergement3 = new Hebergement(empSuper,"Hebergement",100,LocalDate.now());
        Hebergement hebergement4 = new Hebergement(empSuper2,"Hebergement",100,LocalDate.now());

        // Creation de frais et test de rembo dispo
        hebergement1.setRemboDispo(Utilitaire.calculRemboursementMaxHebergement(empJunior));
        hebergement2.setRemboDispo(Utilitaire.calculRemboursementMaxHebergement(empSenior));
        hebergement3.setRemboDispo(Utilitaire.calculRemboursementMaxHebergement(empSuper));
        hebergement4.setRemboDispo(Utilitaire.calculRemboursementMaxHebergement(empSuper2));
        Transport transport = new Transport(empJunior,"Transport",100,LocalDate.now());
        transport.setRemboDispo(Utilitaire.calculRemboursementMaxTransport(empJunior));
        Restauration restauration = new Restauration(empSenior,"Restauration",100,LocalDate.now());
        restauration.setRemboDispo(Utilitaire.calculRemboursementMaxRestaurant(empSenior));


//        System.out.println(hebergement1);
//        System.out.println(hebergement2);
//        System.out.println(hebergement3);
//        System.out.println(transport);
//        System.out.println(restauration);


        //Creer listing Frais
        RegistreFrais2 listingFrais = new RegistreFrais2();

//       //  ajouter facture
        try {
            listingFrais.ajouterFrais2(transport);
        } catch (ExceptionFraisExisteDeja e) {
            JOptionPane.showMessageDialog(null,"Erreur! Frais en double\n","Erreur Ajout Frais",JOptionPane.ERROR_MESSAGE);
        }

        try {
            listingFrais.ajouterFrais2(transport);
        } catch (ExceptionFraisExisteDeja e) {
            JOptionPane.showMessageDialog(null,"Erreur! Frais en double\n","Erreur Ajout Frais",JOptionPane.ERROR_MESSAGE);
        }


        try {
            listingFrais.ajouterFrais2(hebergement2);
        } catch (ExceptionFraisExisteDeja e) {
            JOptionPane.showMessageDialog(null,"Erreur! Frais en double\n","Erreur Ajout Frais",JOptionPane.ERROR_MESSAGE);
        }

        try {
            listingFrais.ajouterFrais2(restauration);
        } catch (ExceptionFraisExisteDeja e) {
            JOptionPane.showMessageDialog(null,"Erreur! Frais en double\n","Erreur Ajout Frais",JOptionPane.ERROR_MESSAGE);
        }

        try {
            listingFrais.ajouterFrais2(hebergement1);
        } catch (ExceptionFraisExisteDeja e) {
            JOptionPane.showMessageDialog(null,"Erreur! Frais en double\n","Erreur Ajout Frais",JOptionPane.ERROR_MESSAGE);
        }

        try {
            listingFrais.ajouterFrais2(hebergement3);
        } catch (ExceptionFraisExisteDeja e) {
            JOptionPane.showMessageDialog(null,"Erreur! Frais en double\n","Erreur Ajout Frais",JOptionPane.ERROR_MESSAGE);
        }

        try {
            listingFrais.ajouterFrais2(hebergement4);
        } catch (ExceptionFraisExisteDeja e) {
            JOptionPane.showMessageDialog(null,"Erreur! Frais en double\n","Erreur Ajout Frais",JOptionPane.ERROR_MESSAGE);
        }




        //Afficher Frais
        System.out.println("\n--------------Afficher Frais-------------------\n");
        listingFrais.listerFrais();



        //----------------Test des RemboDispo Hebergement/Restaurant/Transport-------------------






        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenMenu(listing, listingFrais).setVisible(true);

            }
        });
    }
    
    
    
    
    
}
