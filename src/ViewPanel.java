import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;


class ViewPanel extends JPanel implements MouseListener, MouseMotionListener, ActionListener {
    private JScrollPane scrollPane;
    private Point mouseGrabPoint = null;
    private Point mouseTip = new Point(0,0);
    private SkillLine[] sLine = new SkillLine[30];
    private GameStatistics gs;

    ViewPanel(GameStatistics gs){
        super();
        setLayout(null);
        setPreferredSize(new Dimension(1000,1000));
        //setBorder(new MatteBorder(5, 5, 5, 5, Color.BLUE));
        setOpaque(false);

        this.gs = gs;

        scrollPane = new JScrollPane();
        scrollPane.setViewportView(this);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        ((JViewport) getParent()).setViewPosition(new Point(50, 50));

        addMouseListener(this);
        addMouseMotionListener(this);

        ImageIcon icon = new ImageIcon("textures/skillsTree.png");
        JLabel iconLabel = new JLabel();

        iconLabel.setBounds(0,0,700,700);
        iconLabel.setIcon(icon);
        setupSkillLines(gs);
    }

    public void setupSkillLines(GameStatistics gs){
        sLine[0] = new SkillLine(gs, new Point(349, 283), new Point(284, 249), -1, 0);
        sLine[1] = new SkillLine(gs, new Point(284,208), new Point(320,195), 0, 4);
        sLine[2] = new SkillLine(gs, new Point(253,208), new Point(216,182), 0, 3);
        sLine[3] = new SkillLine(gs, new Point(185,140), new Point(150,124), 3, 6);
        sLine[4] = new SkillLine(gs, new Point(254,249), new Point(216,277), 0, 5);
        sLine[5] = new SkillLine(gs, new Point(186,277), new Point(164,260), 5, 7);
        sLine[6] = new SkillLine(gs, new Point(185,317), new Point(165,334), 5, 8);
        sLine[7] = new SkillLine(gs, new Point(132,334), new Point(93,317), 9, 8);
        sLine[8] = new SkillLine(gs, new Point(368,317), new Point(365,383), -1, 1);
        sLine[9] = new SkillLine(gs, new Point(380,400), new Point(410,372), 1, 10);
        sLine[10] = new SkillLine(gs, new Point(450,365), new Point(484,380), 11, 10);
        sLine[11] = new SkillLine(gs, new Point(350,442), new Point(299,440), 1, 12);
        sLine[12] = new SkillLine(gs, new Point(269,481), new Point(243,497), 12, 15);
        sLine[13] = new SkillLine(gs, new Point(301,480), new Point(350,522), 12, 16);
        sLine[14] = new SkillLine(gs, new Point(349,563), new Point(321,579), 17, 16);
        sLine[15] = new SkillLine(gs, new Point(381,441), new Point(428,440), 1, 13);
        sLine[16] = new SkillLine(gs, new Point(459,480), new Point(481,496), 14, 13);
        sLine[17] = new SkillLine(gs, new Point(389,282), new Point(458,256), -1, 2);
        sLine[18] = new SkillLine(gs, new Point(489,256), new Point(518,277), 2, 18);
        sLine[19] = new SkillLine(gs, new Point(488,215), new Point(517,195), 2, 19);
        sLine[20] = new SkillLine(gs, new Point(550,310), new Point(587,356), 18, 23);
        sLine[21] = new SkillLine(gs, new Point(618,397), new Point(639,424), 24, 23);
        sLine[22] = new SkillLine(gs, new Point(587,276), new Point(602,337), 22, 23);
        sLine[23] = new SkillLine(gs, new Point(616,356), new Point(677,256), 25, 23);
        sLine[24] = new SkillLine(gs, new Point(709,256), new Point(732,282), 25, 26);
        sLine[25] = new SkillLine(gs, new Point(678,213), new Point(618,126), 25, 20);
        sLine[26] = new SkillLine(gs, new Point(586,196), new Point(601,144), 22, 20);
        sLine[27] = new SkillLine(gs, new Point(550,163), new Point(586,125), 19, 20);
        sLine[28] = new SkillLine(gs, new Point(587,84), new Point(566,63), 21, 20);
    }

    public JScrollPane getScrollPane(){
        return scrollPane;
    }

    public void paintComponent(Graphics g){
        ImageIcon icon = new ImageIcon("textures/skillsTree.png");
        //g.drawImage(icon.getImage(),50,25,null);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(2.5f));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for(int i=0; i<29; i++){
            g2d.setPaint(sLine[i].getTexture());
            g.drawLine(sLine[i].getA().x,sLine[i].getA().y, sLine[i].getB().x, sLine[i].getB().y);
        }

        g2d.setPaint(new Color(58, 66, 65, 250));


        int R = 900;
        int r = 2;
        int move = 0;
        g2d.setStroke(new BasicStroke(1f));
        g2d.setPaint(new Color(1, 141, 138));
        //g.drawLine(mouseTip.x - R-move, mouseTip.y-move, mouseTip.x - r-move, mouseTip.y-move);
        //g.drawLine(mouseTip.x + r-move, mouseTip.y-move, mouseTip.x + R-move, mouseTip.y-move);
        //g.drawLine(mouseTip.x-move, mouseTip.y - R-move, mouseTip.x-move, mouseTip.y - r-move);
        //g.drawLine(mouseTip.x-move, mouseTip.y + r-move, mouseTip.x-move, mouseTip.y + R-move);

    }



    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println(e.getPoint());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        mouseGrabPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        setCursor(null);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        /*
        Point dragPoint = e.getPoint();
        JViewport viewPort = (JViewport) getParent();
        Point viewStartPoint = viewPort.getViewPosition();
        Point maxViewStartPoint = new Point(getWidth() - viewPort.getWidth(), getHeight() - viewPort.getHeight());

        if(getWidth() > viewPort.getWidth()){
            viewStartPoint.x -= dragPoint.x - mouseGrabPoint.x;
            if(viewStartPoint.x < 0){
                viewStartPoint.x = 0;
                dragPoint.x = mouseGrabPoint.x;
            }else if( maxViewStartPoint.x < viewStartPoint.x ){
                viewStartPoint.x = maxViewStartPoint.x;
                dragPoint.x = mouseGrabPoint.x;
            }
        }

        if(getHeight() > viewPort.getHeight()){
            viewStartPoint.y -= dragPoint.y - mouseGrabPoint.y;
            if(viewStartPoint.y < 0){
                viewStartPoint.y = 0;
                dragPoint.y = mouseGrabPoint.y;
            }else if( maxViewStartPoint.y < viewStartPoint.y ){
                viewStartPoint.y = maxViewStartPoint.y;
                dragPoint.y = mouseGrabPoint.y;
            }
        }

        mouseGrabPoint = dragPoint;
        viewPort.setViewPosition(viewStartPoint);
        */
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseTip = e.getPoint();
        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
