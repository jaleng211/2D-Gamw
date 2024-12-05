import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics2D;

public class Floor {
    int x, y, width, height;

    Rectangle hitbox;
    public Floor() {
        x=50;
        y=630;
        width=600;
        height=30;
        hitbox=new Rectangle(50, 630, 600, 30);
    }
    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.WHITE);
        gtd.fillRect(x, y, width, height);
    }
}
