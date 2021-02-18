public class Level {
    int level;

    int rows;
    int columns;
    int bricksNumber;

    Kafelka[] brick;
    Bonus[] fallingBonus;
    Plansza plansza;

    Level(int level, Plansza plansza){
        this.level = level;
        this.plansza = plansza;
        createLevel();
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
            rows = 2;
            columns = 12;
            bricksNumber = columns * rows;
            brick = new Kafelka[bricksNumber];
            fallingBonus = new Bonus[bricksNumber];

            for (int i=0; i<bricksNumber; i++){
                brick[i]=new Kafelka(plansza, i%columns, i/columns, 718f/columns, 0);
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
