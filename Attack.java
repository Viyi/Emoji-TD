import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Attack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Attack extends Actor
{
    private int speed;
    private int damage;
    private String type;
    private EvilMojis target;
    
    public Attack(int speed, int damage, String type, EvilMojis target) {
        this.speed = speed;
        this.damage = damage;
        this.type = type;
        this.target = target;
        
    }
    
     public Attack(EvilMojis t, int damage) {
        speed = 5;
        this.damage = damage;
        type = "normal";
        target = t;
    }
    
    public Attack(EvilMojis t, int damage, String type) {
        speed = 5;
        this.damage = damage;
        this.type = type;
        target = t;
        
        if(type.equals("tongue")){
            setImage("images/tongueAtk.png");
        }else if(type.equals("smile")){
            setImage("images/smileAtk.png");
        }else if(type.equals("water")){
            setImage("images/waterAtk.png");
        }else if(type.equals("eggplant")){
            setImage("images/eggplant.png");
        }
    }
    
    public void act() {
        
       follow();
    } 
    
    public void follow() {
        try {
           moveToTarget();
           if (intersects(target)) {
               target.hit(damage,type);
               getWorld().removeObject(this);
           }
       } catch(IllegalStateException e) {
           getWorld().removeObject(this);
       }
    }
    
    public void moveToTarget() {
        turnTowards(target.getX(), target.getY());
        move(speed);
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public int getDamage() {
        return damage;
    }
    
    public EvilMojis getTarget() {
       return target; 
    }
    
    public String type() {
        return type;
    }
    
    public void setSpeed(int s) {
        speed= s;
    }
    
    public void setDamage(int d) {
        damage= d;
    }
    
    public void setTarget(EvilMojis e) {
        target= e;
    }
    
    public void setType(String t) {
        type=t;
    }
}
