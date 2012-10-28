/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import devfortress.model.Company;
import devfortress.model.Employee;
import devfortress.model.Project;
import devfortress.model.facade.Engine;
import devfortress.model.facade.Model;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author cathoanghuy
 */
public class test {

    public static void main(String[] args) {
        Company company = new Company(1000);

        Model model = new Engine(company);
        System.out.println("Welcome to devforess \n"
                + "1 - hire employee \n"
                + "2 - choose project \n"
                + "Enter your option: ");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        switch (input) {
            case 1: {
                List<Employee> employee = model.genterateEmployee(10);
                
                break;
            }
            case 2: {
                List<Project> project = model.generateProject(5);

                break;
            }
        }
    }
}
