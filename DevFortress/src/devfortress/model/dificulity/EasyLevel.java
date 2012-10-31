/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.dificulity;

import devfortress.model.Project;
import devfortress.utilities.Constant;
import devfortress.utilities.Skills;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author cathoanghuy
 */
public class EasyLevel implements GameLevel {

    @Override
    public Map<Skills, Integer> generateSkillList() {
        Map<Skills, Integer> map = new HashMap<>();
        Random random = new Random();
        int numOfField = random.nextInt(11) + 4;
        for (int i = 0; i < numOfField; i++) {
            map.put(Skills.randonSkill(), random.nextInt(3) + 1);
        }
        return map;
    }

    @Override
    public int generateProjectLevel() {
        return new Random().nextInt(2) + 1;
    }

    @Override
    public int generateProjectPayment() {
        return new Random().nextInt(500001) + 300000;
    }

    @Override
    public int generateProjectTime() {
        return new Random().nextInt(7) + 2;
    }

    @Override
    public Project generateProject() {
        Random random = new Random();
        Map<Skills, Integer> map = new HashMap<>();

        int projectTime = this.generateProjectTime();
        int maxFuntionPoint = projectTime * Constant.MAX_FUCNTION_POINT_EASY;

        int numOfField = random.nextInt(11) + 4;


        for (int i = 0; i < numOfField; i++) {
            int requireFuntionPoint = (random.nextInt(maxFuntionPoint/2) + 1);
            map.put(Skills.randonSkill(), requireFuntionPoint);
            maxFuntionPoint -= requireFuntionPoint;

            if (maxFuntionPoint <=0) {
                continue;
            } 

        }

        return new Project(this.generateProjectPayment(), this.generateProjectLevel(), projectTime, map);
    }
}
