import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: SFincher
 * Date: 10/31/11
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class Brick {

    private int x, y;
    private boolean visible;
    private Color color;

    public Brick(int x, int y, boolean visible, Color color) {
        this.x = x;
        this.y = y;
        this.visible = visible;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {

        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
