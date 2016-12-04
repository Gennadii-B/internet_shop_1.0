package ru.on_the_zero.utility.commands;

import ru.on_the_zero.db.Texts;
import ru.on_the_zero.entity.Technics;
import ru.on_the_zero.utility.Shop;

import static ru.on_the_zero.utility.SOP.println;

/**
 * Created by gendy on 02.12.16.
 */
class SearchTechnics {

    static Technics technic;

     static Technics find(String[] messege){
        Technics technicFound = search(messege[2]);
        int amountNeed = Integer.parseInt(messege[3]);
        if((technicFound.getAmount() - amountNeed)< 0) println(Texts.TEXT_NO_PRODUCTS);
        else {
             technic = new Technics(technicFound.getName(), technicFound.getId(),
                    technicFound.getPrice(), amountNeed, technicFound.isGuarantee());
        }
         return technic;
    }

    private static Technics search(String name){
        Technics technicNeed = null;
        for(Technics technic: Shop.getStock().getProductsTechnics()) {
            if(name.equals(technic.getName())){
                technicNeed = technic;
                break;
            }
        }
        return technicNeed;
    }
}
