package JocPaoo.Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage spriteSheet;
    private static  int titleWidth=720;
    private static  int titleHeight=480;

    private static int playerWidth=48;
    private static int playerHeight=48;

    public SpriteSheet(BufferedImage buffImg)
    {
        spriteSheet=buffImg;
    }
    public BufferedImage crop(int x, int y)
    {
        return spriteSheet.getSubimage(x*titleWidth,y*titleHeight,titleWidth,titleHeight);
    }

    public BufferedImage crop3(int x, int y)
    {
        return spriteSheet.getSubimage(x*playerWidth,y*playerHeight,playerWidth,playerHeight);
    }
}
