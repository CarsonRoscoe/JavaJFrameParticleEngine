package particleengine;

import java.awt.Color;
import java.util.ArrayList;

/**
 * The Emitter class. This contains the blueprint for the Emitter object,
 * which is used to create and control the particles. Remember, how often
 * this and the particles are updated is based on the timer of whatever is
 * controlling the Emiter, so all variables(emissionRate, minLife, etc) have
 * their values in relation to the frequency of the updates.
 */
public class Emitter{
    
    /**
     * The x value of the Emitter(and the starting x of the particles).
     */
    private int myX;
    
    /**
     * The y value of the Emitter(and the starting y of the particles).
     */
    private int myY;
    
    /**
     * The emmisionRate of the Emitter, or how often(based on updates from
     * the timer) a new particle is created.
     */
    private int emissionRate;
    
    /**
     * The minimum "life" of a particle. Once the "life" is over, it is
     * destroyed.
     */
    private int minLife;
    
    /**
     * The range of a particles life. If the minLife is 2, and range is 3,
     * the actual life will be somewhere between 2 and 5.
     */
    private int lifeRange;
    
    /**
     * The starting angle of the direction the particles will be shot out at.
     */
    private int minAngle;
    
    /**
     * The range of the direction the particle will be shot out at. If minAngle
     * is zero and angleRange is 30 degree's, it will be between zero and 
     * 30 degrees.
     */
    private int angleRange;
    
    /**
     * The minimum speed of the particle.
     */
    private int minSpeed;
    
    /**
     * The range of the speed of a particle.
     */
    private int speedRange;
    
    /**
     * The minimum size of a particle.
     */
    private int minSize;
    
    /**
     * the range of the size of a particle.
     */
    private int sizeRange;
    
    /**
     * Counter variable for the emissionRate variable. If emissionRate is set
     * to be 10(every 10 updates), this is what counts how many updates it has
     * been since the last emission(creation of a particle).
     */
    private int lastEmission;
    
    /**
     * ArrayList of all the particles created by this Emitter.
     */
    private ArrayList<Particle> list = new ArrayList<Particle>();
    
    /**
     * What color the particles will be.
     */
    private Color color;
    
    /**
     * Contructor for the Emitter object. Initializes all the variables. Set
     * the values within the constructor to be the "settings" you wish the
     * particles to have.
     * 
     * @param x The X position of the Emitter and starting x of the particles.
     * @param y The y position of the Emitter and starting y of the particles.
     */
    public Emitter(int x, int y) {
        myX = x;
        myY = y;
        emissionRate = 2;
        minLife = 10;
        lifeRange = 100;
        minAngle = 0;
        angleRange = 360;
        minSpeed = 3;
        speedRange = 1;
        minSize = 3;
        sizeRange = 2;
        lastEmission = 0;
        color = Color.RED;
    }
    
    /**
     * Update method, which does two tasks. First, it checks if a new particle
     * should be made, and if so, calls the method to make it. Second, it 
     * calls the method to update all current particles.
     */
    public void update() {
        lastEmission++;
        if (lastEmission == emissionRate) {
            createParticle();
        }
        updateParticles();
    }
    
    /**
     * @return The ArrayList of particles.
     */
    public ArrayList<Particle> getList() {
        return list;
    }
    
    /**
     * Creates a new particle.
     */
    private void createParticle() {
        double angle = minAngle + Math.random() * angleRange;
        int speed = (int) (minSpeed + Math.random() * speedRange);
        int life = (int) (minLife + Math.random() * lifeRange);
        int size = (int) (minSize + Math.random() * sizeRange);
        list.add(new Particle(myX, myY, angle, speed, life, size, color));
        lastEmission = 0;
    }
    
    /**
     * Updates all the current particles and deletes the ones that have 
     * expired.
     */
    private void updateParticles() {
        int temp = list.size();
        while (temp-- > 0) {
            Particle particle = list.get(temp);
            particle.updateXY();
            if (particle.doIDie()) {
                list.remove(temp);
            }
        }
    }
}
