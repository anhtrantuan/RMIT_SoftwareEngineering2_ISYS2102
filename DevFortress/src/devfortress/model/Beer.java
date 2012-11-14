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
public class Beer implements Item {

    private float price;

    public Beer(float price) {
        this.price = price;
    }

    @Override
    public float getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return Constant.BEER;
    }
}
