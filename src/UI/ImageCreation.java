package UI;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*
To render a 2D image, we have to render it as a texture using JOGL
Step 0: Class where image is being displayed must implement GLEventListener
Step 1: Load the image
Step 2: Make the image a texture
Step 3: Set up texture for display (init method)
Step 4: Render a quad with applied texture (display method)
 */

public class ImageCreation {
    private String imgFilePath;
    private BufferedImage image;

    //Constructor creates image creation object and loads image
    public ImageCreation(String imgFilePath) {
        try {
            image = ImageIO.read(new File(imgFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Converting image into texture
    public Texture loadTexture(GL2 gl, BufferedImage img) {
        // Convert BufferedImage to byte buffer
        TextureData textureData = AWTTextureIO.newTextureData(gl.getGLProfile(), img, false);
        // Generate the texture
        Texture texture = TextureIO.newTexture(textureData);
        // Bind the texture
        texture.bind(gl);

        return texture;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }



}
