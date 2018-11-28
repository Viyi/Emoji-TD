import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Select here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Select extends Actor
{
    public void act() 
    {
        if (EmojiWorld.towerSel.equals("normalTower")) {
            setImage("images/smiley1.png");
        } else if (EmojiWorld.towerSel.equals("tongueTower")) {
            setImage("images/smiley5.png");
        } else if (EmojiWorld.towerSel.equals("waterTower")) {
            setImage("images/water1.png");
        } else if (EmojiWorld.towerSel.equals("kissTower")) {
            setImage("images/kiss1.png");
        }
    }    
}
