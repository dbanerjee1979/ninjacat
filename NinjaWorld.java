import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class NinjaWorld extends World
{
    Score score;
    
    public NinjaWorld()
    {    
        super(1024, 768, 1);
       
        score = new Score();
        addObject(new Title(), 300, 25);
        addObject(score, 700, 25);
        addObject(new Instructions(), 512, 50);
        addObject(new NinjaCat(), 150, 640);
    }
    
    public void act()
    {
        if (getObjects(Dog.class).isEmpty()) {
            addObject(new Dog(score), 1024, 640);
        }
        
        if (getObjects(Cloud.class).isEmpty()) {
            addObject(new Cloud(), 1024, Greenfoot.getRandomNumber(250) + 115);
        }
        
        if (getObjects(Gem.class).isEmpty() &&  Greenfoot.getRandomNumber(100) < 35) {
            addObject(new Gem(score, Greenfoot.getRandomNumber(10) + 5), 1024, Greenfoot.getRandomNumber(250) + 300);
        }
    }
}
