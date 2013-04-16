import java.applet.*;
import java.awt.*;

/**
 *  Template for all good Applets
 *
 *  @author Tim Rohaly
 */
public class SceneShow extends Applet implements Runnable {

    Thread theThread;

    /**
     * Provides a way for author to associate information with
     * an Applet.  Can be used for copyright, contact information, etc.
     * @return credits
     */
    public String getAppletInfo() {
        StringBuffer s = new StringBuffer();

        s.append("Applet Template\n");
        s.append((char)   169);               // Copyright symbol
//      s.append((char)0x2122);               // Trademark symbol
        s.append("1996 ORC Incorported, All Rights Reserved\n");

        return s.toString();
    }

    /**
     * Describes all user parameters for this Applet; their names,
     * types, and default values.
     * @return parameter name, type, description
     */
    public String[][] getParameterInfo() {
        String[][] result = {
            { "Parameter1", "int",     "Iterations (default 5)" },
            { "Parameter2", "float",   "Variation (default 2.0)" },
            { "Parameter3", "boolean", "Sea (default true)" },
        };
        return result;
    }

    /**
     * Called once to initialize the Applet.
     * Create Components, lay them out, and perform any
     * initializations here.
     */
    public void init() {
    }

    /**
     * Called to start the Applet initially, and whenever Applet
     * is restarted (re-visiting a page, for instance).
     * Start up threads here.
     */
    public void start() {
        if (theThread == null) {
            theThread = new Thread(this);
            theThread.start();
        }
    }

    /**
     * Called to stop the Applet whenever it is iconified or the
     * user leaves the page.  Guaranteed to be called before destroy().
     * Stop threads here.
     */
    public void stop() {
        if (theThread != null) {
            theThread.stop();
            theThread = null;
        }
    }

    /**
     * Used to clean up system resources.
     */
    public void destroy() {
    }

    /**
     * Used to do any drawing to screen.
     * @param g Graphic to use
     */
    public void paint(Graphics g) {
    }

    /**
     * All work should be done here.
     */
    public void run() {
    }

    /**
     * Used to handle action events.
     * @param e event which generated this action 
     * @param arg data associated with this action 
     * @return true if event was handled
     */
    public boolean action(Event e, Object arg) {
        return false;
    }
}