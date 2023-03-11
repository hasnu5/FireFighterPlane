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

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import Objects.MyPoint;
import java.awt.Rectangle;
import assignment2.Board;


import javax.swing.ImageIcon;

public class Player extends Vehicle
{
    private Board c;
    ProjectileFactory projectilefactory = FactoryCreator.getProjectileFactory();
    
	private Player(String path, int x, int y,Board c)
	{
		super(path, x, y);
               this.c = c;
	}
	
	private Player(String path, MyPoint p)
	{
		super(path, p);
                this.c = c;
	}
        private static Player player;
        
        public static Player getInstance(String path, int x, int y,Board c)
        {
            player = new Player(path, x, y,c);
            return player;
        }
	public void move()
	{
		this.x += dx;
		this.y += dy;
                BulletTick();
                if (x>700)
                {
                    x=700;
                }
                else if(x<0)
                {
                    x=0;
                }
                if (y>700)
                {
                    y=700;
                }
                else if(y<0)
                {
                    y=0;
                }
                
	}
	
	public void keyPressed(KeyEvent e) 
	{
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -4;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 4;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -4;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 4;
        }
        if (key == KeyEvent.VK_SPACE) {
            Fire();
        }
    }
	public void Fire()
	{
            c.addBullet(projectilefactory.getBullet("playerfire","src/Sprites/PlayerFire/",this.x,this.y));
	}
        
        
        public void BulletRender(Graphics2D g)
        {
            c.draw(g);
        }
        public void BulletTick()
        {
            c.move();
        }
        
        
    public void keyReleased(KeyEvent e) 
    {        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
        
    }
    
    public Rectangle getBounds3()
    {
        return null;
    }
   public Rectangle getBounds2()
    {
        return (new Rectangle(x+16,y,100,50));
    }
    public Rectangle getBounds()
    {
        return (new Rectangle(x,y,80,100));
    }
}

