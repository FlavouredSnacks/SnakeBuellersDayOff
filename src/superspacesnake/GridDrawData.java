/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superspacesnake;

import java.awt.Point;

/**
 *
 * @author Slugs
 */
public interface GridDrawData {

    public int getCellHeight();

    public int getCellWidth();

    public Point getCellSystemCoordinate(Point cellCoordinate);

}
