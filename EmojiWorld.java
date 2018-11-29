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
    private int coins, lives, wave;
    
    //scale for map tiles
    private int scale = 10;
    // emoji map
    private Integer[][] map;
    
    public static ArrayList<Point> oTracks;
    public static Track typicalTrack;
    public static String towerSel = "normalTower";
    
    
    /*
     * Constructor for objects of class EmojiWorld.
     */
    public EmojiWorld() {
        super(960, 540, 1, false);
        
        
        coins = 300;
        lives = 10;
        wave = 1;
        
        addObject(new WaveMaker(), 0, 30);
        addObject(new Select(), 895, 30);
        
        genMap();

        addObject(new Next(), 66, 505);
    }
    
    public void act() {
        int rWave = wave + 1;
        
        if (lives < 0) {
            showText("Game Over.", getWidth() / 2, getHeight() / 2);
            Greenfoot.stop();
        }
        if (wave > 10) {
            showText("You Win!.", getWidth() / 2, getHeight() / 2);
            Greenfoot.stop();
        }
        
        showText("Coins: " + coins, getWidth() / 2, 10);
        showText("Lives: " + lives , getWidth() / 2, 30);
        showText("Wave: " + wave , getWidth() / 2, 50);
        
        // spawn tower
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            int x = mouse.getX();
            int y = mouse.getY();
            if(Greenfoot.mouseClicked(this) && y < 540 - 100){
                if (EmojiWorld.towerSel.equals("normalTower") && coins > 99) {
                    addObject(new NormalTower(), x, y);
                    coins -= 100;
                } else if (EmojiWorld.towerSel.equals("tongueTower") && coins > 199) {
                    addObject(new tongueTower(), x, y);
                    coins -= 200;
                } else if (EmojiWorld.towerSel.equals("waterTower") && coins > 299) {
                    addObject(new WaterTower(), x, y);
                    coins -= 300;
                } else if (EmojiWorld.towerSel.equals("kissTower") && coins > 499) {
                    addObject(new KissTower(), x, y);
                    coins -= 500;
                }
            }
        }
        
        if (Greenfoot.isKeyDown("1")) {
            towerSel = "normalTower";
        } else if (Greenfoot.isKeyDown("2")) {
            towerSel = "tongueTower";
        } else if (Greenfoot.isKeyDown("3")) {
            towerSel = "waterTower";
        } else if (Greenfoot.isKeyDown("4")) {
            towerSel = "kissTower";
        }
    }
    
    private void genMap() {
        map = new Integer[scale][scale];
        ArrayList<Point> tracks = new ArrayList<Point>();
        // init map to all 0's
        for (int i = 0; i < scale; i++) {
            for (int j = 0; j < scale; j++) {
                map[i][j] = new Integer(0);
            }
        }
        
        // create start point
        map[0][0] = new Integer(1);
        tracks.add(new Point(0, 0));
        
        // Randomly generate points
        for (int i = 0; i < scale; i++) {
         for (int j = 1; j < scale - 1; j++) {
             if (Greenfoot.getRandomNumber(50) < 25 && i < scale - 2) {
                    map[i][j] = new Integer(1);
                    tracks.add(new Point(i, j));
                    i+=2;
                }
            }
        }
        
        // create end point
        map[scale - 1][scale - 1] = new Integer(1);
        tracks.add(new Point(scale - 1, scale - 1));
        
        // connect random points
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
    }
    
    private int getMapIndex(int x, int y) {
        if (x > -1 && x < scale && y > -1 && y < scale) {
            return map[x][y];
        }
        return -1;
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
    
    public void nextWave(){
        wave++;
    }
}
