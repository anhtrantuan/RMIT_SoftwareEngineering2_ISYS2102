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
public class Computer implements Item {

    private float price;

    public Computer(float price) {
        this.price = price;
    }

    public Computer() {
        this(Constant.COMPUTER_PRICE);
    }

    @Override
    public float getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return Constant.COMPUTER;
    }
}
