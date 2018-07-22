import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Gem extends Actor
{
    Score score;
    int velocity;
    
    public Gem(Score score, int velocity) {
        this.score = score;
        this.velocity = velocity;
    }
    
    public void act() 
    {
        setLocation(Math.max(getX() - velocity, 0), getY());
        
        if (getX() == 0) {
            getWorld().removeObject(this);
        }
    }
    
    public void snagged()
    {
        getWorld().removeObject(this);
        score.bump(10);
    }
}
