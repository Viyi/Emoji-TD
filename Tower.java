
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import static greenfoot.ActorVisitor.getWorld;
import java.util.Arrays;
import java.util.List;

public class Tower extends Actor {

    private EvilMojis target;
    private int range, damage, type, rate, timer;

    public Tower() {
        range = 75;
        timer = 0;
        rate = 30;
    }

    public void act() {
        target = locateEnemy();
        timer++;
        if (rate < timer && target != null) {
            if (attack(5)) {
                timer = 0;
            }
        }
    }

    public EvilMojis locateEnemy() {

        List<EvilMojis> temp = getObjectsInRange(range, EvilMojis.class);
        if(temp.size() == 0){
           return new EvilMojis();
        }
        System.out.println("Detected");
        EvilMojis enemy = temp.get(0);
        
        for (EvilMojis e : temp) {
            if(e.getDistance() > e.getDistance()){
                enemy = e;
            }
        }

        

        return enemy;
    }

    public boolean attack(int s) {
        if (target != null) {
          //  getWorld().addObject(new Attack(target, s), 0, 0);
            return true;
        }

        return false;
    }

}
