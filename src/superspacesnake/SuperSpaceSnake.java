/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superspacesnake;

import environment.ApplicationStarter;

/**
 *
 * @author Slugs
 */
public class SuperSpaceSnake {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationStarter.run("Super Space Snake", new SpaceSnakeEnviroment());
    }

}
