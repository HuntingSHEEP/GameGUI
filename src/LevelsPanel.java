import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelsPanel extends JPanel implements ActionListener {
    BackToMainMenuButton backToMainMenuButton;
    MainFrame mainFrame;
    Color backgroundColor;
    JPanel panel;

    LevelsPanel(MainFrame mainFrame){
        super();
        this.mainFrame = mainFrame;
        backgroundColor = new Color(0x222222);

        panel = new JPanel();
        JPanel northPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        JPanel southPanel = new JPanel();

        northPanel.setBackground(backgroundColor);
        northPanel.setPreferredSize(new Dimension(50, 50));

        westPanel.setBackground(backgroundColor);
        westPanel.setPreferredSize(new Dimension(50, 50));

        eastPanel.setBackground(backgroundColor);
        eastPanel.setPreferredSize(new Dimension(50, 50));

        southPanel.setBackground(backgroundColor);
        southPanel.setPreferredSize(new Dimension(50, 50));

        panel.setBackground(backgroundColor);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

        backToMainMenuButton = new BackToMainMenuButton();
        backToMainMenuButton.addActionListener(this);
        southPanel.add(backToMainMenuButton);
        southPanel.setLayout(null);

        setBackground(backgroundColor);
        setLayout(new BorderLayout());

        this.add(northPanel, BorderLayout.NORTH);
        this.add(westPanel, BorderLayout.WEST);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(panel, BorderLayout.CENTER);
        loadLevelButtons();

    }

    public void loadLevelButtons() {
        int maxUnlockedLevel = mainFrame.getGameStatistics().getMaxUnlockedLevel();
        Level level = new Level();
        panel.removeAll();
        for(int i=0; i<level.getNumberOfLevels(); i++){
            LevelButton button = level.getButton(i);
            button.addActionListener(this);
            button.setForeground(new Color(255, 0, 138, 255));
            panel.add(button);
            if( i>maxUnlockedLevel){
                button.setEnabled(false);
                button.setForeground(new Color(80, 75, 80, 72));
            }
        }
        revalidate();
        repaint();
    }

    public String getCardName(){
        return "2";
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == backToMainMenuButton){
            CardLayout cl = (CardLayout) mainFrame.cardsPanel.getLayout();
            cl.show(mainFrame.cardsPanel, mainFrame.mainMenuPanel.getCardName());
        }else{
            //TODO: POTENTIAL BUG PLACE IF MORE BUTTONS ADDED
            int buttonID = ((LevelButton) (actionEvent.getSource())).getLevelID();
            mainFrame.gamePanel.createGame(buttonID);
            CardLayout cl = (CardLayout) mainFrame.cardsPanel.getLayout();
            cl.show(mainFrame.cardsPanel, mainFrame.gamePanel.getCardName());

        }
    }
}
