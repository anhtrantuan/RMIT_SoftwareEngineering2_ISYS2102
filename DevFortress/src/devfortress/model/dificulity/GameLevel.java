/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.dificulity;

import devfortress.utilities.Skills;
import java.util.Map;

/**
 *
 * @author cathoanghuy
 */
public interface GameLevel {

    Map<Skills, Integer> generateSkillLisl();
}
