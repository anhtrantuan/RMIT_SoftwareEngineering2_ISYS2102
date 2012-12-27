/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.utilities;

import devfortress.model.Company;
import devfortress.model.Computer;
import devfortress.model.dificulity.GameLevel;
import devfortress.model.employee.DevFortressEmployeeBuilder;
import devfortress.model.employee.Employee;
import devfortress.model.employee.EmployeeBuilder;
import devfortress.model.facade.Model;
import devfortress.model.project.Project;
import java.util.*;

/**
 *
 * @author Sherlock
 */
public class Utilities {

    private EmployeeBuilder employeeBuilder;
    private static Utilities uInstance = null;

    private Utilities() {
        employeeBuilder = new DevFortressEmployeeBuilder();
    }

    public static Utilities getInstance() {
        if (uInstance == null) {
            uInstance = new Utilities();
            return uInstance;
        } else {
            return uInstance;
        }
    }

    public int calculateSalaryPoint(Skill skill, int skillLevel) {

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

    public int calculateSalary(Map<Skill, Integer> skillList) {
        int salary = 0;
        for (Skill sk : skillList.keySet()) {
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

    public List<Project> generateProjectList(GameLevel level,
            int numberOfProject, Model model) {
        List<Project> projects = new ArrayList<Project>();
        for (int i = 0; i < numberOfProject; i++) {
            Project project;
            do {
                project = level.generateProject(Name.getProjectName());
                project.calculateMainSkill();
            } while (projects.contains(project)
                    || !(model == null
                    || model.getProjectByName(project.getName()) == null));
            projects.add(project);
        }
        return projects;
    }

    public List<Employee> generateEmployeeList(GameLevel level,
            int numberOfEmployee, Model model) {
        List<Employee> employees = new ArrayList<Employee>();
        for (int i = 0; i < numberOfEmployee; i++) {
            Employee employee;
            do {
                employee = generateEmployee(level);
            } while (employees.contains(employee)
                    || !(model == null
                    || model.getEmployeeByName(employee.getName()) == null));
            employees.add(employee);
        }
        return employees;
    }

    private String generateEmployeeName() {
        return Name.getEmployeeName();
    }

    private Employee generateEmployee(GameLevel level) {
        employeeBuilder.createNewEmployee();
        employeeBuilder.addName(generateEmployeeName());
        employeeBuilder.addSkillList(level.generateSkillList());
        return employeeBuilder.getEmployee();
    }

    /**
     * check if there is any empty computer in company then assign employee into
     * that computer, return true if having empty computer
     *
     */
    public boolean assignComputerToEmployee(Company company, Employee employee) {
        //assume that Company will automatically buy computer for new employee in case of lacking computer
        Map<Computer, Employee> computerMap = company.getComputerList();
        for (Computer com : computerMap.keySet()) {
            if (computerMap.get(com) == null) {
                computerMap.put(com, employee);
                return true;
            }
        }
        return false;
    }
    /**
     * Create a list of skill that have full level for each skill
     * @return 
     */
    private Map<Skill, Integer> goldenSkillList() {
        Map<Skill, Integer> map = new EnumMap<Skill, Integer>(Skill.class);
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            map.put(Skill.randomSkill(), 10);
        }
        return map;
    }

    /**
     * create employee that have many skill with full level
     * @return 
     */
    public Employee generateGoldenEmployee() {
        employeeBuilder.createNewEmployee();
        employeeBuilder.addName(generateEmployeeName());
        employeeBuilder.addSkillList(goldenSkillList());
        return employeeBuilder.getEmployee();
    }
}
