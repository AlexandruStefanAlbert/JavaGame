package JocPaoo.Keys;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyManager implements KeyListener {
    private boolean[] keys; //vector pentru toate tastele
    public boolean space;
    public boolean left;
    public boolean right;
    public boolean menu_up;
    public boolean menu_down;
    public boolean menu_enter;
    public boolean esc;
    public boolean f;
    public boolean e;

    public KeyManager()
    {
        keys=new boolean[256];
    }
    public void Update()
    {
        space= keys[KeyEvent.VK_SPACE];
        f=keys[KeyEvent.VK_F];
        left=keys[KeyEvent.VK_A];
        right=keys[KeyEvent.VK_D];
        menu_up=keys[KeyEvent.VK_UP];
        menu_down=keys[KeyEvent.VK_DOWN];
        menu_enter=keys[KeyEvent.VK_ENTER];
        esc=keys[KeyEvent.VK_ESCAPE];
        e=keys[KeyEvent.VK_E];
    }
    @Override
    public void keyPressed(KeyEvent e)
    {
        //se retine ca o tasta a fost apasata
        keys[e.getKeyCode()]=true;
    }
    @Override
    public void keyReleased(KeyEvent e)
    {
        //tasta a fost eliberata
        keys[e.getKeyCode()]=false;
    }
    @Override
    public void keyTyped(KeyEvent e)
    {

    }


}
