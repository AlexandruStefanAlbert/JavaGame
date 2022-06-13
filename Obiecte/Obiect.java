package JocPaoo.Obiecte;
import JocPaoo.RefLinks;

import java.awt.*;

public abstract class Obiect {

    protected float x;
    protected float y;
    protected int width;
    protected int height;
    protected Rectangle bounds; //dreptunghi curent de coliziune
    protected Rectangle normalBounds; //dreptunghi coliziune stare obisnuita
    protected RefLinks refLink;

    public Obiect(RefLinks refLink, float x, float y, int width, int height)
    {
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.refLink=refLink;

        normalBounds=new Rectangle(0,0,width,height);
        bounds=normalBounds;
    }
    public float GetX()
    {
        return x;
    }
    public abstract void Update();
    public abstract void Draw(Graphics g);


}
