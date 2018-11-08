import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Track here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Track extends Actor
{
    /**
     * Act - do whatever the Track wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private EmojiWorld eW;
    
    public Track(int width, int height, int tile_scale, EmojiWorld eW) {
        GreenfootImage i = getImage();
        i.scale(width / tile_scale, height / tile_scale);
        setImage(i);
        eW = this.eW;
    }
}
