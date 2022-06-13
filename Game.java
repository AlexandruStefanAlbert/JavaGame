package JocPaoo;

import JocPaoo.Graphics.Assets;
import JocPaoo.Keys.KeyManager;
import JocPaoo.States.MenuState;
import JocPaoo.States.PlayState;
import JocPaoo.Tiles.Tile;
import JocPaoo.States.State;
import JocPaoo.GameWindow.Window;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable
{

    private Window wind; //fereastra in care se va desena tabla
    private boolean runState;
    private Thread gameThread;
    private BufferStrategy bs;

    private Graphics g; //context grafic

    private State playState; //referinta catre joc
    private State menuState; //meniu
    private State settingsState; //setari




    private KeyManager keyManager; //obiectul ce gestioneaza tastele
    private RefLinks refLink; //retine diverse referinte

    private Tile tile;

    public Game(String title, int width, int height)
    {
        wind=new Window(title,width,height);
        runState=false;
        keyManager=new KeyManager();
    }

    private void InitGame()
    {
        wind.BuildGameWindow();
        wind.GetWindow().addKeyListener(keyManager);

        Assets.Init();

        refLink=new RefLinks(this);

        playState=new PlayState(refLink);
        menuState=new MenuState(refLink);

        State.SetState(menuState);
        //State.SetState(playState);


    }

    public void run()
    {
        InitGame(); //initializeaza obiectul game

        long oldTime=System.nanoTime(); //timpul pt frame-ul anterior
        long curretnTime;   //timpul pt frame-ul actual

        final int FPS= 60;
        final double timeFrame=1000000000/FPS;

        while(runState ==true)
        {
            curretnTime=System.nanoTime(); //timpul curent
            if((curretnTime-oldTime)>timeFrame)
            {
                Update();
                Draw();
                oldTime=curretnTime;
            }
        }

    }
    public  synchronized void StartGame()
    {
        if(runState==false)
        {
            runState=true;
            gameThread= new Thread(this);
            gameThread.start();
        }
        else
            return;
    }

    public synchronized void StopGame()
    {
        if(runState==true)
        {
            runState = false;
            try {
                gameThread.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        else
            return;
    }

    private void Update()
    {
        keyManager.Update(); //starea tastelor
        if(State.GetState() != null)
        {
            ///Actualizez starea curenta a jocului daca exista.
            try {
                State.GetState().Update();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void Draw()
    {
        bs=wind.GetCanvas().getBufferStrategy(); //returnmez pt canvasul existent
        //verific daca bufferStrategy a fost construit
        if(bs==null)
        {
            try
            {
                wind.GetCanvas().createBufferStrategy(3); //triplu buffer
                return;
            }
            catch (Exception e)
            {
                e.printStackTrace();//afisez info despre problema aparuta
            }
        }
        g=bs.getDrawGraphics(); //se obtinue contextul grafic in care se poate desena

        g.clearRect(0,0, wind.GetWidth(), wind.GetHeight());

        if(State.GetState() != null)
        {
            //Actualizez starea curenta a jocului daca exista.
            State.GetState().Draw(g);

        }

        bs.show(); //se afiseaza pe ecran

        g.dispose(); //elibereaza resursele de memorie aferente contextului grafic curent


    }

    public int GetWidth()
    {
        return wind.GetWidth();
    }
    public int GetHeight()
    {
        return wind.GetHeight();
    }
    public KeyManager GetKeyManager()
    {
        return keyManager;
    }


}
