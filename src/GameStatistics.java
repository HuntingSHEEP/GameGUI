public class GameStatistics {

    private int maxUnlockedLevel;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesLost;
    private int skillPoints = 5;
    /* IMPORTANT
    * 0 > indicates the skill is blocked and can't be purchased
    * 1 > indicates the skill is available to buy
    * 2 > indicates the skill is beeing bought
    */
    private int plusBall=1;
    private int ballSpeed=1;
    private int barExtension=1;

    GameStatistics(){
        maxUnlockedLevel = 0;
        gamesPlayed = 0;
        gamesWon = 0;
        gamesLost = 0;
    }

    public int getPlusBallStatus(){
        return plusBall;
    }

    public int getMaxUnlockedLevel(){
        return maxUnlockedLevel;
    }
    public int getSkillPoints(){
        return skillPoints;
    }

    public void gameWon(int lvl){
        if(lvl==maxUnlockedLevel)
            maxUnlockedLevel++;
        gamesPlayed++;
        gamesWon++;
        System.out.println("MAX UNLOCKED LEVEL "+maxUnlockedLevel);
    }

    public void gameLost(){
        gamesPlayed++;
        gamesLost++;
    }

    public int getBallSpeedStatus() {
        return ballSpeed;
    }

    public int getBarExtensionStatus() {
        return barExtension;
    }
}
