import java.awt.*;

public class SkillLine {
    Point A, B;
    GameStatistics gs;
    int skillOne, skillTwo;

    Color active = new Color(2, 255, 250, 255);
    Color disactive = new Color(58, 66, 65, 250);


    SkillLine(GameStatistics gs, Point A, Point B, int skillOne, int skillTwo){
        this.A = A;
        this.B = B;
        this.gs = gs;
        this.skillOne = skillOne;
        this.skillTwo = skillTwo;
    }

    public Point getA(){
        return A;
    }

    public Point getB(){
        return B;
    }

    public Color getTexture(){
        if(skillOne == -1){
            if(gs.getSkillStatus(skillTwo)>1){
                return active;
            }else{
                return disactive;
            }
        }

        if((gs.getSkillStatus(skillOne) > 1) && (gs.getSkillStatus(skillTwo) > 1)){
            return active;
        }else{
            return disactive;
        }
    }


}
