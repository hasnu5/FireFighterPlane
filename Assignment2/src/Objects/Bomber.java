/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;


import assignment2.Board;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Hasnu
 */
public class Bomber extends Vehicle {
   private Board c;
    
    Random r = new Random();
    private ArrayList<Vehicle> b = new ArrayList<Vehicle>();
    
    
    public Bomber(String path, int x, int y,ArrayList<Vehicle> b,Board c) {
        super(path, x, y);
        this.b = b;
        this.c =c;
    }
    public void Fire()
    {
        
    }
    public void move()
    {
      y +=1;   
      if (y>700)
        {
            y=0;
            x = r.nextInt(700);
        }
      if(x<50)
      {
          x=50;
      }
      if (x>650)
      {
          x=650;
      }
     if(c.Collisions(this, b))
        {
            c.removeEnemy(this);
        }
     
    }
   
    public Rectangle getBounds()
    {
        return (new Rectangle(x+16,y,100,50));
    }
    public Rectangle getBounds2()
    {
     return (new Rectangle(x,y,100,200));  
    }
    public Rectangle getBounds3()
    {
     return (new Rectangle(x,y,100,200));  
    }
}
