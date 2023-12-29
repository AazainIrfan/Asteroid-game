/**
 * The Asteroid class represents asteroids in the Asteroid Adventure Game. 
 * It extends the Enemy class and is used as one of the primary obstacles 
 * for the player to navigate and destroy.
 *
 * @version 1.0
 * @since 2023-04-04
 */
public class Asteroid extends Enemy {
    public static final int ASTEROID_SPEED = 1;

    /**
     * Constructs an Asteroid object with a specified size.
     * 
     * @param size The size of the asteroid, determining its properties.
     */
    public Asteroid(AsteroidSize size) {
        super(ASTEROID_SPEED, size.getRadius(), size.getPoints());
    }

    /**
     * Draws the asteroid on the game screen.
     */
    @Override
    public void draw() {
        StdDraw.getPenColor();
        StdDraw.circle(pose.getX(), pose.getY(), getRadius());
    }
}
