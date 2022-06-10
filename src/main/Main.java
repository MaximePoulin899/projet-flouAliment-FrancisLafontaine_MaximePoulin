package main;

import modele.*;
import oi.ManipFichier;
import ui.FenMenu;
import utils.ExceptionEmployeDejaEmploye;
import utils.Utilitaire;

import javax.swing.*;
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
            JOptionPane.showMessageDialog(null, e.getEmploye().toString(),"Erreur AJout",JOptionPane.ERROR_MESSAGE);
        }


        try {
            listing.ajouterEmploye(employ5);//-------------------------on essaie d'ajout un doublon
        } catch (ExceptionEmployeDejaEmploye e) {
            System.out.println(e.getEmploye().toString());
            JOptionPane.showMessageDialog(null, e.getEmploye().toString(),"Erreur AJout",JOptionPane.ERROR_MESSAGE);
        }


        try {
            listing.ajouterEmploye(employ2);
        } catch (ExceptionEmployeDejaEmploye e) {
            JOptionPane.showMessageDialog(null, e.getEmploye().toString(),"Erreur AJout",JOptionPane.ERROR_MESSAGE);
        }


        try {
            listing.ajouterEmploye(employ3);
        } catch (ExceptionEmployeDejaEmploye e) {
            JOptionPane.showMessageDialog(null, e.getEmploye().toString(),"Erreur AJout",JOptionPane.ERROR_MESSAGE);
        }


        try {
            listing.ajouterEmploye(employ4);
        } catch (ExceptionEmployeDejaEmploye e) {
            JOptionPane.showMessageDialog(null, e.getEmploye().toString(),"Erreur AJout",JOptionPane.ERROR_MESSAGE);
        }

        ManipFichier.lecture("c:\\temporaire\\dataIn.txt", listing);


        listing.listerEmployes();


        //----------------Test des RemboDispo Hebergement/Restaurant/Transport-------------------
//        Date date = new Date();
//        Employe empJunior = new Employe("Frank", "Boy", "junior");
//        Employe empSenior = new Employe("Max", "Boy", "senior");
//        Employe empSuper= new Employe("King", "Pin", "super");
//        Hebergement hebergement1 = new Hebergement(empJunior,"Hebergement",100,date);
//        Hebergement hebergement2 = new Hebergement(empSenior,"Hebergement",100,date);
//        Hebergement hebergement3 = new Hebergement(empSuper,"Hebergement",100,date);
//        hebergement1.setRemboDispo(Utilitaire.calculRemboursementMaxHebergement(empJunior));
//        hebergement2.setRemboDispo(Utilitaire.calculRemboursementMaxHebergement(empSenior));
//        hebergement3.setRemboDispo(Utilitaire.calculRemboursementMaxHebergement(empSuper));
//
//        Transport transport = new Transport(empJunior,"Transport",100,date);
//        transport.setRemboDispo(Utilitaire.calculRemboursementMaxTransport(empJunior));
//
//        Restauration restauration = new Restauration(empSenior,"Restauration",100,date);
//        restauration.setRemboDispo(Utilitaire.calculRemboursementMaxRestaurant(empSenior));
//
//        System.out.println(hebergement1);
//        System.out.println(hebergement2);
//        System.out.println(hebergement3);
//        System.out.println(transport);
//        System.out.println(restauration);


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
                new FenMenu(listing).setVisible(true);
            }
        });
    }
    
    
    
    
    
}
