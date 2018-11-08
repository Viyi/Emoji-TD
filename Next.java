
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Next here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Next extends Actor {

    /**
     * Act - do whatever the Next wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            setNext();

        }
    }

    public void setNext() {
        List<WaveMaker> temp = getObjectsInRange(4000, WaveMaker.class);
        if (temp.size() == 0) {
            return;
        }
        WaveMaker wave = temp.get(0);
        setImage("images/world/nextWave.png");
        wave.setNext(true);
    }
    
    public void setIm(String s){
        setImage(s);
    }
    
    

}
