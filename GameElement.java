/**
 * The GameElement class represents the basic elements in the Asteroid Adventure Game.
 * It is an abstract class that provides foundational attributes and behaviors for 
 * various game elements like asteroids, bullets, and the ship.
 *
 * @version 1.0
 * @since 2023-04-04
 */
public abstract class GameElement implements Updatable, Drawable {

    protected Pose pose;
    protected Vector2D velocity;
    protected double radius;
    protected boolean destroyed;

    /**
     * Constructs a GameElement object with specified pose, velocity, and radius.
     * 
     * @param pose The position and heading of the game element.
     * @param velocity The velocity of the game element.
     * @param radius The collision radius of the game element.
     */
    public GameElement(Pose pose, Vector2D velocity, double radius) {
        this.pose = pose;
        this.velocity = velocity;
        this.radius = radius;
    }
    
    /**
     * Gets the current pose of the game element.
     * 
     * @return The current pose.
     */
    public Pose getPose() {
        return this.pose;
    }
    
    /**
     * Gets the current velocity of the game element.
     * 
     * @return The current velocity.
     */
    public Vector2D getVelocity() {
         return this.velocity;
    }
    
    /**
     * Gets the collision radius of the game element.
     * 
     * @return The collision radius.
     */
    public double getRadius() {
        return this.radius;
    }
    
    /**
     * Checks if the game element is destroyed.
     * 
     * @return True if the game element is destroyed, otherwise false.
     */
    public boolean isDestroyed() {
         return this.destroyed;
    }
    
    /**
     * Sets the destroyed state of the game element.
     * 
     * @param destroyed The new destroyed state.
     */
    public void setDestroyed(boolean destroyed) {
         this.destroyed = destroyed;
    }

    /**
     * Checks for collision with another game element.
     * 
     * @param other The other game element to check for collision.
     * @return True if a collision occurs, otherwise false.
     */
    public boolean checkCollision(GameElement other) {
        double x1 = this.getPose().getX();
        double x2 = other.getPose().getX();
        double y1 = this.getPose().getY();
        double y2 = other.getPose().getY();
        double distance = Math.sqrt(Math.pow(x2 - x1, 2)
                    + Math.pow(y2 - y1, 2));
        double inBetween = distance - (this.getRadius() 
                + other.getRadius());
            
        if (inBetween < 0) {
            return true;
        }
        return false;       
    }

    /**
     * Updates the position of the game element based on its velocity.
     */
    public void update() {
       this.pose = this.pose.move(velocity);
        double x = this.pose.getX();
        double y = this.pose.getY();
        int width = GameDriver.SCREEN_WIDTH;
        int hight = GameDriver.SCREEN_HEIGHT;
        if (x > width) {  
            if (y < 0) {
                this.pose = this.pose.newX(0);
                this.pose = this.pose.newY(hight);
            }
            if (y > hight) {
                this.pose = this.pose.newX(0);
                this.pose = this.pose.newY(0);
            } else {
                this.pose = this.pose.newX(0);
            }
        } else if (x < 0) {
            if (y > hight) {
                this.pose = this.pose.newX(width);
                this.pose = this.pose.newY(0);
            }
            if (y < 0) {
                this.pose = this.pose.newX(width);
                this.pose = this.pose.newY(hight);
            } else {
                this.pose = this.pose.newX(width);
            }
        }
    }
}
