/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.aurelien.swingDB.frame;

import fr.aurelien.database.utils.DatabaseConnection;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author formation
 */
public class DatabaseTools {
    
    public static String sha1Encode(String text){
        String encoded = "";
        try {
            
            
            MessageDigest crypto = MessageDigest.getInstance("SHA1");
            crypto.reset();
            crypto.update(text.getBytes("UTF-8"));
           
            
            encoded = byteToHex(crypto.digest());
//            encoded = crypto.digest().toString();
            
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return encoded;
    }
    private static String byteToHex(byte[] byteArray){
        String result = "";
        
        Formatter f = new Formatter();
        for (byte b : byteArray) {
            f.format("%02x", b);
            
        }
        result =f.toString();
        return result;
    }
    public static int addAuthor(String prenom, String nom) throws SQLException {
        //Récuperation de la connexion
        Connection cn = DatabaseConnection.getInstance();

        String sql = "INSERT INTO auteurs (prenom, nom ) VALUES (?,?)";

        // Création de la requette préparée
        PreparedStatement pstm = cn.prepareStatement(sql);
        // Passage des valeurs
        pstm.setString(1, prenom);
        pstm.setString(2, nom);

        //Execution de la requette
        return pstm.executeUpdate();

    }
    public static int updateAuthor(String prenom, String nom, String id) throws SQLException {
        //Récuperation de la connexion
        Connection cn = DatabaseConnection.getInstance();

        String sql = "UPDATE auteurs SET nom=?, prenom=? WHERE id = ?";
        String sql2 = "WHERE id=?";
        
        

        // Création de la requette préparée
        PreparedStatement pstm = cn.prepareStatement(sql);
        // Passage des valeurs
        pstm.setString(1, prenom);
        pstm.setString(2, nom);
        pstm.setString(3, id);
        
        
        
        

        //Execution de la requette
        return pstm.executeUpdate();

    }
    //UPDATE `auteurs` SET `prenom` = 'Francky' WHERE `auteurs`.`id` = 38 
    public static int delAuthor(int id) throws SQLException {
        //Récuperation de la connexion
        Connection cn = DatabaseConnection.getInstance();

        String sql = "DELETE FROM auteurs WHERE id = ?";

        // Création de la requette préparée
        PreparedStatement pstm = cn.prepareStatement(sql);
        // Passage des valeurs
        pstm.setInt(1, id);

        //Execution de la requette
        return pstm.executeUpdate();

    }
    
}
