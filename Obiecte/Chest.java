package JocPaoo.Obiecte;

import JocPaoo.Graphics.Assets;
import JocPaoo.RefLinks;
import JocPaoo.States.State;
import JocPaoo.States.WinState;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Chest extends Caracter{
    private BufferedImage image;


    public Chest(RefLinks refLink,float x, float y)
    {
        super(refLink,x,y,Caracter.width_caracter,Caracter.height_caracter);
        x_Move=0;
        image= Assets.cufar;
        normalBounds.x=16;
        normalBounds.y=16;
        normalBounds.width=16;
        normalBounds.height=32;
    }


    @Override
    public void Update()
    {
        GetInput();
        Move();
    }

    public float GetX()
    {
        return x;
    }
    public float GetY()
    {
        return y;
    }
    {
        this.y=y;
        this.x=x;
        x_Move=0;
        y_Move=0;
    }
    private void GetInput()
    {
        //x_Move=2;
        y_Move=5;
        if(y>150)
        {
            x_Move=0;
            image=Assets.cufar;
        }
        if(x>575)
        {
            x_Move=0;
            image=Assets.cufar;
        }

    }
    private void GetInput2()
    {
        //x_Move=2;
        y_Move=5;
        if(y>150)
        {
            //x_Move=1;
            y=150;
            image=Assets.cufar;
        }
        if(y>150)
        {
            //x_Move=-1;
            y=150;
            image=Assets.cufar;
        }


    }
    public void Update2() {
        GetInput2();
        Move();
    }

    public void Draw(Graphics g)
    {
        g.drawImage(image,(int)x,(int)y, width,height,null);


    }
}
