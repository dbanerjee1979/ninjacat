import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOver extends World
{

    public GameOver()
    {    
        super(1024, 768, 1);
        setBackground(new GreenfootImage("", 0, Color.WHITE, Color.BLACK));
        addObject(new StartOverInstructions(), 512, 384);
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new NinjaWorld());
        }
    }
}
