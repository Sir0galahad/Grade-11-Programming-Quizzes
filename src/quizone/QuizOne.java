/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizone;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author millc9988
 */
public class QuizOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //new city called ez
        City ez = new City();
        //new robot at starting point
        Robot memes = new Robot(ez, 4, 0, Direction.EAST);
        //building stairs
        new Wall(ez, 4, 2, Direction.WEST);
        new Wall(ez, 4, 2, Direction.NORTH);
        new Wall(ez, 3, 3, Direction.WEST);
        new Wall(ez, 3, 3, Direction.NORTH);
        new Wall(ez, 2, 4, Direction.WEST);
        new Wall(ez, 2, 4, Direction.NORTH);
        new Wall(ez, 2, 5, Direction.NORTH);
        new Wall(ez, 2, 5, Direction.EAST);
        new Wall(ez, 3, 6, Direction.EAST);
        new Wall(ez, 4, 7, Direction.EAST);
        new Wall(ez, 2, 5, Direction.NORTH);
        new Wall(ez, 3, 6, Direction.NORTH);
        new Wall(ez, 4, 7, Direction.NORTH);
        //setting up the things
        new Thing(ez, 4, 1);
        new Thing(ez, 3, 2);
        new Thing(ez, 2, 3);
        new Thing(ez, 1, 4);
        //creating a loop that will end at the end of the course
        while (memes.getAvenue() < 9) {
            //creating a loop inside this one to do the first part of the course
            while (memes.getAvenue() < 3) {
                memes.move();
                memes.pickThing();
                memes.turnLeft();
                memes.move();
                memes.turnLeft();
                memes.turnLeft();
                memes.turnLeft();
            }
            //doing final movement of first section
            if (memes.getAvenue() == 3) {
                memes.move();
                memes.pickThing();
            }
            //starting the second section
            if (memes.getAvenue() == 4) {
                memes.move();
                memes.putThing();
            }
            //while robot has stuff in backpack move forward and down then put thing
            while (memes.countThingsInBackpack() > 0) {
                memes.move();
                memes.turnLeft();
                memes.turnLeft();
                memes.turnLeft();
                memes.move();
                memes.putThing();
                memes.turnLeft();
            }
            memes.move();
        }
    }
}
