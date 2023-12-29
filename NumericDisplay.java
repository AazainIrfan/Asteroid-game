/**
 * The NumericDisplay class represents on-screen numeric displays in the 
 * Asteroid Adventure Game. It is used to show the player's score and remaining 
 * lives, among other numerical information.
 *
 * @version 1.0
 * @since 2023-04-04
 */
public class NumericDisplay implements Drawable { 
    private String prefix;
    private int value;
    private Point location;

    /**
     * Constructs a new NumericDisplay object at a specified location with a prefix and initial value.
     * 
     * @param xPos X-coordinate of the display's location.
     * @param yPos Y-coordinate of the display's location.
     * @param prefix Text prefix to display before the numeric value.
     * @param value Initial numeric value to display.
     */
    public NumericDisplay(int xPos, int yPos, String prefix, int value) {
        this.location = new Point(xPos, yPos);
        this.prefix = prefix;
        this.value = value;
    }

    /**
     * Gets the location of the numeric display.
     * 
     * @return The location as a Point object.
     */
    public Point getLocation() {
        return this.location;
    }

    /**
     * Gets the current value of the numeric display.
     * 
     * @return The current value.
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Sets a new value for the numeric display.
     * 
     * @param value The new value to be displayed.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Draws the numeric display on the game screen.
     */
    @Override
    public void draw() {
        StdDraw.textLeft(location.getX(), location.getY(), prefix + value);
    }
}
