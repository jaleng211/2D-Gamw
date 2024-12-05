import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics2D;
public class Player {
    GamePanel gpanel;
    int x, y, width, height;
    double xspeed, yspeed;
    Rectangle hitbox;
    Color playerColor;
    boolean keyLeft, keyRight, keyUp, keyDown;
    public Player(int x, int y, GamePanel panel) {
        gpanel=panel;
        this.x=x;
        this.y=y;
        width=15;
        height=15;
        hitbox=new Rectangle(x, y, width, height);
        playerColor=Color.WHITE;
    }

    public void set() {
        if (keyLeft && keyRight || !keyLeft && !keyRight) {
            xspeed*=0.8;
        } else if (keyLeft && !keyRight) {
            xspeed--;
        } else if (keyRight && !keyLeft) {
            xspeed++;
        }
        if (keyUp) {
            hitbox.y++;
            for (Floor floor: gpanel.floors) {
                if (floor.hitbox.intersects(hitbox)) {
                    yspeed=-5;
                }
            }
            hitbox.y--;
            hitbox.y++;
            for (RedWall redWall:gpanel.redWalls) {
                if (redWall.hitbox.intersects(hitbox)) {
                    yspeed=-5;
                }
            }
            hitbox.y--;
            hitbox.x++;
            for (RedWall redWall:gpanel.redWalls) {
                if (redWall.hitbox.intersects(hitbox)) {
                    yspeed=-5;
                }
            }
            hitbox.x--;
            hitbox.x--;
            for (RedWall redWall:gpanel.redWalls) {
                if (redWall.hitbox.intersects(hitbox)) {
                    yspeed=-5;
                }
            }
            hitbox.x++;
        }
        yspeed+=0.3;
        //Horizonal Collision
        hitbox.x+=xspeed;
        for (Wall wall:gpanel.walls) {
            if (hitbox.intersects(wall.hitbox)) {
                hitbox.x-=xspeed;
                while (!wall.hitbox.intersects(hitbox)) {
                    hitbox.x+=Math.signum(xspeed);
                }
                hitbox.x-=Math.signum(xspeed);
                xspeed=0;
                x=hitbox.x;
            }
        }
        //Floor Collision 
        hitbox.y+=yspeed;
        for (Floor floor: gpanel.floors) {
            if (hitbox.intersects(floor.hitbox)) {
                hitbox.y-=yspeed;
                while (!floor.hitbox.intersects(hitbox)) {
                    hitbox.y+=Math.signum(yspeed);
                }
                hitbox.y-=Math.signum(yspeed);
                yspeed=0;
                y=hitbox.y;
            }
        }
        //Red Walls Collision
        hitbox.x+=xspeed;
        for (RedWall redWall:gpanel.redWalls) {
            if (hitbox.intersects(redWall.hitbox)) {
                hitbox.x-=xspeed;
                while (!redWall.hitbox.intersects(hitbox)) {
                    hitbox.x+=Math.signum(xspeed);
                }
                hitbox.x-=Math.signum(xspeed);
                xspeed=0;
                x=hitbox.x;
            }
        }
        hitbox.y+=yspeed;
        for (RedWall redWall:gpanel.redWalls) {
            if (hitbox.intersects(redWall.hitbox)) {
                hitbox.y-=yspeed;
                while (!redWall.hitbox.intersects(hitbox)) {
                    hitbox.y+=Math.signum(yspeed);
                }
                hitbox.y-=Math.signum(yspeed);
                yspeed=0;
                y=hitbox.y;
            }
        }
        for (RedWall redWall:gpanel.redWalls) {
            if (hitbox.intersects(redWall.hitbox)) {
                if (!redWall.compareColor(playerColor)) {
                    gpanel.reset();
                }
            }
        }
        //Red Button Collision
        hitbox.x+=xspeed;
        for (RedButton redButton:gpanel.redButtons) {
            if (hitbox.intersects(redButton.hitbox)) {
                hitbox.x-=xspeed;
                while (!redButton.hitbox.intersects(hitbox)) {
                    hitbox.x+=Math.signum(xspeed);
                }
                hitbox.x-=Math.signum(xspeed);
                xspeed=0;
                x=hitbox.x;
            }
        }
        hitbox.y+=yspeed;
        for (RedButton redButton:gpanel.redButtons) {
            if (hitbox.intersects(redButton.hitbox)) {
                hitbox.y-=yspeed;
                while (!redButton.hitbox.intersects(hitbox)) {
                    hitbox.y+=Math.signum(yspeed);
                }
                hitbox.y-=Math.signum(yspeed);
                yspeed=0;
                y=hitbox.y;
            }
        }
        //Button Collision
        hitbox.x+=xspeed;
        for (Button button:gpanel.buttons) {
            if (hitbox.intersects(button.hitbox)) {
                hitbox.x-=xspeed;
                while (!button.hitbox.intersects(hitbox)) {
                    hitbox.x+=Math.signum(xspeed);
                }
                hitbox.x-=Math.signum(xspeed);
                xspeed=0;
                x=hitbox.x;
            }
        }
        hitbox.y+=yspeed;
        for (Button button:gpanel.buttons) {
            if (hitbox.intersects(button.hitbox)) {
                hitbox.y-=yspeed;
                while (!button.hitbox.intersects(hitbox)) {
                    hitbox.y+=Math.signum(yspeed);
                }
                hitbox.y-=Math.signum(yspeed);
                yspeed=0;
                y=hitbox.y;
            }
        }
        for (Button button:gpanel.buttons) {
            if (hitbox.intersects(button.hitbox)) {
                action();
            }
        }
        //Speed Resets
        if (xspeed>0 && xspeed<0.75) {
            xspeed=0;
        }
        if (xspeed<0 && xspeed>-0.75) {
            xspeed=0;
        }
        if (xspeed>6) {
            xspeed=6;
        }
        if (xspeed<-6) {
            xspeed=-6;
        }
        x+=xspeed;
        y+=yspeed;
        hitbox.x=x;
        hitbox.y=y;
    }
    public void action() {
        gpanel.level++;
        gpanel.makeNewLevel();
    }
    public void draw (Graphics2D gtd) {
        gtd.setColor(playerColor);
        gtd.fillRect(x, y, width, height);
    }
    public void changeColor(Color color) {
        playerColor=color;
    }
    public Color getColor() {
        return playerColor;
    }
}