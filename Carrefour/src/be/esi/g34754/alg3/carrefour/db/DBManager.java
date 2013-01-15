/*
 * DBManager.java
 */
package be.esi.g34754.alg3.carrefour.db;

import java.sql.*;

/**
 * Offre les outils de connexion et de gestion de transaction. 
 */
public class DBManager {

    private static Connection connection;
    //private static MesParametresDeConnexion dbChoisie;


    /**
     * Retourne la connexion établie ou à défaut, l'établit
     * @return la connexion établie.
     */
    public static Connection getConnection() throws CarrefourDbException {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:derby://localhost:1527/CarrefourDB", "app", "app");
            } catch (SQLException ex) {
                throw new CarrefourDbException("Connexion impossible: " + ex.getMessage());
            }
        }
        return connection;
    }

    /**
     * débute une transaction
     */
    public static void startTransaction() throws CarrefourDbException {
        try {

            getConnection().setAutoCommit(false);
        } catch (SQLException ex) {
            throw new CarrefourDbException("Impossible de démarrer une transaction: "+ex.getMessage());
        }
    }

    /**
     * débute une transaction en spécifiant son niveau d'isolation
     * Attention, ceci n'est pas implémenté sous Access!
     * (cette notion sera abordée ultérieurement dans le cours de bd)
     */
    public static void startTransaction(int isolationLevel) throws CarrefourDbException {
        try {
            getConnection().setAutoCommit(false);

            int isol = 0;
            switch (isolationLevel) {
                case 0:
                    isol = java.sql.Connection.TRANSACTION_READ_UNCOMMITTED;
                    break;
                case 1:
                    isol = java.sql.Connection.TRANSACTION_READ_COMMITTED;
                    break;
                case 2:
                    isol = java.sql.Connection.TRANSACTION_REPEATABLE_READ;
                    break;
                case 3:
                    isol = java.sql.Connection.TRANSACTION_SERIALIZABLE;
                    break;
                default:
                    throw new CarrefourDbException("Degré d'isolation inexistant!");
            }


            getConnection().setTransactionIsolation(isolationLevel);
        } catch (SQLException ex) {
            throw new CarrefourDbException("Impossible de démarrer une transaction: "+ex.getMessage());
        }
    }

    /**
     * valide la transaction courante
     */
    public static void valideTransaction() throws CarrefourDbException {
        try {
            getConnection().commit();
            getConnection().setAutoCommit(true);
        } catch (SQLException ex) {
            throw new CarrefourDbException("Impossible de valider la transaction: "+ex.getMessage());
        }
    }

    /**
     * annule la transaction courante
     */
    public static void annuleTransaction() throws CarrefourDbException {
        try {
            getConnection().rollback();
            getConnection().setAutoCommit(true);
        } catch (SQLException ex) {
            throw new CarrefourDbException("Impossible d'annuler la transaction: "+ex.getMessage());
        }
    }
}
