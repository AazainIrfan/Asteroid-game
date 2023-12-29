/**
 * The Star class represents background stars in the Asteroid Adventure Game.
 * Each Star object displays a static star on the game screen, contributing to 
 * the space-themed environment of the game.
 *
 * @version 1.0
 * @since 2023-04-04
 */
public class Star implements Drawable {
    
    public static final int STAR_RADIUS = 1;
    private Point location;

    /**
     * Constructs a new Star object at a specified location.
     * 
     * @param x The x-coordinate of the star's location.
     * @param y The y-coordinate of the star's location.
     */
    public Star(double x, double y) {
        this.location = new Point(x, y);
    }

    /**
     * Gets the location of the star.
     * 
     * @return The current location of the star as a Point object.
     */
    public Point getLocation() {
        return this.location;
    }

    /**
     * Draws the star on the game screen.
     */
    @Override
    public void draw() {
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledCircle(location.getX(), location.getY(), STAR_RADIUS);
    }
}
