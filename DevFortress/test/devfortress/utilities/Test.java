/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.utilities;

import devfortress.model.Employee;
import devfortress.model.dificulity.EasyLevel;
import devfortress.model.dificulity.GameLevel;
import java.util.List;

/**
 *
 * @author cathoanghuy
 */
public class Test {

    public static void main(String[] args) {
        GameLevel level = new EasyLevel();
//        int numberOfProject = 4;
//        List result = Utilities.generateProjectList(level, numberOfProject);
//        for (int i = 0; i < result.size(); i++) {
//            System.out.println(result.get(i));
//        }

        Employee e = new Employee("Cat Hoang Huy", level.generateSkillList());
        for (Object skill : e.getSkillList().keySet()) {
            System.out.println(skill.toString()+":"+e.getSkillList().get(skill));
        }
        System.out.println(e.getLowestSkillLvl());
        

    }
}
