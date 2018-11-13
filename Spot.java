import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spot extends Actor
{
    /**
     * Act - do whatever the Spot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       addSpot();
    } 
    public void addSpot()
    {
        MouseInfo mouse= Greenfoot.getMouseInfo();
        if(mouse==null)return;
        int x = mouse.getX();
        int y = mouse.getY();
        if(Greenfoot.mouseClicked(null)){
            getWorld().addObject(new Tower(), x, y);
        }
    }
}
