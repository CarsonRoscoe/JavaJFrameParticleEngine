package particleengine;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * The goal of this program was to create a particle engine inside 
 * JFrame/JPanel. The program has a timer, which is set to activate every 60th
 * of a second. It creates an Emiter object and updates that emitter object
 * every time the timer's "loop"(every tick) is activate. The Emiter object, in
 * turn, create an ArrayList of particles with the settings given to the
 * Emitter object.
 */
public class Engine extends JFrame {
    
    /**
     *  Default serialVersionUID set to 1L.
     */
    private static final long serialVersionUID = 1L;
    
    
    /**
     * The variable that holds the value of the width of the screen.
     */
    private final int screenWidth = 640;
    
    /**
     * The variable that holds the value of the height of the screen.
     */
    private final int screenHeight = 480;
    
    /**
     * The constructor for the class, sets the size of the panel, creates the
     * JPanel via EnginePanel() and utilizes Emitter object.
     */
    public Engine() {
        super("JFrame Particle Engine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new EnginePanel());
        setSize(screenWidth, screenHeight);
        setVisible(true);
    }

    /**
     * The EnginePanel method, which is the panel portion of the JFrame.
     */
    private class EnginePanel extends JPanel{

        /**
         * Sets the serialVersionUID to be 1L.
         */
        private static final long serialVersionUID = 1L;
        
        /**
         * Creation of the Emitter object, which will control all of the
         * particles.
         */
        private Emitter emitter = new Emitter(screenWidth / 2, screenHeight / 2);

        /**
         * The constructor of the EnginePanel method. It adds the
         * Adds the timer.
         */
        public EnginePanel() {
            int delay = 1000 / 60;
            Timer timer = new Timer(delay, new LoopListener());
            timer.start();
        }

        /**
         * The paintComponent method used to draw our particles.
         * 
         * @param g Creates an object reference to the graphics class.
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            ArrayList<Particle> list = emitter.getList();
            
            int size = list.size();
            
            while (size-- > 0) {
                Particle particle = list.get(size);
                g.setColor(particle.getColor());
                g.fillOval(particle.getX(), particle.getY(), 10, 10);
            }
        }
        
        private class LoopListener implements ActionListener {
            /**
             * Updates the Emitter object and then repaints.
             * 
             * @param event creates an object referencing the ActionEvent class.
             */
            public void actionPerformed(ActionEvent event) {
                emitter.update();
                repaint();
            }
        }
    }

    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments are unused.
     */
    public static void main(String[] args) {
        new Engine();
    }

};
