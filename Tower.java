
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import static greenfoot.ActorVisitor.getWorld;
import java.util.Arrays;
import java.util.List;

public class Tower extends Actor {

    public EvilMojis target;
    
    private int range;
    private int rate;
    private int damage;
    private String type = "";
    private int timer;
    
    public Tower(int range, int rate, int damage) {
        this.range = range;
        this.rate = rate;
        this.damage = damage;
        timer = 0;
    }

    public Tower(int range, int rate, int damage, String type) {
        this.range = range;
        this.rate = rate;
        this.damage = damage;
        this.type = type;
        timer = 0;
        
    }
    
    public void act() {
        locateEnemy();
        timer++;
        if (rate < timer && target != null) {
            if (attack()) {
                timer = 0;
            }
        }
    }

    public void locateEnemy() {
        List<EvilMojis> temp = getObjectsInRange(range, EvilMojis.class);
        if (temp.size() == 0) {
            target = null;
            return;
        }
        EvilMojis enemy = temp.get(0);
        for (EvilMojis e : temp) {

            if (e.getDistance() > enemy.getDistance()) {
                enemy = e;
            }
        }
        target = enemy;
    }

    public boolean attack() {
         try {
            if (target != null) {
                turnTowards(target.getX(), target.getY());
                getWorld().addObject(new Attack(target, damage, type), getX(), getY());
                return true;
            }
        } catch (IllegalStateException e){
            return false;
        }
        return false;
    }
    
    public int getDamage(){
        return damage;
    }
    
    public String getType(){
        return type;
    }


}
