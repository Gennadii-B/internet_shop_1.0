package ru.on_the_zero.utility;

import ru.on_the_zero.entity.Clothing;
import ru.on_the_zero.entity.Food;
import ru.on_the_zero.entity.Basket;
import ru.on_the_zero.entity.Technics;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by gendy on 03.12.16.
 */
public class Unpacking {

    private FileInputStream fileIn;
    private ObjectInputStream in;
    private Shop shop = Shop.getInstance();
    ByteArrayInputStream bais;
    ObjectInputStream ois;
    Basket res;
    DaoBase daoBase = DaoBase.getInstance();

    public Object deserData(String fileName) throws IOException {
        Object retObject = null;
        try {
            fileIn = new FileInputStream(fileName + ".arch");
            in = new ObjectInputStream(fileIn);
            retObject = in.readObject();

        }catch(FileNotFoundException e){
            System.out.println("файл не найден");
            System.exit(1);
        }catch (IOException e){
            System.out.println("ошибка ввода/вывода");
            e.printStackTrace();
            System.exit(2);
        }catch (ClassNotFoundException e){
            System.out.println("Класс не найден");
            System.exit(3);
        }finally {
            fileIn.close();
            in.close();
        }
        return retObject;
    }

    public boolean isHaveFile(){
        File file = new File("src/ru/on_the_zero/db/archive/Food.arch");
        return file.exists();
    }

    Basket deserToDB(byte[] bytes) throws IOException {
        try {
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            res = (Basket) ois.readObject();
            return res;

        } catch (FileNotFoundException e) {
            System.out.println("файл не найден");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("ошибка ввода/вывода");
            e.printStackTrace();
            System.exit(2);
        } finally {
            ois.close();
            bais.close();
            return res;
        }
    }


    public void unpack() throws IOException, SQLException{
        shop.getStock().setProductsFood((ArrayList<Food>) (deserData("src/ru/on_the_zero/db/archive/Food")));
        shop.getStock().setProductsClothing((ArrayList<Clothing>) (deserData("src/ru/on_the_zero/db/archive/Clothing")));
        shop.getStock().setProductsTechnics((ArrayList<Technics>) (deserData("src/ru/on_the_zero/db/archive/Technics")));
        shop.getStock().setBaskets((ArrayList<Basket>) (deserData("src/ru/on_the_zero/db/archive/Baskets")));
     //   shop.setBasket((Basket)(deserData("src/ru/on_the_zero/db/archive/actualBasket")));
        shop.setBasket(deserToDB(daoBase.getBasket()));
    }
}
