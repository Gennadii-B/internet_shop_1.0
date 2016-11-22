package ru.on_the_zero.utility;

import ru.on_the_zero.db.Controller;
import ru.on_the_zero.entity.Clothing;
import ru.on_the_zero.entity.Order;

import java.time.LocalDate;

import ru.on_the_zero.entity.Food;
import ru.on_the_zero.entity.Technics;
import static ru.on_the_zero.utility.Texts.text;

/**
 * Created by N on 21.11.2016.
 */
public class Menu {
    private static Menu ourInstance = new Menu();

    public static Menu getInstance() {
        return ourInstance;
    }

    private Menu() {
    }
    public static final boolean OPEN = true;
    public static final boolean CLOSED = false;
    public static boolean shopStatus = Menu.OPEN;

    Controller controller = Controller.getInstance();
    Reader reader = Reader.getInstance();
    Texts texts = Texts.getInstance();
    Order order = null;
    String[] messege;

    public void startShop(){
        texts.initTexts();
        text(0);
        text(1);
    }

    public String[] firstCommand() throws Exception{
        messege = reader.readLine();
        return messege;
    }

    public void secondCommand(String[] messege) {
        if (messege[0].equals("NEW BUY")) {
            order = new Order();
            text(2);
        }
        if (messege[0].equals("SHOW")) {
            if (messege.length == 1) {
                controller.showAllProducts();
            } else {
                if (messege[1].equals("FOOD")) {
                    controller.showFood();
                } else {
                    if (messege[1].equals("CLOTHING")) {
                        controller.showClothing();
                    } else {
                        if (messege[1].equals("TECHNICS")) {
                            controller.showTechnics();
                        }
                    }
                }
            }
        }
        if(messege[0].equals("ADD")){
            if(order == null){
                text(6);
            }
            if (order != null && messege[1].equals("FOOD")) {
                Food food = controller.searchFood(messege[2]);
                float amountNeed = Float.parseFloat(messege[3]);
                if((food.getAmount() - amountNeed)  < 0){
                    text(3);
                }else{
                    food.setAmount(food.getAmount() - amountNeed);
                    order.getOrderFoods().add(new Food(food.getName(), food.getId(),
                            food.getPrice(), amountNeed, food.getDateMake(), food.getDateValid()));
                    text(4);
                }
            } else {
                if (order != null && messege[1].equals("CLOTHING")) {
                    Clothing cloth = controller.searchCloth(messege[2]);
                    int amountNeed = Integer.parseInt(messege[3]);
                    if((cloth.getAmount() - amountNeed)  < 0){
                        text(3);
                    }else {
                        cloth.setAmount(cloth.getAmount() - amountNeed);
                        order.getOrderClothing().add(new Clothing(cloth.getName(), cloth.getId(),
                                cloth.getPrice(), amountNeed, cloth.getColor(), cloth.getSize()));
                        text(4);
                    }
                } else {
                    if (order != null && messege[1].equals("TECHNICS")) {
                        Technics technic = controller.searchTechnic(messege[2]);
                        int amountNeed = Integer.parseInt(messege[3]);
                        if((technic.getAmount() - amountNeed)  < 0){
                            text(3);
                        }else {
                            technic.setAmount(technic.getAmount() - amountNeed);
                            order.getOrderTechnicses().add(new Technics(technic.getName(), technic.getId(),
                                    technic.getPrice(), amountNeed, true));
                            text(4);
                        }
                    }
                }
            }
        }
        if(messege[0].equals("EXIT")){
            Menu.shopStatus = Menu.CLOSED;
            text(5);
        }
        if(messege[0].equals("HELP")){
            text(1);
        }
        if(order != null && messege[0].equals("SHOW BASKET")){
            order.showOrderProducts();
        }
        if(messege[0].equals("PAY")){
            order.setDateBuy(LocalDate.now());
            controller.orderArchivator(order);
            order = null;
        }
    }
}
