import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel implements ActionListener {
    SkillsTreeButton skillsTreeButton;
    LevelsMainButton levelsMainButton;
    StartMainButton startMainButton;
    SettingsMainButton settingsMainButton;
    Color backgroundColor;
    MainFrame mainFrame;

    MainMenuPanel(MainFrame mainFrame){
        super();
        this.mainFrame = mainFrame;
        backgroundColor = new Color(0x222222);

        JPanel panel = new JPanel();

        skillsTreeButton = new SkillsTreeButton();
        levelsMainButton = new LevelsMainButton();
        startMainButton = new StartMainButton();
        settingsMainButton = new SettingsMainButton();

        skillsTreeButton.addActionListener(this);
        levelsMainButton.addActionListener(this);
        startMainButton.addActionListener(this);
        settingsMainButton.addActionListener(this);


        panel.add(skillsTreeButton);
        panel.add(levelsMainButton);
        panel.add(startMainButton);
        panel.add(settingsMainButton);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 80));
        panel.setBackground(backgroundColor);

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

        this.setLayout(new BorderLayout(10, 10));
        this.setBackground( backgroundColor);

        this.add(northPanel, BorderLayout.NORTH);
        this.add(westPanel, BorderLayout.WEST);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == skillsTreeButton){
            System.out.println("skill");
            CardLayout cl = (CardLayout) (mainFrame.cardsPanel.getLayout());
            cl.show(mainFrame.cardsPanel, "1");


        }else if(actionEvent.getSource() == levelsMainButton){
            System.out.println("levels");
        }else if(actionEvent.getSource() == startMainButton){
            System.out.println("starten!");
        }else if(actionEvent.getSource() == settingsMainButton){
            System.out.println("settings");
        }

    }
}
