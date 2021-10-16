/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import common.AccessBdd;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class ArticleDao {
    public List<Article> selectAllArticle() throws SQLException {
        Article articleModel;
        List articles = new ArrayList();
        String sql = "SELECT * FROM `stock_articles`";
        AccessBdd accessBdd = new AccessBdd();
        accessBdd.loadDriver();
        ResultSet rs = accessBdd.executeSelect(sql);
        while (rs.next()) {
            int id = Integer.parseInt(rs.getString("id_article"));
            String nom = rs.getString("nom_article");
            int quantite = rs.getInt("quantite");
            int id_fournisseur = rs.getInt("id_fournisseur");

            articleModel = new Article(id, nom, quantite, id_fournisseur);
            articles.add(articleModel);

        }
        return articles;
    }
    
    public void addArticle(Article n, int i) throws SQLException{
        AccessBdd accessBdd = new AccessBdd();
        PreparedStatement ps = null;
        Connection con = accessBdd.getConnection();
        String sql = "INSERT INTO `stock_articles`(`id_article`, `nom_article`, `quantite`, `id_fournisseur`) VALUES (?,?,?,?)";
        ps = con.prepareStatement(sql);
        ps.setInt(1, n.getId());
        ps.setString(2, n.getNom());
        ps.setInt(3, n.getQuantite());
        ps.setInt(4, i);
        ps.executeUpdate();
   }
   public void updateById(int id_article, int quantiteReste) throws SQLException {
        AccessBdd accessBdd = new AccessBdd();
        PreparedStatement ps = null;
        Connection con = accessBdd.getConnection();
        String sql = "UPDATE `stock_articles` SET `quantite`=? WHERE id_article = ?";
        ps = con.prepareStatement(sql);
        ps.setInt(1,quantiteReste );
        ps.setInt(2, id_article);
        ps.executeUpdate();
    }
}
