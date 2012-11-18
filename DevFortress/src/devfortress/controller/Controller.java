/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.controller;

import devfortress.model.Employee;
import devfortress.model.exception.OvercrowdedException;
import devfortress.model.facade.Model;
import devfortress.view.View;

/**
 *
 * @author tommy
 */
public class Controller {

    /* Declare Model and DevFortressView modules. */
    private Model model;
    private View view;

    /**
     * Constructor for Controller.
     *
     * @param model
     * @param view
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        /* Set up button listeners. */
        view.addButtonListener(new MainScreenButtonListener(model));
        view.setTableButtonListener(new EmployeeTableButtonListener(model));
    }

    public void hireEmployee(Employee emp) throws OvercrowdedException {
        model.hireEmployee(emp);
    }
}
