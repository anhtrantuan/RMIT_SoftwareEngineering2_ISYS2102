/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.dificulity;

import devfortress.model.Project;
import devfortress.utilities.Skills;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;

/**
 *
 * @author cathoanghuy
 */
public class EasyLevel implements GameLevel {

    @Override
    public Map<Skills, Integer> generateSkillList() {
        Map<Skills, Integer> map = new HashMap<>();
        Random random = new Random();
        int numOfField = random.nextInt(6) + 2;
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
        
        return new Project(this.generateProjectPayment(),this.generateProjectLevel(),this.generateProjectTime());
    }
}
