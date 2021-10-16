/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author bynan_gamer
 */
public class Article {
    private int id;
    private String nom;
    private int quantite;
    private int id_fournisseur;
    

    public Article(int id, String nom, int quantite, int id_fournisseur) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
        this.id_fournisseur = id_fournisseur;
    }
    
    public Article() {
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }
    
}
