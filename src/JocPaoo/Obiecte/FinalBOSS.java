package JocPaoo.Obiecte;

import JocPaoo.Graphics.Assets;
import JocPaoo.RefLinks;
import JocPaoo.States.State;
import JocPaoo.States.WinState;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FinalBOSS extends Caracter{
    private BufferedImage image;


    public FinalBOSS(RefLinks refLink,float x, float y)
    {
        super(refLink,x,y,Caracter.width_caracter,Caracter.height_caracter);
        x_Move=0;
        image= Assets.finalBoss_stanga;
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
    public  float getLife()
    {
        return enemy_life;
    }
    public void setLife(int life)
    {
        this.enemy_life=life;
    }
    public void minus_life()
    {
        enemy_life=enemy_life-4;
    }
    public void SetY(float x,float y)
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
        if(x<390 )
        {
            x_Move=1;

            image=Assets.finalBoss_stanga;
        }
        if(x>=550)
        {
            x_Move=-1;
            image=Assets.finalBoss_dreapta;
        }
        if(y>320)
        {
            y=390;
        }

    }



    public void Draw(Graphics g)
    {
        g.drawImage(image,(int)x,(int)y, width,height,null);


    }
}
