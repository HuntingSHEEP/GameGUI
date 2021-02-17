import javax.swing.*;
import java.awt.*;

public class BonusEngine extends Thread {
    boolean running=true;
    int fireBallCycles = 0;
    int stickyBarCycles = 0;

    Plansza p;
    GamePanel gamePanel;
    boolean justWait=false;
    boolean doRepaint=false;


    JLabel skillBadge;
    boolean skillBadgeFlag = false;

    BonusEngine(Plansza p, GamePanel gamePanel){
        this.p = p;
        this.gamePanel = gamePanel;

        skillBadge = new JLabel(""+p.skillCoins);
        skillBadge.setFont(new Font("MV Boli", Font.PLAIN, 17));
        skillBadge.setHorizontalTextPosition(JLabel.CENTER);
        skillBadge.setVerticalTextPosition(JLabel.CENTER);
        skillBadge.setBounds(5, 200, 40, 60);
        skillBadge.setPreferredSize(new Dimension(40, 60));
        skillBadge.setForeground(new Color(0x8907fa));
        skillBadge.setOpaque(false);
        skillBadge.setIcon(new ImageIcon("textures/skillBagde.png"));

        start();
    }

    public void run(){
        try{
            System.out.println("START ENGINE");
            while(running){
                if(justWait){
                    while(justWait){
                        sleep(10);
                    }
                }



                for(int index=0; index< p.liczba_kafelek; index++){


                    if(p.fallingBonus[index].isAlive){
                        p.fallingBonus[index].y++;

                        if(executeBarHit(index)){
                            p.fallingBonus[index].isAlive=false;
                            p.fallingBonus[index].liveCycles=0;
                        }
                        if(executeSuperFloorHit(index)){
                            p.fallingBonus[index].isAlive=false;
                            p.fallingBonus[index].liveCycles=0;
                        }

                        if(p.fallingBonus[index].liveCycles == 0){
                            p.fallingBonus[index].isAlive=false;
                        }
                        else if(p.fallingBonus[index].liveCycles>0){
                            p.fallingBonus[index].liveCycles--;
                        }
                    }
                }


                if (p.skillCoins > 0){
                    if (!skillBadgeFlag){
                        skillBadge.setText(""+p.skillCoins);
                        gamePanel.eastPanel.add(skillBadge);
                        gamePanel.eastPanel.repaint();
                        skillBadgeFlag = true;
                    }
                    skillBadge.setText(""+p.skillCoins);

                }else if(p.skillCoins == 0){
                    if(skillBadgeFlag){
                        gamePanel.eastPanel.remove(skillBadge);
                        gamePanel.eastPanel.repaint();
                        skillBadgeFlag=false;
                    }
                }


                if (p.floor.isAlive){
                    if(p.floor.lifeCycles == 0){
                        //System.out.println("Dead Floor cycles: "+ p.floor.lifeCycles);
                        p.floor.isAlive=false;
                        p.floor.superFloor=false;
                    }else if(p.floor.lifeCycles > 0){
                        p.floor.lifeCycles--;
                        //System.out.println("Floor cycles: "+ p.floor.lifeCycles);
                    }
                }

                if (fireBallCycles>0){
                    fireBallCycles--;
                }else{
                    for (int i=0; i<p.maxAmountOfBalls; i++){
                        p.a[i].ballType = 0;
                    }
                }

                if(stickyBarCycles>0){
                    stickyBarCycles--;
                    System.out.println("Sticky bar cycles: "+ stickyBarCycles);
                }else{
                    p.b.sticky=false;
                }

                if(doRepaint)
                    p.repaint();

                sleep(10);
            }
        }catch (InterruptedException e) {System.out.println("Floor Engine Issue: " +e);}
    }


    public boolean executeBarHit(int index){
        if(p.b.intersects(p.fallingBonus[index])){
            p.fallingBonus[index].exec();
            p.fallingBonus[index].isAlive = false;
            return true;
        }
        return false;
    }

    public boolean executeSuperFloorHit(int index){
        if(p.floor.superFloor && p.floor.isAlive){
            if(p.floor.intersects(p.fallingBonus[index])){
                p.fallingBonus[index].exec();
                p.fallingBonus[index].isAlive = false;
                return true;
            }
        }

        return false;
    }
}
