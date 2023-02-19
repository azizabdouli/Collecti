/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collecti.services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import collecti.entity.Utilisateur;
import tn.esprit.services.InterfaceService;
import Collecti.tools.MaConnection;
import static Collecti.tools.MaConnection.ct;
import collecti.entity.Role;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fayechi
 */
public class UtilisateurService implements InterfaceService<Utilisateur> {

    Connection cnx;

    public UtilisateurService() {
        cnx = MaConnection.getInstance().getCnx();
    }

    @Override
    public void ajouter(Utilisateur u) {
        try {
            String sql = "INSERT INTO `utilisateur`(nom,prenom,email,pwd,profilePic,numTel,dateNaissance,solde,verifiedEmail,verifiedPhone,Role) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ste = cnx.prepareStatement(sql);
           
            ste.setString(1, u.getNom());
            ste.setString(2, u.getPrenom());
            ste.setString(3, u.getEmail());
            ste.setString(4,u.getPwd());
            ste.setString(5, u.getProfilePic());
            ste.setInt(6, u.getNumTel());
            ste.setDate(7, (Date) u.getDateNaissance());
            ste.setInt(8,u.getSolde());
            ste.setBoolean(9, true);
            ste.setBoolean(10, false);
            ste.setString(11, u.getRole().name());
            ste.executeUpdate();
            System.out.println("Utilisateur ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
  
    public List<Utilisateur> getAll() {
    List<Utilisateur> utilisateurs = new ArrayList<>();
    String requete = "select * from utilisateur";
    try {
        PreparedStatement pst = cnx.prepareStatement(requete);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Utilisateur u = new Utilisateur();
            u.setId(rs.getInt("id"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            u.setEmail(rs.getString("email"));
            u.setPwd(rs.getString("pwd"));
            u.setProfilePic(rs.getString("profilePic"));
            u.setNumTel(rs.getInt("numTel"));
            u.setDateNaissance(rs.getDate("dateNaissance"));
            u.setSolde(rs.getInt("solde"));
            u.setVerifiedEmail(rs.getBoolean("verifiedEmail"));
            u.setVerifiedPhone(rs.getBoolean("verifiedPhone"));
            u.setRole(Role.valueOf(rs.getString("role")));
            utilisateurs.add(u);
        }
    } catch (SQLException ex) {
        Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return utilisateurs;
}

    @Override
    public List<Utilisateur> findById(int id) {
    List<Utilisateur> utilisateurs = new ArrayList<>();
    String requete = "select * from utilisateur where id = ?";
    try {
        PreparedStatement pst = cnx.prepareStatement(requete);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Utilisateur u = new Utilisateur();
            u.setId(rs.getInt("id"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            u.setEmail(rs.getString("email"));
            u.setPwd(rs.getString("pwd"));
            u.setProfilePic(rs.getString("profilePic"));
            u.setNumTel(rs.getInt("numTel"));
            u.setDateNaissance(rs.getDate("dateNaissance"));
            u.setSolde(rs.getInt("solde"));
            u.setVerifiedEmail(rs.getBoolean("verifiedEmail"));
            u.setVerifiedPhone(rs.getBoolean("verifiedPhone"));
            u.setRole(Role.valueOf(rs.getString("role")));
            utilisateurs.add(u);
        }
    } catch (SQLException ex) {
        Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return utilisateurs;
}
////// **********             Supprimer                 ****************
      public void delete(int id) {
    String requete = "DELETE FROM utilisateur WHERE id = ?";
    try {
        PreparedStatement pst = cnx.prepareStatement(requete);
        pst.setInt(1, id);
        pst.executeUpdate();
        System.out.println("Utilisateur supprimé avec succès !");
    } catch (SQLException ex) {
        Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
    }
}

///////// ***      Modifier **************
      
      
  public void modifierUtilisateur(int id, String nom, String prenom, String email, String pwd, String profilePic, int numTel, Date dateNaissance, int solde, boolean verifiedEmail, boolean verifiedPhone, Role role) {
    Utilisateur u = new Utilisateur(id, nom, prenom, email, pwd, profilePic, numTel, dateNaissance, solde, verifiedEmail, verifiedPhone, role);
    String sql = "UPDATE utilisateur SET nom = ?, prenom = ?, email = ?, pwd = ?, profilePic = ?, numTel = ?, dateNaissance = ?, solde = ?, verifiedEmail = ?, verifiedPhone = ?, role = ? WHERE id = ?";
    try {
        PreparedStatement ste = cnx.prepareStatement(sql);
        ste.setString(1, nom);
        ste.setString(2, prenom);
        ste.setString(3, email);
        ste.setString(4, pwd);
        ste.setString(5, profilePic);
        ste.setInt(6, numTel);
        java.sql.Date sqlDate = new java.sql.Date(dateNaissance.getTime());
        ste.setDate(7,sqlDate);
        ste.setInt(8, solde);
        ste.setBoolean(9, verifiedEmail);
        ste.setBoolean(10, verifiedPhone);
        ste.setString(11, u.getRole().name());
        ste.setInt(12, id);
        ste.executeUpdate();
        System.out.println("Utilisateur modifié avec succès !");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}


   /* public void modifierUtilisateur(int i, String durand, String paul, String pauldurandexamplecom, String password, String photojpg, int i0, String string, int i1, boolean b, boolean b0, String admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

   

   
  

}

