
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * Program that allows users to edit a scene composed of items
 * @author 
 */
public class SceneEditor 
{
    public static void main (String [] args)
    {
        JFrame frame = new JFrame();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        
        //add the scene component
        final SceneComponent scene = new SceneComponent();
        
        
        JButton houseButton = new JButton("House");
        houseButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                scene.add(new HouseShape(20, 20, 50));
            }
        });
        
        JButton carButton = new JButton("Car");
        carButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                scene.add(new CarShape(20, 20, 50));
            }
        });
        
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                scene.removeSelected();
            }
        });
        
        
        JPanel buttons = new JPanel();
        buttons.add(houseButton);
        buttons.add(carButton);
        buttons.add(removeButton);
        
        
        frame.add(buttons, BorderLayout.NORTH);
        
        frame.add(scene, BorderLayout.CENTER);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 300;
}
