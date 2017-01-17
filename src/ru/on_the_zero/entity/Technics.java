package ru.on_the_zero.entity;

import static ru.on_the_zero.utility.SOP.println;
/**
 * Created by N on 20.11.2016.
 */
public class Technics extends AbstractProduct {
    private int amount;
    private boolean guarantee;

    public void showInfo(){
        super.showInfo();
        println("       " + "Кол-во: "+ amount + " /// Гарантия: " + guarantee);
    }

    public Technics(){}

    public Technics(String name, int id, int price, int amount, boolean guarantee) {
        super(name, id, price);
        this.amount = amount;
        this.guarantee = guarantee;
    }

    public Technics(String name) {
        super(name);
    }

    public boolean isGuarantee() {
        return guarantee;
    }

    public void setGuarantee(boolean guarantee) {
        this.guarantee = guarantee;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
