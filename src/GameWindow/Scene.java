package GameWindow;

import Cards.Card;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.awt.GLJPanel;

import javax.swing.*;
import java.awt.*;

public class Scene implements GLEventListener{
    private final GLProfile profile;
    private final GLCapabilities capabilities;
    public final JFrame ogFrame;
    public  JLayeredPane backFrame;
    private int width;
    private int height;

    //Default scene (*not updated from second constructor)
    public Scene() {
        //getting the capabilities object of GL2 profile
        profile = GLProfile.get(GLProfile.GL2);
        capabilities = new GLCapabilities(profile);

        //creating frame
        ogFrame = new JFrame (" Basic Frame");
        ogFrame.setSize(400,400);
        ogFrame.setVisible(true);
        ogFrame.setResizable(true);

        //Creating the JLayeredPane
        backFrame = new JLayeredPane(); //We may still have to it be the back layer only, when adding more components
        backFrame.setSize(400,400);
        backFrame.setLayout(null);
        backFrame.setOpaque(true);
        ogFrame.add(backFrame);

//        animator =  new Animator(window);
//        animator.start();
    }

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
        ogFrame.getContentPane().add(glCanvas);
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
////
////        //Creating the JLayeredPane
        backFrame = new JLayeredPane(); //We may still have to it be the back layer only, when adding more components
        backFrame.setSize(width,height);
        backFrame.setLayout(null);
        backFrame.setOpaque(false);
        ogFrame.add(backFrame);

        //Instance variables
        this.width = width;
        this.height = height;
    }

    public void addBackground(String imgFilePath, int width, int height) {
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
    public void init(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {

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
