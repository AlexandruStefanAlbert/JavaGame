package JocPaoo.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {

    public static BufferedImage LoadImage(String part)
    {
        try
        {
            return ImageIO.read(ImageLoader.class.getResource(part));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
