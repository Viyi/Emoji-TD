
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Next here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Next extends Actor {

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
        setImage("images/nextWave.png");
        wave.setNext(true);
    }
    
    public void setIm(String s){
        setImage(s);
    }

}
