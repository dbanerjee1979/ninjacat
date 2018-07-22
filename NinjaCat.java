import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class NinjaCat extends Actor
{
    int startingVelocity = 32;
    int velocity;
    int acceleration = -2;
    boolean jumping = false;
    int jumpingFromY;
    
    public void act() 
    {
        if (Greenfoot.isKeyDown("right")) {
            move(8);
        }
        else if (Greenfoot.isKeyDown("left")) {
            move(-8);
        }
        else if (Greenfoot.isKeyDown("space") && !jumping) {
            jumpingFromY = getY();
            jumping = true;
            velocity = startingVelocity;
        }
        
        if (jumping) {
            setLocation(getX(), getY() - velocity);
            velocity = velocity + acceleration;
            if (getY() >= jumpingFromY) {
                setLocation(getX(), jumpingFromY);
                jumping = false;
            }
        }
        
        for (Dog dog : getWorld().getObjects(Dog.class)) {
            if (this.intersects(dog)) {
                if (dog.isBelow(getX(), getY() + 15)) {
                    dog.stomped();
                }
                else {
                    Greenfoot.setWorld(new GameOver());
                }
            }
        }
        
        for (Gem gem : getWorld().getObjects(Gem.class)) {
            if (this.intersects(gem)) {
                gem.snagged();
            }
        }
    }    
}
