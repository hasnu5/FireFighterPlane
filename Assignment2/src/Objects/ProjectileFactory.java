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
public class ProjectileFactory {
    public Bullet getBullet(String bullet,String path, int x, int y)
    {
        if(bullet.equalsIgnoreCase("PlayerFire"))
        {
            return new Bullet(path, x, y);
        }
    return null;
    }
    public EnemyFire getEnemyFire(String bullet,String path, int x, int y)
    {
        if(bullet.equalsIgnoreCase("EnemyFire"))
        {
            return new EnemyFire(path, x, y);
        }
        return null;
    }
}
