package ru.on_the_zero.utility.commands;

import ru.on_the_zero.db.Texts;
import ru.on_the_zero.entity.Food;
import ru.on_the_zero.utility.Shop;

import static ru.on_the_zero.utility.SOP.println;

/**
 * Created by gendy on 02.12.16.
 */
class SearchFood {

    static Food food;

     static Food find(String[] messege){
        Food foodFound = search(messege[2]);
        Float amountNeed = Float.parseFloat(messege[3]);
        if((foodFound.getAmount() - amountNeed)<= 0) {
            println(Texts.TEXT_NO_PRODUCTS);
        } else {
            foodFound.setAmount(foodFound.getAmount() - amountNeed);
            food = new Food(foodFound.getName(), foodFound.getId(),
                    foodFound.getPrice(), amountNeed, foodFound.getDateMake(), foodFound.getDateValid());
        }
        return food;
    }

    private static Food search(String name){
        Food foodNeed = null;
        for(Food food: Shop.getStock().getProductsFood()) {
            if(name.equals(food.getName())){
                foodNeed = food;
                break;
            }
        }
        return foodNeed;
    }
}
