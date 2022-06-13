package JocPaoo.Map;

import JocPaoo.RefLinks;
import JocPaoo.Tiles.Tile;

import java.awt.*;

public class lvl2 {
    private RefLinks refLink;
    private int width;          //latimea hartii in nr de dale
    private int height;        //inaltimea hartii in nr de dale
    private int [][] tiles;   //matricea cu codurile dalelor ce vor construi mapa

    public lvl2(RefLinks refLink)
    {
        this.refLink=refLink;
        LoadWorld2();
    }
    public void Update2()
    {

    }

    public void DrawLvl2(Graphics g)
    {   //Contextul desenarii hartii
        for(int y = 0; y<refLink.GetGame().GetHeight()/ Tile.TILE_HEIGHT; y++)
        {
            for(int x=0; x<refLink.GetGame().GetWidth()/Tile.TILE_WIDTH;x++)
            {
                GetTile2(x,y).Draw(g,(int)x*Tile.TILE_HEIGHT, (int)y*Tile.TILE_WIDTH);
            }
        }
    }

    public Tile GetTile2(int x, int y)
    {
        if(x <0 || y<0 || x>=width || y>=height)
        {
            return Tile.nivel2;
        }
        Tile t= Tile.tiles[tiles[x][y]];
        if(t==null)
        {
            return Tile.nivel2;
        }
        return t;
    }

    private void LoadWorld2()
    {
        width=1;
        height=1;
        tiles=new int[width][height];
        for(int y=0;y<height;y++)
        {
            for(int x=0; x<width;x++)
            {
                tiles[x][y]=KtrlMap2(y,x);
            }
        }
    }

    private int KtrlMap2(int x, int y)
    {

        final int map[][]= {
                {2},

        };
        return map[x][y];
    }
}
