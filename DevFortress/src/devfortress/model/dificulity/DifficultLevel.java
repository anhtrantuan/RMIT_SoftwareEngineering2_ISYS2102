/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.dificulity;

import devfortress.model.DateTime;
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
public class DifficultLevel implements GameLevel {

    @Override
    public Map<Skills, Integer> generateSkillList() {
        Map<Skills, Integer> map = new HashMap<>();
        Random random = new Random();
        int numOfField = random.nextInt(4) + 10;
        for (int i = 0; i < numOfField; i++) {
            map.put(Skills.randomSkill(), random.nextInt(5) + 6);
        }
        return map;
    }

    @Override
    public int generateProjectLevel() {
        Random random = new Random();
        return random.nextInt(2) + 4;
    }

    @Override
    public int generateProjectPayment() {
        Random random = new Random();
        return (random.nextInt(201) + 300) * 10000;
    }

    @Override
    public DateTime generateProjectTime() {
        Random random = new Random();
        int months = random.nextInt(13) + 12;
        return new DateTime(0, months % 12, months % 12);
    }

    @Override
    public Project generateProject() {
        Random random = new Random();
        Map<Skills, Integer> map = new HashMap<>();

        DateTime projectTime = this.generateProjectTime();
        int maxFuntionPoints = projectTime.getMonths()
                * Constant.MAX_FUNCTION_POINT_DIFFICULT;
        int totalPoints = maxFuntionPoints;

        int numOfField = random.nextInt(6) + 10;


        for (int i = 0; i < numOfField; i++) {
            int requireFuntionPoint = (random.nextInt(maxFuntionPoints / 2) + 1);
            map.put(Skills.randomSkill(), requireFuntionPoint);
            maxFuntionPoints -= requireFuntionPoint;
            if (maxFuntionPoints <= 10) {
                continue;
            }
        }

        return new Project("P" + random.nextLong(), totalPoints,
                this.generateProjectPayment(),
                this.generateProjectLevel(), projectTime, map);
    }
}
