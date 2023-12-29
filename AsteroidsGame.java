import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The AsteroidsGame class is the main class for the Asteroid Adventure Game. 
 * It manages the game elements, game logic, and interactions between different components.
 *
 * @version s23
 */
public class AsteroidsGame implements Playable {

    public static final int LIVES = 3;
    private ArrayList<Drawable> drawElements;
    private ArrayList<Updatable> updateElements;
    private ArrayList<GameElement> shipAndBullets;
    private ArrayList<Enemy> enemies;

    private NumericDisplay score;
    private NumericDisplay lives;
    private Ship ship;

    /**
     * Constructs all game elements and initializes the game environment.
     */
    public AsteroidsGame() {
        StdDraw.setTitle("Generic Space Rock Shooter");
        
        drawElements = new ArrayList<>();
        updateElements = new ArrayList<>();
        shipAndBullets = new ArrayList<>();
        enemies = new ArrayList<>();

        final int TOP = GameDriver.SCREEN_HEIGHT;
        score = new NumericDisplay(10, TOP - 20, "Score: ", 0);
        lives = new NumericDisplay(10, TOP - 40, "Lives: ", LIVES);
        drawElements.add(score);
        drawElements.add(lives);
    }

    /**
     * Creates and adds 100 stars with random locations to the game.
     */
    private void newStars() {
        for (int i = 0; i < 100; i++) {
            double x = randomXPosition();
            double y = randomYPosition();
            Star star = new Star(x, y);
            drawElements.add(star);
        }
    }

    /**
     * Creates and adds new enemies to the game.
     */
    private void newEnemies() {
        for (int i = 0; i < 10; i++) {
            Asteroid asteroid = new Asteroid(AsteroidSize.randomSize());
            drawElements.add(asteroid);
            updateElements.add(asteroid);
            enemies.add(asteroid);
        }
    }

    /**
     * Creates and adds a new ship to the game.
     */
    private void newShip() {
        ship = new Ship();
        shipAndBullets.add(ship);
        updateElements.add(ship);
        drawElements.add(ship);
    }

    /**
     * Starts a new game with stars, a ship, and asteroids.
     */
    public void startGame() {
        newStars();
        newShip();
        newEnemies();
    }

    /**
     * Handles keyboard input to control the ship and shoot bullets.
     */
    private void handleKeyboardInput() {
        if (GameDriver.spacePressed()) {
            Bullet b = new Bullet(ship.getPose());
            updateElements.add(b);
            shipAndBullets.add(b);
            drawElements.add(b);
        }

        if (GameDriver.leftPressed()) {
            ship.turnLeft();
        }
        if (GameDriver.rightPressed()) {
            ship.turnRight();
        }
        if (GameDriver.upPressed()) {
            ship.thrust();
        }
    }

    /**
     * Updates the state of the game, including handling input, updating elements,
     * and managing collisions.
     */
    @Override
    public void update() {
        if (lives.getValue() <= 0) {
            return;
        }

        handleKeyboardInput();
        for (Updatable item : updateElements) {
            item.update();
        }

        handleCollisions();
        removeDestroyedBullets();
        removeDestroyedEnemies();
        if (enemies.size() == 0) {
            newEnemies();
        }

        if (GameDriver.GENERATOR.nextDouble() <= 0.002) {
            Saucer saucer = new Saucer();
            addEnemy(saucer);
        }
    }

    /**
     * Draws all the drawable elements of the game.
     */
    @Override
    public void draw() {
        for (Drawable draw : drawElements) {
            draw.draw();
        }
    }

    /**
     * Generates a random X position on the screen.
     *
     * @return the x position
     */
    protected static double randomXPosition() {
        return GameDriver.GENERATOR.nextDouble() * GameDriver.SCREEN_WIDTH;
    }

    /**
     * Generates a random Y position on the screen.
     *
     * @return the y position
     */
    protected static double randomYPosition() {
        return GameDriver.GENERATOR.nextDouble() * GameDriver.SCREEN_HEIGHT;
    }

    /**
     * Generates a random heading from the interval [0, 2*PI).
     *
     * @return the heading
     */
    protected static double randomHeading() {
        return GameDriver.GENERATOR.nextDouble() * 2 * Math.PI;
    }

    /**
     * Handles collisions between different game elements like ships, bullets, and enemies.
     */
    public void handleCollisions() {
        for (GameElement element : shipAndBullets) {
            for (Enemy enemy : enemies) {
                if (element.checkCollision(enemy)) {
                    element.setDestroyed(true);
                    enemy.setDestroyed(true);
                    int a = score.getValue() + enemy.getPoints();
                    score.setValue(a);
                }
            }
        }
    }

    /**
     * Removes bullets that have been destroyed from the game elements lists.
     */
    public void removeDestroyedBullets() {
        Iterator<GameElement> it = shipAndBullets.iterator();
        while (it.hasNext()) {
            GameElement element = it.next();
            if (element.isDestroyed() && element instanceof Bullet) {
                it.remove();
                updateElements.remove(element);
                drawElements.remove(element);
            } else if (element.isDestroyed() && element instanceof Ship) {
                it.remove();
                updateElements.remove(element);
                drawElements.remove(element);
                if (lives.getValue() > 0) {
                    int current_lives = lives.getValue();
                    lives.setValue(current_lives - 1);
                }
            }
        }

        if (ship.isDestroyed()) {
            newShip();
        }
    }

    /**
     * Removes enemies that have been destroyed from the game elements lists.
     */
    public void removeDestroyedEnemies() {
        Iterator<Enemy> it = enemies.iterator();
        while (it.hasNext()) {
            Enemy enemy = it.next();
            if (enemy.isDestroyed()) {
                it.remove();
                updateElements.remove(enemy);
                drawElements.remove(enemy);
            }
        }
    }

    /**
     * Adds a new enemy to the game.
     * 
     * @param enemy The enemy to be added to the game.
     */
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
        updateElements.add(enemy);
        drawElements.add(enemy);
    }

