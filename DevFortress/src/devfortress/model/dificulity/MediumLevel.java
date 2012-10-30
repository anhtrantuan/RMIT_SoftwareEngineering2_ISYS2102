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
        return random.nextInt(3) + 2;
    }

    @Override
    public int generateProjectPayment() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public DateTime generateProjectTime() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
