package Game_engine;

import Cards.Card;
import UI.ImageCreation;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.texture.Texture;

import javax.swing.*;
import java.awt.*;

public class Scene implements GLEventListener{
    private GLProfile profile;
    private GLCapabilities capabilities;
    public JFrame ogFrame;
    public  JLayeredPane backFrame;
    private int width;
    private int height;
    private Texture texture;


    //Default scene (*not updated from second constructor)


    //Constructor to make a game scene (with title)
    public Scene(String title, int width, int height) {
        //getting the capabilities object of GL2 profile
        profile = GLProfile.get(GLProfile.GL2);
        capabilities = new GLCapabilities(profile);

        GLCanvas glCanvas = new GLCanvas(capabilities); //Block of 1 part of method 2
        glCanvas.addGLEventListener(this);
        glCanvas.setSize(width, height);

        //creating frame (method 2)
        ogFrame = new JFrame (title);
        ogFrame.getContentPane().add(glCanvas); //used to have .getContentPane()
        ogFrame.setSize(ogFrame.getContentPane().getPreferredSize());
        ogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ogFrame.setVisible(true);

        //Method 1:
//        ogFrame = new JFrame (title);
//        ogFrame.setSize(width,height);
//        ogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ogFrame.setResizable(false); //Resizable is going to be false by default
////        ogFrame.setExtendedState(JFrame.NORMAL); //To remove title
////        ogFrame.setUndecorated(true); //To remove title
//        ogFrame.setVisible(true);

        //Creating the JLayeredPane
//        backFrame = new JLayeredPane(); //We may still have to it be the back layer only, when adding more components
//        backFrame.add(glCanvas); // will we need this for jogl to work better?
//        backFrame.setSize(width,height);
//        backFrame.setLayout(null);
//        backFrame.setOpaque(false);
//        ogFrame.add(backFrame);

        //Instance variables
        this.width = width;
        this.height = height;
    }

    public void addBackground(String imgFilePath) {
        //Creating the GLJPanel for OpenGL rendering support
        GLJPanel imgPanel = new GLJPanel(capabilities);
        imgPanel.addGLEventListener(this);
        imgPanel.setSize(width,height);
        imgPanel.setLayout(null);
        backFrame.add(imgPanel);

        //Creating and resizing imgIcon
        ImageIcon imgIcon = new ImageIcon(imgFilePath);
        Image img = imgIcon.getImage();
        Image newImg = img.getScaledInstance(width, height,  Image.SCALE_SMOOTH);
        imgIcon = new ImageIcon(newImg);

        JLabel imgFrame = new JLabel();
        imgFrame.setSize(width,height);
        imgFrame.setIcon(imgIcon);
//        imgFrame.setBounds(0,0,width,height);
//        System.out.println("Width: " + width + ". Height: " + height);
        imgPanel.add(imgFrame);
    }

    //Adds card to scene
    public void addCard(Card newCard) {

    }

    @Override
    public void init(GLAutoDrawable glAutoDrawable) { //How can we call this whenever we want?
        //Rendering the background image (setting up step 3)
//        ImageCreation backgroundCreation = new ImageCreation();
        //Creating out gl object
        GL2 gl = glAutoDrawable.getGL().getGL2();

        // Enable 2D textures
        gl.glEnable(GL2.GL_TEXTURE_2D);

        //Loading image and texture conversion
        ImageCreation sceneBackground = new ImageCreation("res/back_copy.png");
        texture = sceneBackground.loadTexture(gl, sceneBackground.getImage());
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL2 gl = glAutoDrawable.getGL().getGL2();

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        texture.bind(gl);

        // Draw a quad with texture mapped to it
        gl.glBegin(GL2.GL_QUADS);

        // Bottom-left corner
        gl.glTexCoord2f(0.0f, 0.0f); // Texture coordinate
        gl.glVertex2f(-1.0f, -1.0f); // Vertex coordinate

        // Bottom-right corner
        gl.glTexCoord2f(1.0f, 0.0f); // Texture coordinate
        gl.glVertex2f(1.0f, -1.0f);  // Vertex coordinate

        // Top-right corner
        gl.glTexCoord2f(1.0f, 1.0f); // Texture coordinate
        gl.glVertex2f(1.0f, 1.0f);   // Vertex coordinate

        // Top-left corner
        gl.glTexCoord2f(0.0f, 1.0f); // Texture coordinate
        gl.glVertex2f(-1.0f, 1.0f);  // Vertex coordinate

        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
