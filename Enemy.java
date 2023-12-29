/**
 * The Enemy class represents the adversaries in the Asteroid Adventure Game. 
 * It extends the GameElement class, adding specific features like points 
 * earned for destroying the enemy. This class is used as a base for different 
 * types of enemies in the game, such as asteroids and saucers.
 *
 * @version 1.0
 * @since 2023-04-04
 */
public abstract class Enemy extends GameElement{
    
    protected int points;

    /**
     * Constructs a new Enemy object with specified speed, radius, and points.
     * 
     * @param speed  The speed at which the enemy moves.
     * @param radius The radius of the enemy, used for collision detection.
     * @param points The points that the player earns for destroying this enemy.
     */
    public Enemy(double speed, double radius, int points) {
        super(new Pose(AsteroidsGame.randomXPosition(), 
                AsteroidsGame.randomYPosition(), 
                AsteroidsGame.randomHeading()), 
                new Vector2D(AsteroidsGame.randomHeading(), speed), radius);
        
       this.points = points;
    }

    /**
     * Gets the points value of this enemy.
     * 
     * @return The points awarded for destroying this enemy.
     */
    public int getPoints() {
        return this.points;
    }

}
