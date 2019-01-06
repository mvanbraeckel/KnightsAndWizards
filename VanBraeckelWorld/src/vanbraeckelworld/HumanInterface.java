/*
 * Mitchell Van Braeckel
 * 24/10/2016
 * An interface for a Human-type object, that defines methods that all humans must implement:
 */

package vanbraeckelworld;

// imports
import TurtleGraphics.*;

public interface HumanInterface {
    public String getName();                //return the name of the human
    public void setName(String nom);        //change the name of the human
    public int getAge();                    //get the age of the human
    public boolean setAge(int a);           //change the age of a human, return false if invalid age
    public double getHeight();              //return the height of a human (in cm)
    public boolean setHeight(double h);     //change the height of a human (in cm), return false if invalid height
    public int getHealth();                 //return the health of a human
    public boolean setHealth(int hp);       //change the health of a human, return false if invalid health
    public void draw(Pen p);                //draw a human
    public void move(int x, int y);         //move a human
    public int getYPos();                   //get Y position of a human
    public int getXPos();                   //get X position of a human
    //public boolean equals(Human other);   
    //public Human clone();                 
    public String toString();               //return a string representation of a human object
} // end HumanInterface class interface
