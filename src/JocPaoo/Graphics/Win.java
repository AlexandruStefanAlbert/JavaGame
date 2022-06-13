package JocPaoo.Graphics;

import JocPaoo.RefLinks;
import JocPaoo.Tiles.Tile;

import java.awt.*;

public class Win
{
    private RefLinks refLink;
    private int width;
    private int height;
    private int [][] tiles;

    public Win(RefLinks refLink)
    {
        this.refLink=refLink;
        LoadWorld3();
    }
    public void Update3()
    {

    }

    public void Draw3(Graphics g)
    {
        for(int y=0; y<refLink.GetGame().GetHeight()/Tile.TILE_HEIGHT; y++)
        {
            for(int x=0; x<refLink.GetGame().GetWidth()/Tile.TILE_WIDTH;x++)
            {
                GetTile3(x,y).Draw(g,(int)x*Tile.TILE_HEIGHT, (int)y*Tile.TILE_WIDTH);
            }
        }
    }

    public Tile GetTile3(int x, int y)
    {
        if(x <0 || y<0 || x>=width || y>=height)
        {
            return Tile.win_game;
        }
        Tile t= Tile.tiles[tiles[x][y]];
        if(t==null)
        {
            return Tile.win_game;
        }
        return t;
    }

    private void LoadWorld3()
    {
        width=1;
        height=1;
        tiles=new int[width][height];
        for(int y=0;y<height;y++)
        {
            for(int x=0; x<width;x++)
            {
                tiles[x][y]=Win(y,x);
            }
        }
    }

    private int Win(int x, int y)
    {

        final int map[][]= {
                {3},

        };
        return map[x][y];
    }
}
