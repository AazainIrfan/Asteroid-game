/**
 * The Ship class represents the player's spaceship in the Asteroid Adventure Game.
 * It extends the GameElement class, adding specific features like movement control 
 * and friction. The Ship class handles the player's input for movement and shooting.
 *
 * @version 1.0
 * @since 2023-04-04
 */
public class Ship extends GameElement{
    
   public static final int SHIP_WIDTH = 10;
   public static final int SHIP_HEIGHT  = 20;
   public static final double  SHIP_TURN  = 0.1;
   public static final double SHIP_MOVE  = 0.1;
   public static final double FRICTION  = 0.02;
   
   /**
    * Constructs a new Ship object with a default position and heading.
    */
   public Ship() {
        super(new Pose(240, 240, Math.PI/2), 
               new Vector2D(Math.PI/2, 0), 10);
   }
    
   /**
    * Turns the ship to the left.
    */
   public void turnLeft() {
      double var = super.getPose().getHeading() + 0.1;
      super.pose = super.getPose().newHeading(var);
   }
   
   /**
    * Turns the ship to the right.
    */
   public void turnRight() {
       double var = super.getPose().getHeading() - SHIP_TURN;
       super.pose = super.getPose().newHeading(var);
   }
   
   /**
    * Applies thrust to the ship, moving it forward in its current heading.
    */
   public void thrust() {
       Vector2D vector = new Vector2D(this.pose.getHeading(), 0.1);
       super.velocity = super.velocity.add(vector);
   }
   
   /**
    * Updates the Ship's position and applies friction to its movement.
    */
   public void update() {
      super.update();
       if (velocity.getMagnitude() - FRICTION < 0.0) {
           velocity = velocity.newMagnitude(0.0);
       } else {
           velocity = velocity.newMagnitude(getVelocity().getMagnitude() - FRICTION);
       }
   }

   /**
    * Draws the Ship on the game screen.
    */
   public void draw() {
       GameUtils.drawPoseAsTriangle(pose, 10.0, 20.0);
   }
}
