
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.event;

import devfortress.model.Company;
import devfortress.model.employee.Employee;
import devfortress.model.exception.EmployeeNotExist;
import devfortress.model.facade.Model;
import devfortress.model.project.Project;
import devfortress.utilities.Event;
import devfortress.utilities.Skill;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Cat Hoang Huy
 */
public class ProjectEvent implements EventInterface {
    
    public static Event teamBuilding(Employee e) {
        Project p = e.getWorkingProject();
        Map<Skill, Employee> emList = p.getSkill_employeeMap();
        if (p != null) {
            for (Skill sk : emList.keySet()) {
                emList.get(sk).getTeamBuilding();
            }
            return Event.TEAM_BUILDING_EXERCISE;
        }
        return Event.NO_EVENT;
    }
    
    public static Event gotSued(Employee e, Company c) {
        c.decreaseMoney(c.getMoney() / 4);
        return Event.GOT_SUED_BY_ANOTHER_COMPANY;
    }
    
    public static Event killDeveloper(Employee e, Company c) {
        
        try {
            if (c.getEmployeeList().size() >= 2) {
                int num = new Random().nextInt(c.getEmployeeList().size());
                c.removeEmployee(c.getEmployeeList().get(num));
                num = new Random().nextInt(c.getEmployeeList().size());
                c.removeEmployee(c.getEmployeeList().get(num));
                return Event.DEVELOPER_KILLS_ANOTHER_DEVELOPER;
            }
        } catch (EmployeeNotExist ex) {
        } finally {
            return Event.NO_EVENT;
        }
    }
    
    public static Event GoldenEmployee(Employee e, Model m) {
        m.createGoldenEmployee();
        return Event.GOLDEN_EMPLOYEE;
    }
    
    public static Event warErrupt(Employee e, Company c) throws EmployeeNotExist {
        List<Employee> emList = c.getEmployeeList();
        int number = emList.size() * 2 / 3;
        for (int i = 0; i < number; i++) {
            int n = new Random().nextInt(emList.size());
            c.removeEmployee(emList.get(n));
        }
        return Event.WAR_ERUPTS;
    }
    
    public static Event companyBurnt(Employee e, Company c) throws EmployeeNotExist {
        List<Employee> emList = c.getEmployeeList();
        for (Employee employee : emList) {
            if (!employee.isLoyal()) {
                c.removeEmployee(employee);
                c.decreaseMoney(c.getMoney() * 2 / 3);
            }
        }
        return Event.COMPANY_IS_BURNT_DOWN_BY_ANONYMOUS;
    }
    
    public static Event zombie(Employee e, Company company) {
        company.decreaseMoney(company.getMoney());
        return Event.ZOMBIE_APOCALYPSE;
    }
}
