import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelsPanel extends JPanel implements ActionListener {
    JButton backToMainMenuButton;
    MainFrame mainFrame;
    Color backgroundColor;

    LevelsPanel(MainFrame mainFrame){
        super();
        this.mainFrame = mainFrame;
        backgroundColor = new Color(0x222222);

        JPanel panel = new JPanel();
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

        panel.setBackground(Color.BLUE);

        backToMainMenuButton = new JButton();
        backToMainMenuButton.setBounds(30, 10, 30, 30);
        backToMainMenuButton.addActionListener(this);
        southPanel.add(backToMainMenuButton);
        southPanel.setLayout(null);

        setBackground(backgroundColor);
        setLayout(new BorderLayout());

        this.add(northPanel, BorderLayout.NORTH);
        this.add(westPanel, BorderLayout.WEST);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(panel, BorderLayout.CENTER);

    }

    public String getCardName(){
        return "2";
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == backToMainMenuButton){
            CardLayout cl = (CardLayout) mainFrame.cardsPanel.getLayout();
            cl.show(mainFrame.cardsPanel, mainFrame.mainMenuPanel.getCardName());
        }
    }
}