package particleengine;

import java.awt.Color;

/**
 * The particle objects. This is, essentially, the physical particles you
 * see on the screen, that are created by the Emitter object.
 */
public class Particle {
    
    /**
     * The x position of the particle.
     */
    private double myX;
    
    /**
     * The y position of the particle.
     */
    private double myY;
    
    /**
     * The speed of the particle.
     */
    private double mySpeed;
    
    /**
     * The angle at which the particle travels.
     */
    private double myAngle;
    
    /**
     * The max life(based on updates) of the particle.
     */
    private int myLife;
    
    /**
     * The age of the particle.
     */
    private int myLived;
    
    /**
     * The speed at which the particle travels along the x axis. This will be
     * based around the angle and speed of the particle. This is, essentially,
     * the true speed, just horizontally.
     */
    private double myXVelocity;
    
    /**
     * The speed at which the particle travels along the y axis. This will be
     * based around the angle and speed of the particle. This is, essentially,
     * the true speed, just vertically.
     */
    private double myYVelocity;
    
    /**
     * The size of the particle.
     */
    private int mySize;
    
    /**
     * The colour of the particle.
     */
    Color myColor;
    
    /**
     * The contructor of the particle. Yes, it takes in a lot of parameters.
     * 
     * @param x position of the particle.
     * @param y position of the particle.
     * @param angle of the particle.
     * @param speed of the particle.
     * @param life of the particle.
     * @param size of the particle.
     * @param color of the particle.
     */
    public Particle(int x, int y, double angle, double speed, int life, int size, Color color) {
        myX = x;
        myY = y;
        mySpeed = speed;
        myLife = life;
        myLived = 0;
        myAngle = angle * Math.PI / 180;
        myXVelocity = Math.cos(myAngle) * mySpeed;
        myYVelocity = -Math.sin(myAngle) * mySpeed;
        myColor = color;
        mySize = size;
    }
    
    /**
     * Method used to check if the particle has completed it's life cycle.
     * @return whether it should die or not.
     */
    public boolean doIDie() {
        myLived++;
        return (myLife == myLived);
    }
    
    /**
     * Updates the x and y values of the particle. It adds the current x and y
     * positions to the velocity of the object.
     */
    public void updateXY() {
        myX += myXVelocity;
        myY += myYVelocity;
    }
    
    /**
     * @return the x value of the object.
     */
    public double getX() {
        return myX;
    }
    
    /**
     * @return the y value of the object.
     */
    public double getY() {
        return myY;
    }
    
    public int getSize() {
        return mySize;
    }
    
    /**
     * @return the colour of the object.
     */
    public Color getColor() {
        return myColor;
    }
}
