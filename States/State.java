package JocPaoo.States;
import java.awt.*;
import JocPaoo.RefLinks;

public abstract class State {
    private static State previousState=null;
    private static State currentState=null;

    protected RefLinks refLink;
    public State(RefLinks refLink)
    {
        this.refLink=refLink;
    }

    public static void SetState(State state)
    {
        previousState=currentState;
        currentState=state;
    }
    public static State GetState()
    {
        return currentState;
    }
    public abstract void Update() throws InterruptedException;

    public abstract void Draw(Graphics g);
}
