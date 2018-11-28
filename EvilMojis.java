
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.Iterator;

/**
 * Write a description of class EvilMojis here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EvilMojis extends Actor {

    private int distanceTraveled, health, speed, direction, value;
    private String type;
    private int sX, sY;
    private Iterator itr = EmojiWorld.oTracks.iterator();
    private GreenfootImage trackImg;

    public EvilMojis(int h, int s, int v) {
        distanceTraveled = 0;
        health = h;
        speed = s;
        direction = v;
        type = "normal";
        value = 5;
        if (itr.hasNext()) {
            Point p = (Point) itr.next();
            sX = p.x;
            sY = p.y;
        }
        trackImg = EmojiWorld.typicalTrack.getImage();
    }

    public void act() {
        distanceTraveled++;
        if (getX() < sX - 20) {
            setLocation(getX() + speed, getY());
        } else if (getX() > sX + 20) {
            setLocation(getX() - speed, getY());
        } else if (getY() < sY - 20) {
            setLocation(getX(), getY() + speed);
        } else if (getY() > sY + 20) {
            setLocation(getX(), getY() - speed);
        } else {
            if (itr.hasNext()) {
                Point p = (Point) itr.next();
                sX = p.x * trackImg.getWidth() + (trackImg.getWidth() / 2);
                sY = p.y * trackImg.getHeight() + (trackImg.getHeight() / 2);
            } else {
                sX = Integer.MAX_VALUE;
            }
        }
        
        //followTrack();
       //move(speed);
       if(getX() > getWorld().getWidth()) {
           ((EmojiWorld) getWorld()).takeLives(1);
           getWorld().removeObject(this);
       }
       if(health < 0) {
           ((EmojiWorld) getWorld()).addCoins(value);
           getWorld().removeObject(this);
           
       }
    }

    public int getDistance() {
        return distanceTraveled;
    }

    public void followTrack() {
        detectTrack();
        turnToTrack();
        move(speed);
    }
    
    private void detectTrack(){
  
            if(getOneObjectAtOffset(0, -2, Track.class) != null && getOneObjectAtOffset(0, 2, Track.class) != null) {
                //Right
                direction = 0;
                setRotation(0);
                
            } else if(getOneObjectAtOffset(0, -30, Track.class) != null){
                //Up
                direction = 2;
                setRotation(-90);
            } else if(getOneObjectAtOffset(0, 30, Track.class) != null){
                //Down
                direction = 1;
                setRotation(90);
            }
            /*else  if(getOneObjectAtOffset(-1,0, Track.class) != null){
                //Right
                direction = 4;
                setRotation(180);
            }*/
        
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

    void hit(int damage, String type) {
        int realD = damage;
        health -= realD;
    }
    
    
}
