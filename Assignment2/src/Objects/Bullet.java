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
public class Bullet extends Vehicle {
    
    public Bullet(String path, int x, int y)
    {
        super(path, x, y);
    }
    
   
    public void Fire()
    {
        
    }
    public void move()
    {
        y -= 15;
        
    }
    public Rectangle getBounds()
    {
        return (new Rectangle(x,y,80,50));
    }
    public Rectangle getBounds2()
    {
        
        return (new Rectangle(x,y,80,500));

    }
    public Rectangle getBounds3()
    {
        return null;                
    }
    
}
