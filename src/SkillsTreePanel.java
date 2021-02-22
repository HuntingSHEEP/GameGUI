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
    SkillButton plusBall, ballSpeed, barExtension, iceBall, ballX2
            ,fireBall,iceRadius,fireForce,fireTime,flyThrough,ballSpeedTime,
            ballSpeedBonus,floor,magnetFloor,magnetFloorTime,floorTime,
            flyToPoint,freeze;

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
        //
        plusBall.updateStatus(gs.getPlusBallStatus());
        ballSpeed.updateStatus(gs.getBallSpeedStatus());
        barExtension.updateStatus(gs.getBarExtensionStatus());
        iceBall.updateStatus(gs.getIceBallStatus());
        ballX2.updateStatus(gs.getBallX2Status());
        fireBall.updateStatus(gs.getFireBallStatus());
        iceRadius.updateStatus(gs.getIceRadiusStatus());
        fireForce.updateStatus(gs.getFireForceStatus());
        fireTime.updateStatus(gs.getFireTimeStatus());
        flyThrough.updateStatus(gs.getFlyThroughStatus());
        //
        ballSpeedTime.updateStatus(gs.getBallSpeedTimeStatus());
        ballSpeedBonus.updateStatus(gs.getBallSpeedBonusStatus());
        floor.updateStatus(gs.getFloorStatus());
        magnetFloor.updateStatus(gs.getMagnetFloorStatus());
        magnetFloorTime.updateStatus(gs.getMagnetFloorTimeStatus());
        floorTime.updateStatus(gs.getFloorTimeStatus());
        flyToPoint.updateStatus(gs.getFlyToPointStatus());
        freeze.updateStatus(gs.getFreezeStatus());

    }

    public String getCardName(){
        return "1";
    }

    private void addButtons(){
        startButton = new SkillButton();
        plusBall = new SkillButton();
        iceBall = new SkillButton();
        fireBall = new SkillButton();
        barExtension = new SkillButton();
        SkillButton roundExtend = new SkillButton();
        SkillButton stickyBar = new SkillButton();
        SkillButton shortenBar = new SkillButton();
        SkillButton shortenRound = new SkillButton();
        ballSpeed = new SkillButton();
        magnetFloor = new SkillButton();
        floor = new SkillButton();
        flyToPoint = new SkillButton();

        iceRadius = new SkillButton();
        ballX2 = new SkillButton();
        fireForce = new SkillButton();
        fireTime = new SkillButton();
        SkillButton barMaxSize = new SkillButton();
        SkillButton barDX = new SkillButton();
        SkillButton barShortBonus = new SkillButton();
        SkillButton stickyBarTime = new SkillButton();
        SkillButton shortRoundBonus = new SkillButton();
        ballSpeedBonus = new SkillButton();
        ballSpeedTime = new SkillButton();
        magnetFloorTime = new SkillButton();
        floorTime = new SkillButton();
        freeze = new SkillButton();
        flyThrough = new SkillButton();

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
        fireForce.equipFireForce();
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
        barExtension.addActionListener(this);
        iceBall.addActionListener(this);
        ballX2.addActionListener(this);
        fireBall.addActionListener(this);
        iceRadius.addActionListener(this);
        fireForce.addActionListener(this);
        fireTime.addActionListener(this);
        flyThrough.addActionListener(this);
        ballSpeedTime.addActionListener(this);
        ballSpeedBonus.addActionListener(this);
        floor.addActionListener(this);
        magnetFloor.addActionListener(this);
        magnetFloorTime.addActionListener(this);
        floorTime.addActionListener(this);
        flyToPoint.addActionListener(this);
        freeze.addActionListener(this);



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
        System.out.println("PRESSED");

        if(actionEvent.getSource() == backToMainMenuButton){
            CardLayout cl = (CardLayout) mainFrame.cardsPanel.getLayout();
            cl.show(mainFrame.cardsPanel, mainFrame.mainMenuPanel.getCardName());
        }else{
            if(gs.getSkillPoints()>0){
                SkillButton button = (SkillButton) actionEvent.getSource();

                gs.buttonUP(button.getSkillCode(), true);
                gs.unlockButtons(button.getChildren());
                System.out.println("BUTTON  "+button.getSkillCode());

                setupButtons();
                revalidate();
                repaint();
            }
        }


    }
}
