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
    

<img src="/SceneEditorHighlighted.png" width="548">

## The TEMPLATE METHOD Pattern

The drawSelection method is an example of the TEMPLATE METHOD pattern. 

In this pattern, a superclass defines a method that calls primitive operations that a subclass needs to supply.

Each subclass can supply the primitive operations as is most appropriate for it.

The template method contains the knowledge of how to combine the primitive operations into a more complex operation.

