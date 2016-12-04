package ru.on_the_zero.entity;

import java.io.Serializable;
import java.time.LocalDate;
import static ru.on_the_zero.utility.SOP.println;
/**
 * Created by N on 20.11.2016.
 */
public class Food extends AbstractProduct implements Serializable {
    private float amount;
    private LocalDate dateMake;
    private LocalDate dateValid;

    public void showInfo(){
        super.showInfo();
        println("        Кол-во: "+ amount + " /// Дата изготовления: " +
                dateMake + " /// Годен до: " + dateValid);
    }

    public Food(String name, int id, int price, float amount, LocalDate dateMake, LocalDate dateValid) {
        super(name, id, price);
        this.amount = amount;
        this.dateMake = dateMake;
        this.dateValid = dateValid;
    }


    public LocalDate getDateMake() {
        return dateMake;
    }

    public void setDateMake(LocalDate dateMake) {
        this.dateMake = dateMake;
    }

    public LocalDate getDateValid() {
        return dateValid;
    }

    public void setDateValid(LocalDate dateValid) {
        this.dateValid = dateValid;
    }

    public Food(String name) {
        super(name);
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
