
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JComponent;


/**
 * A component that shows a scene composed of shapes.
 * @author 
 */
public class SceneComponent extends JComponent
{
    public SceneComponent()
    {
        shapes = new ArrayList<SceneShape>();
        
        addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent event)
            {
                mousePoint = event.getPoint();
                
                for (SceneShape s : shapes)
                {
                    if (s.contains(mousePoint))
                    {
                        s.setSelected(!s.isSelected());
                    }
                }
                repaint();
            }
        });
        
        
        addMouseMotionListener(new MouseMotionAdapter()
        {
            public void mouseDragged(MouseEvent event)
            {
                Point lastMousePoint = mousePoint;
                
                mousePoint = event.getPoint();
                
                for(SceneShape s : shapes)
                {
                    if (s.isSelected())
                    {
                        double dx = mousePoint.getX() - lastMousePoint.getX();
                        double dy = mousePoint.getY() - lastMousePoint.getY();
                        
                        s.translate((int)dx, (int)dy);
                    }
                }
                repaint();
            }
        });
    }
    
    /**
     * Adds a shape to the scene.
     * @param s the shape to add
     */
    public void add(SceneShape s)
    {
        shapes.add(s);
        repaint();
    }
    
    public void removeSelected()
    {
        for( int i = shapes.size() - 1 ; i >= 0 ; i--)
        {
            SceneShape s = shapes.get(i);
            if (s.isSelected())
            {
                shapes.remove(i);        
            }
        }
        repaint();
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        for (SceneShape s : shapes)
        {
            s.drawShape(g2);
            if(s.isSelected())
            {
                s.drawSelection(g2);
            }
        }
        
    }
    
    
    private ArrayList<SceneShape> shapes;
    private Point mousePoint;
}
