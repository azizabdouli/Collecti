/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collecti.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import collecti.entity.Utilisateur;
import collecti.services.UtilisateurService;
import Collecti.tools.MaConnection;
import collecti.entity.Role;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.applet.Main;

/**
 *
 * @author Fayechi
 */
public class PiDev3A26 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {

       
     System.out.println("test");
    MaConnection ds1 = MaConnection.getInstance();
    System.out.println(ds1);
    // *********************test de l'ajout**********************************************
     /*
     String dateString = "11-12-2023";
     SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
try {
         java.util.Date utilDate = new SimpleDateFormat("dd-MM-yyyy").parse("11-12-2023");
java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
Utilisateur u = new Utilisateur("aaaaaaaa", "fffffffff", "uuuuuuuuu", "xzzzzzzzzz", "",1, sqlDate,5, false, true, Role.Admin);
    UtilisateurService se = new UtilisateurService();
    se.ajouter(u);
} catch (ParseException ex) {
    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
}
    
*/
//*********************************test de l'affichage ****************************************************************
/*UtilisateurService se = new UtilisateurService();
List<Utilisateur> utilisateurs = se.getAll();
utilisateurs.stream().map((u) -> {
    System.out.println("Id de l'utilisateur : " + u.getId());
    return u;
}).map((u) -> {
    System.out.println("Nom de l'utilisateur : " + u.getNom());
    return u;
}).map((u) -> {
    System.out.println("Prenom de l'utilisateur : " + u.getPrenom());
    return u;
}).map((u) -> {
    System.out.println("email de l'utilisateur : " + u.getEmail());
    return u;
}).map((u) -> {
    System.out.println("mot de passe de l'utilisateur : " + u.getPwd());
    return u;
}).map((u) -> {
    System.out.println("ProfilePic de l'utilisateur : " + u.getProfilePic());
    return u;
}).map((u) -> {
    System.out.println("numero de telp : " + u.getNumTel());
    return u;
}).map((u) -> {
    System.out.println("Votre date de naissance : " + u.getDateNaissance());
    return u;
}).map((u) -> {
    System.out.println("Votre solde : " + u.getSolde());
    return u;
}).map((u) -> {
    System.out.println("Verification email : " + u.isVerifiedEmail());
    return u;
}).map((u) -> {
    System.out.println("Verification mobile phone : " + u.isVerifiedPhone());
    return u;
}).forEachOrdered((u) -> {
    System.out.println("Role : " + u.getRole());
});*/
//fin test getall
//// ******   test de findby id   **************


// Création d'un objet UtilisateurService

// Appel de la fonction findById avec un identifiant existant en base de données
// Vérification que l'utilisateur a bien été récupéré
/*if (!utilisateurs.isEmpty()) {
    Utilisateur utilisateur = utilisateurs.get(2);
    System.out.println("Nom de l'utilisateur : " + utilisateur.getNom());
    System.out.println("Prenom de l'utilisateur : " + utilisateur.getPrenom());
} else {
    System.out.println("Utilisateur introuvable !");
}*/

   
   ///*************************** test de suppression****************************
  // se.delete(1);
   ///********************* test de Modifier*******************************
   UtilisateurService se = new UtilisateurService();
  int id = 5;
//Utilisateur userToUpdate = (Utilisateur) se.findById(id);
// Set the new values for the user
String nom = "New Name";
String prenom = "New Last Name";
String email = "new.email@example.com";
String pwd = "newpassword";
String profilePic = "https://example.com/newprofilepic.jpg";
int numTel = 123456789;
java.util.Date utilDate = new SimpleDateFormat("dd-MM-yyyy").parse("11-12-2023");
java.sql.Date dateNaissance = new java.sql.Date(utilDate.getTime());


//Date dateNaissance = Date.valueOf("2023-3-4");
int solde = 100;
boolean verifiedEmail = true;
boolean verifiedPhone = true;
Role role = Role.Admin;

// Retrieve the user to update


// Update the user's information
se.modifierUtilisateur(id, nom, prenom, email, pwd, profilePic, numTel, dateNaissance, solde, verifiedEmail, verifiedPhone, role);
}
    }


