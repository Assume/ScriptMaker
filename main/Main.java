package scripts.ScriptMaker.main;

import java.awt.Graphics;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import org.tribot.api.General;
import org.tribot.api.input.Mouse;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Ending;
import org.tribot.script.interfaces.Painting;
import org.tribot.script.interfaces.Pausing;
import org.tribot.script.interfaces.RandomEvents;

import scripts.ScriptMaker.GUI.MainGUI;
import scripts.ScriptMaker.api.methods.paint.PaintHandler;
import scripts.ScriptMaker.api.types.block.handler.BlockHandler;
import scripts.ScriptMaker.api.types.main.Intent;

@ScriptManifest(authors = { "Assume" }, category = "Custom", name = "Script Maker")
public class Main extends Script implements Painting, Pausing, Ending,
	RandomEvents
{

    @Override
    public void run()
    {

	try
	{
	    SwingUtilities.invokeAndWait(new Runnable()
	    {

		@Override
		public void run()
		{
		    vars.gui = new MainGUI();
		    vars.gui.setVisible(true);

		}
	    });
	} catch (InvocationTargetException | InterruptedException e)
	{
	    e.printStackTrace();
	}
	Mouse.setSpeed(250);
	while (vars.gui.isVisible())
	{
	    General.sleep(3);
	}

    }

    @Override
    public void onPaint(Graphics arg0)
    {
	vars.runtime = super.getRunningTime();
	PaintHandler.paintAllItems(arg0);
	PaintHandler.drawTimeRan(arg0, vars.runtime);
    }

    @Override
    public void onEnd()
    {
	vars.stop = true;
	if (vars.thread != null)
	    vars.thread.interrupt();
    }

    @Override
    public void onPause()
    {
	System.out.println("In on pause");
	/*
	 * if (vars.thread != null) vars.thread.interrupt(); vars.stop = true;
	 * vars.lastBlock = vars.currentBlock;
	 */
    }

    @Override
    public void onResume()
    {
	System.out.println("In on resume");
	/*
	 * vars.stop = false; if (vars.lastBlock != null) {
	 * 
	 * vars.thread = new Thread(new Runnable() {
	 * 
	 * @Override public void run() {
	 * Intent.executeAllIntents(vars.lastBlock, vars.lastIndex); } });
	 * vars.thread.start(); }
	 */

    }

    @Override
    public void onRandom(RANDOM_SOLVERS arg0)
    {
	System.out.println("In on random");
	if (vars.thread != null)
	    vars.thread.interrupt();
	vars.stop = true;
	vars.lastBlock = vars.currentBlock;
    }

    @Override
    public boolean randomFailed(RANDOM_SOLVERS arg0)
    {
	System.out.println("In on random failed");
	vars.stop = false;
	if (vars.lastBlock != null)
	{

	    vars.thread = new Thread(new Runnable()
	    {

		@Override
		public void run()
		{
		    Intent.executeAllIntents(vars.lastBlock, vars.lastIndex);
		}
	    });
	    vars.thread.start();
	}

	return true;
    }

    @Override
    public void randomSolved(RANDOM_SOLVERS arg0)
    {
	System.out.println("In on random solved");
	vars.stop = false;
	if (vars.lastBlock != null)
	{
	    System.out.println("In thread creator");
	    vars.thread = new Thread(new Runnable()
	    {
		@Override
		public void run()
		{
		    System.out.println("In thread");
		    System.out.println(vars.lastBlock.getName());
		    System.out.println(vars.lastIndex);
		    Intent.executeAllIntents(BlockHandler.getMain(), vars.lastIndex);
		}
	    });
	    System.out.println("made thread");
	    vars.thread.start();
	    System.out.println("started thread");
	}

    }

}
