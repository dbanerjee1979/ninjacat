import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cloud extends Actor
{
    public void act() 
    {
        setLocation(Math.max(0, getX() - 6), getY());
        
        if (getX() == 0) {
            getWorld().removeObject(this);
        }
    }    
}
