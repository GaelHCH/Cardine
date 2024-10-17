package Cards;

import Game_engine.Scene;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

import javax.swing.*;

public class Card implements GLEventListener {
    /*
    Default card must have an empty card with...
        * A default size
        * A clickable animation
        * A default clickable sound
        * A draggable card (however not enabled by default)
     */
    private JLayeredPane card;
    private Scene scene;


    public Card() {
        //Setting the current scene
        //Default card creation
        card = new JLayeredPane(); //We may still have to it be the back layer only, when adding more components
        card.setSize(50,100);
        card.setLayout(null);
        card.setOpaque(true);
    }

    //This method creates the actual rectangle outline for the card
    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        final GL2 cardOutline = glAutoDrawable.getGL().getGL2();

        cardOutline.glBegin(GL.GL_LINE_LOOP);

    }

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }
}
