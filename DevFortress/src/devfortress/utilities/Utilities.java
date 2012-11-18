/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.utilities;

import devfortress.model.Company;
import devfortress.model.Computer;
import devfortress.model.Employee;
import devfortress.model.Project;
import devfortress.model.dificulity.GameLevel;
import java.util.*;

/**
 *
 * @author Sherlock
 */
public class Utilities {

    private static String generateProjectName() {
        return Name.getProjectName();
    }

    public static int calculateSalaryPoint(Skills skill, int skillLevel) {

        if (skill.ordinal() <= 24) {
            if (skillLevel == 1) {
                if (skill.ordinal() == 24) {
                    return 5;
                } else {
                    return 1;
                }
            } else {
                return (calculateSalaryPoint(skill, skillLevel - 1) + 2);
            }
        } else if (skill.ordinal() >= 25 && skill.ordinal() <= 27) {
            if (skillLevel == 1) {
                return 2;
            } else {
                return (calculateSalaryPoint(skill, skillLevel - 1) + 4);
            }
        } else {
            if (skillLevel == 1) {
                if (skill.ordinal() == 29) {
                    return 3;
                } else {
                    return 2;
                }
            } else {
                return (calculateSalaryPoint(skill, skillLevel - 1) * 2);
            }
        }
    }

    public static int calculateSalary(Map<Skills, Integer> skillList) {
        int salary = 0;
        for (Skills sk : skillList.keySet()) {
            if (sk.ordinal() <= 24) {
                salary += calculateSalaryPoint(sk, skillList.get(sk)) * 2;
            } else if (sk.ordinal() >= 25 && sk.ordinal() <= 27) {
                salary += calculateSalaryPoint(sk, skillList.get(sk)) * 4;
            } else {
                salary += calculateSalaryPoint(sk, skillList.get(sk)) * 5;
            }
        }
        return salary;
    }

    public static List<Project> generateProjectList(GameLevel level, int numberOfProject) {
        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < numberOfProject; i++) {
            projects.add(level.generateProject(Name.getProjectName()));
        }
        return projects;
    }

    public static List<Employee> generateEmployeeList(GameLevel level, int numberofEmployee) {
        List<Employee> employee = new ArrayList<>();
        for (int i = 0; i < numberofEmployee; i++) {
            Employee newEmployee = generateEmployee(level);
            employee.add(newEmployee);
        }
        return employee;
    }

    private static String generateEmployeeName() {
        return Name.getEmployeeName();
    }

    private static Employee generateEmployee(GameLevel level) {
        return new Employee(generateEmployeeName(), level.generateSkillList());
    }

    /**
     * check if there is any empty computer in company then assign employee into
     * that computer, return true if having empty computer
     *
     */
    public static boolean assignComputerToEmployee(Company company, Employee employee) {
        Map<Computer, Employee> computerMap = company.getComputerList();
        for (Computer com : computerMap.keySet()) {
            if (computerMap.get(com) == null) {
                computerMap.put(com, employee);
                return true;
            }
        }
        return false;
    }
}
