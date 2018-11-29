import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Select here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Select extends Actor
{
    String cost = "0";
    public void act() 
    {
        if (EmojiWorld.towerSel.equals("normalTower")) {
            cost = "Cost: 100";
            setImage("images/smiley1.png");
        } else if (EmojiWorld.towerSel.equals("tongueTower")) {
            cost = "Cost: 200";
            setImage("images/smiley5.png");
        } else if (EmojiWorld.towerSel.equals("waterTower")) {
            cost = "Cost: 300";
            setImage("images/water1.png");
        } else if (EmojiWorld.towerSel.equals("kissTower")) {
            cost = "Cost: 500";
            setImage("images/kiss1.png");
        }
        
        getWorld().showText(cost, getX(), getY() + 40);
    }    
}
