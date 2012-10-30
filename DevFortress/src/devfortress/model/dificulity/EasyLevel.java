/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.dificulity;

import devfortress.model.DateTime;
import devfortress.utilities.Skills;
import java.util.Map;

/**
 *
 * @author cathoanghuy
 */
public class EasyLevel implements GameLevel{

    @Override
    public Map<Skills, Integer> generateSkillLisl() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int generateProjectLevel() {
        throw new UnsupportedOperationException("Not supported yet.");
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
