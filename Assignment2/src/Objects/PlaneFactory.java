/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import assignment2.Board;
import java.util.ArrayList;

/**
 *
 * @author Hasnu
 */
public class PlaneFactory {
    public Vehicle getEnemy(String enemy,String path, int x, int y,ArrayList<Vehicle> b,Board c)
    {
        if(enemy.equalsIgnoreCase("FIGHTER"))
        {
            return new Fighter(path, x, y, b, c);
        }
        else if(enemy.equalsIgnoreCase("BOMBER"))
        {
            return new Bomber(path, x, y, b, c);
        }
        return null;
    }
}
