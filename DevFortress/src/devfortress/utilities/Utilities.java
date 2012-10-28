/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.utilities;

/**
 *
 * @author Sherlock
 */
public class Utilities {

    public static int calculateSalaryPoint(int skill, int skillLevel) {
        
        if (skill <= 24) {
            if (skillLevel == 1) {
                if(skill == 24){
                    return 5;
                }
                else return 1;
            } else {
                return calculateSalaryPoint(skill, skillLevel - 1) + 2;
            }
        }
        else if(skill>=25 || skill<=27){
            if (skillLevel == 1) {
                return 1;
            } else {
                return calculateSalaryPoint(skill, skillLevel - 1) + 4;
            }
        }
        else {
            if (skillLevel == 1) {
                return 2;
            } else {
                return calculateSalaryPoint(skill, skillLevel - 1) * 2;
            }
        }
    }
}
