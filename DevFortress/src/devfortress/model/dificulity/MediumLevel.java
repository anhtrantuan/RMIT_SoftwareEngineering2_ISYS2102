
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
public class MediumLevel implements GameLevel {

    @Override
    public Map<Skills, Integer> generateSkillList() {
        Map<Skills, Integer> map = new HashMap<>();
        Random random = new Random();
        int numOfField = random.nextInt(4) + 6;
        for (int i = 0; i < numOfField; i++) {
            map.put(Skills.randonSkill(), random.nextInt(5) + 3);
        }
        return map;
    }

    @Override
    public int generateProjectLevel() {
        Random random = new Random();
        return random.nextInt(2) + 3;
    }

    @Override
    public int generateProjectPayment() {
        Random random = new Random();
        return (random.nextInt(81) + 100) * 10000;
    }

    @Override
    public int generateProjectTime() {
        Random random = new Random();
        return random.nextInt(8) + 5;
    }

    @Override
    public Project generateProject() {
        Random random = new Random();
        Map<Skills, Integer> map = new HashMap<>();

        int projectTime = this.generateProjectTime();
        int maxFuntionPoint = projectTime * Constant.MAX_FUCNTION_POINT_MEDIUM;

        int numOfField = random.nextInt(6) + 6;



        for (int i = 0; i < numOfField; i++) {
            int requireFuntionPoint = (random.nextInt(maxFuntionPoint / 2) + 1);
            map.put(Skills.randonSkill(), requireFuntionPoint);
            maxFuntionPoint -= requireFuntionPoint;

            if (maxFuntionPoint <= 5) {

                continue;
            }
        }

        return new Project(this.generateProjectPayment(), this.generateProjectLevel(), projectTime, map);
    }
}
