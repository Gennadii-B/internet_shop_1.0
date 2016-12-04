package ru.on_the_zero.utility.commands;

import ru.on_the_zero.db.Texts;
import ru.on_the_zero.entity.Clothing;
import ru.on_the_zero.utility.Shop;

import static ru.on_the_zero.utility.SOP.println;

/**
 * Created by gendy on 02.12.16.
 */
class SearchClothing {

    static Clothing clothing;

     static Clothing find(String[] messege){
        Clothing clothingFound = search(messege[2]);
        int amountNeed = Integer.parseInt(messege[3]);
        if((clothingFound.getAmount() - amountNeed)< 0) println(Texts.TEXT_NO_PRODUCTS);
        else {
            clothing = new Clothing(clothingFound.getName(), clothingFound.getId(),
                    clothingFound.getPrice(), amountNeed, clothingFound.getColor(),
                    clothingFound.getSize());
        }
        return clothing;
    }

    private static Clothing search(String name){
        Clothing clothNeed = null;
        for(Clothing cloth: Shop.getStock().getProductsClothing()) {
            if(name.equals(cloth.getName())){
                clothNeed = cloth;
                break;
            }
        }
        return clothNeed;
    }
}
