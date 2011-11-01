import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: SFincher
 * Date: 10/31/11
 * Time: 3:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Breakout extends Applet implements Settings, MouseMotionListener {

    private Brick brick[] = new Brick[TOTAL_NUM_BRICKS];
    private Rectangle rectangle[] = new Rectangle[TOTAL_NUM_BRICKS];

    private int paddleX = APPLICATION_WIDTH / 2;

    private int ballX = BALL_STARTER_X;
    private int ballY = BALL_STARTER_Y;
    private int xVel = BALL_START_SPEED_X;
    private int yVel = BALL_START_SPEED_Y;

    private int brickTotal = TOTAL_NUM_BRICKS;

    public void init() {

        this.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        addMouseMotionListener(this);
        makeBricks();

        Timer timer1 = new Timer(16, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ballX += xVel;
                ballY += yVel;

                checkCollisions();
                
                repaint();
            }
        });

        timer1.start();

    }

    public void checkCollisions() {
        Rectangle ballRectangle = new Rectangle(ballX, ballY, BALL_DIAM, BALL_DIAM);
        Rectangle paddleRectangle = new Rectangle(paddleX, PADDLE_Y, PADDLE_WIDTH, PADDLE_HEIGHT);

        if(ballX + BALL_DIAM >= APPLICATION_WIDTH || ballX <= 0) {
            xVel = -xVel;
        }

        if(ballY <= 0 || ballY >= APPLICATION_HEIGHT) {
            yVel = -yVel;
        }

        if(ballRectangle.intersects(paddleRectangle)) {
            yVel = -yVel;
        }

        for(int i = 0; i < brick.length; i++) {

            if(brick[i].isVisible() && ballRectangle.intersects(rectangle[i])) {
                brick[i].setVisible(false);
                brickTotal--;
                yVel = -yVel;
            }
        }

        if(brickTotal == 0) {
            System.exit(0);
        }
    }

    public void paint(Graphics g) {

        for(int i = 0; i < brick.length; i++) {

            if(brick[i].isVisible()) {
                g.setColor(brick[i].getColor());
                g.fillRect(brick[i].getX(), brick[i].getY(), BRICK_WIDTH, BRICK_HEIGHT);
            }
        }

        g.setColor(PADDLE_DEFAULT_COLOR);
        g.fillRect(paddleX, PADDLE_Y, PADDLE_WIDTH, PADDLE_HEIGHT);

        g.setColor(BALL_DEFAULT_COLOR);
        g.fillOval(ballX, ballY, BALL_DIAM, BALL_DIAM);
    }

    public void makeBricks() {

        int colorCounter = 0;
        int brickX = BRICK_X_OFFSET;
        int brickY = BRICK_Y_OFFSET;
        int brickCounter = 0;
        int rowCounter = 0;


        for(int i = 0; i < NBRICK_ROWS; i++) {

            if(rowCounter == NUM_ROW_PER_COLOR) {
                colorCounter++;
                rowCounter = 0;
            }

            if(colorCounter == cols.length) {
                colorCounter = 0;
            }

            for(int j = 0; j < NBRICKS_PER_ROW; j++) {
                brick[brickCounter] = new Brick(brickX, brickY, true, cols[colorCounter]);
                rectangle[brickCounter] = new Rectangle(brickX, brickY, BRICK_WIDTH, BRICK_HEIGHT);
                brickX += (BRICK_SEP + BRICK_WIDTH);
                brickCounter++;
            }

            brickX = BRICK_X_OFFSET;
            brickY += (BRICK_HEIGHT + BRICK_SEP);
            rowCounter++;
        }
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {

        paddleX = e.getX();

        if(paddleX - (PADDLE_WIDTH / 2) <= 0 ) {
            paddleX = (PADDLE_WIDTH / 2);
        }

        if(paddleX + (PADDLE_WIDTH / 2) >= APPLICATION_WIDTH) {
            paddleX = APPLICATION_WIDTH - (PADDLE_WIDTH / 2);
        }

        paddleX -= (PADDLE_WIDTH / 2);
    }
}
