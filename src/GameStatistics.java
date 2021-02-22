public class GameStatistics {

    private int maxUnlockedLevel;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesLost;
    private int skillPoints = 10;
    /* IMPORTANT
    * 0 > indicates the skill is blocked and can't be purchased
    * 1 > indicates the skill is available to buy
    * 2 > indicates the skill is being bought
    */
    private int plusBall=1;
    private int ballSpeed=1;
    private int barExtension=1;
    private int[] skills;

    GameStatistics(){
        maxUnlockedLevel = 0;
        gamesPlayed = 0;
        gamesWon = 0;
        gamesLost = 0;
        skills = new int[] {1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    }

    public void unlockButtons(int[] list){
        for (int j : list) buttonUP(j, false);

    }

    public void buttonUP(int bNumber, boolean spendSP){
        if(spendSP)
            skillPoints--;

        skills[bNumber]++;

        if(bNumber==0)
            plusBall++;
        else if(bNumber==1)
            ballSpeed++;
        else if(bNumber==2)
            barExtension++;

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

    public int getPlusBallStatus(){
        return skills[0];
    }

    public int getBallSpeedStatus() {
        return skills[1];
    }

    public int getBarExtensionStatus() {
        return skills[2];
    }

    public int getIceBallStatus() {
        return skills[3];
    }

    public int getBallX2Status() {
        return skills[4];
    }

    public int getFireBallStatus() {
        return skills[5];
    }

    public int getIceRadiusStatus() {
        return skills[6];
    }

    public int getFireForceStatus() {
        return skills[7];
    }

    public int getFireTimeStatus() {
        return skills[8];
    }

    public int getFlyThroughStatus() {
        return skills[9];
    }

    public int getBallSpeedTimeStatus() {
        return skills[10];
    }

    public int getBallSpeedBonusStatus() {
        return skills[11];
    }

    public int getFloorStatus() {
        return skills[12];
    }

    public int getMagnetFloorStatus() {
        return skills[13];
    }

    public int getMagnetFloorTimeStatus() {
        return skills[14];
    }

    public int getFloorTimeStatus() {
        return skills[15];
    }

    public int getFlyToPointStatus() {
        return skills[16];
    }

    public int getFreezeStatus() {
        return skills[17];
    }
}
