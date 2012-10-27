/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

/**
 *
 * @author cathoanghuy
 */
public class Computer implements Item{
    private float price;

    public Computer(float price) {
        this.price = price;
    }

    @Override
    public float getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
        
}
