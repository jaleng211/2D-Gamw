import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics2D;

public class Button {
    int x, y, width, height;

    Rectangle hitbox;
    public Button(int x, int y, int width, int height) {
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        hitbox=new Rectangle(x, y, width, height);
    }
    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.WHITE);
        gtd.fillRect(x, y, width, height);
    }
}
