import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Write a description of class EmojiWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EmojiWorld extends World
{
    private int coins,lives, wave;
    
    
    private int scale = 10;
    public Integer[][] map;
    public static ArrayList<Point> oTracks;
    public static Track typicalTrack;
    
    /**
     * Constructor for objects of class EmojiWorld.
     * 
     */
    public EmojiWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super( 960, 540, 1, false); 
        coins = 300;
        lives = 10;
        wave = 0;
        addObject(new WaveMaker(), 0, 30);
        
        
        map = new Integer[scale][scale];
        ArrayList<Point> tracks = new ArrayList<Point>();
        // init map to all 0's
        for (int i = 0; i < scale; i++) {
            for (int j = 0; j < scale; j++) {
                map[i][j] = new Integer(0);
            }
        }
        
        // start point
        map[0][0] = new Integer(1);
        tracks.add(new Point(0, 0));
        
        // Randomly generate points
        for (int i = 0; i < scale; i++) {
         for (int j = 0; j < scale; j++) {
             if (Greenfoot.getRandomNumber(50) < 2 && i < scale - 2) {
                    map[i][j] = new Integer(1);
                    tracks.add(new Point(i, j));
                    System.out.println("i = " + i + " j = " + j);
                    i+=2;
                }
            }
        }
        
        // end point
        map[scale - 1][scale - 1] = new Integer(1);
        tracks.add(new Point(scale - 1, scale - 1));
        
        // connect points
        for (int i = 0; i < tracks.size() - 1; i++) {
            int dX = tracks.get(i + 1).x - tracks.get(i).x;
            int dY = tracks.get(i + 1).y - tracks.get(i).y;
            Point p = new Point(tracks.get(i).x, tracks.get(i).y);
            for (int x = p.x; x < p.x + dX; x++) {
                map[x][p.y] = new Integer(1);
            }
            if (dY > 0) {
               for (int y = p.y; y < p.y + dY; y++) {
                   map[p.x + dX][y] = new Integer(1);
               }
            } else {
                for (int y = p.y; y > p.y + dY; y--) {
                   map[p.x + dX][y] = new Integer(1);
                }
            }
            System.out.println("ix = " + dX + " iy = " + dY);
        }
        // generate track template
        typicalTrack = new Track(getWidth(), getHeight(), scale, this);
        // render map
        for (int i = 0; i < scale; i+=1) {
            for (int j = 0; j < scale; j+=1) {
                if (map[i][j] == 1) {
                    Track t = new Track(getWidth(), getHeight(), scale, this);
                    GreenfootImage img = t.getImage();
                    addObject(t, i * img.getWidth() + (img.getWidth() / 2), j * img.getHeight() + (img.getHeight() / 2));
                }
            }
        }
        // create path
        oTracks = new ArrayList<Point>();
        oTracks.add(new Point(0, 0));
        while (true) {
            Point lastT = oTracks.get(oTracks.size() - 1);
            if (getMapIndex(lastT.x + 1, lastT.y) == 1) {
                Point p = new Point(lastT.x + 1, lastT.y);
                if (!oTracks.contains(p)) {
                    oTracks.add(p);
                    continue;
                }
            }
            if (getMapIndex(lastT.x, lastT.y - 1) == 1) {
                Point p = new Point(lastT.x, lastT.y - 1);
                if (!oTracks.contains(p)) {
                    oTracks.add(p);
                    continue;
                }
                
            }
            if (getMapIndex(lastT.x, lastT.y + 1) == 1) {
                Point p = new Point(lastT.x, lastT.y + 1);
                if (!oTracks.contains(p)) {
                    oTracks.add(p);
                    continue;
                }
            }
            break;
        }
        
        addObject(new Next(), 66, 505);
    }
    
    private int getMapIndex(int x, int y) {
        if (x > -1 && x < scale && y > -1 && y < scale) {
            return map[x][y];
        }
        return -1;
    }
    
    public void act(){
        int rWave = wave + 1;
        showText("Coins: " + coins, getWidth()/2, 10);
        showText("Lives: " + lives , getWidth()/2, 30);
        showText("Wave: " + rWave , getWidth()/2, 50);
        
        // spawn tower
        if(Greenfoot.mouseClicked(this) && coins > 99){
           coins -= 100;
           MouseInfo mouse = Greenfoot.getMouseInfo();
           addObject(new Tower(), mouse.getX(), mouse.getY());
        }
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
    
    public void setWave(int w){
        wave = w;
    }
    
    public int getTileScale() {
        return scale;
    }
    
    public Integer[][] getMap() {
        return map;
    }
}
