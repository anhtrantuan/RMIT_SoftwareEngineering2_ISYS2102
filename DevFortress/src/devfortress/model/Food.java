/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

import devfortress.utilities.Constant;

/**
 *
 * @author cathoanghuy
 */
public class Food implements Item {

    private float price;
    private String name;

    public Food(float price, String name) {
        this.price = price;
        this.name = name;
    }

    public Food() {
        this(Constant.PIZZA_PRICE, Constant.FOOD_PIZZA);
    }

    @Override
    public float getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
