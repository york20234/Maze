import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class MazeGame extends JFrame implements KeyListener {
    private Container cp;
    private byte currentX ,currentY,steocount;
    private JLabel jlbs[][]=new JLabel[15][15];
    private byte map[][]={{0,0,0,0,1,1,1,1,1,1,1,1,1,1,1},
                          {1,1,1,0,1,1,0,0,0,0,0,0,1,1,1},
                          {1,1,1,0,1,1,0,1,1,0,1,0,1,1,1},
                          {0,0,0,0,0,0,0,0,0,0,1,1,0,0,1},
                          {0,1,1,1,1,1,0,1,1,0,1,1,0,1,1},
                          {0,1,1,0,0,0,0,1,1,0,1,1,0,1,1},
                          {0,1,1,1,1,1,0,0,0,0,1,1,0,1,1},
                          {0,0,1,1,1,1,1,1,0,1,1,1,0,1,1},
                          {0,1,0,0,0,0,0,0,0,1,1,1,0,1,1},
                          {0,1,0,1,1,1,1,1,1,1,0,0,0,1,1},
                          {1,1,0,1,1,1,0,0,0,1,0,1,0,1,1},
                          {1,1,0,1,1,1,0,1,0,1,0,1,0,1,1},
                          {1,1,0,0,0,0,0,1,0,0,0,1,0,1,1},
                          {1,1,1,1,1,1,1,1,1,1,1,1,0,1,1},
                          {1,1,1,1,1,1,1,1,1,1,1,1,0,1,1}};
    private ImageIcon icons[]=new ImageIcon[3];


 public MazeGame(){
     init();
 }
 private void init(){
     cp=this.getContentPane();
     this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
     this.setBounds(100,100,800,800);
     cp.setLayout(new GridLayout(15,15,1,1));
     icons[0]=new ImageIcon("grass.jpg");
     icons[1]=new ImageIcon("stone5.jpg");
     icons[2]=new ImageIcon("sora.png");

     Image image =icons[0].getImage();
     Image image1=image.getScaledInstance(50,50,Image.SCALE_SMOOTH);
     icons[0].setImage(image1);

     Image images =icons[1].getImage();
     Image images1=images.getScaledInstance(50,50,Image.SCALE_SMOOTH);
     icons[1].setImage(images1);

     Image imagess =icons[2].getImage();
     Image imagess1=imagess.getScaledInstance(50,50,Image.SCALE_SMOOTH);
     icons[2].setImage(imagess1);

     addKeyListener(this);
     setFocusable(true);
     setFocusTraversalKeysEnabled(true);

     for (int i=0;i<15;i++){
         for (int j=0;j<15;j++){
             jlbs[i][j]=new JLabel();
             jlbs[0][0].setIcon(icons[2]);
             if (map[i][j]==0){
                 jlbs[i][j].setIcon(icons[0]);
             }else {
                 jlbs[i][j].setIcon(icons[1]);
             }
             cp.add(jlbs[i][j]);
         }
     }

 }
 public void keyPressed(KeyEvent ke){
     switch (ke.getKeyCode()){
         case 37://left
             if (currentX-1>=0){
                 if (map[currentY][currentX-1]==0){
                     jlbs[currentY][currentX].setIcon(icons[0]);
                     currentX--;
                     jlbs[currentY][currentX].setIcon(icons[2]);
                     steocount++;
                 }
             }
             break;
         case 38://up
             if (currentY-1>=0){
                 if (map[currentY-1][currentX]==0){
                     jlbs[currentY][currentX].setIcon(icons[0]);
                     currentY--;
                     jlbs[currentY][currentX].setIcon(icons[2]);
                     steocount++;
                 }
             }
             break;
         case 39://
             if (currentX+1<15){
                 if (map[currentY][currentX+1]==0){
                     jlbs[currentY][currentX].setIcon(icons[0]);
                     currentX++;
                     jlbs[currentY][currentX].setIcon(icons[2]);
                     steocount++;
                 }
             }
             break;
         case 40:
             if (currentY+1<15){
                 if (map[currentY+1][currentX]==0){
                     jlbs[currentY][currentX].setIcon(icons[0]);
                     currentY++;
                     jlbs[currentY][currentX].setIcon(icons[2]);
                 }
             }
             if (map[currentX][currentY]==15){
                 System.out.println("XXXXXXXX");
             }
     }
 }
 public void keyReleased(KeyEvent ke){
     System.out.println(ke.getKeyCode());
 }
 public void keyTyped(KeyEvent ke){
        System.out.println(ke.getKeyCode());
    }




}
