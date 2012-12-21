/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.exception;

/**
 *
 * @author Cat Hoang Huy
 */
public class EmployeeNotExist extends Exception{

    public EmployeeNotExist() {
    }

    public EmployeeNotExist(String message) {
        super(message);
    }
    
}
