// Copyright (C) 2008 Universitaet Karlsruhe, Germany
//           (C) 2015 Karlsruhe Institute of Technology, Germany
//
// This source is protected by the GNU General Public License.
//

// Please do NOT add a package declaration here.

import edu.kit.iti.formal.lights.sat.SATSolver;
import org.sat4j.specs.TimeoutException;
import edu.kit.iti.formal.lights.*;

/**
 * This class provides a template for your own solution to the assignment.
 *
 * Please consult the source code for detailed information
 *
 * @author Mattias Ulbrich
 * @version 2015.1
 */

public class MyLightUpSolver implements LightUpSolver {

    /*
     * solve a Light Up puzzle.
     *
     * Consult the source code
     */
    @Override
    public String solve(String desc) throws LightsFormatException, TimeoutException {
        Lights lights = new Lights(desc);
        SATSolver solver = new SATSolver();

        System.out.println(lights.getField(3,4));

        // to show a graphical representation of the board (optional):
        lights.showWindow();

        // [Step 1] add clauses to solver like this:
        solver.addClause(42, -42); //tautology; REMOVE THIS LINE

        // [Step 2] invoke SAT solver
        int[] result = solver.solve();

        if (result != null) {
            // SAT solver found a model
            //  --> [Step 3] interpret SAT solver result; change variable "lights" accordingly:
            // interpret(result, lights);
            lights.setLight(1, 1); //REMOVE THIS LINE!

            // Output result (optional):
            lights.showWindow();

            // [Step 4] Print (optional) and return solution:
            System.out.println(lights.toString());

            return lights.toString();
        } else {
            // unsatisfiable
            System.out.println("UNSAT");
            return null;
        }
    }

    public static void main(String[] args) {
        LightUpSolver solver = new MyLightUpSolver();
        try {
            solver.solve(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

}
