import javax.swing.*;
import java.awt.*;

class SkillsTreeButton extends JButton {

    private Color hoverBackgroundColor=new Color(0x222222);
    private Color pressedBackgroundColor=new Color(0x222222);
    private ImageIcon selected = new ImageIcon("textures/wholeTreeCyanTwich.png");
    private ImageIcon hovered = new ImageIcon("textures/wholeTreeCyan.png");
    private ImageIcon unselected = new ImageIcon("textures/wholeTreeWhite.png");

    public SkillsTreeButton() {
        this(null);
        setIcon(unselected);

        setBounds(100, 100, 150, 150);
        setBackground(null);
        setForeground(new Color(200, 200, 200));
        setFocusable(false);
        setBorder(null);
    }

    public SkillsTreeButton(String text) {
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
