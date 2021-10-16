/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;
import config.Config;
import java.sql.*;

/**
 *
 * @author bynan_gamer
 */
public class AccessBdd {
    private String driver = null;	//Ex : "oracle.jdbc.OracleDriver"
    private String url = null; 	//Ex : "jdbc:oracle:thin:@192.168.200.91:1521:DATA10G";
    private String user = null;
    private String password = null;
    private Connection conn = null;
    private ResultSet resultSet = null;

    public  AccessBdd() {
        Config config = new Config();
        this.driver = config.driver;
        this.url = config.url;
        this.user = config.user;
        this.password = config.password;
    }

    /**
     * @param args
     */
    public void loadDriver() {
        try {
            Class.forName(driver);
            System.out.println("Driver chargé");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver non trouvé");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Connexion établie");
            } catch (SQLException e) {
                System.err.println("Problème de connexion  : " + e.getMessage());
            }
        } else {
            try {
                if (conn.isClosed()) {
                    conn = DriverManager.getConnection(url, user, password);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return conn;
    }

    public ResultSet executeSelect(String sql) {
        Statement statement;
        try {
            if (resultSet == null) {
                statement = getConnection().createStatement();
                resultSet = statement.executeQuery(sql);
                System.out.println("Sélection dans la base de données effectuée");
                return resultSet;
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeUpdate(String sql) {
        Statement statement;
        try {
            statement = getConnection().createStatement();
            statement.executeUpdate(sql);
            System.out.println("Modification dans la base de données effectuée");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
