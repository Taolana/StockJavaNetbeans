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
import model.Client;

/**
 *
 * @author bynan_gamer
 */
public class ClientDao {
    public void addClient(Client client) throws SQLException{
        AccessBdd accessBdd = new AccessBdd();
        PreparedStatement ps = null;
        Connection con = accessBdd.getConnection();
        String sql = "INSERT INTO `clients`(`nom_client`) VALUES (?)";
        ps = con.prepareStatement(sql);
        ps.setString(1, client.getNom());
        ps.executeUpdate();
    }
    
    public void updateClient(Client client) throws SQLException {
        AccessBdd accessBdd = new AccessBdd();
        PreparedStatement ps = null;
        Connection con = accessBdd.getConnection();
        String sql = "UPDATE `clients` SET `id_client`=[value-1],`nom_client`=[value-2],`prenom_client`=[value-3],`adresse`=[value-4] WHERE 1";
        ps = con.prepareStatement(sql);
        ps.setString(1, client.getNom());
        ps.setString(2, client.getPrenom());
        ps.setString(3, client.getAdresse());
        ps.setInt(6, client.getId());
        ps.executeUpdate();
    }
    public List<Client> selectAllClient() throws SQLException {
        Client ClientModel;
        List clients = new ArrayList();
        String sql = "SELECT * FROM `clients`";
        AccessBdd accessBdd = new AccessBdd();
        accessBdd.loadDriver();
        ResultSet rs = accessBdd.executeSelect(sql);
        while (rs.next()) {
            int id = Integer.parseInt(rs.getString("id_client"));
            String nom = rs.getString("nom_client");
            String prenom = rs.getString("prenom_client");
            String adresse = rs.getString("adresse");

            ClientModel = new Client(id, nom, prenom, adresse);
            clients.add(ClientModel);

        }
        return clients;
    }
    public Client lastId() throws SQLException{
        Client client = null;
        String sql = "SELECT id_client FROM  `clients` ORDER BY id_client  DESC LIMIT 1";
        AccessBdd accessBdd = new AccessBdd();
        accessBdd.loadDriver();
        ResultSet rs = accessBdd.executeSelect(sql);
        while(rs.next()){
            int id  = rs.getInt("id_client");
            
            client = new Client(id);
        }
        return client;
    }
}
