import javax.swing.*;
import java.awt.*;

class LevelButton extends JButton {

    private Color hoverBackgroundColor=new Color(0x222222);
    private Color pressedBackgroundColor=new Color(0x222222);
    private ImageIcon selected = new ImageIcon("textures/levelButtonCyanTwich.png");
    private ImageIcon hovered = new ImageIcon("textures/levelButtonCyan.png");
    private ImageIcon unselected = new ImageIcon("textures/levelButtonSzare.png");
    private ImageIcon disabled = new ImageIcon("textures/levelButtonCiemnoSzare.png");

    int levelNumber;
    public LevelButton() {
        super();
        setIcon(unselected);
        setBounds(100, 100, 150, 150);
        setBackground(null);
        setForeground(new Color(200, 200, 200));
        setFocusable(false);
        setBorder(null);
    }

    public LevelButton(int number) {
        super(""+number+"\n");
        super.setContentAreaFilled(false);
        setIcon(unselected);
        setBounds(100, 100, 150, 150);
        setBackground(null);
        setForeground(new Color(200, 200, 200));
        setFocusable(false);
        setBorder(null);
        setVerticalTextPosition(JButton.BOTTOM);
        setHorizontalTextPosition(JButton.CENTER);
        setIconTextGap(-25);
        setDisabledIcon(disabled);
        levelNumber=number;
    }

    public int getLevelID(){
        return levelNumber;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            setForeground(new Color(255, 0, 138, 255));
            setIcon(selected);
            g.setColor(pressedBackgroundColor);
        } else if (getModel().isRollover()) {
            setForeground(new Color(0, 255, 234, 255));
            setIcon(hovered);
            g.setColor(hoverBackgroundColor);
        } else {
            setForeground(new Color(44, 50, 50, 255));
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

