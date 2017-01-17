package ru.on_the_zero.utility;

import ru.on_the_zero.entity.Clothing;
import ru.on_the_zero.entity.Food;
import ru.on_the_zero.entity.Technics;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by user on 16.01.2017.
 */
public class DaoBaseController {

    private static DaoBaseController ourInstance = new DaoBaseController();

    public static DaoBaseController getInstance() {
        return ourInstance;
    }
    LocalDate lDate = LocalDate.of(2016, 10, 15);
    private DaoBaseController() {
    }

    private String JDBCdriver;
    private String url;
    private Connection connection = null;
    private Statement statement = null;


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
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            connection.close();
            System.out.println("DB connect [ OFF ]");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void setFoodDB(Food food) throws SQLException{
        Food foodTEST = new Food("помидорка", 17, 100, 2.5f,
                LocalDate.of(2016, 10, 16), LocalDate.of(2017, 10, 17));
        Date date = new Date(2016, 10, 16);

        String insert = "INSERT INTO FOOD (AMOUNT, DATE_MAKE, DATE_VALID," +
                "PRODUCT_ID, PRICE, NAME) VALUES (?,?,?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(insert);
        ps.setFloat(1, food.getAmount());
        ps.setDate(2, date);
        ps.setDate(3, date);
        ps.setInt(4, food.getId());
        ps.setInt(5, food.getPrice());
        ps.setString(6, food.getName());
        ps.executeUpdate();
        ps.close();
    }

    public void setClothingDB(Clothing cloth) throws SQLException{

        String insert = "INSERT INTO CLOTHING (NAME, clothing_id, PRICE, " +
                "AMOUNT, COLOR, SIZE) VALUES (?,?,?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(insert);

        ps.setString(1, cloth.getName());
        ps.setInt(2, cloth.getId());
        ps.setInt(3, cloth.getPrice());
        ps.setInt(4, cloth.getAmount());
        ps.setString(5, cloth.getColor());
        ps.setInt(6, cloth.getSize());

        ps.executeUpdate();
        ps.close();
    }

    public void setTechnicsDB(Technics tech) throws SQLException{

        String insert = "INSERT INTO TECHNICS (NAME, technic_id, PRICE, " +
                "AMOUNT, GUARANTEE) VALUES (?,?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(insert);

        ps.setString(1, tech.getName());
        ps.setInt(2, tech.getId());
        ps.setInt(3, tech.getPrice());
        ps.setInt(4, tech.getAmount());
        ps.setBoolean(5, tech.isGuarantee());

        ps.executeUpdate();
        ps.close();
    }

    public void cleanTables()throws SQLException{
        statement = connection.createStatement();
        statement.execute("TRUNCATE FOOD;");
        statement.execute("TRUNCATE CLOTHING;");
        statement.execute("TRUNCATE TECHNICS;");
        statement.close();


    }

    public ArrayList<Food> readFoodFromDB() throws SQLException{
        ArrayList<Food> foods = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(
                "SELECT AMOUNT, DATE_MAKE, DATE_VALID," +
                "PRODUCT_ID, PRICE, NAME FROM FOOD");
        while(rs.next()){
            Food food = new Food();
            food.setName(rs.getString("NAME"));
            food.setPrice(rs.getInt("PRICE"));
            food.setAmount(rs.getInt("AMOUNT"));
            food.setDateMake(lDate);
            food.setDateValid((lDate));
            food.setId(rs.getInt("PRODUCT_ID"));
            foods.add(food);
        }
        return foods;
    }

    public ArrayList<Clothing> readClothingFromDB() throws SQLException{
        ArrayList<Clothing> clothing = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(
                "SELECT AMOUNT, COLOR, SIZE,  " +
                        "CLOTHING_ID, PRICE, NAME FROM CLOTHING");
        while(rs.next()){
            Clothing cloth = new Clothing();
            cloth.setName(rs.getString("NAME"));
            cloth.setPrice(rs.getInt("PRICE"));
            cloth.setAmount(rs.getInt("AMOUNT"));
            cloth.setId(rs.getInt("CLOTHING_ID"));
            cloth.setColor(rs.getString("COLOR"));
            cloth.setSize(rs.getInt("SIZE"));
            clothing.add(cloth);
        }
        return clothing;
    }

    public ArrayList<Technics> readTechnicsFromDB() throws SQLException{
        ArrayList<Technics> technicses = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(
                "SELECT AMOUNT, GUARANTEE," +
                        "TECHNIC_ID, PRICE, NAME FROM TECHNICS");
        while(rs.next()){
            Technics tech = new Technics();
            tech.setName(rs.getString("NAME"));
            tech.setPrice(rs.getInt("PRICE"));
            tech.setAmount(rs.getInt("AMOUNT"));
            tech.setId(rs.getInt("TECHNIC_ID"));
            tech.setGuarantee(rs.getBoolean("GUARANTEE"));
            technicses.add(tech);
        }
        return technicses;
    }
}



