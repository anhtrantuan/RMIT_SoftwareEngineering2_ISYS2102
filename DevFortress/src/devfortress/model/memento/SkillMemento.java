/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.memento;

import devfortress.utilities.Skill;
import java.util.Map;

/**
 *
 * @author Cat Hoang Huy
 */
public class SkillMemento {

    private Map<Skill, Integer> skillList;
    private float price;

    public SkillMemento(Map<Skill, Integer> skillList, float price) {
        this.skillList = skillList;
        this.price = price;
    }

    public Map<Skill, Integer> restoreSkill() {
        return skillList;
    }

    public float restorePrice() {
        return price;
    }
}
