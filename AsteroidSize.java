/**
 * The AsteroidSize enum defines the different sizes of asteroids in the 
 * Asteroid Adventure Game. Each size has associated properties like radius 
 * and points, affecting gameplay dynamics.
 *
 * @version 1.0
 * @since 2023-04-04
 */
public enum AsteroidSize {
    SMALL(10, 200),
    MEDIUM(20, 100),
    LARGE(30, 50);
    
    private final int radius;
    private final int points;

    /**
     * Constructs an AsteroidSize with specified radius and points.
     * 
     * @param radius The radius of the asteroid.
     * @param points The points awarded for destroying the asteroid.
     */
    private AsteroidSize(int radius, int points) {
        this.radius = radius;
        this.points = points;
    }

    /**
     * Gets the radius of the asteroid size.
     * 
     * @return The radius of the asteroid.
     */
    public int getRadius() {
        return this.radius;
    }

    /**
     * Gets the points awarded for destroying the asteroid.
     * 
     * @return The points for the asteroid.
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * Randomly selects an asteroid size, with each size having an equal probability.
     * 
     * @return A randomly selected AsteroidSize.
     */
    public static AsteroidSize randomSize() {
        double choice = GameDriver.GENERATOR.nextDouble();
        if (choice <= 0.25) {
            return AsteroidSize.SMALL;
        }
        else if (choice >= 0.25 && choice <= 0.50 ) {
            return AsteroidSize.MEDIUM;
        }
        else {
            return AsteroidSize.LARGE;
        }

    }
}
