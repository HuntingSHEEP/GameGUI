import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SkillsTreePanel extends JPanel implements ActionListener {
    BackToMainMenuButton backToMainMenuButton;
    MainFrame mainFrame;
    Color backgroundColor;
    ViewPanel panel;
    GameStatistics gs;

    SkillButton startButton;
    SkillButton plusBall, ballSpeed, barExtension;

    SkillsTreePanel(MainFrame mainFrame){
        super();
        this.mainFrame = mainFrame;
        backgroundColor = new Color(0x222222);
        gs = mainFrame.getGameStatistics();

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
        setupButtons();
    }

    private void setupButtons() {
        startButton.setText(""+gs.getSkillPoints());
        plusBall.updateStatus(gs.getPlusBallStatus());
        ballSpeed.updateStatus(gs.getBallSpeedStatus());
        barExtension.updateStatus(gs.getBarExtensionStatus());

    }

    public String getCardName(){
        return "1";
    }

    private void addButtons(){
        startButton = new SkillButton();
        plusBall = new SkillButton();
        SkillButton iceBall = new SkillButton();
        SkillButton fireBall = new SkillButton();
        barExtension = new SkillButton();
        SkillButton roundExtend = new SkillButton();
        SkillButton stickyBar = new SkillButton();
        SkillButton shortenBar = new SkillButton();
        SkillButton shortenRound = new SkillButton();
        ballSpeed = new SkillButton();
        SkillButton magnetFloor = new SkillButton();
        SkillButton floor = new SkillButton();
        SkillButton flyToPoint = new SkillButton();

        SkillButton iceRadius = new SkillButton();
        SkillButton ballX2 = new SkillButton();
        SkillButton fireForce = new SkillButton();
        SkillButton fireTime = new SkillButton();
        SkillButton barMaxSize = new SkillButton();
        SkillButton barDX = new SkillButton();
        SkillButton barShortBonus = new SkillButton();
        SkillButton stickyBarTime = new SkillButton();
        SkillButton shortRoundBonus = new SkillButton();
        SkillButton ballSpeedBonus = new SkillButton();
        SkillButton ballSpeedTime = new SkillButton();
        SkillButton magnetFloorTime = new SkillButton();
        SkillButton floorTime = new SkillButton();
        SkillButton freeze = new SkillButton();
        SkillButton flyThrough = new SkillButton();

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
        iceRadius.equipRadius();
        ballX2.equipX2();
        fireForce.equipForce();
        fireTime.equipFireTime();
        barMaxSize.equipBarMaxSize();
        barDX.equipBarDX();
        barShortBonus.equipBarShorteningBonus();
        stickyBarTime.equipStickyTime();
        shortRoundBonus.equipShortRoundBonus();
        ballSpeedBonus.equipBallSpeedBonus();
        ballSpeedTime.equipBallSpeedTime();
        magnetFloorTime.equipMagnetFloorTime();
        floorTime.equipFloorTime();
        freeze.equipFreeze();
        flyThrough.equipFlyThrough();

        plusBall.addActionListener(this);
        barExtension.addActionListener(this);
        ballSpeed.addActionListener(this);



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
        panel.add(flyToPoint);
        panel.add(iceRadius);
        panel.add(ballX2);
        panel.add(fireForce);
        panel.add(fireTime);
        panel.add(barMaxSize);
        panel.add(barDX);
        panel.add(barShortBonus);
        panel.add(stickyBarTime);
        panel.add(shortRoundBonus);
        panel.add(ballSpeedBonus);
        panel.add(ballSpeedTime);
        panel.add(magnetFloorTime);
        panel.add(floorTime);
        panel.add(freeze);
        panel.add(flyThrough);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == backToMainMenuButton){
            CardLayout cl = (CardLayout) mainFrame.cardsPanel.getLayout();
            cl.show(mainFrame.cardsPanel, mainFrame.mainMenuPanel.getCardName());
        }else{
            //If enough points
            SkillButton button = (SkillButton) actionEvent.getSource();
            int skillCode = button.getSkillCode();
            button.up();
            int[] children = button.getChildren();

            for (int x=0; x<children.length; x++){
                System.out.println("Child: "+children[x]);

            }

            System.out.println("SkillCode "+skillCode);
        }
    }
}
