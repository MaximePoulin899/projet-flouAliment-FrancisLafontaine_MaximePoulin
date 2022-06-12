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
        RegistreFrais2 listingFrais = new RegistreFrais2();

















        ManipFichier.lecture("src/data/dataIn.txt", listing);//----------------------cela fonctionne a date si tu as le fichier dans ton ordinateur
        //-----------------------------------------------------------------------------il va falloir que je cherche pour faire passe un chemin relatif







        //Creer listing Frais















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
