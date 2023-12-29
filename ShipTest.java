/**
 * The ShipTest class is a JUnit test class for the Ship class in the 
 * Asteroid Adventure Game. It tests various functionalities of the Ship class.
 *
 * @version 1.0
 * @since 2023-04-04
 */
public class ShipTest {
    
    private Ship s;
    private Pose pose; 
    /**
     * Sets up the test environment for each test method.
     */
    @BeforeEach
    public void setup() {
        s = new Ship();
    }

    /**
     * Tests if the Ship class correctly implements the GameElement interface.
     */
    @Test
    public void testImplementsInterface() {
        assertTrue(s instanceof GameElement);
    }

    /**
     * Tests the constant values defined in the Ship class.
     */
    @Test
    public void testConstants() {
        assertEquals(10, Ship.SHIP_WIDTH);
        assertEquals(20, Ship.SHIP_HEIGHT);
        assertEquals(0.1, Ship.SHIP_TURN);
        assertEquals(0.1, Ship.SHIP_MOVE);
        assertEquals(0.02, Ship.FRICTION);
    }

    /**
     * Tests the constructor of the Ship class.
     */
    @Test
    public void testConstructor() {
        TestHelpers.comparePoses(new Pose(240.0, 240.0, Math.PI/2),
                s.getPose());
    }

    /**
     * Tests the turnLeft method of the Ship class.
     */
    @Test
    public void testturnLeft() {
        s.turnLeft();
        double val = (Math.PI/2) + 0.1;
        assertEquals(val, s.getPose().getHeading());
    }

    /**
     * Tests the turnRight method of the Ship class.
     */
    @Test
    public void testturnRight() {
        s.turnRight();
        double val = (Math.PI/2) - 0.1;
        assertEquals(val, s.getPose().getHeading());
    }

    /**
     * Tests the thrust method of the Ship class.
     */
    @Test
    public void testthrust() {
        s.thrust();
        double speed = s.getVelocity().getMagnitude();
        System.out.println(speed);
        assertEquals(0.1, speed);
        assertEquals(Math.PI/2, s.getPose().getHeading());
        System.out.println(s.getPose().getHeading());
        System.out.println(Math.PI/2);
    }

    /**
     * Tests the thrust and update methods of the Ship class.
     */
    @Test
    public void testthrustwithupdate() {
        s.thrust();
        s.update();
        double speed = s.getVelocity().getMagnitude();
        assertEquals(0.08, speed);
        assertEquals(240.0, s.getPose().getX());
        assertEquals(240.1, s.getPose().getY());
        assertEquals(Math.PI/2, s.getPose().getHeading());
        for (int i = 0; i < 20; i ++ ) {
            s.update();
        }
        double speed_zero = s.getVelocity().getMagnitude();
        assertEquals(0.0, speed_zero);
    }

    /**
     * Tests the draw method of the Ship class.
     */
    @Test
    public void testDraw() {
        s.draw();
        String actual = StdDraw.getLastDraw();
        assertTrue("polygon()".equals(actual));
    }
}
