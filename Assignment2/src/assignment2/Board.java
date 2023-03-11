/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author Hasnu
 */
 

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import java.awt.Image;
import javax.swing.ImageIcon;


import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import Objects.*;
import java.util.ArrayList;
import java.util.Random;

public class Board extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final int DELAY = 10;
    
	private Player player;
	private int w = 700;
	private int h = 700;
        private boolean check = false;
        
        private PlaneFactory planefactory = FactoryCreator.getPlaneFactory();
        
        private ArrayList<Vehicle> b = new ArrayList<Vehicle>();
        private ArrayList<Vehicle> e = new ArrayList<Vehicle>();
        private Image[] Explosionimage = new Image[4];
        private ImageIcon[] EI = new ImageIcon[4];
        private int q;
        private int p;
        
        private int we,he;
        
        private Image image;
        
        private int enemy_count = 0;
        
        private boolean go=false;
        private int count;
	private Timer timer;
        
        private Graphics2D g;
        
        
    public Board() 
    {    	
        initBoard();
        
    }
        
    private void initBoard() //Initializes all the game objects
    {	
    	addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);
	
        
        player= Player.getInstance("src/Sprites/BF-109E/Type-1/Animation/", 0, 0,this);
        
        
        Controller("src/Sprites/FighterSprite/");
        
        ImageIcon imageIcon = new ImageIcon("src/Sprites/Background/Background.png");
	image = imageIcon.getImage();
        
        setPreferredSize(new Dimension((int)w, (int)h));   //Set the size of Window     
        player.moveTo((int)w/2, (int)h *3/4);
        timer = new Timer(DELAY, this); //Timer with 10 ms delay 
        timer.start();
        
        
    }
    
    
    @Override
    public void paintComponent(Graphics g) //Draws all the components on screen
    {
        if (this.go==false)
        {
    	g.setColor(getBackground());		//get the background color
        g.clearRect(0 , 0, (int)w, (int)h);	//clear the entire window
    	Dimension size = getSize();  //get the current window size  	
        w = (int)size.getWidth();
        h = (int)size.getHeight();

        Graphics2D g2d = (Graphics2D) g;
        
        g.drawImage(image, (int)w, (int)h, null);
        
        player.paintComponent(g2d);//paint the player
        player.BulletRender(g2d);
        
        if(check == true)
        {
        for(int a = 0; a < 4; a++)
            {
                EI[a] = new ImageIcon("src/Sprites/Explosion/"+(a+1)+".png");
                Explosionimage[a] = EI[a].getImage();
				
                this.we = Explosionimage[a].getWidth(null);
                this.he = Explosionimage[a].getHeight(null);
            }
        
           for(int i = 0 ; i < 4 ; i++)
           {
             g2d.drawImage( Explosionimage[i], this.q - this.we/2, this.p - this.he/2, null);
           }
           check =false;
           Toolkit.getDefaultToolkit().sync();
    
        }   
        
        }
        GameOver();
        if(this.go)
           {
               
               g.setColor(Color.red);
               g.setFont(new Font("arial",Font.BOLD,50));
               g.drawString("Game Over", 300, 300);
               
           }    
    }
    
        
    public void actionPerformed(ActionEvent e) {
        
        step();
    }
    
    private void step() 
    {    
        player.move();
        repaint();
        
        Cleanup();	//clean the list from unwanted objects
    }    
    
    private void Cleanup()
    {
    }

    private class TAdapter extends KeyAdapter 
    {

        @Override
        public void keyReleased(KeyEvent e) 
        {
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) 
        {
            player.keyPressed(e);
        }
    }

    public void GameOver()
    {
        for(int i=0;i< this.b.size() ;i++)
        {
            if((this.b.get(i) instanceof EnemyFire) && (player.getBounds().intersects(this.b.get(i).getBounds())))
            {
                this.go=true;
            }
           
        }
    }

    public boolean Collisions(Vehicle e,ArrayList<Vehicle> b)
    {
        for(int i=0;i< b.size() ;i++)
        {
            if((b.get(i) instanceof Bullet) && (e.getBounds().intersects(b.get(i).getBounds())))
            {
                q = e.getX();
                p = e.getY();
                check = true;
                removeBullet(b.get(i));
                return true;
            }
        }
        
        return false;
    }
    
    Random r = new Random();
    
    Vehicle TempBullet,TempEnemy;
    String path;
    
    
    public void Controller(String path)
    {
        this.path = path;
        for(int x=0;x<2;x++)
        {
            addEnemy(planefactory.getEnemy("Fighter", path,r.nextInt(700),0,b,this));
            
        }
        for(int x=0;x<2;x++)
        {
            addEnemy(planefactory.getEnemy("Bomber","src/Sprites/B-17/Type-1/Animation/",r.nextInt(700),0,b,this));
                      
        }
        enemy_count +=4;
  
    }
    public void move()
    {
        for(int i=0;i<b.size();i++)
        {
            
            TempBullet = b.get(i);
            if (TempBullet.getY()<0)
            {
                removeBullet(TempBullet);
            }
            
            TempBullet.move();
        }
        
        for(int i=0;i<e.size();i++)
        {
            TempEnemy = e.get(i);
            
            if(e.get(i).getBounds3().intersects(player.getBounds()))
            {
                TempEnemy.Fire();
            }
            if (TempEnemy.getY()<0)
            {
                removeEnemy(TempEnemy);
            }
            
            TempEnemy.move();
            
        }
        
    }
    public void draw(Graphics2D g)
    {
        for(int i=0;i<b.size();i++)
        {
            TempBullet = b.get(i);
            TempBullet.paintComponent(g);
        }
        for(int i=0;i<e.size();i++)
        {
            TempEnemy = e.get(i);
            TempEnemy.paintComponent(g);
        }
    }
    
    public void addBullet(Vehicle block)
    {
        b.add(block);
    }
    public void removeBullet(Vehicle block)
    {
        b.remove(block);
        enemy_count--;
        if (enemy_count==1)
        {
            Controller("src/Sprites/FighterSprite/");
        }
    }
    public void addEnemy(Vehicle block)
    {
        e.add(block);
    }
    public void removeEnemy(Vehicle block)
    {
        e.remove(block);
    }
    
    
   
    public ArrayList<Vehicle> getBullet()
    {
        return b;
    }
    public ArrayList<Vehicle> getEnemy()
    {
        return e;
    }
    
    
    
    
}
