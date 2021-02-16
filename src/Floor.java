import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Floor extends Rectangle2D.Float {
    Plansza p;
    boolean isAlive;
    boolean superFloor;
    int lifeCycles = 0;
    BufferedImage[] textures;

    Floor(Plansza p, int x, int y, int width)
    {
        this.width=width;
        this.height=100;
        this.x=x;
        this.y=y;
        this.isAlive=false;
        this.superFloor=false;
        this.p = p;
        textures = new BufferedImage[2];
        loadTextures();
    }

    private void loadTextures(){
        String[] pliki = {"textures/floorTexture.png", "textures/floorTexture.png"};

        try
        {
            for (int i=0; i<2; i++){
                File f=new File(pliki[i]);
                textures[i] = ImageIO.read(f);
            }

        }
        catch(IOException e)
        {
            System.err.println("Problem z pobraniem tekstury: "+e);
        }
    }

    public BufferedImage getTexture(){
        if (superFloor)
            return textures[1];
        return textures[0];
    }

    public void setBounds(double x, double y, double width, double height){
        this.x = (float) x;
        this.y = (float) y;
        this.width = (float) width;
        this.height = (float) height;
    }

    public boolean intersects(Kulka q){
        boolean test1 = contains(q.x, q.y);
        boolean test2 = contains(q.x+q.width, q.y);
        boolean test3 = contains(q.x+q.width, q.y+q.height);
        boolean test4 = contains(q.x, q.y+q.height);

        return test1 || test2 || test3 || test4;
    }

    public boolean intersects(Bonus q){
        //TODO:[BUG] BELKA NIŻSZA OD BONUSU
        boolean test1 = contains(q.x, q.y);
        boolean test2 = contains(q.x+q.width, q.y);
        boolean test3 = contains(q.x+q.width, q.y+q.height);
        boolean test4 = contains(q.x, q.y+q.height);

        return test1 || test2 || test3 || test4;
    }
}
