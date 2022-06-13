package JocPaoo.States;

import JocPaoo.Graphics.Win;
import JocPaoo.RefLinks;

import java.awt.*;

public class WinState extends State{

    private Win wingame;
    public WinState(RefLinks refLink)
    {
        super(refLink); //apel al constr clasei de baza

        wingame=new Win(refLink);

    }
    @Override
    public void Update()
    {

        wingame.Update3();
        if(refLink.GetKeyManager().esc)
        {
            State resume= new ResumeMenu(refLink);
            State.SetState(resume);
        }
    }
    public void Draw(Graphics g)
    {
        wingame.Draw3(g);
    }
}
