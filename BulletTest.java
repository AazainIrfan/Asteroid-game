/**
 * The BulletTest class is a JUnit test class for the Bullet class in the 
 * Asteroid Adventure Game. It tests various functionalities of the Bullet class.
 *
 * @version 1.0
 * @since 2023-04-04
 */
public class BulletTest {
    
    private Bullet b;
    private Pose pose; 

    /**
     * Sets up the test environment for each test method.
     */
    @BeforeEach
    public void setup() {
        pose = new Pose(240.0, 240.0, Math.PI/2); 
        b = new Bullet(pose);
    }

    /**
     * Tests if the Bullet class correctly implements the GameElement interface.
     */
    @Test
    public void testImplementsInterface() {
        assertTrue(b instanceof GameElement);
    }

    /**
     * Tests the constant values defined in the Bullet class.
     */
    @Test
    public void testConstants() {
        assertEquals(1.5, Bullet.BULLET_RADIUS);
        assertEquals(20, Bullet.BULLET_SPEED);
        assertEquals(20, Bullet.BULLET_DURATION);
    }

    /**
     * Tests the constructor of the Bullet class.
     */
    @Test
    public void testConstructor() {
         TestHelpers.comparePoses(new Pose(240.0, 240.0, Math.PI/2),
                b.getPose());
    }

    /**
     * Tests the draw method of the Bullet class.
     */
    @Test
    public void testDraw() {
        b.draw();
        String actual = StdDraw.getLastDraw();
        assertTrue("filledCircle(240.0, 240.0, 1.5)".equals(actual) || 
                   "circle(240.0, 240.0, 1.5)".equals(actual));
    }

    /**
     * Tests the update method of the Bullet class after one update call.
     */
    @Test
    public void testUpdateonce() {
        b.update();
        assertEquals(240, b.getPose().getX());
        assertEquals(260, b.getPose().getY());
        assertEquals(Math.PI/2, b.getPose().getHeading());
    }

    /**
     * Tests the update method of the Bullet class after multiple update calls.
     */
    @Test
    public void testUpdatetwenty() {
        for (int i = 0; i < 21; i ++) {
            b.update();  
        }
        assertTrue(b.destroyed);
    }
}
