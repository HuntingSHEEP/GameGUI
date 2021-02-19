import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;


class Plansza extends JPanel implements MouseMotionListener, MouseListener, KeyListener, ActionListener
{
    Graphics2D g2d;

    int maxAmountOfBalls = 10;
    int ballCount = 1;
    Belka b;
    Kulka[] a = new Kulka[maxAmountOfBalls];
    Color barColor;
    Floor floor;
    int lastMousePositionX = 325;

    SilnikKulki ballsEngine;
    BonusEngine bonusEngine;


    /*
    int rows = 2;
    int columns = 12;
    int liczba_kafelek = rows * columns;
    int livingBricks = liczba_kafelek;
    Kafelka[] k = new Kafelka[liczba_kafelek];
    Bonus[] fallingBonus = new Bonus[liczba_kafelek];*/


    int liczba_kafelek;
    int livingBricks;
    Kafelka[] k;
    Bonus[] fallingBonus;


    int score = 0;
    int skillCoins = 0;

    boolean gameOver = false;
    boolean gamePaused = false;
    boolean engineStartFlag = false;
    boolean freezeAndFlyToPoint=false;
    boolean updatedStatistics=false;

    Point mouseTip = new Point(0,0);
    GamePanel gamePanel;
    Level level;

    //JButton conti, retry;
    ContinueButton conti;
    RetryButton retry;

   Plansza(GamePanel gamePanel, int lvl)
   {
       super();

       level = new Level(lvl, this);
       liczba_kafelek = level.getBricksNumber();
       livingBricks = level.getBricksNumber();
       k = level.getBricks();
       fallingBonus = level.getFallingBonus();

       conti = new ContinueButton();
       retry = new RetryButton();

       conti.addActionListener(this);
       retry.addActionListener(this);

       setLayout(null);


       addMouseMotionListener(this);
       addMouseListener(this);
       setFocusable(true);
       addKeyListener(this);

       this.gamePanel = gamePanel;

       b=new Belka(325-40, 525);
       floor=new Floor(this, 0, 455, 650);

       for(int w=0; w<maxAmountOfBalls; w++)
           a[w]=new Kulka(this,325-5,515,0,-2, false);
       a[0].isAlive=true;
        /*
       for (int i=0; i<liczba_kafelek; i++){
           //k[i]=new Kafelka(this, i%columns, i/columns, 718f/columns, 0);
           fallingBonus[i] = new Bonus(this,i%columns, i/columns, 718f/columns);
       } */
       bonusEngine = new BonusEngine(this, this.gamePanel);
       loadTextures();
       setOpaque(false);
   }



   void loadTextures(){
       barColor = new Color(0,60,60);
   }

   public void paintComponent(Graphics g)
   {
       super.paintComponent(g);
       g2d=(Graphics2D)g;

       if (livingBricks==0){
           gamePanel.eastPanel.removeAll();
           gamePanel.eastPanel.repaint();
           ballsEngine.running = false;
           bonusEngine.running=false;
           g2d.setPaint(new Color(63, 75, 68));
           g.setFont(new Font("Dialog", Font.BOLD, 20));
           g2d.drawString("YOU WON!", getSize().width/2 - 80, getSize().height/2+30);
           g2d.drawString("SCORE: " + score, getSize().width/2 - 80, getSize().height/2+60);
           if (!updatedStatistics){
               gamePanel.mainFrame.getGameStatistics().gameWon(level.level);
               add(conti);
               add(retry);
               updatedStatistics=true;
           }



       }else{

           if (!gameOver){

               if (engineStartFlag){
                   g2d.setPaint(new Color(63, 75, 68));
                   g.setFont(new Font("Dialog", Font.BOLD, 15));
                   g2d.drawString("SCORE: "+score, 20, 360);
               }else{
                   requestFocus();
               }

               g2d.setPaint(barColor);
               g2d.fill(b);
               g2d.setPaint(new GradientPaint(b.x,b.y, new Color(32,178,170), b.x+(int)(b.width*b.roundPercentage), b.y+b.height, barColor));

               g2d.fill(new Rectangle2D.Float(b.x, b.y,(int) (b.width * b.roundPercentage), b.height));
               g2d.setPaint(new GradientPaint((b.x + (int) (b.width*(1- b.roundPercentage))) ,b.y, barColor, b.x+ b.width, b.y+b.height, new Color(32,178,170)));
               g2d.fill(new Rectangle2D.Float((b.x + (int) (b.width*(1- b.roundPercentage))) ,b.y, (int) (b.width * b.roundPercentage), b.height));

               if(floor.isAlive){
                   g2d.setPaint(new TexturePaint(floor.getTexture(), (Rectangle2D) floor));
                   g2d.fill(floor);
               }

               for(int i=0; i<liczba_kafelek; i++){

                   if (fallingBonus[i].isAlive){
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
                   g2d.setPaint(new Color(111, 114, 114));
                   g.setFont(new Font("Dialog", Font.BOLD, 16));
                   g2d.drawString("LEVEL "+level.level, 180, 280);

                   g2d.setPaint(new Color(63, 75, 68));
                   g.setFont(new Font("Dialog", Font.BOLD, 20));
                   g2d.drawString("LEFT CLICK", 180, 320);

                   g2d.setPaint(new Color(76, 57, 74));
                   g.setFont(new Font("Dialog", Font.BOLD, 17));
                   g2d.drawString("TO SHOOT THE BALL!", 330, 320);
               }

               if(gamePaused){
                   g2d.setPaint(new Color(76, 57, 74));
                   g.setFont(new Font("Dialog", Font.BOLD, 25));
                   g2d.drawString("PAUSE", getSize().width/2 - 35, getSize().height/2+30);
               }

               if(freezeAndFlyToPoint){
                   int R = 900;
                   int r = 10;
                   int move = 5;
                   g2d.setStroke(new BasicStroke(1f));
                   g2d.setPaint(new Color(1, 141, 138));
                   g.drawLine(mouseTip.x - R-move, mouseTip.y-move, mouseTip.x - r-move, mouseTip.y-move);
                   g.drawLine(mouseTip.x + r-move, mouseTip.y-move, mouseTip.x + R-move, mouseTip.y-move);
                   g.drawLine(mouseTip.x-move, mouseTip.y - R-move, mouseTip.x-move, mouseTip.y - r-move);
                   g.drawLine(mouseTip.x-move, mouseTip.y + r-move, mouseTip.x-move, mouseTip.y + R-move);
               }


          }else{
             ballsEngine.running = false;
             bonusEngine.running=false;
             g2d.setPaint(new Color(76, 57, 74));
             g.setFont(new Font("Dialog", Font.BOLD, 20));
             g2d.drawString("GAME OVER", getSize().width/2 - 65, getSize().height/2+30);

             gamePanel.eastPanel.removeAll();
             gamePanel.eastPanel.repaint();

               if (!updatedStatistics){
                   gamePanel.mainFrame.getGameStatistics().gameLost();;
                   add(retry);
                   updatedStatistics=true;
               }
          }

       }

   }

   public void mouseMoved(MouseEvent e)
   {
       mouseTip.setLocation(e.getX(), e.getY());
       if(!gamePaused){
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
   }


    public void mouseClicked(MouseEvent e){
        System.out.println("CLICKED!");



        if(!engineStartFlag){
            engineStartFlag =true;
            ballsEngine =new SilnikKulki(this, a);
        }

        if(!freezeAndFlyToPoint){
            for(int w=0; w<maxAmountOfBalls; w++){
                if(a[w].isAlive){
                    if(!a[w].isFlying){
                        a[w].isFlying = true;
                        w=maxAmountOfBalls+10;
                    }
                }
            }
        }

        if(freezeAndFlyToPoint){
            mouseTip.setLocation(e.getX()-5, e.getY()-5);
            freezeAndFlyToPoint(false);
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

        if(engineStartFlag){
            if(!gamePaused){
                if(!freezeAndFlyToPoint){
                    if(keyEvent.getKeyCode() == 81){
                        //FREEZE AND FLY TO POINT
                        if(skillCoins>0){
                            skillCoins--;
                            gamePanel.eastPanel.repaint();
                            freezeAndFlyToPoint(true);
                        }
                    }
                }


            }
        }



        if(keyEvent.getKeyCode() == 27){
            if(!gameOver && !freezeAndFlyToPoint){
                if(engineStartFlag){
                    if(!bonusEngine.justWait){
                        gamePaused = true;
                        bonusEngine.justWait=true;
                        ballsEngine.justWait=true;
                    }else{
                        gamePaused = false;
                        bonusEngine.justWait=false;
                        ballsEngine.justWait=false;
                    }
                }
            }
        }
    }

    public void freezeAndFlyToPoint(boolean start){
       if(start){
           freezeAndFlyToPoint=true;
           //ballsEngine.justWait=true;
           //bonusEngine.doRepaint=true;
       }else{
           freezeAndFlyToPoint=false;
           //ballsEngine.justWait=false;
           //bonusEngine.doRepaint=false;

           for(int w=0; w<maxAmountOfBalls; w++){
               if (a[w].isAlive){
                   if(a[w].isFlying){
                       a[w].flyToPoint(mouseTip);
                   }
               }
           }
       }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == conti){
            gamePanel.createGameNextLevel();

        }else if(actionEvent.getSource() == retry){
            gamePanel.createGame(level.level);

        }
    }
}
