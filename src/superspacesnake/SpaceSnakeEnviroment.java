/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superspacesnake;

import environment.Environment;
import environment.LocationValidatorIntf;
import grid.Grid;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author Slugs
 */
class SpaceSnakeEnviroment extends Environment implements GridDrawData, LocationValidatorIntf {

    private Grid grid;
    private Snake snake;

    public final int SLOW_SPEED = 7;
    public final int MEDIUM_SPEED = 5;
    public final int HIGH_SPEED = 1;
    //OVER 9000!!!

    private int moveDelayLimit = HIGH_SPEED;
    private int moveDelayCounter = 0;

    public SpaceSnakeEnviroment() {
    }

    @Override
    public void initializeEnvironment() {
        this.setBackground(ResourceTools.loadImageFromResource("resources/space.jpg"));
        grid = new Grid(50, 22, 25, 25, new Point(50, 100), Color.DARK_GRAY);

        snake = new Snake();
        snake.setDirection(Direction.DOWN);
        snake.setDrawData(this);
        snake.setLocationValidator(this);

        ArrayList<Point> body = new ArrayList<>();
        body.add(new Point(3, 1));
        body.add(new Point(3, 2));
        body.add(new Point(3, 3));
        body.add(new Point(3, 4));
        body.add(new Point(3, 5));
        body.add(new Point(3, 6));
        body.add(new Point(3, 7));
        body.add(new Point(3, 8));
        body.add(new Point(3, 9));
        body.add(new Point(3, 10));
        body.add(new Point(3, 11));

        snake.setBody(body);

    }

    @Override
    public void timerTaskHandler() {
        if (snake != null) {
            //if counter >= limit then reset counter and move snake
            //else increment counter
            if (this.moveDelayCounter >= this.moveDelayLimit) {
                moveDelayCounter = 0;
                snake.move();
            } else {
                moveDelayCounter++;
            }

        }
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_C) {
            grid.setShowCellCoordinates(!grid.getShowCellCoordinates());
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            snake.setDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            snake.setDirection(Direction.LEFT);

        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            snake.setDirection(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            snake.setDirection(Direction.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_P) {
            snake.togglePaused();
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            snake.grow(2);
        }
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        if (grid != null) {
            grid.paintComponent(graphics);
        }

        if (snake != null) {
            snake.draw(graphics);

        }
    }

    @Override
    public int getCellHeight() {
        return grid.getCellHeight();
    }

    @Override
    public int getCellWidth() {
        return grid.getCellWidth();

    }

    @Override
    public Point getCellSystemCoordinate(Point cellCoordinate) {
        return grid.getCellSystemCoordinate(cellCoordinate);
    }

//<editor-fold defaultstate="collapsed" desc="LocationValidatorIntf">
    @Override
    public Point validateLocation(Point point) {
        if (point.x >= this.grid.getColumns()){
            point.x = 0;
        } else if (point.x < 0) {
            point.x = this.grid.getColumns() -1;
            
        } else if (point.y < 0){
            point.y = this.grid.getRows() -1;
            
        } else if (point.y >= this.grid.getRows()){
            
        }
        
        
        
        return point;
    }

//</editor-fold>
}
