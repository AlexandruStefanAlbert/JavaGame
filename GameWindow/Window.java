package JocPaoo.GameWindow;

import javax.swing.*;
import java.awt.*;

public class Window {

    private JFrame window; //fereastra principala
    private String title; //titlul ferestrei
    private int width; //latimea
    private int height; //inaltimea

    private Canvas canvas; //fereastra in care se poate desena

    public Window(String WindTitle, int WindWidth, int WindHeight)
    {
        title   = WindTitle;
        width   = WindWidth;
        height  = WindHeight;
        window  = null; //fereastra nu este construita
    }
    public void BuildGameWindow()
    {
        if(window!=null)
        {
            return;
        }

        window=new JFrame(title);
        window.setSize(width,height);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        canvas= new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));

        window.add(canvas);
        window.pack();

    }
    public int GetWidth()
    {
        return width;
    }
    public int GetHeight()
    {
        return height;
    }
    public Canvas GetCanvas()
    {
        return canvas;
    }
    public JFrame GetWindow()
    {
        return window;
    }
}
