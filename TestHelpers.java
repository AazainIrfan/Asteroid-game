/**
 * The TestHelpers class provides utility methods for testing in the 
 * Asteroid Adventure Game. It includes methods for comparing numerical values 
 * and game elements within a certain tolerance, useful in JUnit tests.
 *
 * @version 1.0
 * @since 2023-04-04
 */
public class TestHelpers {
    
    private static final double EPSILON = 0.01; // Tolerance for comparison

    /**
     * Compares two double values with a tolerance.
     * 
     * @param a The first double to compare.
     * @param b The second double to compare.
     * @return True if the values are close enough within the tolerance.
     */
    public static boolean closeEnough(double a, double b) {
        return Math.abs(a - b) < EPSILON;
    }

    /**
     * Compares two Pose objects for equality within a certain tolerance.
     * 
     * @param a The first Pose to compare.
     * @param b The second Pose to compare.
     */
    public static void comparePoses(Pose a, Pose b) {
        comparePoints(a, b);
        assertEquals(a.getHeading(), b.getHeading(), EPSILON, "Pose.heading");
    }

    /**
     * Compares two Point objects for equality within a certain tolerance.
     * 
     * @param a The first Point to compare.
     * @param b The second Point to compare.
     */
    public static void comparePoints(Point a, Point b) {
        assertEquals(a.getX(), b.getX(), EPSILON, "Point.xPosition");
        assertEquals(a.getY(), b.getY(), EPSILON, "Point.yPosition");
    }
    
    /**
     * Compares two Vector2D objects for equality within a certain tolerance.
     * 
     * @param a The first Vector2D to compare.
     * @param b The second Vector2D to compare.
     */
    public static void compareVectors(Vector2D a, Vector2D b) {
        assertEquals(a.getX(), b.getX(), EPSILON, "Vector2D.xComponent");
        assertEquals(a.getY(), b.getY(), EPSILON, "Vector2D.yComponent");
    }
}
