import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    JPanel cardsPanel;

    MainMenuPanel mainMenuPanel;
    SkillsTreePanel skillsTreePanel;


    MainFrame(){
        super();
        cardsPanel = new JPanel(new CardLayout());

        mainMenuPanel = new MainMenuPanel(this);
        skillsTreePanel = new SkillsTreePanel(this);

        cardsPanel.setLayout(new CardLayout());
        cardsPanel.add(mainMenuPanel, "0");
        cardsPanel.add(skillsTreePanel, "1");

        this.add(cardsPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(820, 700);
        this.setResizable(true);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==null){
            System.out.println("skillsTree");
        }
    }
}
