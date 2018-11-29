import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KissTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KissTower extends Tower
{
    private int attackKeeper = 2;
    
    public KissTower() {
        super(300, 35, 75);
    }
    
    public void act() 
    {
        super.act();
    } 
    
    @Override
    public boolean attack() {
         try {
             
            if (target != null) {
                turnTowards(target.getX(), target.getY());
                if(attackKeeper % 3 == 0){
                  getWorld().addObject(new Attack(target, getDamage(), "eggplant"), getX(), getY());  
                }else{
                  getWorld().addObject(new Attack(target, getDamage(), getType()), getX(), getY());
                }
                attackKeeper ++;
                return true;
            }
        } catch (IllegalStateException e){
            return false;
        }
        return false;
    }
}
