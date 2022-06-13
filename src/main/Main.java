package main;

import modele.*;
import oi.ManipFichier;
import oi.ManipFichierFrais;
import ui.FenMenu;
import utils.ExceptionFraisExisteDeja;
import utils.Utilitaire;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Main {


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

//---------------------------------------------------------------création registre employ
        RegistreEmploye listing = new RegistreEmploye();
        //---------------------------------------------------------------Creer listing Frais
        RegistreFrais2 listingFrais = new RegistreFrais2();

        //---------------------------------------------------------------Entrer des employés
        ManipFichier.lecture("src/data/dataIn.txt", listing);
//        ManipFichierFrais.lecture("src/data/dataFraisIn", listingFrais);


        Employe empJunior = new Employe("Pou", "Max", "junior");



        Hebergement hebergement1 = new Hebergement(empJunior, "Hebergement", 1000, LocalDate.of(2022, 1, 01));
        hebergement1.setRemboDispo(Utilitaire.calculRemboursementMaxHebergement(empJunior, listingFrais, hebergement1));


        Transport transport = new Transport(empJunior, "Transport", 200, LocalDate.now());
        transport.setRemboDispo(Utilitaire.calculRemboursementMaxTransport(empJunior, listingFrais, transport));

        try {
            listingFrais.ajouterFrais2(hebergement1);
        } catch (ExceptionFraisExisteDeja e) {
            JOptionPane.showMessageDialog(null, "Erreur! Frais en double\n", "Erreur Ajout Frais", JOptionPane.ERROR_MESSAGE);
        }

        try {
            listingFrais.ajouterFrais2(transport);
        } catch (ExceptionFraisExisteDeja e) {
            JOptionPane.showMessageDialog(null, "Erreur! Frais en double\n", "Erreur Ajout Frais", JOptionPane.ERROR_MESSAGE);
        }


//        String resultat = ManipFichierFrais.lecture2("src/data/dataTestIn.txt");
//
//
//        System.out.println(resultat);
//
//
//        ManipFichierFrais.ecriture2("src/data/dataTestOut.txt", resultat);









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
