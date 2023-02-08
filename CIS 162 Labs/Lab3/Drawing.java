import javax.swing.*;
import java.awt.*;
/***************************************************************
 * Drawing class - drawing example
 * @author -
 * @version -
 **************************************************************/
public class Drawing extends JPanel{
 public static void main(String[] a) {
 JFrame f = new JFrame();
 f.setContentPane(new Drawing());
 f.setSize(1000, 400);
 f.setVisible(true);
 }
 public void paintComponent(Graphics g){
    // this statement required
    super.paintComponent(g);
    // optional: paint the background color (default is white)
    setBackground(Color.CYAN);
    // street
    g.setColor(Color.GRAY);
    g.fillRect(0, 225, 1000, 175);
    // sun
    g.setColor(Color.YELLOW);
    g.fillOval(400, 15, 100, 100);
    
    //translation variables
     int x1 = 0;
     int y1 = 0;
     int x2 = 0;
     int y2 = 0;
    
    //car 1 -------
    // car body
    g.setColor(Color.RED);
    g.fillRect(x1 + 100, y1 + 195, 300, 70);
    // car top
    g.fillRect(x1 + 175, y1 + 120, 150, 75);
    //car window 1
    g.setColor(Color.WHITE);
    g.fillRect(x1 + 185, y1 + 130, 60, 60);
    // car window 2
    g.fillRect(x1 + 255, y1 + 130, 60, 60);
    // wheel 1
    g.setColor(Color.BLACK);
    g.fillOval(x1 + 150, y1 + 240, 50, 50);
    //wheel 2
    g.fillOval(x1 + 300, y1 + 240, 50, 50);
    
    //car 2 -------
    // car body
    g.setColor(Color.BLUE);
    g.fillRect(x2 + 600, y2 + 195, 300, 70);
    // car top
    g.fillRect(x2 + 675, y2 + 120, 150, 75);
    //car window 1
    g.setColor(Color.WHITE);
    g.fillRect(x2 + 685, y2 + 130, 60, 60);
    // car window 2
    g.fillRect(x2 + 755, y2 + 130, 60, 60);
    // wheel 1
    g.setColor(Color.BLACK);
    g.fillOval(x2 + 650, y2 + 240, 50, 50);
    //wheel 2
    g.fillOval(x2 + 800, y2 + 240, 50, 50);
 }
}