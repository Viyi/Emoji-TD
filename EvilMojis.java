
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class EvilMojis here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EvilMojis extends Actor {

    private int distanceTraveled, health, speed, direction;

    public EvilMojis() {
        distanceTraveled = 0;
        health = 100;
        speed = 5;
        direction = 1;
    }

    public void act() {
        distanceTraveled++;
        followTrack();
    }

    public int getDistance() {
        return distanceTraveled;
    }

    public void followTrack() {
        detectTrack();
        turnToTrack();
        
        move(speed);

    }

    public int setRot(int r){
        
        setRotation(r);
        
        directionToRotation();
        
        return direction;
    }
    private void detectTrack(){
  
            if(getOneObjectAtOffset(1, 0, Track.class) != null){
                //Right
                direction = 0;
                setRotation(0);
                
            }else  if(getOneObjectAtOffset(0, -1, Track.class) != null){
                //Up
                direction = 1;
                setRotation(-90);
            }else  if(getOneObjectAtOffset(0, 1, Track.class) != null){
                //Down
                direction = 2;
                setRotation(90);
            }else  if(getOneObjectAtOffset(-1,0, Track.class) != null){
                //Right
                direction = 4;
                setRotation(180);
            }
        
    }
    
    private void directionToRotation(){
        if(getRotation() == 0){
            direction = 0;
        }
        
        if(getRotation() == -90){
            direction = 1;
        }
        
        if(getRotation() == 90){
            direction = 2;
        }
        
        if(getRotation() == 180){
            direction = 3;
        }
    }
    
    private void turnToTrack(){
        if(direction == 0){
            if(getRotation() != 0){
                setRotation(0);
            }
        }else if(direction == 1){
            if(getRotation() != -90){
                setRotation(-90);
            }
        }else if(direction == 2){
            if(getRotation() != 90){
                setRotation(90);
            }
        }else if(direction == 0){
            if(getRotation() != 180){
                setRotation(180);
            }
            
        }
    }
    
    
}
