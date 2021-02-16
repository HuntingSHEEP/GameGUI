
import javax.imageio.ImageIO;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

class Kafelka extends Rectangle2D.Float
{
    /*
    * BRICK TYPES:
    * 1) STONE BRICK - 2 live points
    * 2) ICE BRICK - 3 live points, can melt down immediately when hit with fire ball
    */

  Plansza p;
  BufferedImage[] textures;
  int margines;
  int flaga_ZYCIA;
  int bonus;
  int brickType;


    Kafelka(Plansza p, int x, int y, float width, int brickType)
    {
        this.margines=4;
        this.width=width-this.margines;
        this.height=20-this.margines;
        this.x=x*(this.width+this.margines)+this.margines;
        this.y=y*(this.height+this.margines)+this.margines;
        bonus = ThreadLocalRandom.current().nextInt(0, 10 + 1);
        //bonus = 1;
        this.p = p;
        this.brickType=brickType;
        this.flaga_ZYCIA=2;

        if(brickType == 0)
            this.flaga_ZYCIA=2;
        else if(brickType == 1)
            this.flaga_ZYCIA=3;

        textures = new BufferedImage[3];
        loadTextures();
    }

    private void loadTextures(){
        String[][] pliki = {
                {"textures/brickStoneHIT.png", "textures/brickStoneFull.png"},
                {"textures/brickIceHITTwice.png", "textures/brickIceHITOnce.png","textures/brickIceFULL.png"}};

        int lvs=2;
        if (brickType==0)
            lvs = 2;
        else if(brickType==1)
            lvs = 3;

        try
        {
            for (int i=0; i<lvs; i++){
                File f=new File(pliki[brickType][i]);
                textures[i] = ImageIO.read(f);
            }

        }
        catch(IOException e)
        {
            System.err.println("Problem z pobraniem tekstury: "+e);
        }
    }

    public void createBonus(int index){
        if ( (0<=bonus) && (bonus <=10)){

            p.fallingBonus[index].type = bonus%10;
            p.fallingBonus[index].type = 5;
            p.fallingBonus[index].isAlive = true;

            Thread watek = new Thread(){
                public void run(){
                    for (int i=0; i<p.getSize().height+5; i++){
                        p.fallingBonus[index].y++;
                        waitSomeTime();
                        if(executeBarHit())
                            i = p.getSize().height+10;
                        if(executeSuperFloorHit())
                            i = p.getSize().height+10;
                    }
                    p.fallingBonus[index].isAlive = false;
                }

                public void waitSomeTime(){
                    final long INTERVAL =  10000000;
                    long start = System.nanoTime();
                    long end;
                    do{
                        end = System.nanoTime();
                    }while(start + INTERVAL >= end);
                }

                public boolean executeBarHit(){
                    if(p.b.intersects(p.fallingBonus[index])){
                        p.fallingBonus[index].exec();
                        p.fallingBonus[index].isAlive = false;
                        return true;
                    }
                    return false;
                }

                public boolean executeSuperFloorHit(){
                    if(p.floor.superFloor && p.floor.isAlive){
                        if(p.floor.intersects(p.fallingBonus[index])){
                            p.fallingBonus[index].exec();
                            p.fallingBonus[index].isAlive = false;
                            return true;
                        }
                    }

                    return false;
                }

            };
            watek.start();

        }
    }

    public boolean contains(double x, double y){
        // ALSO THE BOUNDARIES ARE IN SCOPE
        boolean testX = ((this.x<=x) && (x<=this.x+this.width));
        boolean testY = ((this.y<=y) && (y<=this.y+this.height));
        return (testX && testY);
    }

    public boolean intersects(Kulka q){
        boolean test1 = contains(q.x, q.y);
        boolean test2 = contains(q.x+q.width, q.y);
        boolean test3 = contains(q.x+q.width, q.y+q.height);
        boolean test4 = contains(q.x, q.y+q.height);

        return test1 || test2 || test3 || test4;
    }

    void setX(int x)
    {
        this.x=x;
    }

    void setY(int y) { this.y=y; }

    public BufferedImage getTexture(){
        return textures[flaga_ZYCIA-1];
    }

}
