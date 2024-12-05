import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics2D;

public class RedWall {
    int x, y, width, height;

    Rectangle hitbox;
    public RedWall(int x, int y, int width, int height) {
        this.x=x;
        this.y=y;

        this.width=width;
        this.height=height;
        hitbox=new Rectangle(x, y, width, height);
    }
    public void moveY(int k) {
        y+=k;
    }
    public void moveX(int k) {
        x+=k;
    }
    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.RED);
        gtd.fillRect(x, y, width, height);
    }
    public Color getColor() {
        return Color.RED;
    }
    public boolean compareColor(Color other) {
        if (other.equals(getColor())) {
            return true;
        }
        return false;
    }
}
