package JocPaoo.States;

import JocPaoo.Graphics.Meniu;
import JocPaoo.RefLinks;
import java.awt.*;

public class MenuState  extends PlayState {
    private String[] options = {"Start","Load", "Settings", "Quit"};
    public int currentSelection = 0;
    private Meniu meniu;
    private WinState wingame;
    public MenuState(RefLinks refLink) {

        super(refLink);
        meniu= new Meniu(refLink);
        wingame=new WinState(refLink);

    }

    public void Draw(Graphics g)
    {

        meniu.Draw(g);
        for (int i = 0; i < options.length; i++) {
            if (i == currentSelection) {
                g.setColor(Color.GREEN);
            } else {
                g.setColor(Color.BLACK);
            }
            g.setFont(new Font("Serif", Font.BOLD, 70));
            g.drawString(options[i], refLink.GetWidth() / 2 - 120, 90 + i * 120);

        }
    }
    public void keyPressed(int k)
    {

    }
    public void Update()
    {
        if(refLink.GetKeyManager().menu_up )
        {
            currentSelection++;

            System.out.println("l "+currentSelection);
            if(currentSelection >=options.length)
            {
                currentSelection=0;
            }
        }
        else if(refLink.GetKeyManager().menu_down)
        {
            currentSelection--;
            if(currentSelection <0)
            {
                currentSelection= options.length-1;
            }
        }
        else if(refLink.GetKeyManager().menu_enter)
        {
            if(currentSelection==0)
            {
                State playgame=new PlayState(refLink);
                State.SetState(playgame);
            }
            if(currentSelection==1)
            {
                State settings=new SettingState(refLink);
                State.SetState(settings);

            }
            if(currentSelection==2)
            {
                State settings=new SettingState(refLink);
                State.SetState(settings);

            }
            if(currentSelection==3)
            {
                System.exit(0);

            }
        }
    }
}