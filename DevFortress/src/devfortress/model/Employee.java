/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

import java.util.Map;

/**
 *
 * @author cathoanghuy
 */
public class Employee {
    private String name;
    private float salary;
    private Map skillList;

    public Employee(String name, float salary, Map skillList) {
        this.name = name;
        this.salary = salary;
        this.skillList = skillList;
    }

    public Employee(String name,Map skillList) {
        this.name = name;
        this.skillList = skillList;
    }
    
    
}
