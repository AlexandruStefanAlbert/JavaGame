package JocPaoo.Obiecte;

import JocPaoo.RefLinks;
import JocPaoo.States.PlayLvl2;
import JocPaoo.States.PlayState;
import JocPaoo.States.State;
import JocPaoo.States.WinState;

public abstract class Caracter extends Obiect{

    public static final int default_life=10;
    public static final float default_speed=3.0f;
    public static final int width_caracter=48;
    public static final int height_caracter=48;
    public static int default_score=0;

    public static final int lvl2_life=8;
    public static final int boss_life=8;

    protected int score;
    protected int life;
    protected int enemy_lvl2;
    protected int boss_final;
    protected int enemy_life;
    protected float speed;
    protected float x_Move;
    protected float y_Move;

    public Caracter(RefLinks refLink, float x, float y, int width, int height)
    {
        super(refLink,x,y,width,height);
        life=default_life;
        enemy_life=default_life;
        enemy_lvl2=lvl2_life;
        boss_final=boss_life;
        score=default_score;
        speed=default_speed;
        x_Move=0;
        y_Move=0;
    }
    public void Move()
    {
        MoveX();
        MoveY();
    }
    public void Move2()
    {
        MoveX3();
        MoveY();
    }
    public void MoveX()
    {
        x+=x_Move;

        if(x<0)
        {

            x=0;

        }
        else if(x>675)
        {
            x=675;
        }
       if(life==0)
       {
           State playgame=new PlayState(refLink);
           State.SetState(playgame);
       }


        if(y>395 && x<=675)
        {
            y=395;
        }

    }
    public void MoveX2()
    {
        if(x<70 && y >150) {
            y = 150;
            y_Move=5;

        }

    }

    public void MoveX3()
    {

        if(x>270 && x< 295 && y==395 || (x>577 && x<626 && y==395)  )
        {
            score=0;
            life=life-5;
            x=0;
            y=150;
            System.out.println("Life lvl2: "+life);


        }
        if(x>670 && y>160)
        {

                //State wingame=new WinState(refLink);
                //State.SetState(wingame);

        }
        if(x<270 && x >70 && y>320)
        {
            y=320;
        }
        if(x>626 && y>210)
        {
            y=210;
        }
        if(x>380 && x<430 && y>110)
        {
            y=110;

        }

    }

    public void MoveY()
    {
        y+=y_Move;
    }

}
