import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {
    JButton backToMainMenuButton;
    MainFrame mainFrame;
    Color backgroundColor;
    JPanel northPanel;
    JPanel westPanel;
    JPanel eastPanel;
    JPanel southPanel;

    GamePanel(MainFrame mainFrame){
        super();
        this.mainFrame = mainFrame;
        backgroundColor = new Color(0x222222);

        JPanel panel = new JPanel();
        northPanel = new JPanel();
        westPanel = new JPanel();
        eastPanel = new JPanel();
        southPanel = new JPanel();

        northPanel.setBackground(backgroundColor);
        northPanel.setOpaque(false);
        northPanel.setPreferredSize(new Dimension(50, 50));

        westPanel.setBackground(backgroundColor);
        westPanel.setOpaque(false);
        westPanel.setPreferredSize(new Dimension(50, 50));

        eastPanel.setBackground(backgroundColor);
        eastPanel.setOpaque(false);
        eastPanel.setPreferredSize(new Dimension(50, 50));
        eastPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel justNothing = new JLabel();
        justNothing.setPreferredSize(new Dimension(40, 200));
        eastPanel.add(justNothing);

        southPanel.setBackground(backgroundColor);
        southPanel.setOpaque(false);
        southPanel.setPreferredSize(new Dimension(50, 50));


        Plansza plansza = new Plansza(this);
        panel.setOpaque(false);
        panel.add(plansza);
        panel.setLayout(new GridLayout(1,1));
        panel.setBorder(BorderFactory.createLineBorder(new Color(50, 55, 55), 1));

        backToMainMenuButton = new JButton();
        backToMainMenuButton.setBounds(30, 10, 30, 30);
        backToMainMenuButton.addActionListener(this);
        southPanel.add(backToMainMenuButton);
        southPanel.setLayout(null);

        //setBackground(backgroundColor);
        //setBackground(new Color(70, 70, 70));
        setLayout(new BorderLayout());

        this.add(northPanel, BorderLayout.NORTH);
        this.add(westPanel, BorderLayout.WEST);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(panel, BorderLayout.CENTER);

    }

    public void paintComponent(Graphics g){
        ImageIcon img = new ImageIcon("textures/tlo.png");

        if (img != null)
        {
            g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
        }
    }

    public String getCardName(){
        return "3";
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == backToMainMenuButton){
            CardLayout cl = (CardLayout) mainFrame.cardsPanel.getLayout();
            cl.show(mainFrame.cardsPanel, mainFrame.mainMenuPanel.getCardName());
        }
    }
}
