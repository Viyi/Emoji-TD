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
    public WaveMaker(){
        wait = fWait;
        wave = 1;
        level = 0;
        levels = new String[10];
        levels[0] = "ewwewwewwewwewwewwewwe";
        levels[1] = "eeweeweeweeweeweeweewe";
        levels[2] = "eeeweeeweeeweeewweeeee";
        levels[3] = "eewweeeewweeeewwweweee";
        levels[4] = "eweeeeeweeeeeweeeeeeee";
        levels[5] = "eweeeeweeeeeeeeeeeeww";
        levels[6] = "ewewweeeweeeweeeeeeeeewewwe";
        levels[7] = "ewweeeeeeeeeeweeeeeeeweeeeeweeeeeeeeeee";
        levels[8] = "eeeeeeeeeeweeeeeeeeeeeeeweeeeeeeeeewwweee";
        levels[9] = "eeeeeeweeeeeeweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
        
        currentLevel = levels[0];
    }
    public void act() 
    {
        
        if(wait < 1 && next == true){
            if(currentLevel.length() < 1 ){
                currentLevel = nextLevel();
            }else{
             parse();   
            }
             
        }
        wait --;
       
    } 
    
    //eeeeweeee
    //e spawns an evil moji, w waits
    
    public void parse(){
        wait = fWait;
        char current = currentLevel.charAt(0);
        currentLevel = currentLevel.substring(1);
        
        switch(current) {
            
            case 'w': wait = 75;
                      break;
            case 'e': getWorld().addObject(new EvilMojis(), getX(), getY());
                      break;
        }
    }
    
    public String nextLevel(){
        level++;
        List<Next> temp = getObjectsInRange(4000, Next.class);
        if (!(temp.size() == 0)) {
           Next  butt = temp.get(0);
           butt.setIm("images/world/nextWaveGlow.png");
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
