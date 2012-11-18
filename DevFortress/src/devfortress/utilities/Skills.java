/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.utilities;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author cathoanghuy
 */
public enum Skills {

    C,
    C_PLUSS_PLUSS,
    C_SHARP,
    VB,
    PYTHON,
    PHP,
    RUBY,
    PERL,
    ERLANG,
    PROLOG,
    SQL,
    PL_SQL,
    T_SQL,
    VHDL,
    UNIX,
    WINDOWS,
    ORACLE,
    SQL_SERVER,
    MY_SQL,
    NO_SQL,
    UI_DEVELOPMENT,
    SCALABILITY,
    DOCUMENTATION,
    PERFORMANCE,
    CONFIG_MANAGEMENT,
    LISP,
    HASKELL,
    FORTH,
    DESIGN,
    ALGORITHMS,
    ANALYSIS,
    TEAM_PLAYER,
    COMMUNICATION;
    //...
    private static final List<Skills> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Skills randomSkill() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
