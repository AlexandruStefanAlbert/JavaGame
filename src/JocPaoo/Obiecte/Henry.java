package JocPaoo.Obiecte;

import JocPaoo.Graphics.Assets;
import JocPaoo.RefLinks;
import JocPaoo.States.State;
import JocPaoo.States.WinState;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Henry extends Caracter{
    private BufferedImage image;
    public Henry(RefLinks refLink,float x, float y)
    {
        super(refLink,x,y,Caracter.width_caracter,Caracter.height_caracter);

        image= Assets.hero;

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

        if(refLink.GetKeyManager().right==true)
        {
            image=Assets.alerg;

        }
        if(refLink.GetKeyManager().left==true)
        {
            image=Assets.hero;

        }
        if(refLink.GetKeyManager().space==true)
        {
            image=Assets.alerg;
            if(refLink.GetKeyManager().left==true)
            {
                image=Assets.hero;
            }
        }

        if(refLink.GetKeyManager().f==true)
        {
            image=Assets.ataca;
            if( refLink.GetKeyManager().left==true)
            {
                image = Assets.atacaStanga;
            }
        }

    }
    public void Update2()
    {
        GetInput2();
        Move();

        if(refLink.GetKeyManager().right==true)
        {
            image=Assets.alerg;

        }
        if(refLink.GetKeyManager().left==true)
        {
            image=Assets.hero;

        }
        if(refLink.GetKeyManager().space==true)
        {
            image=Assets.alerg;
            if(refLink.GetKeyManager().left==true)
            {
                image=Assets.hero;
            }
        }
        if(refLink.GetKeyManager().f==true)
        {
            image=Assets.ataca;
        }
        if(refLink.GetKeyManager().f==true)
        {
            if( refLink.GetKeyManager().left==true)
            {
                image = Assets.atacaStanga;
            }
        }


    }
    public void SCORE()
    {
        score=score+2;
    }
    public int getScore()
    {
        return score;
    }
    public  float getLife()
    {
        return life;
    }
    public void minus_life()
    {
        life=life-2;
    }
    public void set_life()
    {
        life=0;
    }
    public void set_score(int x)
    {
        this.score=x;
    }
    public void plus_life()
    {
        life=10;
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
        x_Move=0;
        y_Move=5;

        if(refLink.GetKeyManager().space)
        {
            y_Move = -(speed+2.0f);

        }


        if(refLink.GetKeyManager().left)
        {
            x_Move = -speed;

        }

        if(refLink.GetKeyManager().right)
        {
            x_Move = speed;
        }
    }
    private void GetInput2()
    {
        x_Move=0;
        y_Move=0;

        if( y<395)
        {
            y_Move=5;
            MoveX2();

        }
        MoveX3();

        if(refLink.GetKeyManager().space)
        {
            y_Move = -speed;

        }
        if(x>675)
        {
            State wingame=new WinState(refLink);
            State.SetState(wingame);
        }


        if(refLink.GetKeyManager().left)
        {
            x_Move = -speed;

        }

        if(refLink.GetKeyManager().right)
        {
            x_Move = speed;
        }
    }
    public void Draw(Graphics g)
    {
        g.drawImage(image,(int)x,(int)y, width,height,null);

    }
}
