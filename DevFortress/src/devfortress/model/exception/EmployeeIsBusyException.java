/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.exception;

/**
 *
 * @author Sherlock
 */
public class EmployeeIsBusyException extends Exception{

    public EmployeeIsBusyException() {
    }
    
    public EmployeeIsBusyException(String message) {
        super(message);
    }
    
}
