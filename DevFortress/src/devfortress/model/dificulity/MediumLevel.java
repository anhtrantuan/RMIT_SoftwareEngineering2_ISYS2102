/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.dificulity;

import devfortress.model.DateTime;
import devfortress.utilities.Skills;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author cathoanghuy
 */
public class MediumLevel implements GameLevel {

    @Override
    public Map<Skills, Integer> generateSkillList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int generateProjectLevel() {
        Random random = new Random();
        return random.nextInt(2) + 2;
    }

    @Override
    public int generateProjectPayment() {
        Random random = new Random();
        return random.nextInt(800001) + 1000000;
    }

    @Override
    public int generateProjectTime() {
        Random random = new Random();
        return random.nextInt(8) + 5;
    }
}
