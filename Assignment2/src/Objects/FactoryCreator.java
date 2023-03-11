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
public abstract class FactoryCreator {

    public static PlaneFactory getPlaneFactory(){
    
        return new PlaneFactory();
    }
    
    public static ProjectileFactory getProjectileFactory()
    {
        
        return new ProjectileFactory();
        
    }
}

