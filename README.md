# Scene Editor Highlighted

Selected shapes need to be drawn in a special way so that they can be visually distiguished. 

Each shape class has to provide a seperate mechanism for drawing the decoration.  

Move the shape by a small amount, draw it, move it again, and draw it again. 

The method can be supplied in the SelectableShape class:

    public void drawSelection(Graphics2D g2)
    {
      translate(1, 1);
      draw(g2);
      translate(1, 1);
      draw(g2);
      translate(-2, -2);
    }
    
![](/SceneEditorHighlighted.png)
