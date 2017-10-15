package com.test.level32.lesson15.big01.listeners;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import com.javarush.test.level32.lesson15.big01.View;
/**
 * Created by Vladislav on 16.11.2016.
 */
public class UndoMenuListener implements MenuListener
{
    private View view;
    private JMenuItem undoMenuItem;
    private JMenuItem redoMenuItem;


    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem)
    {
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
    }

    @Override
    public void menuSelected(MenuEvent menuEvent)
    {
        if(view.canUndo())
        {
            undoMenuItem.setEnabled(true);
        }
        else if(!view.canUndo())
        {
            undoMenuItem.setEnabled(false);
        }
        if(view.canRedo())
        {
            redoMenuItem.setEnabled(true);
        }
        else if(!view.canRedo())
        {
            redoMenuItem.setEnabled(false);
        }

        /*
        undoMenuItem.setEnabled(View.canUndo());
        redoMenuItem.setEnabled(View.canRedo());
*/
    }

    @Override
    public void menuDeselected(MenuEvent e)
    {

    }

    @Override
    public void menuCanceled(MenuEvent e)
    {

    }
}
