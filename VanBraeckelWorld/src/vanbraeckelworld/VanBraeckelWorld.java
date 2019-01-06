/*
 * Mitchell Van Braeckel
 * 21/10/2016
 * The world contains three types of humans:
    -> Knights  (RED)
    -> Wizards  (BLUE)
    -> RANGERS  (GREEN)
    Humans can be represented in the world as: small, simple drawings
    The relationship between Humans, Knights and Wizards can be described by the following hierarchy:
        Human implements HumanInterface
            |-> Knight
            |-> Wizard
            |-> RANGER
RAZZLE DAZZLE:
    -> Draw better humanoid shapes and equipment
 */

package vanbraeckelworld;

// imports
import TurtleGraphics.*;
import java.util.Random;

public class VanBraeckelWorld {
    // declare imports
    static Random r = new Random();
    /**
     * Runs the main program class test harness
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Human humans[] = new Human[6];                                          //0. Declares 6 Humans
	humans[0] = new Knight("Sir Lancelot", 32, 150, -150, 175, 180, "Beric");    //1. Instantiates a Knight
	humans[1] = new Wizard("Merlin", 19, 100, 0, 0, 150, 200);              //2. Instantiates a Wizard and moves it. 
        humans[1].move(75, 0);
        humans[2] = ((Knight)humans[0]).clone();                                //3. Clones the Knight and changes its name
        humans[2].setName("King Arthur");
	//4. Checks if the Knight clone is NOT EQUAL to the original Knight, and if so:
	//	a) Moves the clone
        if(!((Knight)humans[0]).equals(((Knight)humans[2]))) {
            humans[2].move(-150, 75);
        } // end if
	humans[3] = ((Wizard)humans[1]).clone();                                //5. Clones the Wizard 
	//6. Checks if the Wizard clone is EQUAL to the original Wizard, and if so:
	//	a) Moves the clone
        if(((Wizard)humans[1]).equals(((Wizard)humans[3]))) {
            humans[3].move(175, 0);
        } // end if
        // =========================================================================================================================
            //10.a) Instantiates a RANGER
        humans[4] = new Ranger("Robin Hood", 23, 125, 0, -150, 210, 200);
            //10.b) Clones the Ranger
        humans[5] = ((Ranger)humans[4]).clone();
            //10.c) Checks if the RANGER clone is EQUAL to the original RANGER, and if so:
                // ii) changes all the clone's attributes (coords, name, age, health, height)
        if(((Ranger)humans[4]).equals(((Ranger)humans[5]))) {
            ((Ranger)humans[5]).move(-150, -100);
            ((Ranger)humans[5]).setName("Merida Brave");
            ((Ranger)humans[5]).setAge(18);
            ((Ranger)humans[5]).setHealth(143);
        } // end if
                //iii) changes #of arrows by shooting 1 to 10 arrows
        int rndNum = r.nextInt(10) + 1; // determine how many arrows are shot by RANGER clone
        for (int i = 1; i <= rndNum; i++) {
            ((Ranger)humans[5]).shootArrow();
        } // end for loop
        // =========================================================================================================================
        Pen p = new StandardPen(750, 750);                                      //7. Draws all humans living in this world
        for (int i = 0; i < 6; i++) {
            humans[i].draw(p);
        } // end for loop
	System.out.println("Number of Humans:\t" + humans[0].getNumHumans());   //8. Prints the total number of Humans living in this world
	for (int i = 0; i < 6; i++) {                                           //9. Prints a description of all Humans to the console.
            System.out.println(humans[i].toString() + "\n");
        } // end for loop
    } // end main
} // end class
