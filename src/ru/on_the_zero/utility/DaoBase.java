package ru.on_the_zero.utility;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by user on 16.01.2017.
 */
public class DaoBase {

    private static DaoBase ourInstance = new DaoBase();

    public static DaoBase getInstance() {
        return ourInstance;
    }

    private DaoBase() {
    }

    private String JDBCdriver;
    private String url;
    private Connection connection = null;
    private Statement statement = null;
    private byte[] serBasket;
    private byte[] deserBasket;

    private static Properties properties() {
        Properties property = new Properties();
        property.put("database", "jdbc:postgresql://localhost:5432/test");
        property.put("user", "postgres");
        property.put("password", "admin1788");
        return property;
    }

    public void RegDriverManager() {
        try {
            JDBCdriver = "org.postgresql.Driver";
            Class.forName(JDBCdriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void connect(){
        try {
            url = "jdbc:postgresql://localhost:5432/test";
            connection = DriverManager.getConnection(url,properties());
            if(connection != null)
                System.out.println("DB connect [ ON ]");
            else {
                System.out.println("DB connect [ NONE ]");
                System.exit(0);
            }

            statement = connection.createStatement();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            statement.close();
            connection.close();
            System.out.println("DB connect [ OFF ]");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void setBasket() {
        try {
            Packing packing = new Packing();
            serBasket = packing.serToDB();
            String createBasketTable = "CREATE TABLE BASKETON ("
                    + "USER_ID INT NOT NULL, "
                    + "CONTENT BYTEA  NOT NULL, "
                    + "PRIMARY KEY (USER_ID));";
//        statement.execute(createBasketTable);

            String insertBasket = "INSERT INTO BASKETON (USER_ID, CONTENT) " +
                    "VALUES (1, ?);";
//        PreparedStatement ps = connection.prepareStatement(insertBasket);

            String updateBasket = "UPDATE BASKETON SET CONTENT = ? WHERE USER_ID = 1;";

            PreparedStatement ps = connection.prepareStatement(updateBasket);
            ps.setBytes(1, serBasket);
            ps.executeUpdate();
            System.out.println("save basket [ OK ]");
        }catch(IOException e) {
            System.out.println("ошибка ввода вывода");
            e.printStackTrace();
        }catch(SQLException e){
            System.out.println("ошибка БД");
            e.printStackTrace();
        }
    }

    public byte[] getBasket() throws SQLException{

        String selectBasket = "SELECT CONTENT FROM BASKETON;";
        ResultSet rs = statement.executeQuery(selectBasket);
        while(rs.next()){
            deserBasket = rs.getBytes("CONTENT");
        }
        return deserBasket;
    }

}



