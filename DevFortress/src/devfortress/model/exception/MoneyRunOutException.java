/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.exception;

/**
 *
 * @author cathoanghuy
 */
public class MoneyRunOutException extends Exception {

    public MoneyRunOutException(String message) {
        super(message);
    }

    public MoneyRunOutException() {
    }
}
