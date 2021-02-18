import javax.swing.*;

public class Level {
    int level;

    int rows;
    int columns;
    int bricksNumber;
    int numberOfLevels = 5;

    Kafelka[] brick;
    Bonus[] fallingBonus;
    Plansza plansza;

    Level(){

    }

    Level(int level, Plansza plansza){
        this.level = level;
        this.plansza = plansza;
        createLevel();
    }

    public LevelButton getButton(int number){
        LevelButton button = new LevelButton(number);
        button.setBounds(0,0,100,100);

        return button;
    }

    public int getNumberOfLevels(){
        return numberOfLevels;
    }

    private void createLevel(){
        if(level == 0){
            rows = 1;
            columns = 1;
            bricksNumber = columns * rows;
            brick = new Kafelka[bricksNumber];
            fallingBonus = new Bonus[bricksNumber];

            for (int i=0; i<bricksNumber; i++){
                brick[i]=new Kafelka(plansza, i%columns, i/columns, 718f/columns, 0);
                fallingBonus[i] = new Bonus(plansza,i%columns, i/columns, 718f/columns);
            }
        }else if(level == 1){
            rows = 1;
            columns = 12;
            bricksNumber = columns * rows;
            brick = new Kafelka[bricksNumber];
            fallingBonus = new Bonus[bricksNumber];

            for (int i=0; i<bricksNumber; i++){
                brick[i]=new Kafelka(plansza, i%columns, i/columns, 718f/columns, 0);
                fallingBonus[i] = new Bonus(plansza,i%columns, i/columns, 718f/columns);
            }
        }else if(level == 2){
            rows = 2;
            columns = 9;
            bricksNumber = columns * rows;
            brick = new Kafelka[bricksNumber];
            fallingBonus = new Bonus[bricksNumber];

            for (int i=0; i<bricksNumber; i++){
                brick[i]=new Kafelka(plansza, i%columns, i/columns, 718f/columns, 0);
                fallingBonus[i] = new Bonus(plansza,i%columns, i/columns, 718f/columns);
            }
        }else if(level == 3){
            rows = 2;
            columns = 12;
            bricksNumber = columns * rows;
            brick = new Kafelka[bricksNumber];
            fallingBonus = new Bonus[bricksNumber];

            for (int i=0; i<bricksNumber; i++){
                brick[i]=new Kafelka(plansza, i%columns, i/columns, 718f/columns, 0);
                fallingBonus[i] = new Bonus(plansza,i%columns, i/columns, 718f/columns);
            }
        }else if(level == 4){
            rows = 2;
            columns = 9;
            bricksNumber = columns * rows;
            brick = new Kafelka[bricksNumber];
            fallingBonus = new Bonus[bricksNumber];

            for (int i=0; i<bricksNumber; i++){
                brick[i]=new Kafelka(plansza, i%columns, i/columns, 718f/columns, 1);
                fallingBonus[i] = new Bonus(plansza,i%columns, i/columns, 718f/columns);
            }
        }

    }

    public int getBricksNumber(){
        return bricksNumber;
    }

    public Kafelka[] getBricks(){
        return brick;
    }

    public Bonus[] getFallingBonus(){
        return fallingBonus;
    }

}
