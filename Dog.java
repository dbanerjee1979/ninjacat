import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Dog extends Actor
{
    Score score;
    boolean jumping;
    int acceleration = -2;
    int jumpingFromY;
    int initialVelocity = 32;
    int minVelocity = 15;
    int velocity;
    
    public Dog(Score score)
    {
        this.score = score;
    }
    
    public void act() 
    {
        setLocation(getX() - 8, getY());
        
        if (getX() <= 0) {
            setLocation(getWorld().getWidth(), getY());
        }
        
        if (!jumping) {
            jumping = true;
            jumpingFromY = getY();
            velocity = Greenfoot.getRandomNumber(initialVelocity - minVelocity) + minVelocity;
        }
        else {
            setLocation(getX(), getY() - velocity);
            velocity = velocity + acceleration;
            if (getY() > jumpingFromY) {
                setLocation(getX(), jumpingFromY);
                jumping = false;
            }
        }
    }
    
    public boolean isBelow(int x, int bottomY) 
    {
        if (Math.abs(getX() - x) < 75 && Math.abs((getY() - 75) - bottomY) < 5) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void stomped() 
    {
        getWorld().removeObject(this);
        score.bump(25);
    }
}
