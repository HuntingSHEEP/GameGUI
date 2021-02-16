import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;


class Plansza extends JPanel implements MouseMotionListener, MouseListener, KeyListener
{
    int maxAmountOfBalls = 10;
    int ballCount = 1;
    Belka b;
    Kulka[] a = new Kulka[maxAmountOfBalls];
    Color barColor;
    Floor floor;
    int lastMousePositionX = 325;

    SilnikKulki s;
    BonusEngine bonusEngine;

    int rows = 3;
    int columns = 12;
    int liczba_kafelek = columns * rows;
    int livingBricks = liczba_kafelek;
    Kafelka[] k = new Kafelka[liczba_kafelek];
    Bonus[] fallingBonus = new Bonus[liczba_kafelek];

    int score = 0;
    int skillCoins = 2;

    boolean game_over = false;
    boolean engineStartFlag = false;

    GamePanel gamePanel;

   Plansza(GamePanel gamePanel)
   {
      super();
      addMouseMotionListener(this);
      addMouseListener(this);


      setFocusable(true);

      addKeyListener(this);

      this.gamePanel = gamePanel;

       b=new Belka(325-40, 525);
       floor=new Floor(this, 0, 455, 650);
       bonusEngine = new BonusEngine(this, this.gamePanel);

       for(int w=0; w<maxAmountOfBalls; w++)
           a[w]=new Kulka(this,325-5,515,0,-2, false);
       a[0].isAlive=true;
       a[1].addDeltaX(10);

       for (int i=0; i<liczba_kafelek; i++){
           k[i]=new Kafelka(this, i%columns, i/columns, 718f/columns, 1);
           fallingBonus[i] = new Bonus(this,i%columns, i/columns, 718f/columns);
       }
       loadTextures();
       setOpaque(false);
       System.out.println(isFocusable());
   }



   void loadTextures(){
       barColor = new Color(0,60,60);
   }

   public void paintComponent(Graphics g)
   {
       requestFocus();

       super.paintComponent(g);
       ImageIcon img = new ImageIcon("textures/woodenBackground.jpg");

       if (img != null)
       {
           //g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
       }

       Graphics2D g2d=(Graphics2D)g;

       if (livingBricks==0){
           gamePanel.eastPanel.removeAll();
           gamePanel.eastPanel.repaint();
           s.running = false;
           bonusEngine.running=false;
           g2d.setPaint(new Color(63, 75, 68));
           g.setFont(new Font("Dialog", Font.BOLD, 20));
           g2d.drawString("YOU WON!", getSize().width/2 - 65, getSize().height/2+30);
           g2d.drawString("SCORE: " + score, getSize().width/2 - 65, getSize().height/2+60);

       }else{

           if (!game_over){
               if (engineStartFlag){
                   g2d.setPaint(new Color(63, 75, 68));
                   g.setFont(new Font("Dialog", Font.BOLD, 15));
                   g2d.drawString("SCORE: "+score, 20, 360);
               }


               g2d.setPaint(barColor);
               g2d.fill(b);
               g2d.setPaint(new GradientPaint(b.x,b.y, new Color(32,178,170), b.x+(int)(b.width*b.roundPercentage), b.y+b.height, barColor));

               g2d.fill(new Rectangle2D.Float(b.x, b.y,(int) (b.width * b.roundPercentage), b.height));
               g2d.setPaint(new GradientPaint((b.x + (int) (b.width*(1- b.roundPercentage))) ,b.y, barColor, b.x+ b.width, b.y+b.height, new Color(32,178,170)));
               g2d.fill(new Rectangle2D.Float((b.x + (int) (b.width*(1- b.roundPercentage))) ,b.y, (int) (b.width * b.roundPercentage), b.height));

               if(floor.isAlive){
                   //g2d.setPaint(floor.getTexture());
                   //g2d.setStroke(new BasicStroke(2f));
                   //g2d.draw(floor);
                   g2d.setPaint(new TexturePaint(floor.getTexture(), (Rectangle2D) floor));
                   g2d.fill(floor);
               }

               for(int i=0; i<liczba_kafelek; i++){

                   if (fallingBonus[i].isAlive){
                       //g2d.setPaint(fallingBonus[i].getTexture());
                       g2d.setPaint(new TexturePaint(fallingBonus[i].getTexture(), (Rectangle2D) fallingBonus[i]));
                       g2d.fill(fallingBonus[i]);
                   }

                   if (k[i].flaga_ZYCIA > 0){
                       g2d.setPaint(new TexturePaint(k[i].getTexture(), (Rectangle2D) k[i]));
                       g2d.fill(k[i]);
                   }
               }


               g2d.setPaint(a[0].getTexture());
               for(int i=0; i<maxAmountOfBalls; i++){
                   if(a[i].isAlive){
                       g2d.setStroke(new BasicStroke(1.5f));
                       g2d.draw(a[i]);
                   }
               }

               if (!engineStartFlag){
                   g2d.setPaint(new Color(63, 75, 68));
                   g.setFont(new Font("Dialog", Font.BOLD, 20));
                   //g2d.drawString("LEFT CLICK", 150, 320);

                   g2d.setPaint(new Color(76, 57, 74));
                   g.setFont(new Font("Dialog", Font.BOLD, 17));
                   //g2d.drawString("TO SHOOT THE BALL!", 300, 320);
               }


          }else{
             s.running = false;
             bonusEngine.running=false;
             g2d.setPaint(new Color(76, 57, 74));
             g.setFont(new Font("Dialog", Font.BOLD, 20));
             g2d.drawString("GAME OVER", getSize().width/2 - 65, getSize().height/2+30);
             gamePanel.eastPanel.removeAll();
             gamePanel.eastPanel.repaint();
          }

       }

   }

   public void mouseMoved(MouseEvent e)
   {
       int mousePositionX=e.getX();

       for(int i=0; i<maxAmountOfBalls; i++){
           if(a[i].isAlive){
               if(!a[i].isFlying){
                   if (0 <= (a[i].getMinX()-(lastMousePositionX-mousePositionX)) &&
                          getWidth() >= (a[i].getMaxX()-(lastMousePositionX-mousePositionX))){

                       a[i].addDeltaX(-(lastMousePositionX-mousePositionX));
                       a[i].setY(getSize().height - 30 -13-5);
                   }

               }
           }
       }

       b.setY(getSize().height - 20-13-5);
       b.setX(e.getX()-(int) b.width/2);

       floor.setBounds(0, getSize().height - 10, getSize().width, getSize().height);

       if (!engineStartFlag)
           repaint();

       lastMousePositionX=mousePositionX;
   }


    public void mouseClicked(MouseEvent e){
        System.out.println("CLICKED!");
        if(!engineStartFlag){
            engineStartFlag =true;
            s=new SilnikKulki(this, a);
        }

        for(int w=0; w<maxAmountOfBalls; w++){
            if(a[w].isAlive){
                if(!a[w].isFlying){
                    a[w].isFlying = true;
                    w=maxAmountOfBalls+10;
                }
            }
        }
    }

    public void mouseDragged(MouseEvent e)
    {

    }

    public void mouseReleased(MouseEvent e){

    }


    public void mouseExited(MouseEvent e){

    }


    public void mouseEntered(MouseEvent e){

    }


    public void mousePressed(MouseEvent e){

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    @Override
    public void keyPressed(KeyEvent keyEvent) {}

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        System.out.println("You typed: " + keyEvent.getKeyCode());

    }

}
