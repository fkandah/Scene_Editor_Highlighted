
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
 * A shape that is a part of a scene
 * @author CPSC
 */
public interface SceneShape 
{
    /**
     * Draws this item
     * @param g2 the graphics context
     */
    void drawShape(Graphics2D g2);
    
    /**
     * Draws the selection adornment of this item.
     * @param g2 the graphics context
     */
    void drawSelection (Graphics2D g2);
    
    /**
     * Sets the selection state of this item
     * @param b true if this item is selected
     */
    void setSelected(boolean b);
    
    /**
     * Gets the selection state of this item
     * @return true if this item is selected
     */
    boolean isSelected();
    
    /**
     * Translate this item by a given amount
     * @param dx the amount to translate in x-direction
     * @param dy the amount to translate in y-direction
     */
    void translate(int dx, int dy);
    
    /**
     * Tests weather this item contains a given point.
     * @param p a point
     * @return true if this item contains p
     */
    boolean contains(Point2D p);
    
}
