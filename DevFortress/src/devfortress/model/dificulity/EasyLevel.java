/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.dificulity;

import devfortress.model.DateTime;
import devfortress.model.Project;
import devfortress.utilities.Constant;
import devfortress.utilities.Skill;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author cathoanghuy
 */
public class EasyLevel implements GameLevel {

    @Override
    public Map<Skill, Integer> generateSkillList() {
        Map<Skill, Integer> map = new HashMap<>();
        Random random = new Random();
        int numOfField = random.nextInt(3) + 4;
        for (int i = 0; i < numOfField; i++) {
            map.put(Skill.randomSkill(), random.nextInt(3) + 1);
        }
        return map;
    }

    @Override
    public int generateProjectLevel() {
        return new Random().nextInt(2) + 1;
    }

    @Override
    public int generateProjectPayment() {
        return (new Random().nextInt(51) + 30) * 10000;
    }

    @Override
    public DateTime generateProjectTime() {
        return new DateTime(0, new Random().nextInt(7) + 2, 0);
    }

    @Override
    public Project generateProject() {
        Random random = new Random();
        Map<Skill, Integer> map = new HashMap<>();

        DateTime projectTime = this.generateProjectTime();
        int maxFuntionPoints = projectTime.getMonths()
                * Constant.MAX_FUCNTION_POINT_EASY;
        int totalPoints = maxFuntionPoints;

        int numOfField = random.nextInt(6) + 2;


        for (int i = 0; i < numOfField; i++) {
            int requireFuntionPoint = (random.nextInt(maxFuntionPoints / 2) + 1);
            map.put(Skill.randomSkill(), requireFuntionPoint);
            maxFuntionPoints -= requireFuntionPoint;

            if (maxFuntionPoints <= 0) {
                continue;
            }

        }

        return new Project("P" + random.nextLong(), totalPoints,
                this.generateProjectPayment(),
                this.generateProjectLevel(), projectTime, map);
    }
}
