/**
 * The Updatable interface defines a standard method for game elements 
 * in the Asteroid Adventure Game that need to update their state each frame.
 *
 * @version 1.0
 * @since 2023-04-04
 */
public interface Updatable {
    
    /**
     * Updates the state of the game element, such as its position or other properties.
     */
    public void update();
}
