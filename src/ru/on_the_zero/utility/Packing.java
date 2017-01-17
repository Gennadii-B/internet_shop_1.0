package ru.on_the_zero.utility;


import ru.on_the_zero.entity.Basket;
import ru.on_the_zero.entity.Clothing;
import ru.on_the_zero.entity.Food;
import ru.on_the_zero.entity.Technics;

import java.io.*;
import java.sql.SQLException;

/**
 * Created by gendy on 03.12.16.1
 */
public class Packing {

    private FileOutputStream fileOut;
    private ObjectOutputStream out;
    private Shop shop = Shop.getInstance();
    DaoBaseController daoBaseController = DaoBaseController.getInstance();

    private void serData(String fileName, Object obj) throws IOException {
        try {
            fileOut = new FileOutputStream(fileName + ".arch", false);
            out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);

        }catch(FileNotFoundException e){
            System.out.println("файл не найден");
            System.exit(1);
        }catch (IOException e){
            System.out.println("ошибка ввода/вывода");
            e.printStackTrace();
            System.exit(2);
        }finally{
            fileOut.close();
            out.close();

        }
    }

    public void pack() throws IOException{
        serData("src/ru/on_the_zero/db/archive/Food",
    shop.getStock().getProductsFood());
        serData("src/ru/on_the_zero/db/archive/Clothing",
    shop.getStock().getProductsClothing());
        serData("src/ru/on_the_zero/db/archive/Technics",
    shop.getStock().getProductsTechnics());
        serData("src/ru/on_the_zero/db/archive/Baskets",
    shop.getStock().getBaskets());
//        serData("src/ru/on_the_zero/db/archive/actualBasket",
//  shop.getBasket());

    }

    public void packBasketDB(Basket basket)throws SQLException{
        daoBaseController.cleanTables();

        if(!basket.getOrderFoods().isEmpty())
            for(Food food : basket.getOrderFoods())
                daoBaseController.setFoodDB(food);

        if(!basket.getOrderClothing().isEmpty())
            for(Clothing cloth : basket.getOrderClothing())
                daoBaseController.setClothingDB(cloth);

        if(!basket.getOrderTechnicses().isEmpty())
            for(Technics technic : basket.getOrderTechnicses())
                daoBaseController.setTechnicsDB(technic);
    }
}
