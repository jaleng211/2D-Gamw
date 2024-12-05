import java.awt.Dimension;
import java.awt.Toolkit;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class App {
  public static void main(String[] args) {
    MainFrame frame = new MainFrame();
    frame.setSize(700, 700);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setLocation((int)(screensize.getWidth()/2-frame.getSize().getWidth()/2), (int)(screensize.getHeight()/2-frame.getSize().getHeight()/2));

    frame.setResizable(false);
    frame.setTitle("Platformer Game");
    frame.setVisible(true);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
}
