import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import javax.swing.border.MatteBorder;


class ViewPanel extends JPanel implements MouseListener, MouseMotionListener {
    private JScrollPane scrollPane;
    private Point mouseGrabPoint = null;

    ViewPanel(){
        super();
        setLayout(null);
        setPreferredSize(new Dimension(1000,700));
        setBorder(new MatteBorder(5, 5, 5, 5, Color.BLUE));

        scrollPane = new JScrollPane();
        scrollPane.setViewportView(this);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        ((JViewport) getParent()).setViewPosition(new Point(50, 50));
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public JScrollPane getScrollPane(){
        return scrollPane;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
