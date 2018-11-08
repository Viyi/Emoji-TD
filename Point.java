/**
 * Write a description of class Point here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Point implements Comparable  
{
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Object o) {
            Point p = (Point) o;
            if (this.x == p.x && this.y == p.y) {
                return 0;
            }
            return 1;
        }
        
        @Override
        public boolean equals(Object o) {
            Point p = (Point) o;
            if (this.x == p.x && this.y == p.y) {
                return true;
            }
            return false;
        }
        
        @Override
        public String toString() {
            return "x = " + x + " y = " + y;
        }
}
