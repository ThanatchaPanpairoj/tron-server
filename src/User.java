
/**
 * Write a description of class User here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class User
{
    private int x, z, colorID;
    private double angle;
    
    public User(int x, int z, double angle, int colorID) {
        this.x = x;
        this.z = z;
        this.angle = angle;
        this.colorID = colorID;
    }
    
    public void setX(int newX) {
        x = newX;
    }
    
        public void setZ(int newZ) {
        z = newZ;
    }
    
        public void setAngle(double newAngle) {
        angle = newAngle;
    }
    
    public int getX() {
        return x;
    }
    
    public int getZ() {
        return z;
    }
    
    public double getAngle() {
        return angle;
    }
    
    public int getColorID() {
        return colorID;
    }
}
