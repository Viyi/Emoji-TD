import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Attack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Attack extends Actor
{
    private int speed = -1;
    private int damage= -1;
    private EvilMojis target;
    private String type;
    /**
     * Act - do whatever the Attack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    public int getSpeed()
    {
        return speed;
    }
    public int getDamage()
    {
        return damage;
    }
    public EvilMojis getTarget()
    {
       return target; 
    }
    public String type()
    {
        return type;
    }
    public void setSpeed(int s)
    {
        speed= s;
    }
    public void setDamage(int d)
    {
        damage= d;
    }
    public void setTarget(EvilMojis e)
    {
        target= e;
    }
    public void setType(String t)
    {
        type=t;
    }
}
