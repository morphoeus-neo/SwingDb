/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingdb;

import fr.aurelien.swingDB.frame.LoginFrame;

/**
 *
 * @author formation
 */
public class SwingDb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instanciation de la fenetre de Login
        LoginFrame app = new LoginFrame();
        //Affichage de la fenêtre
        app.setVisible(true);
        // Centrage de la fenetre sur L'écran
        app.setLocationRelativeTo(null);
        
    }
    
}
