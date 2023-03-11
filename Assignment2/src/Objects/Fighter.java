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
public class Fighter extends Vehicle{
    private Board c;
    ProjectileFactory projectilefactory = FactoryCreator.getProjectileFactory();
    private boolean ef=true;
    private int fire=0;
    
    Random r = new Random();
    private ArrayList<Vehicle> b = new ArrayList<Vehicle>();
    
   
    public Fighter(String path, int x, int y,ArrayList<Vehicle> b,Board c) {
        super(path, x, y);
        this.b = b;
        this.c =c;
    }
   
    public void move()
    {
      y +=1;   
      if (y>700)
        {
            y=0;
            x = r.nextInt(700);
        }
      if (x>650)
      {
          x=650;
      }
      if(x<50)
      {
          x=50;
      }
     if(c.Collisions(this, b))
        {
            c.removeEnemy(this);
        }
     Collisions2(b);
     
    }
    
    public void Fire()
    {
        if(fire>500)
        {
            fire=5;
        }
        this.fire++;
        if (fire%25==0)
        {
            c.addBullet(projectilefactory.getEnemyFire("EnemyFire","src/Sprites/EnemyFire/",this.x,this.y));
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
     return (new Rectangle(x,y,100,700));  
    }
   
    
    
    
    public void Collisions2(ArrayList<Vehicle> b)
    {
        for(int i=0;i< b.size() ;i++)
        {
            if((b.get(i) instanceof Bullet ) && this.getBounds2().intersects(b.get(i).getBounds2()))
            {
                
                if (b.get(i).getX()>this.getX())
                {
                    x -= 8;
                }
                else
                {
                    x+=8;
                }
            }
        }
    }
}
