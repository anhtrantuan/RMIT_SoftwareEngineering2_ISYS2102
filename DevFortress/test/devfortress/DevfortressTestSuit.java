/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress;

import devfortress.model.CompanyTest;
import devfortress.model.DateTime;
import devfortress.model.difficulty.DifficultTest;
import devfortress.model.difficulty.EasyTest;
import devfortress.model.difficulty.MediumTest;
import devfortress.model.employee.EmployeeBuilderTest;
import devfortress.model.employee.EmployeeTest;
import devfortress.model.event.EventTest;
import devfortress.model.facade.DevFortressTest;
import devfortress.utilities.UtilityTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Cat Hoang Huy
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CompanyTest.class, DateTime.class, DifficultTest.class, MediumTest.class,
    EasyTest.class, EmployeeBuilderTest.class, EmployeeTest.class, UtilityTest.class, DevFortressTest.class, EventTest.class})
public class DevfortressTestSuit {
}
