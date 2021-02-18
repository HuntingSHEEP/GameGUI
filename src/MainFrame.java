import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrame extends JFrame implements ActionListener {

    JPanel cardsPanel;

    MainMenuPanel mainMenuPanel;
    SkillsTreePanel skillsTreePanel;
    LevelsPanel levelsPanel;
    GamePanel gamePanel;
    SettingsPanel settingsPanel;
    GameStatistics gameStatistics;


    MainFrame(){
        super();
        loadGameStatistics();

        cardsPanel = new JPanel(new CardLayout());

        mainMenuPanel = new MainMenuPanel(this);
        skillsTreePanel = new SkillsTreePanel(this);
        levelsPanel = new LevelsPanel(this);
        gamePanel = new GamePanel(this);
        settingsPanel = new SettingsPanel(this);

        cardsPanel.setLayout(new CardLayout());
        cardsPanel.add(mainMenuPanel, mainMenuPanel.getCardName());
        cardsPanel.add(skillsTreePanel, skillsTreePanel.getCardName());
        cardsPanel.add(levelsPanel, levelsPanel.getCardName());
        cardsPanel.add(gamePanel, gamePanel.getCardName());
        cardsPanel.add(settingsPanel, settingsPanel.getCardName());

        this.add(cardsPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(820, 700);
        this.setMaximumSize(new Dimension(820, 700));
        this.setResizable(false);
        this.setVisible(true);

    }

    private void loadGameStatistics() {
        gameStatistics = new GameStatistics();
    }

    public GameStatistics getGameStatistics(){
        return gameStatistics;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==null){
            System.out.println("skillsTree");
        }
    }

}
