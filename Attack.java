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
    
    public Attack(int s, int d, String ty, EvilMojis t){
        speed = s;
        damage = d;
        type = ty;
        target = t;
        
    }
    
     public Attack(EvilMojis t){
        speed = 5;
        damage = 30;
        type = "normal";
        target = t;
        
    }
    
    
    public void act() 
    {
       follow();
    } 
    
    public void follow(){
        
        try{
           moveToTarget();
           
           if (intersects(target)) {
               target.hit(damage,type);
               getWorld().removeObject(this);
           }
   
       } catch(IllegalStateException e) {
           getWorld().removeObject(this);
       }
    }
    
    public void moveToTarget(){
        turnTowards(target.getX(), target.getY());
        move(speed);
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
