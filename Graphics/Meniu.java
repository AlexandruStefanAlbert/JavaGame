package JocPaoo.Graphics;

import JocPaoo.RefLinks;
import JocPaoo.Tiles.Tile;

import java.awt.*;

public class Meniu
{
    private RefLinks refLink;
    private int width;          //latimea hartii in nr de dale
    private int height;        //inaltimea hartii in nr de dale
    private int [][] tiles;   //matricea cu codurile dalelor ce vor construi mapa

    public Meniu(RefLinks refLink)
    {
        this.refLink=refLink;
        LoadWorld();
    }
    public void Update()
    {

    }

    public void Draw(Graphics g)
    {   //Contextul desenarii hartii
        for(int y=0; y<refLink.GetGame().GetHeight()/Tile.TILE_HEIGHT; y++)
        {
            for(int x=0; x<refLink.GetGame().GetWidth()/Tile.TILE_WIDTH;x++)
            {
                GetTile(x,y).Draw(g,(int)x*Tile.TILE_HEIGHT, (int)y*Tile.TILE_WIDTH);
            }
        }
    }

    public Tile GetTile(int x, int y)
    {
        if(x <0 || y<0 || x>=width || y>=height)
        {
            return Tile.meniu;
        }
        Tile t= Tile.tiles[tiles[x][y]];
        if(t==null)
        {
            return Tile.meniu;
        }
        return t;
    }

    private void LoadWorld()
    {
        width=1;
        height=1;
        tiles=new int[width][height];
        for(int y=0;y<height;y++)
        {
            for(int x=0; x<width;x++)
            {
                tiles[x][y]=Meniu(y,x);
            }
        }
    }

    private int Meniu(int x, int y)
    {

        final int map[][]= {
                {1},

        };
        return map[x][y];
    }
}
