/**
 * The Saucer class represents a type of enemy in the Asteroid Adventure Game.
 * It extends the Enemy class and adds specific features like unique movement 
 * and point value. Saucers are more challenging enemies that randomly appear 
 * and move in the game area.
 *
 * @version 1.0
 * @since 2023-04-04
 */
public class Saucer extends Enemy{
    
    public static int HALF_WIDTH = 10;
    public static int HALF_HEIGHT = 5;
    public static int SAUCER_SPEED = 2;
    public static int SAUCER_POINTS = 400;
    public static double SPAWN_PROB = 0.002;
    public static double TURN_PROB = 0.05;
    
    /**
     * Constructs a new Saucer object with predefined speed and points.
     */
    public Saucer() {
        super(SAUCER_SPEED, HALF_WIDTH, SAUCER_POINTS);
    }
    
    /**
     * Updates the Saucer's position and handles its random movements and boundary checks.
     */
    public void update() {
       pose = pose.move(velocity);
        double x = pose.getX();
        double y = pose.getY();
        if (x < 0) {
            setDestroyed(true);
        } else if (x > GameDriver.SCREEN_WIDTH) {
            setDestroyed(true);
        } else if (y < 0) {
            setDestroyed(true);
        } else if (y > GameDriver.SCREEN_HEIGHT) {
            setDestroyed(true);
        }
        if (GameDriver.GENERATOR.nextDouble() <= TURN_PROB) {
            velocity = velocity.newHeading(AsteroidsGame.randomHeading());
        }
    }

    /**
     * Draws the Saucer on the game screen.
     */
    @Override
    public void draw() {
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.rectangle(pose.getX(), pose.getY(), HALF_WIDTH, HALF_HEIGHT);
    }
}
