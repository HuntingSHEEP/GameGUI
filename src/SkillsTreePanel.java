import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SkillsTreePanel extends JPanel implements ActionListener {
    BackToMainMenuButton backToMainMenuButton;
    MainFrame mainFrame;
    Color backgroundColor;
    ViewPanel panel;

    SkillsTreePanel(MainFrame mainFrame){
        super();
        this.mainFrame = mainFrame;
        backgroundColor = new Color(0x222222);

        panel = new ViewPanel();
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

        backToMainMenuButton = new BackToMainMenuButton();
        backToMainMenuButton.addActionListener(this);
        backToMainMenuButton.setTreeBounds();

        panel.add(backToMainMenuButton);
        //southPanel.setLayout(null);

        setBackground(backgroundColor);
        setLayout(new BorderLayout());

        //this.add(northPanel, BorderLayout.NORTH);
        //this.add(westPanel, BorderLayout.WEST);
        //this.add(eastPanel, BorderLayout.EAST);
        //this.add(southPanel, BorderLayout.SOUTH);
        this.add(panel, BorderLayout.CENTER);
        addButtons();
    }

    public String getCardName(){
        return "1";
    }

    private void addButtons(){
        SkillButton startButton = new SkillButton();
        SkillButton plusBall = new SkillButton();
        SkillButton iceBall = new SkillButton();
        SkillButton fireBall = new SkillButton();
        SkillButton barExtension = new SkillButton();
        SkillButton roundExtend = new SkillButton();
        SkillButton stickyBar = new SkillButton();
        SkillButton shortenBar = new SkillButton();
        SkillButton shortenRound = new SkillButton();
        SkillButton ballSpeed = new SkillButton();
        SkillButton magnetFloor = new SkillButton();
        SkillButton floor = new SkillButton();
        SkillButton flyToPoint = new SkillButton();

        startButton.equipStart();
        plusBall.equipAddBall();
        iceBall.equipIce();
        fireBall.equipFire();
        barExtension.equipBarExtension();
        roundExtend.equipRoundExtension();
        stickyBar.equipSticky();
        shortenBar.equipShortenBar();
        shortenRound.equipShortenRound();
        ballSpeed.equipBallSpeed();
        magnetFloor.equipMagnetFloor();
        floor.equipFloor();
        flyToPoint.equipFlyToPoint();


/*
        panel.add(startButton);
        panel.add(plusBall);
        panel.add(iceBall);
        panel.add(fireBall);
        panel.add(barExtension);
        panel.add(roundExtend);
        panel.add(stickyBar);
        panel.add(shortenBar);
        panel.add(shortenRound);
        panel.add(ballSpeed);
        panel.add(magnetFloor);
        panel.add(floor);
        panel.add(flyToPoint); */
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == backToMainMenuButton){
            CardLayout cl = (CardLayout) mainFrame.cardsPanel.getLayout();
            cl.show(mainFrame.cardsPanel, mainFrame.mainMenuPanel.getCardName());
        }
    }
}
