package JocPaoo.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    private static final int NO_TILES   = 32;
    public static Tile[] tiles          = new Tile[NO_TILES];

    public static Tile roof= new Roof(0);
    public static Tile meniu=new MeniuTile(1);
    public static Tile nivel2=new lvl2(2);
    public static Tile win_game=new win(3);




    public static final int TILE_WIDTH  = 720;                       //Latimea unei dale
    public static final int TILE_HEIGHT = 480;

    protected BufferedImage img;                                  //Imaginea aferenta tipului de dala.
    protected final int id;
    public Tile(BufferedImage image, int idd)
    {
        img=image;
        id=idd;
        tiles[id]=this;
    }

    public void Update()
    {

    }

    public void Draw(Graphics g, int x, int y)
    {
        /// Desenare dala
        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }
}
