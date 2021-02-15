import javax.swing.*;
import java.awt.*;

class LevelsMainButton extends JButton {

    private Color hoverBackgroundColor=new Color(0x222222);
    private Color pressedBackgroundColor=new Color(0x222222);
    private ImageIcon selected = new ImageIcon("textures/levelsMainClicked.png");
    private ImageIcon hovered = new ImageIcon("textures/levelsMainHoveredd.png");
    private ImageIcon unselected = new ImageIcon("textures/levelsMainWhite.png");

    public LevelsMainButton() {
        this(null);
        setIcon(unselected);

        setBounds(100, 100, 150, 150);
        setBackground(null);
        setForeground(new Color(200, 200, 200));
        setFocusable(false);
        setBorder(null);
    }

    public LevelsMainButton(String text) {
        super(text);
        super.setContentAreaFilled(false);
        setIcon(unselected);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            setIcon(selected);
            g.setColor(pressedBackgroundColor);
        } else if (getModel().isRollover()) {
            setIcon(hovered);
            g.setColor(hoverBackgroundColor);
        } else {
            setIcon(unselected);
            g.setColor(getBackground());
        }
        g.fillRect(0, 0, getWidth(), getHeight());
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
}
