/**
 * The Bullet class represents the bullets fired by the player's ship in the 
 * Asteroid Adventure Game. Bullets are used to destroy asteroids and enemies.
 *
 * @version 1.0
 * @since 2023-04-04
 */
public class Bullet extends GameElement {
    
   public static final double BULLET_RADIUS = 1.5;
   public static final int BULLET_SPEED  = 20;
   public static final int BULLET_DURATION = 20;
   private int counter;
   
   /**
    * Constructs a new Bullet object with a specified initial position and heading.
    * 
    * @param pose The initial position and heading of the bullet.
    */
   public Bullet (Pose pose) {
       /  super(pose, new Vector2D(pose.getHeading(), BULLET_SPEED), BULLET_RADIUS);
   }
   
   /**
    * Updates the position of the bullet and checks its lifespan.
    */
   @Override
   public void update() {
      boolean destroyed = false;
      super.update();
      counter++;
      if (counter == 20) {
        destroyed = true;
        super.setDestroyed(destroyed);
      }
   }

   /**
    * Draws the bullet on the game screen.
    */
   @Override
   public void draw() {
       StdDraw.setPenColor(Color.WHITE);
       StdDraw.filledCircle(pose.getX(), pose.getY(), BULLET_RADIUS);
   }
}
