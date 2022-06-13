package JocPaoo.States;

import JocPaoo.Map.lvl2;
import JocPaoo.Obiecte.*;
import JocPaoo.RefLinks;
import JocPaoo.Map.Map;

import java.awt.*;

public class PlayLvl2 extends State{

    private Henry hero;
    private lvl2 nivel2;
    private Monstru1LVL2 montru1;
    private FinalBOSS bossFINAL;
    private Chest chest;
    private Printesa printesa;
    public PlayLvl2(RefLinks refLink)
    {
        super(refLink);


        nivel2=new lvl2(refLink);
        hero=new Henry(refLink,0,150);
        montru1=new Monstru1LVL2(refLink,250,320);
        bossFINAL=new FinalBOSS(refLink,565,120);
        printesa=new Printesa(refLink,665,120);
        hero.set_score(0);

    }
    @Override
    public void Update()
    {

        nivel2.Update2();
        hero.Update2();
        montru1.Update();
        bossFINAL.Update();
        printesa.Update();


        if(hero.GetX()==montru1.GetX() && hero.GetY()==montru1.GetY())
        {
            System.out.println("Hero life before collision: "+hero.getLife() );
            hero.minus_life();
            System.out.println("Hero life AFTER collision: "+hero.getLife() );
            if(hero.GetX()==montru1.GetX() && hero.GetY()==montru1.GetY()&& refLink.GetKeyManager().f )
            {

                montru1.minus_life();
                if(montru1.getLife()<=0)
                {
                    hero.plus_life();
                    hero.SCORE();
                    montru1.setLife(8);
                    montru1.SetY(300,100);


                }
                System.out.println("LVL1 Hero life after kill: "+hero.getLife() );
                System.out.println("LVL1 inamic1 life: "+montru1.getLife());
                System.out.println("LVL1  score: "+hero.getScore());

            }

        }
        if(hero.GetX()==bossFINAL.GetX() && hero.GetY()==bossFINAL.GetY())
        {
            System.out.println("Hero life before collision: "+hero.getLife() );
            hero.minus_life();
            System.out.println("Hero life AFTER collision: "+hero.getLife() );
            if(hero.GetX()==bossFINAL.GetX() && hero.GetY()==bossFINAL.GetY()&& refLink.GetKeyManager().f )
            {

                bossFINAL.minus_life();
                if(bossFINAL.getLife()<=0)
                {
                    hero.plus_life();
                    hero.SCORE();
                    bossFINAL.setLife(20);
                    bossFINAL.SetY(600,100);

                }
                System.out.println("Hero life after kill: "+hero.getLife() );
                System.out.println("inamic2 life: "+bossFINAL.getLife());
                System.out.println("score: "+hero.getScore());

            }

        }



        if(hero.GetX()==printesa.GetX() && hero.GetY()==printesa.GetY())
        {
            System.out.println("Collision wih PRINTESA: ");
                State win=new WinState(refLink);
                State.SetState(win);

        }

        if(hero.getLife()<=0)
        {
            State restart=new PlayLvl2(refLink);
            State.SetState(restart);
        }
        if(refLink.GetKeyManager().esc)
        {
            State resume= new ResumeMenu(refLink);
            State.SetState(resume);
        }
    }
    public void Draw(Graphics g)
    {
        nivel2.DrawLvl2(g);
        montru1.Draw(g);
        bossFINAL.Draw(g);
        if(hero.getScore()>=8)
        {
            printesa.Draw(g);
            if(refLink.GetKeyManager().e)
            {
                State win=new WinState(refLink);
                State.SetState(win);
            }

        }
        hero.Draw(g);
    }
}
