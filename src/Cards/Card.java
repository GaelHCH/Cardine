package Cards;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class Card implements GLEventListener {
    /*
    Default card must have an empty card with...
        * A default size
        * A clickable animation
        * A default clickable sound
        * A draggable card (however not enabled by default)
     */

    public Card() {

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
