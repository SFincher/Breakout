import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: SFincher
 * Date: 10/30/11
 * Time: 1:21 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Settings {

     /** Dimensions of program */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

    /** Dimensions of the paddle */
    public static final int PADDLE_WIDTH = 60;
    public static final int PADDLE_HEIGHT = 10;

    /** Offset of the paddle up from the bottom */
    public static final int PADDLE_Y_OFFSET = 30;

    /** Radius and Diameter of the ball in pixels */
    public static final int BALL_RADIUS = 10;
    public static final int BALL_DIAM = (BALL_RADIUS * 2);

    /** Starting position of the ball */
    public static final int BALL_STARTER_X = (APPLICATION_WIDTH / 2);
    public static final int BALL_STARTER_Y = (APPLICATION_HEIGHT / 2);

    /** Starting speed of the ball */
    public static final int BALL_START_SPEED_X = 6;
    public static final int BALL_START_SPEED_Y = 6;

    /** Dimensions of game board (usually the same) */
    public static final int GAME_WIDTH = APPLICATION_WIDTH;
    public static final int GAME_HEIGHT = APPLICATION_HEIGHT;

    /** Paddle's actual Y Coordinate */
    public static final int PADDLE_Y = (GAME_HEIGHT - PADDLE_Y_OFFSET);
    public int paddle_X = (APPLICATION_WIDTH / 2);

    /** Number of bricks per row */
    public static final int NBRICKS_PER_ROW = 10;

    /** Number of rows of bricks */
    public static final int NBRICK_ROWS = 10;

    /** Total number of bricks to be displayed */
    public static final int TOTAL_NUM_BRICKS = (NBRICK_ROWS * NBRICKS_PER_ROW);

    /** Separation between bricks */
    public static final int BRICK_SEP = 4;

    /** Width of a brick */
    public static final int BRICK_WIDTH = (GAME_WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

    /** Height of a brick */
    public static final int BRICK_HEIGHT = 8;

    /** Total width of bricks including separation */
    public static final int TOTAL_ROW_WIDTH = ((NBRICKS_PER_ROW * BRICK_WIDTH) + ((NBRICKS_PER_ROW - 1) * BRICK_SEP));

    /** Offset of the leftmost brick */
    public static final int BRICK_X_OFFSET = ( (GAME_WIDTH - TOTAL_ROW_WIDTH) / 2);

    /** Offset of the top brick row from the top */
    public static final int BRICK_Y_OFFSET = 70;

    /** Number of rows to make per color */
    public static final int NUM_ROW_PER_COLOR = 2;

    /** Number of turns */
    public static final int NTURNS = 3;

    /** Delay between each iteration */
    public static final int DELAY = 50;

    /** Default colors */
    public static final Color PADDLE_DEFAULT_COLOR = Color.BLACK;
    public static final Color BALL_DEFAULT_COLOR = Color.BLACK;

    /** Array of brick row colors */
    public static final Color cols[] = new Color[]{Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN};
}