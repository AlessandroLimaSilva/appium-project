package com.github.AlessandroLimaSilva.utils;

import java.sql.*;
import java.util.ArrayList;

public class DBUtils {

    protected String exemploInsert = "INSERT INTO <TABELA> VALUES( <Valor1>, <Valor2>,...,<ValorN> )";
    protected String exemploDado = "Engenharia de software";

    public DBUtils(){}

    public void dataInsert(String insert, String dado) throws Exception {
        try{
            DBFactory dbFactory = new DBFactory();
            PreparedStatement pst =
                    dbFactory.getConnection().prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, dado);
            pst.executeUpdate();
            dbFactory.transactionConfirm();
            pst.close();

        } catch (Exception ex) {
            throw new Exception("Falha ocorrida: "+ex.getMessage());
        }
    }


    public int dataInsertReturnPK(String insert, String dado) throws Exception {
        try{
            DBFactory dbFactory = new DBFactory();
            PreparedStatement pst =
                    dbFactory.getConnection().prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, dado);
            pst.executeUpdate();
            dbFactory.transactionConfirm();
            ResultSet rs = pst.getGeneratedKeys();
            rs.next();
            int pk = rs.getInt(1);
            rs.close();
            pst.close();
            return pk;

        } catch (Exception ex) {
            throw new Exception("Falha ocorrida: "+ex.getMessage());
        }

    }

    public static ArrayList<String> getQueryResult(String query){
        ArrayList<String> arrayList = null;
        DBFactory connection = null;
        Statement stmt = null;

        try {

            stmt = connection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if(!rs.isBeforeFirst()){
                return null;
            }

            else{
                int numberOfColumns;
                ResultSetMetaData metadata=null;

                arrayList = new ArrayList<String>();
                metadata = rs.getMetaData();
                numberOfColumns = metadata.getColumnCount();

                while (rs.next()) {
                    int i = 1;
                    while(i <= numberOfColumns) {
                        arrayList.add(rs.getString(i++));
                    }
                }
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                connection.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static void executeQuery(String query){
        DBFactory connection = null;
        Statement stmt = null;

        try {


            stmt = connection.getConnection().createStatement();
            stmt.executeQuery(query);
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                connection.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
