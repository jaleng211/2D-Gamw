import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics2D;

public class RedButton {
    int x, y, width, height, count;
    boolean startPos;
    GamePanel gpanel;

    Rectangle hitbox;
    public RedButton(int x, int y, int width, int height, GamePanel gpanel) {
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.gpanel=gpanel;
        count=0;
        hitbox=new Rectangle(x, y, width, height);
        startPos=true;
    }
    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.RED);
        gtd.fillRect(x, y, width, height);
    }
}
