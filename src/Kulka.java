import java.awt.geom.*;
import java.lang.Math;
import java.awt.*;

class Kulka extends Ellipse2D.Float
{
   Plansza p;
   double dx,dy;
   boolean inBar = false;
   boolean isAlive;
   boolean isFlying=false;
   Color normalBall = new Color(0, 255, 255);
   Color fireBall = new Color(250, 81, 2);
   Color iceBall = new Color(0xB8C7C9);

   int ballType = 0;
   int force = 1;


   Kulka(Plansza p,int x,int y,double dx,double dy, boolean isAlive)
   {
      this.x=x;
      this.y=y;
      this.width=10;
      this.height=10;

      this.p=p;
      this.dx=dx;
      this.dy=dy;
      this.isAlive=isAlive;
   }

   public Color getTexture(){
       if(ballType == 1)
           return fireBall;
       if(ballType == 2)
           return iceBall;
       return normalBall;
   }

   void setX(int x){
       this.x = x;
   }

   void setY(int y){
       this.y = y;
   }

   void setDXDY (double dx, double dy){
       this.dx = dx;
       this.dy = dy;
   }
   void flyToPoint(Point point){
       float eDX = point.x - x;
       float eDY = point.y - y;
       double nonScaledSpeed = Math.sqrt(eDX*eDX + eDY*eDY);
       double speedScale = getSpeed()/nonScaledSpeed;
       eDX *= speedScale;
       eDY *= speedScale;
       setDXDY(eDX, eDY);
   }

   public double getSpeed(){
       return Math.sqrt(dx*dx + dy*dy);
   }

   void addDeltaX(int dx){
       this.x += dx;
   }

   void nextKrok()
   {
       x+=dx;
       y+=dy;
        //TODO: FIX BALL IN WALL BUG
       if(getMinX()<0 || getMaxX()>p.getWidth())  dx=-dx;
       if(getMinY()<0){
           if(dy<0){
               dy=-dy;
           }
       }

       if((getMinY()>p.getHeight()) && (p.getHeight()>5)){
           isAlive=false;
           p.ballCount--;
           if(p.ballCount==0)
               p.gameOver = true;
       }

       bounceFromBar();
       bounceFromBricks();
       bounceFromFloor();
       //p.repaint();
   }

   void bounceFromBar(){
       if (p.b.intersects(this) && !inBar){
           dy=-dy;

           if(p.b.sticky){
               isFlying=false;
               double velocity = Math.sqrt(dx*dx + dy*dy);
               dx=0;
               dy=-velocity;
           }
           inBar=true;
           p.b.changeAngle(this);

       }else if(! p.b.intersects(this)){
           inBar=false;
       }
   }

   void bounceFromBricks(){
       //TODO: [BASIC FEATURE] ODBICIE OD BOCZNYCH KRAWĘDZI
       for(int u=0; u<p.liczba_kafelek; u++){
           if(p.k[u].intersects(this) && (p.k[u].flaga_ZYCIA>0)){
               if(p.a[0].ballType == 0){
                   //System.out.println("BOUNCED FROM BRICK!");
                   dy=-dy;
                   p.k[u].flaga_ZYCIA-=force;
               }else if(p.a[0].ballType == 1){
                   System.out.println("BRICK IS BURNED DOWN!");
                   p.k[u].flaga_ZYCIA=0;
               }

               if (p.k[u].flaga_ZYCIA<=0){
                   p.livingBricks--;
                   p.score++;
                   if ((int) (p.score / 2) >0){
                       p.skillCoins += p.score/2;
                       p.score = p.score%2;
                       p.gamePanel.eastPanel.repaint();

                   }
                   p.k[u].createBonus(u);
               }
               u=p.liczba_kafelek+1;
           }
       }
   }

   void bounceFromFloor(){
       if(p.floor.isAlive){
           if(p.floor.intersects(this)){
               dy=-dy;
           }
       }
   }

}
