import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class WaveMaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaveMaker extends Actor
{
    private final int fWait = 40;
    private int wait, wave, level;
     private boolean next = false;
    private String currentLevel;
    private String[] levels;
    public WaveMaker() {
        wait = fWait;
        wave = 1;
        level = 0;
        levels = new String[10];
        levels[0] = "ewwewswepwaawewwssewweawwewwe";
        levels[1] = "eeweeaweseweepwsseeweewaeewe";
        levels[2] = "eeeaweeseweepewesseeawweeeee";
        levels[3] = "eewwseepeewweesseeawwweweee";
        levels[4] = "ewaeeeeeweeseeewpeeeeeeee";
        levels[5] = "eweppseeeweaeeeeppeeeeeeeww";
        levels[6] = "eweawweeeweeseweaeeeeeeepeawewwe";
        levels[7] = "ppewaweseeeeeeeeewaeeeeeepweeeaeeweeeeeeeeeee";
        levels[8] = "eeeeeeseepppeeweeeeeeassasseeeeeeeweeeeaeeeeeewwweee";
        levels[9] = "eeeeeesweeaeeeeweeepppeeeaeeeeeeeeepppeeeppppppppppppappppppppeeeeaeeeeeeeeeeeeeee";
        
        currentLevel = levels[0];
    }
    
    public void act() {
        if(wait < 1 && next == true){
            if(currentLevel.length() < 1 ){
                currentLevel = nextLevel();
            } else{
                parse();   
            }
        }
        wait--;
    } 
    
    //eeeeweeee
    //e spawns an evil moji, w waits
    public void parse() {
        wait = fWait;
        char current = currentLevel.charAt(0);
        currentLevel = currentLevel.substring(1);
        
        switch(current) {
            
            case 'w': wait = 75;
                      break;
            case 'e': getWorld().addObject(new DevilEnemy(), getX(), getY());
                      break;
            case 'p': getWorld().addObject(new TurnipBoi(), getX(), getY());
                      break;
            case 's': getWorld().addObject(new NormalBoi(), getX(), getY());
                      break;
            case 'a': getWorld().addObject(new SkullBoi(), getX(), getY());
                      break;    
        }
    }
    
    public String nextLevel(){
        level++;
        List<Next> temp = getObjectsInRange(4000, Next.class);
        if (!(temp.size() == 0)) {
           Next  butt = temp.get(0);
           butt.setIm("images/nextWaveGlow.png");
        }
        if(level < levels.length){
            ((EmojiWorld) getWorld()).setWave(level);
            next = false;
            
            return levels[level];
        }
        
        level = 0;
        ((EmojiWorld) getWorld()).setWave(level);
        
        next = false;
        
       
        
        return levels[level];
        
    }
    
    public void setNext(Boolean b){
        next = b;
    }
    
}
