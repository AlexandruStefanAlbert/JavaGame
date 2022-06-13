package JocPaoo.States;

import JocPaoo.Obiecte.Henry;
import JocPaoo.RefLinks;
import JocPaoo.Map.Map;

import java.awt.*;


public class SettingState extends State
{

    public SettingState(RefLinks refLink)
    {

        super(refLink);
    }


    @Override
    public void Update()
    {
        if(refLink.GetKeyManager().esc)
        {
            State menustate= new MenuState(refLink);
            State.SetState(menustate);
        }
    }


    @Override
    public void Draw(Graphics g)
    {

    }
}
