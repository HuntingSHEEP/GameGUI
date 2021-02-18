public class GameStatistics {

    private int maxUnlockedLevel;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesLost;

    GameStatistics(){
        maxUnlockedLevel = 0;
        gamesPlayed = 0;
        gamesWon = 0;
        gamesLost = 0;
    }

    public int getMaxUnlockedLevel(){
        return maxUnlockedLevel;
    }

    public void gameWon(){
        gamesPlayed++;
        gamesWon++;
        maxUnlockedLevel++;
        System.out.println("MAX UNLOCKED LEVEL "+maxUnlockedLevel);
    }

    public void gameLost(){
        gamesPlayed++;
        gamesLost++;
    }
}
