import javax.swing.*;
import java.awt.*;

class SkillButton extends JButton {

    private Color hoverBackgroundColor=new Color(0x222222);
    private Color pressedBackgroundColor=new Color(0x222222);
    private ImageIcon selected = new ImageIcon("textures/start.png");
    private ImageIcon hovered = new ImageIcon("textures/start.png");
    private ImageIcon unselected = new ImageIcon("textures/start2.png");
    private ImageIcon disabled = new ImageIcon("textures/start2.png");

    ViewPanel panel;
    private int skillStatus;
    private int skill=-1;
    private int[] children;

    public SkillButton() {
        this(null);
        setIcon(unselected);
        setBackground(null);
        setForeground(new Color(200, 200, 200));
        setFocusable(false);
        setBorder(null);
    }



    public SkillButton(String text) {
        super(text);
        super.setContentAreaFilled(false);
        setIcon(unselected);
    }

    public JToolTip createToolTip(){
        ToolTipManager.sharedInstance().setDismissDelay(60000);
        JToolTip tip = super.createToolTip();
        tip.setBorder(BorderFactory.createLineBorder(new Color(0, 200, 200), 1));
        tip.setOpaque(false);
        tip.setForeground(Color.WHITE);
        return tip;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            setIcon(selected);
            //g.setColor(pressedBackgroundColor);
        } else if (getModel().isRollover()) {
            setIcon(hovered);
            //g.setColor(hoverBackgroundColor);
        } else {
            setIcon(unselected);
            //g.setColor(null);
        }
        //g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    public void setContentAreaFilled(boolean b) {
    }

    public Color getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public void setHoverBackgroundColor(Color hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
    }

    public Color getPressedBackgroundColor() {
        return pressedBackgroundColor;
    }

    public void setPressedBackgroundColor(Color pressedBackgroundColor) {
        this.pressedBackgroundColor = pressedBackgroundColor;
    }

    public int getSkillCode(){
        return skill;
    }


    public void equipStart() {
        selected = new ImageIcon("textures/start.png");
        hovered = new ImageIcon("textures/start.png");
        unselected = new ImageIcon("textures/start2.png");
        setBounds(325, 240, 90, 90);
        setHorizontalTextPosition(JLabel.CENTER);
        setVerticalTextPosition(JLabel.BOTTOM);
        setIconTextGap(-35);
        setForeground(new Color(255, 211, 0, 100));
        setToolTipText("Available number of skill points.");

    }

    public void equipAddBall() {
        skill = 0;
        children = new int[] {3,4,5};
        selected = new ImageIcon("textures/ballPlus2.png");
        hovered = new ImageIcon("textures/ballPlus1.png");
        unselected = new ImageIcon("textures/ballPlus01.png");
        //disabled = new ImageIcon("textures/ballPlus0.png");
        setBounds(238, 187, 62, 84);
        setToolTipText("ADD BALL");
    }

    public void equipIce() {
        skill = 3;
        children = new int[] {6};
        selected = new ImageIcon("textures/iceBall2.png");
        hovered = new ImageIcon("textures/iceBall1.png");
        unselected = new ImageIcon("textures/iceBall01.png");
        disabled = new ImageIcon("textures/iceBall0.png");
        setBounds(170, 119, 62, 84);
        setToolTipText("Ice Ball");
    }

    public void equipFire() {
        skill = 5;
        children = new int[] {7,8};
        selected = new ImageIcon("textures/rab2.png");
        hovered = new ImageIcon("textures/rab1.png");
        unselected = new ImageIcon("textures/rab.png");
        disabled = new ImageIcon("textures/rab.png");
        setBounds(170, 255, 62, 84);
        setToolTipText("Fire Ball");
    }

    public void equipBarExtension() {
        skill = 2;
        children = new int[] {18,19};
        selected = new ImageIcon("textures/rab2.png");
        hovered = new ImageIcon("textures/rab1.png");
        unselected = new ImageIcon("textures/rab.png");
        disabled = new ImageIcon("textures/rab.png");
        setBounds(442, 192, 62, 84);
        setToolTipText("Bar Extension");
    }

    public void equipRoundExtension() {
        skill = 22;
        children = new int[] {20,23};
        selected = new ImageIcon("textures/rab2.png");
        hovered = new ImageIcon("textures/rab1.png");
        unselected = new ImageIcon("textures/rab.png");
        disabled = new ImageIcon("textures/rab.png");
        setBounds(555, 192, 62, 84);
        setToolTipText("Extend the round section");
    }

    public void equipSticky() {
        skill = 25;
        children = new int[] {26,23,20};
        selected = new ImageIcon("textures/rab2.png");
        hovered = new ImageIcon("textures/rab1.png");
        unselected = new ImageIcon("textures/rab.png");
        disabled = new ImageIcon("textures/rab.png");
        setBounds(661, 192, 62, 84);
        setToolTipText("Sticky Bar");
    }

    public void equipShortenBar() {
        skill = 20;
        children = new int[] {21,22,25,19};
        selected = new ImageIcon("textures/rab2.png");
        hovered = new ImageIcon("textures/rab1.png");
        unselected = new ImageIcon("textures/rab.png");
        disabled = new ImageIcon("textures/rab.png");
        setBounds(570, 62, 62, 84);
        setToolTipText("Shorten the bar");
    }

    public void equipShortenRound() {
        skill = 23;
        children = new int[] {22,25,24,18};
        selected = new ImageIcon("textures/rab2.png");
        hovered = new ImageIcon("textures/rab1.png");
        unselected = new ImageIcon("textures/rab.png");
        disabled = new ImageIcon("textures/rab.png");
        setBounds(570, 334, 62, 84);
        setToolTipText("Shorten the round section");
    }

    public void equipBallSpeed() {
        skill = 1;
        children = new int[] {10,12,13};
        selected = new ImageIcon("textures/rab2.png");
        hovered = new ImageIcon("textures/rab1.png");
        unselected = new ImageIcon("textures/rab.png");
        disabled = new ImageIcon("textures/rab.png");
        setBounds(334, 380, 62, 84);
        setToolTipText("Ball Speed");
    }

    public void equipMagnetFloor() {
        skill = 13;
        children = new int[] {14};
        selected = new ImageIcon("textures/rab2.png");
        hovered = new ImageIcon("textures/rab1.png");
        unselected = new ImageIcon("textures/rab.png");
        disabled = new ImageIcon("textures/rab.png");
        setBounds(412, 418, 62, 84);
        setToolTipText("Magnet Floor");
    }

    public void equipFloor() {
        skill = 12;
        children = new int[] {15,16};
        selected = new ImageIcon("textures/rab.png");
        hovered = new ImageIcon("textures/rab2.png");
        unselected = new ImageIcon("textures/rab.png");
        disabled = new ImageIcon("textures/rab.png");
        setBounds(253, 418, 62, 84);
        setToolTipText("Solid Floor");
    }

    public void equipFlyToPoint() {
        skill = 16;
        children = new int[] {17};
        selected = new ImageIcon("textures/rab.png");
        hovered = new ImageIcon("textures/rab2.png");
        unselected = new ImageIcon("textures/rab.png");
        disabled = new ImageIcon("textures/rab.png");
        setBounds(334, 500, 62, 84);
        setToolTipText("Fly to point");
    }

    public void equipRadius() {
        skill = 6;
        children = new int[] {};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        disabled = new ImageIcon("textures/kolo2.png");
        setBounds(110, 86, 47, 47);
        setToolTipText("Ice Ball freeze radius");
    }

    public void equipX2() {
        skill = 4;
        children = new int[] {};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        disabled = new ImageIcon("textures/kolo2.png");
        setBounds(314, 156, 47, 47);
        setToolTipText("Add two balls");
    }

    public void equipFireForce() {
        skill = 7;
        children = new int[] {};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        disabled = new ImageIcon("textures/kolo2.png");
        setBounds(125, 221, 47, 47);
        setToolTipText("Fire Ball Force");
    }

    public void equipFireTime() {
        skill = 8;
        children = new int[] {9};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        disabled = new ImageIcon("textures/kolo2.png");
        setBounds(125, 327, 47, 47);
        setToolTipText("Fire Ball Time");
    }

    public void equipBarMaxSize() {
        skill = 19;
        children = new int[] {20,2};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        disabled = new ImageIcon("textures/kolo2.png");
        setBounds(510, 156, 47, 47);
        setToolTipText("Increse the max bar size");
    }

    public void equipBarDX() {
        skill = 18;
        children = new int[] {23,2};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        disabled = new ImageIcon("textures/kolo2.png");
        setBounds(510, 270, 47, 47);
        setToolTipText("DX");
    }

    public void equipBarShorteningBonus() {
        skill = 21;
        children = new int[] {};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        disabled = new ImageIcon("textures/kolo2.png");
        setBounds(526, 25, 47, 47);
        setToolTipText("Bonus for the bar shortening");
    }

    public void equipStickyTime() {
        skill = 26;
        children = new int[] {};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        disabled = new ImageIcon("textures/kolo2.png");
        setBounds(722, 277, 47, 47);
        setToolTipText("Sticky bar time");
    }

    public void equipShortRoundBonus() {
        skill = 24;
        children = new int[] {};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        disabled = new ImageIcon("textures/kolo2.png");
        setBounds(629, 419, 47, 47);
        setToolTipText("Bonus for the decreased round section");
    }

    public void equipBallSpeedBonus() {
        skill = 11;
        children = new int[] {};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        disabled = new ImageIcon("textures/kolo2.png");
        setBounds(480, 368, 47, 47);
        setToolTipText("Bonus for the ball speed");
    }

    public void equipBallSpeedTime() {
        skill = 10;
        children = new int[] {11};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        disabled = new ImageIcon("textures/kolo2.png");
        setBounds(405, 335, 47, 47);
        setToolTipText("Ball speed time");
    }

    public void equipMagnetFloorTime() {
        skill = 14;
        children = new int[] {};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        disabled = new ImageIcon("textures/kolo2.png");
        setBounds(473, 490, 47, 47);
        setToolTipText("Magnet floor time");
    }

    public void equipFloorTime() {
        skill = 15;
        children = new int[] {};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        disabled = new ImageIcon("textures/kolo2.png");
        setBounds(208, 494, 47, 47);
        setToolTipText("Floor time");
    }

    public void equipFreeze() {
        skill = 17;
        children = new int[] {};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        disabled = new ImageIcon("textures/kolo2.png");
        setBounds(277, 561, 47, 47);
        setToolTipText("Freeze and fly to point");
    }

    public void equipFlyThrough() {
        skill = 9;
        children = new int[] {};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        disabled = new ImageIcon("textures/kolo2.png");
        setBounds(53, 279, 47, 47);
        setToolTipText("Fly through the broken brick");
    }

    public void updateStatus(int status) {
        skillStatus = status;

        if (status == 0){
            setEnabled(false);
            setDisabledIcon(disabled);
        }else if(status == 1){
            setEnabled(true);
        }else if(status == 2){
            setEnabled(false);
            setDisabledIcon(selected);
        }
    }

    public int[] getChildren() {
        return children;
    }
}
