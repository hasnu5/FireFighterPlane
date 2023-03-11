/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public abstract class Vehicle 
{
	protected Image[] image = new Image[3];
	protected int x;
	protected int y;
	protected int w;
        protected int h;
	protected int dx, dy;
		
	protected long count = 0;
	
	public Vehicle(String path, int x, int y)
	{
		this.x = x;
		this.y = y;
		
		ImageIcon[] imageIcon= new ImageIcon[3];    
            //imageIcon = new ImageIcon[imageIcon.length];
            for (int i = 0; i < 3; ++i)
            {
                imageIcon[i] = new ImageIcon(path+(i+1)+".png");
                image[i] = imageIcon[i].getImage();
				
                w = image[i].getWidth(null);
                h = image[i].getHeight(null);
            }
	}
	
	public Vehicle(String path, MyPoint p)
	{
		x = p.x;
		y = p.y;
		ImageIcon[] imageIcon= new ImageIcon[3];    
            imageIcon = new ImageIcon[imageIcon.length];
            for (int i = 0; i < 3; ++i)
            {
                imageIcon[i] = new ImageIcon(path+(i+1)+".png");
                image[i] = imageIcon[i].getImage();
				
                w = image[i].getWidth(null);
                h = image[i].getHeight(null);
            }
	}
	
	
	public void paintComponent(Graphics2D g) 
	{
		
            int num = (int)(count%3);
            g.drawImage(image[num], x - image[num].getWidth(null)/2, y - image[num].getHeight(null)/2, null);
            g.setColor(new Color(255,0,0));
            count++;
	}
	
	public void moveTo(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public abstract void move();
	public abstract void Fire();
        
	
        public abstract Rectangle getBounds();
        public abstract Rectangle getBounds2();
        public abstract Rectangle getBounds3();
        
        public int getX() {
        return x;
    }

    public int getY() {
        
        return y;
    }
    
    public int getWidth() {
        
        return w;
    }
    
    public int getHeight() {
        
        return h;
    }    

    public Image[] getImage() {
        
        return image;
    }
    public Rectangle getBounds(int width,int height)
    {
        return (new Rectangle((int)x,(int)y,32,32));
    }
	
	
}

