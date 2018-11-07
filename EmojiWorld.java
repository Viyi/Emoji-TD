import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EmojiWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EmojiWorld extends World
{
    private int coins,lives;
    /**
     * Constructor for objects of class EmojiWorld.
     * 
     */
    public EmojiWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super( 960, 540, 1, false); 
        coins = 0;
        lives = 10;
        addObject(new WaveMaker(), 0, 300);
    }
    
    public void act(){
        showText("Coins: " + coins, getWidth()/2, 10);
        showText("Lives: " + lives , getWidth()/2, 30);
    }
    
    public void addCoins(int v){
        coins += v;
    }
    
    public void spendCoins(int v){
        coins -= v;
    }
    
    public void addLives(int l){
        lives += l;
    }
    
    public void takeLives(int l){
        lives -= l;
    }
    
}
