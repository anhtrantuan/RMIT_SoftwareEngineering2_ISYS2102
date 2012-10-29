/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.utilities;

import devfortress.model.Employee;
import devfortress.model.Project;
import devfortress.model.dificulity.GameLevel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Sherlock
 */
public class Utilities {

    public static int calculateSalaryPoint(int skill, int skillLevel) {

        if (skill <= 24) {
            if (skillLevel == 1) {
                if (skill == 24) {
                    return 5;
                } else {
                    return 1;
                }
            } else {
                return calculateSalaryPoint(skill, skillLevel - 1) + 2;
            }
        } else if (skill >= 25 || skill <= 27) {
            if (skillLevel == 1) {
                return 1;
            } else {
                return calculateSalaryPoint(skill, skillLevel - 1) + 4;
            }
        } else {
            if (skillLevel == 1) {
                return 2;
            } else {
                return calculateSalaryPoint(skill, skillLevel - 1) * 2;
            }
        }
    }

    public static List<Project> generateProject(int numberOfProject) {
        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < numberOfProject; i++) {
            // TODO implement Engine.generateProject
        }
        return projects;
    }

    public static List<Employee> genterateEmployee(GameLevel level,int numberofEmployee) {
        List<Employee> employee = new ArrayList<>();
        for (int i = 0; i < numberofEmployee; i++) {
            Employee newEmployee = new Employee(generateEmployeeName(), generateSkillList(4));

        }
        return employee;
    }
    
    
    private static String generateEmployeeName() {
        Random randomGenerator = new Random();
        return Name.name[randomGenerator.nextInt(Name.name.length)];

    }
}
