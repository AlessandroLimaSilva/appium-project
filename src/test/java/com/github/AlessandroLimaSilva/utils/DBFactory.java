package com.github.AlessandroLimaSilva.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBFactory {

    private static Connection connection;
    private String connectionString = "jdbc:mysql://endereço do seu banco/";
    private String usuarioBanco = "Seu nome de usuario no banco";
    private String senhaBanco = "sua senha de usuario do banco";

    public DBFactory() throws Exception{
        try {
            if (connection != null && !connection.isClosed()) return;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionString,usuarioBanco,senhaBanco);
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        }
        catch (ClassNotFoundException cnf){
            throw new Exception("Driver não encontrado !");
        }
        catch (SQLException sql){
            throw new Exception("Falha ocorrida: "+sql.getMessage());
        }
    }

    public DBFactory(String enderecoBanco, String nomeUsuario, String senha) throws Exception{
        try {
            if (connection != null && !connection.isClosed()) return;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(enderecoBanco,nomeUsuario, senha);
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        }
        catch (ClassNotFoundException cnf){
            throw new Exception("Driver não encontrado !");
        }
        catch (SQLException sql){
            throw new Exception("Falha ocorrida: "+sql.getMessage());
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public void closeConnection() throws Exception{
        try{
            if (connection == null || connection.isClosed()) return;
            connection.close();
        }
        catch (SQLException sql){
            throw new Exception("Falha ocorrida: " + sql.getMessage());
        }
    }

    public void transactionConfirm() throws Exception{
        try{
            if (connection == null || connection.isClosed()) return;
            connection.commit();
        }
        catch (SQLException sql){
            throw new Exception("Falha ocorrida: " + sql.getMessage());
        }
    }

    public void transactionCancel() throws Exception{
        try {
            if (connection == null || connection.isClosed()) return;
            connection.rollback();
        }
        catch (SQLException sql){
            throw new Exception("Falha ocorrida: " + sql.getMessage());
        }
    }

}
