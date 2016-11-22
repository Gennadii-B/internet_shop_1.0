package ru.on_the_zero.utility;

import java.util.LinkedList;
import static ru.on_the_zero.entity.tools.SOP.println;
/**
 * Created by N on 20.11.2016.
 */
public class Texts {
    private static Texts ourInstance = new Texts();

    public static Texts getInstance() {
        return ourInstance;
    }

    private Texts() {
    }

    private static LinkedList<String> texts = new LinkedList<>();

    static void text(int id){
        println(texts.get(id));
    }

    void initTexts(){
        //0
        texts.add("Вас приветствует магазин \"ON-THE-ZERO\"");
        //1
        texts.add("\nДоступные команды:   \"NEW BUY\"        - открывает новую покупку\n" +
                            "                     \"PAY\"          - оплатить выбранный товар и закрыть покупку\n" +
                            "                     \"EXIT\"         - покинуть магазин без всяких на то причин\n" +
                            "                     \"SHOW\"         - просмотр всех товаров \n " +
                            "                    \"SHOW/(FOOD),(CLOTHING),(TECHNICS)\" \n" +
                            "                                    - для просмотра товаров нужного типа \n" +
                            "                     \"SHOW BASKET\"  - показать корзину и общую стоимость \n " +
                            "                    \"ADD/тип товара/название товара/количество\" +\n" +
                            "                                    - для добавление товара в корзину \n" +
                            "                              ПРИМЕР: \"ADD/FOOD/молоко/2\" \n " +
                            "                    \"HELP\"         - показать все команды");
        //2
        texts.add("новая корзина создана");
        //3
        texts.add("на данный момент товара нет в наличии, либо нет установленного количества");
        //4
        texts.add("товар добавлен в корзину");
        //5
        texts.add("магазин закрывается");
        //6
        texts.add("откройте новую покупку");
        //7
        texts.add("");
    }
}
