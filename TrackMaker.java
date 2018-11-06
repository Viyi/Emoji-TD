import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TrackMaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrackMaker extends Actor
{
    /**
     * Act - do whatever the TrackMaker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TrackMaker(){
        Track t = null;
        Track p = null;
        for(int a = 540; a > 0; a-= 55){
            t = new Track(p);
            getWorld().addObject(t, a, 300);
            p = t;
        }
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
