/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import common.AccessBdd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Article;
import model.Client;
import model.Fournisseur;

/**
 *
 * @author bynan_gamer
 */
public class FournisseurDao {
    public List<Fournisseur> selectAllFournisseurs() throws SQLException {
        Fournisseur fournisseurModel;
        List fournisseurs = new ArrayList();
        String sql = "SELECT * FROM `fournisseurs`";
        AccessBdd accessBdd = new AccessBdd();
        accessBdd.loadDriver();
        ResultSet rs = accessBdd.executeSelect(sql);
        while (rs.next()) {
            int id = Integer.parseInt(rs.getString("id_fournisseur"));
            String nom = rs.getString("nom_fournisseur");

            fournisseurModel = new Fournisseur(id, nom);
            fournisseurs.add(fournisseurModel);
        }
        return fournisseurs;
    }
    
    public Fournisseur selectById(int idParam) throws SQLException {
        Fournisseur fournisseurModel = null;
        String sql = "SELECT * FROM `fournisseurs`  WHERE `id_fournisseur` = " + idParam;
        AccessBdd accessBdd = new AccessBdd();
        accessBdd.loadDriver();
        ResultSet rs = accessBdd.executeSelect(sql);
        while (rs.next()) {
            int id = Integer.parseInt(rs.getString("id_fournisseur"));
            String nom = rs.getString("nom_fournisseur");

            fournisseurModel = new Fournisseur(id, nom);
        }
        return fournisseurModel;
    }
    
    public void addFournisseur(Fournisseur fournisseur){
        String sql = "INSERT INTO `fournisseurs`(`id_fournisseur`, `nom_fournisseur`) VALUES ('"+fournisseur.getId()+"', '"+fournisseur.getNom()+"')";
        AccessBdd accessBdd = new AccessBdd();
        accessBdd.loadDriver();
        accessBdd.executeUpdate(sql);
    }
}
