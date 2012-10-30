/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.dificulity;

import devfortress.utilities.Skills;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author cathoanghuy
 */
public class EasyLevel implements GameLevel {

    @Override
    public Map<Skills, Integer> generateSkillList() {
        throw new UnsupportedOperationException("Not supported yet.");
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
}
