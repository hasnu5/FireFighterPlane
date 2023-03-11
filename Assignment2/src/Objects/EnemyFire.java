/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author Hasnu
 */
import java.awt.*;
public class EnemyFire extends Vehicle {
    
    public EnemyFire(String path, int x, int y)
    {
        super(path, x, y);
    }
    
   
    public void Fire()
    {
        
    }
    public void move()
    {
        y += 5;
        
    }
    public Rectangle getBounds()
    {
        return (new Rectangle(x,y,80,50));
    }
    public Rectangle getBounds2()
    {
        return null;                
    }
    public Rectangle getBounds3()
    {
        return null;                
    }
    
}
