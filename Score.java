import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Score extends Actor
{
    int score = 0;
    
    public void act() 
    {
         setImage(new GreenfootImage("SCORE: " + score, 24, Color.WHITE, new Color(0, 0, 0, 0)));
    }    
    
    public void bump(int amount) {
        score = score + amount;
    }
}
