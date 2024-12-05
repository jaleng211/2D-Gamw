import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Color;
public class GamePanel extends javax.swing.JPanel implements ActionListener {
    Player player;
    ArrayList<Wall> walls = new ArrayList<Wall>();
    ArrayList<Floor> floors = new ArrayList<Floor>();
    ArrayList<RedWall> redWalls = new ArrayList<RedWall>();
    ArrayList<Button> buttons = new ArrayList<Button>();
    ArrayList<RedButton> redButtons = new ArrayList<RedButton>();
    int cameraY;
    Timer gameTimer;
    int level;
    public GamePanel() {
        player=new Player(90, 500, this);
        reset();
        gameTimer=new Timer();
        gameTimer.schedule(new TimerTask() {
            public void run() {
                player.set();
                for (RedButton redButton: redButtons) {
                    if (player.hitbox.intersects(redButton.hitbox)) {
                        player.changeColor(Color.RED);
                    }
                }
                repaint();
            }
        }, 0, 17);
    }
    public void reset() {
        player.x=90;
        player.y=500;
        player.xspeed=0;
        player.yspeed=0;
        level=1;
        walls.clear();
        floors.clear();
        redWalls.clear();
        buttons.clear();
        redButtons.clear();
        makeFloor();
        makeRedWall();
        makeWalls();
        makeButtons();
        makeRedButtons();
        player.changeColor(Color.WHITE);
    }
    public void makeNewLevel() {
        player.x=90;
        player.y=500;
        player.xspeed=0;
        player.yspeed=0;
        walls.clear();
        floors.clear();
        redWalls.clear();
        buttons.clear();
        redButtons.clear();
        makeFloor();
        makeRedWall();
        makeWalls();
        makeButtons();
        makeRedButtons();
        player.changeColor(Color.WHITE);
    }
    public void makeFloor() {
        floors.add(new Floor());
    }
    public void makeWalls() {
        walls.add(new Wall(50, -100000000, 30, 100000630));
        walls.add(new Wall(620, -100000000, 30, 100000630));
    }
    public void makeButtons() {
        buttons.add(new Button(500, 30, 15, 15));
    }
    public void makeRedButtons() {
        if (level==1) {
            redButtons.add(new RedButton(150, 550, 15, 15, this));
        } else if (level==2) {
            redButtons.add(new RedButton(150, 590, 15, 15, this));
        }
    }
    public void makeRedWall() {
        if (level==1) {
            int j=590;
            for (int i=150; i<=550; i+=80) {
                redWalls.add(new RedWall(i, j, 70, 15));
                j-=40;
            }
            for (int i=470; i>=80; i-=80) {
                redWalls.add(new RedWall(i, j, 70, 15));
                j-=40;
            }
            for (int i=230; i<=550; i+=80) {
                redWalls.add(new RedWall(i, j, 70, 15));
                j-=40;
                if (j<50) {
                    break;
                }
            }
        } else if (level==2) {
            redWalls.add(new RedWall(250, 300, 70, 15));
            redWalls.add(new RedWall(450, 200, 15, 70));
        }
    }
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gtd=(Graphics2D)g;
        player.draw(gtd);
        for (Wall wall: walls) {
            wall.draw(gtd);
        }
        for (Floor floor: floors) {
            floor.draw(gtd);
        }
        for (RedWall redWall: redWalls) {
            redWall.draw(gtd);
        }
        for (Button button: buttons) {
            button.draw(gtd);
        }
        for (RedButton redButton: redButtons) {
            redButton.draw(gtd);
        }
    }
    void keyPressed(KeyEvent e) {
        if (e.getKeyChar()=='a') {
            player.keyLeft=true;
        }
        if (e.getKeyChar()=='w') {
            player.keyUp=true;
        }
        if (e.getKeyChar()=='s') {
            player.keyDown=true;
        }
        if (e.getKeyChar()=='d') {
            player.keyRight=true;
        }
        if (e.getKeyChar()=='r') {
            reset();
        }
    }
    void keyReleased(KeyEvent e) {
        if (e.getKeyChar()=='a') {
            player.keyLeft=false;
        }
        if (e.getKeyChar()=='w') {
            player.keyUp=false;
        }
        if (e.getKeyChar()=='s') {
            player.keyDown=false;
        }
        if (e.getKeyChar()=='d') {
            player.keyRight=false;
        }
    }
    public void actionPerformed(ActionEvent ae) {
    }
}