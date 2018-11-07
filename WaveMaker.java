import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WaveMaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaveMaker extends Actor
{
    private int wait, wave, level;
    private String currentLevel;
    private String[] levels;
    public WaveMaker(){
        wait = 30;
        wave = 1;
        level = 0;
        levels = new String[5];
        levels[0] = "eeeweeweee";
        levels[1] = "eweeeweee";
        levels[2] = "eeweeeweee";
        levels[3] = "eeeweeeweeee";
        levels[4] = "eeeweeweeeee";
        currentLevel = levels[0];
    }
    public void act() 
    {
        
        if(wait < 1){
            if(currentLevel.length() < 1 ){
                currentLevel = nextLevel();
            }
           parse();  
        }
        wait --;
       
    } 
    
    //eeeeweeee
    //e spawns an evil moji, w waits
    
    public void parse(){
        wait = 30;
        char current = currentLevel.charAt(0);
        currentLevel = currentLevel.substring(1);
        
        switch(current) {
            
            case 'w': wait = 50;
                      break;
            case 'e': getWorld().addObject(new EvilMojis(), getX(), getY());
                      break;
        }
    }
    
    public String nextLevel(){
        level++;
        if(level < levels.length){
            ((EmojiWorld) getWorld()).setWave(level);
            return levels[level];
        }
        
        level = 0;
        ((EmojiWorld) getWorld()).setWave(level);
        wait = 200;
        return levels[level];
        
    }
    
}
