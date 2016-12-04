package ru.on_the_zero.db;

import static ru.on_the_zero.utility.SOP.println;
/**
 * Created by N on 20.11.2016.
 */
public class Texts {

        public static final String TEXT_HELLO = "Вас приветствует магазин \"ON-THE-ZERO\"";
        public static final String TEXT_ALL_COMMANDS = "\nДоступные команды:   \"new buy\"        - открывает новую покупку\n" +
                            "                     \"pay\"          - оплатить выбранный товар и закрыть покупку\n" +
                            "                     \"exit\"         - покинуть магазин без всяких на то причин\n" +
                            "                     \"show/all\"         - просмотр всех товаров \n " +
                            "                    \"show/(food),(clothing),(technics)\" \n" +
                            "                                    - для просмотра товаров нужного типа \n" +
                            "                     \"show/basket\"  - показать корзину и общую стоимость \n " +
                            "                    \"add/тип товара/название товара/количество\" +\n" +
                            "                                    - для добавление товара в корзину \n" +
                            "                              ПРИМЕР: \"add/food/молоко/2\" \n " +
                            "                    \"help\"         - показать все команды";
        public static final String TEXT_CREATED_NEW_ORDER = "новая корзина создана";
        public static final String TEXT_NO_PRODUCTS = "на данный момент товара нет в наличии, либо нет установленного количества";
        public static final String TEXT_PRODUCT_ADDED = "товар добавлен в корзину";
        public static final String TEXT_SHOP_CLOSE = "магазин закрывается";
        public static final String TEXT_CREATE_NEW_ORDER = "откройте новую покупку";
        public static final String TEXT_BUY_CLOSED = "покупка оплачена!!!";

}
