package ru.on_the_zero.utility;


import java.io.*;

/**
 * Created by gendy on 03.12.16.1
 */
public class Packing {

    private FileOutputStream fileOut;
    private ObjectOutputStream out;
    private Shop shop = Shop.getInstance();
    byte[] res = {1};
    ByteArrayOutputStream baos;
    ObjectOutputStream oos;
    DaoBase daoBase = DaoBase.getInstance();

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

    byte[] serToDB() throws IOException {
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(shop.getBasket());
            res = baos.toByteArray();
            return res;

        } catch (FileNotFoundException e) {
            System.out.println("файл не найден");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("ошибка ввода/вывода");
            e.printStackTrace();
            System.exit(2);
        } finally {
            oos.close();
            baos.close();
            return res;
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
// shop.getBasket());
     ////   serToDB(shop.getBasket());
        daoBase.setBasket();
    }
}
