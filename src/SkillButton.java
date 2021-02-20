import javax.swing.*;
import java.awt.*;

class SkillButton extends JButton {

    private Color hoverBackgroundColor=new Color(0x222222);
    private Color pressedBackgroundColor=new Color(0x222222);
    private ImageIcon selected = new ImageIcon("textures/start.png");
    private ImageIcon hovered = new ImageIcon("textures/start.png");
    private ImageIcon unselected = new ImageIcon("textures/start2.png");

    ViewPanel panel;

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

    public void equipStart() {
        selected = new ImageIcon("textures/start.png");
        hovered = new ImageIcon("textures/start.png");
        unselected = new ImageIcon("textures/start2.png");
        setBounds(325, 240, 90, 90);
    }

    public void equipAddBall() {
        selected = new ImageIcon("textures/rab.png");
        hovered = new ImageIcon("textures/rab2.png");
        unselected = new ImageIcon("textures/rab.png");
        setBounds(238, 187, 62, 84);
    }

    public void equipIce() {
        selected = new ImageIcon("textures/rab.png");
        hovered = new ImageIcon("textures/rab2.png");
        unselected = new ImageIcon("textures/rab.png");
        setBounds(170, 119, 62, 84);
    }

    public void equipFire() {
        selected = new ImageIcon("textures/rab.png");
        hovered = new ImageIcon("textures/rab2.png");
        unselected = new ImageIcon("textures/rab.png");
        setBounds(170, 255, 62, 84);
    }

    public void equipBarExtension() {
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
        selected = new ImageIcon("textures/rab.png");
        hovered = new ImageIcon("textures/rab2.png");
        unselected = new ImageIcon("textures/rab.png");
        setBounds(334, 380, 62, 84);
    }

    public void equipMagnetFloor() {
        selected = new ImageIcon("textures/rab.png");
        hovered = new ImageIcon("textures/rab2.png");
        unselected = new ImageIcon("textures/rab.png");
        setBounds(412, 418, 62, 84);
    }

    public void equipFloor() {
        selected = new ImageIcon("textures/rab.png");
        hovered = new ImageIcon("textures/rab2.png");
        unselected = new ImageIcon("textures/rab.png");
        setBounds(253, 418, 62, 84);
    }

    public void equipFlyToPoint() {
        selected = new ImageIcon("textures/rab.png");
        hovered = new ImageIcon("textures/rab2.png");
        unselected = new ImageIcon("textures/rab.png");
        setBounds(334, 500, 62, 84);
    }
}
