/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import common.AccessBdd;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import model.Article;
import model.Client;

/**
 *
 * @author bynan_gamer
 */
public class CommandeDao {
    public void addCommande(Client client, int id_article, int quantite) throws SQLException{
        
        AccessBdd accessBdd = new AccessBdd();
        PreparedStatement ps = null;
        Connection con = accessBdd.getConnection();
        
        java.util.Date datetime = new java.util.Date();
        long time = datetime.getTime();
        Timestamp ts = new Timestamp(time);
        
        String sql = "INSERT INTO `commandes`(`quantite`, `id_article`, `id_client`, `date_commande`) VALUES (?,?,?,?)";
        ps = con.prepareStatement(sql);
        ps.setInt(1, quantite);
        ps.setInt(2, id_article);
        ps.setInt(3, client.getId());
        ps.setTimestamp(4, ts);
        ps.executeUpdate();
    }
}
