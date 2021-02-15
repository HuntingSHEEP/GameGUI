import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    JPanel cardsPanel;

    MainMenuPanel mainMenuPanel;
    SkillsTreePanel skillsTreePanel;
    LevelsPanel levelsPanel;
    GamePanel gamePanel;


    MainFrame(){
        super();
        cardsPanel = new JPanel(new CardLayout());

        mainMenuPanel = new MainMenuPanel(this);
        skillsTreePanel = new SkillsTreePanel(this);
        levelsPanel = new LevelsPanel(this);
        gamePanel = new GamePanel(this);

        cardsPanel.setLayout(new CardLayout());
        cardsPanel.add(mainMenuPanel, mainMenuPanel.getCardName());
        cardsPanel.add(skillsTreePanel, skillsTreePanel.getCardName());
        cardsPanel.add(levelsPanel, levelsPanel.getCardName());
        cardsPanel.add(gamePanel, gamePanel.getCardName());

        this.add(cardsPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(820, 700);
        this.setResizable(true);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==null){
            System.out.println("skillsTree");
        }
    }
}
