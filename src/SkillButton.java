import javax.swing.*;
import java.awt.*;

class SkillButton extends JButton {

    private Color hoverBackgroundColor=new Color(0x222222);
    private Color pressedBackgroundColor=new Color(0x222222);
    private ImageIcon selected = new ImageIcon("textures/start.png");
    private ImageIcon hovered = new ImageIcon("textures/start.png");
    private ImageIcon unselected = new ImageIcon("textures/start2.png");

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

    }

    public void equipAddBall() {
        skill = 0;
        children = new int[] {3,4,5};
        selected = new ImageIcon("textures/rab.png");
        hovered = new ImageIcon("textures/rab2.png");
        unselected = new ImageIcon("textures/rab.png");
        setBounds(238, 187, 62, 84);
    }

    public void equipIce() {
        skill = 3;
        children = new int[] {6};
        selected = new ImageIcon("textures/rab.png");
        hovered = new ImageIcon("textures/rab2.png");
        unselected = new ImageIcon("textures/rab.png");
        setBounds(170, 119, 62, 84);
    }

    public void equipFire() {
        skill = 5;
        children = new int[] {7,8};
        selected = new ImageIcon("textures/rab.png");
        hovered = new ImageIcon("textures/rab2.png");
        unselected = new ImageIcon("textures/rab.png");
        setBounds(170, 255, 62, 84);
    }

    public void equipBarExtension() {
        skill = 2;
        selected = new ImageIcon("textures/rab.png");
        hovered = new ImageIcon("textures/rab2.png");
        unselected = new ImageIcon("textures/rab.png");
        setBounds(442, 192, 62, 84);
    }

    public void equipRoundExtension() {
        selected = new ImageIcon("textures/rab.png");
        hovered = new ImageIcon("textures/rab2.png");
        unselected = new ImageIcon("textures/rab.png");
        setBounds(555, 192, 62, 84);
    }

    public void equipSticky() {
        selected = new ImageIcon("textures/rab.png");
        hovered = new ImageIcon("textures/rab2.png");
        unselected = new ImageIcon("textures/rab.png");
        setBounds(661, 192, 62, 84);
    }

    public void equipShortenBar() {
        selected = new ImageIcon("textures/rab.png");
        hovered = new ImageIcon("textures/rab2.png");
        unselected = new ImageIcon("textures/rab.png");
        setBounds(570, 62, 62, 84);
    }

    public void equipShortenRound() {
        selected = new ImageIcon("textures/rab.png");
        hovered = new ImageIcon("textures/rab2.png");
        unselected = new ImageIcon("textures/rab.png");
        setBounds(570, 334, 62, 84);
    }

    public void equipBallSpeed() {
        skill = 1;
        children = new int[] {10,12,13};
        selected = new ImageIcon("textures/rab.png");
        hovered = new ImageIcon("textures/rab2.png");
        unselected = new ImageIcon("textures/rab.png");
        setBounds(334, 380, 62, 84);
    }

    public void equipMagnetFloor() {
        skill = 13;
        children = new int[] {14};
        selected = new ImageIcon("textures/rab.png");
        hovered = new ImageIcon("textures/rab2.png");
        unselected = new ImageIcon("textures/rab.png");
        setBounds(412, 418, 62, 84);
    }

    public void equipFloor() {
        skill = 12;
        children = new int[] {15,16};
        selected = new ImageIcon("textures/rab.png");
        hovered = new ImageIcon("textures/rab2.png");
        unselected = new ImageIcon("textures/rab.png");
        setBounds(253, 418, 62, 84);
    }

    public void equipFlyToPoint() {
        skill = 16;
        children = new int[] {17};
        selected = new ImageIcon("textures/rab.png");
        hovered = new ImageIcon("textures/rab2.png");
        unselected = new ImageIcon("textures/rab.png");
        setBounds(334, 500, 62, 84);
    }

    public void equipRadius() {
        skill = 6;
        children = new int[] {};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        setBounds(110, 86, 47, 47);
    }

    public void equipX2() {
        skill = 4;
        children = new int[] {};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        setBounds(314, 156, 47, 47);
    }

    public void equipFireForce() {
        skill = 7;
        children = new int[] {};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        setBounds(125, 221, 47, 47);
    }

    public void equipFireTime() {
        skill = 8;
        children = new int[] {9};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        setBounds(125, 327, 47, 47);
    }

    public void equipBarMaxSize() {
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        setBounds(510, 156, 47, 47);
    }

    public void equipBarDX() {
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        setBounds(510, 270, 47, 47);
    }

    public void equipBarShorteningBonus() {
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        setBounds(526, 25, 47, 47);
    }

    public void equipStickyTime() {
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        setBounds(722, 277, 47, 47);
    }

    public void equipShortRoundBonus() {
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        setBounds(629, 419, 47, 47);
    }

    public void equipBallSpeedBonus() {
        skill = 11;
        children = new int[] {};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        setBounds(480, 368, 47, 47);
    }

    public void equipBallSpeedTime() {
        skill = 10;
        children = new int[] {11};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        setBounds(405, 335, 47, 47);
    }

    public void equipMagnetFloorTime() {
        skill = 14;
        children = new int[] {};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        setBounds(473, 490, 47, 47);
    }

    public void equipFloorTime() {
        skill = 15;
        children = new int[] {};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        setBounds(208, 494, 47, 47);
    }

    public void equipFreeze() {
        skill = 17;
        children = new int[] {};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        setBounds(277, 561, 47, 47);
    }

    public void equipFlyThrough() {
        skill = 9;
        children = new int[] {};
        selected = new ImageIcon("textures/kolo.png");
        hovered = new ImageIcon("textures/kolo.png");
        unselected = new ImageIcon("textures/kolo2.png");
        setBounds(53, 279, 47, 47);
    }

    public void updateStatus(int status) {
        skillStatus = status;

        if (status == 0){
            setEnabled(false);
            //setDisabledIcon(selected);
        }else if(status == 1){
            setEnabled(true);
        }else if(status == 2){
            setEnabled(false);
            setDisabledIcon(hovered);
        }
    }

    public int[] getChildren() {
        return children;
    }
}
