package JocPaoo.Obiecte;

import JocPaoo.Graphics.Assets;
import JocPaoo.RefLinks;
import JocPaoo.States.State;
import JocPaoo.States.WinState;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Printesa extends Caracter{
    private BufferedImage image;


    public Printesa(RefLinks refLink,float x, float y)
    {
        super(refLink,x,y,Caracter.width_caracter,Caracter.height_caracter);
        x_Move=0.1f;
        image= Assets.printesa;
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


    private void GetInput()
    {
        //x_Move=2;
        y_Move=5;
        if(x<635 )
        {
            x_Move=0.2f;

            image=Assets.printesa;
        }
        if(x>=670)
        {
            x_Move=-0.2f;
            image=Assets.printesa;
        }
        if(x>626 && y>210)
        {
            y=210;
        }

    }



    public void Draw(Graphics g)
    {
        g.drawImage(image,(int)x,(int)y, width,height,null);


    }
}
