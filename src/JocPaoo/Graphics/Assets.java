package JocPaoo.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Assets {

    public static BufferedImage roof;
    public static BufferedImage alerg;
    public static BufferedImage hero;
    public static BufferedImage ataca;
    public static BufferedImage atacaStanga;
    public static BufferedImage meniu;
    public static BufferedImage lvl2;
    public static BufferedImage win;
    public static BufferedImage cufar;

    public static BufferedImage inamic_stanga;
    public static BufferedImage inamic_dreapta;

    public static BufferedImage inamic1_stanga;
    public static BufferedImage inamic1_dreapta;
    public static BufferedImage inamic2_stanga;
    public static BufferedImage inamic2_dreapta;
    public static BufferedImage finalBoss_stanga;
    public static BufferedImage finalBoss_dreapta;
    public static BufferedImage printesa;
    public static void Init()
    {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Harta1.jpg"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.LoadImage("/textures/Roof1.png"));
        SpriteSheet sheet3 = new SpriteSheet(ImageLoader.LoadImage("/textures/Meniu.jpg"));
        SpriteSheet sheet4 = new SpriteSheet(ImageLoader.LoadImage("/textures/lvl2.jpg"));
        SpriteSheet sheet5 = new SpriteSheet(ImageLoader.LoadImage("/textures/win.jpg"));
        SpriteSheet sheet6 = new SpriteSheet(ImageLoader.LoadImage("/textures/cufar.png"));
        SpriteSheet inamic =new SpriteSheet(ImageLoader.LoadImage("/textures/enemy.png"));
        SpriteSheet boss=new SpriteSheet(ImageLoader.LoadImage("/textures/final.png"));
        SpriteSheet talya=new SpriteSheet(ImageLoader.LoadImage("/textures/printesa.png"));

        printesa=talya.crop3(0,0);

        inamic1_stanga=boss.crop3(0,1);
        inamic1_dreapta=boss.crop3(1,1);

        inamic2_stanga=boss.crop3(2,1);
        inamic2_dreapta=boss.crop3(3,1);

        finalBoss_stanga=boss.crop3(0,0);
        finalBoss_dreapta=boss.crop3(1,0);

        inamic_stanga=inamic.crop3(0,1);
        inamic_dreapta=inamic.crop3(1,1);
        cufar=sheet6.crop3(0,0);
        meniu=sheet3.crop(0,0);
        lvl2= sheet4.crop(0,0);
        win=sheet5.crop(0,0);
        roof=sheet.crop(0,0);
        alerg=sheet2.crop3(1,1);
        hero=sheet2.crop3(0,1);
        ataca=sheet2.crop3(2,1);
        atacaStanga=sheet2.crop3(3,1);

    }
}
