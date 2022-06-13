package JocPaoo.States;

import JocPaoo.Map.lvl2;
import JocPaoo.Obiecte.Chest;
import JocPaoo.Obiecte.Enemy;
import JocPaoo.Obiecte.Henry;
import JocPaoo.RefLinks;
import JocPaoo.Map.Map;

import java.awt.*;

public class PlayState extends State{
    private Map map; //referinta catre harta curenta
    private Henry hero;
    private Enemy inamic1;
    private Enemy inamic2;
    private Chest chestlvl;
    public PlayState(RefLinks refLink)
    {
        super(refLink); //apel al constr clasei de baza

        map= new Map(refLink);
        hero=new Henry(refLink,100,395);
        inamic1=new Enemy(refLink,300,395);
        inamic2=new Enemy(refLink,100,395);
        chestlvl=new Chest(refLink,100,395);
        refLink.SetMap(map);
    }
    @Override
    public void Update() throws InterruptedException {
        map.Update();
        hero.Update();
        inamic1.Update();
        inamic2.Update();
        chestlvl.Update();

        if(hero.GetX()==inamic1.GetX() && hero.GetY()==inamic1.GetY())
        {
            System.out.println("Hero life before collision: "+hero.getLife() );
            hero.minus_life();
            System.out.println("Hero life AFTER collision: "+hero.getLife() );
            if(hero.GetX()==inamic1.GetX() && hero.GetY()==inamic1.GetY()&& refLink.GetKeyManager().f )
            {
                hero.plus_life();
                inamic1.minus_life();
                if(inamic1.getLife()==0)
                {
                    hero.SCORE();
                    inamic1.SetY(800,100);


                }
                System.out.println("LVL1 Hero life after kill: "+hero.getLife() );
                System.out.println("LVL1 inamic1 life: "+inamic1.getLife());
                System.out.println("LVL1  score: "+hero.getScore());

            }

        }
        if(hero.GetX()==inamic2.GetX() && hero.GetY()==inamic2.GetY())
        {
            System.out.println("Hero life before collision: "+hero.getLife() );
            hero.minus_life();
            System.out.println("Hero life AFTER collision: "+hero.getLife() );
            if(hero.GetX()==inamic2.GetX() && hero.GetY()==inamic2.GetY()&& refLink.GetKeyManager().f )
            {
                hero.plus_life();
                inamic2.minus_life();
                if(inamic2.getLife()==0)
                {
                    hero.SCORE();
                    inamic2.SetY(0,100);

                }
                System.out.println("Hero life after kill: "+hero.getLife() );
                System.out.println("inamic2 life: "+inamic2.getLife());
                System.out.println("score: "+hero.getScore());

            }

        }

        if(refLink.GetKeyManager().esc)
        {
            State resume= new ResumeMenu(refLink);
            State.SetState(resume);
        }
    }
    public void Draw(Graphics g)
    {
        map.Draw(g);
        inamic1.Draw(g);
        inamic2.Draw(g);
        if(hero.getScore()>=4)
        {

            chestlvl.Draw(g);
            if( hero.GetX()==chestlvl.GetX() && hero.GetY()==chestlvl.GetY() && refLink.GetKeyManager().e )
            {
                State lvl2 = new PlayLvl2(refLink);
                State.SetState(lvl2);
                hero.set_score(0);
            }

        }


        hero.Draw(g);
    }
}
