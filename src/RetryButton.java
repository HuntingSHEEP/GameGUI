import javax.swing.*;
import java.awt.*;

class RetryButton extends JButton {

    private Color hoverBackgroundColor=new Color(0x222222);
    private Color pressedBackgroundColor=new Color(0x222222);
    private ImageIcon selected = new ImageIcon("textures/retryWhite.png");
    private ImageIcon hovered = new ImageIcon("textures/retryWhite.png");
    private ImageIcon unselected = new ImageIcon("textures/retryGray.png");

    public RetryButton() {
        super();
        super.setContentAreaFilled(false);
        setIcon(unselected);
        setBounds(450, 330, 60, 60);
        setBackground(null);
        setForeground(new Color(200, 200, 200));
        setFocusable(false);
        setBorder(null);
        setVerticalTextPosition(JButton.BOTTOM);
        setHorizontalTextPosition(JButton.CENTER);
    }

    public RetryButton(String name) {
        super(name);
        super.setContentAreaFilled(false);
        setIcon(unselected);
        setBounds(100, 100, 150, 150);
        setBackground(null);
        setForeground(new Color(200, 200, 200));
        setFocusable(false);
        setBorder(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            setIcon(selected);
            g.setColor(hoverBackgroundColor);
        } else if (getModel().isRollover()) {
            setIcon(hovered);
            g.setColor(hoverBackgroundColor);
        } else {
            setIcon(unselected);
            g.setColor(hoverBackgroundColor);
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

