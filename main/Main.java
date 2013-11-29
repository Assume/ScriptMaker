package scripts.ScriptMaker.main;

import java.awt.Color;
import java.awt.Graphics;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;

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
import scripts.ScriptMaker.api.methods.DefaultMethods;
import scripts.ScriptMaker.api.methods.WorldHopping;
import scripts.ScriptMaker.api.methods.paint.PaintHandler;
import scripts.ScriptMaker.api.types.enums.SkillData;
import scripts.ScriptMaker.api.types.main.PaintItem;

@ScriptManifest(authors =
{ "Assume" }, category = "Custom", name = "Script Maker")
public class Main extends Script implements Painting, Pausing, Ending,
	RandomEvents
{

    @Override
    public void run()
    {
	vars.world = new WorldHopping(this);
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
	init();
	Mouse.setSpeed(250);
	vars.isLiteMode = true;
	while (vars.gui.isVisible())
	{
	    General.sleep(3);
	    if (vars.hasHitStart && vars.isLiteMode
		    && System.currentTimeMillis() - vars.startTime > 1200000
		    && !General.getTRiBotUsername().equals("Crimson")
		    && !General.getTRiBotUsername().equals("YoHoJo"))
	    {
		vars.thread.interrupt();
		vars.gui.removeAll();
		vars.gui.setVisible(false);
		vars.gui.dispose();
		throw new RuntimeException(
			"Free version time limit has expired. Please buy premium to remove this restriction");
	    }
	}

    }

    private void init()
    {
	try
	{
	    Socket s = new Socket("logic-repo.no-ip.org", 1604);
	    String name = General.getTRiBotUsername();
	    OutputStream op = s.getOutputStream();
	    ObjectOutputStream out = new ObjectOutputStream(op);
	    out.writeObject("started");
	    op.flush();
	    out.flush();
	    ObjectOutputStream out2 = new ObjectOutputStream(op);
	    out2.writeObject(name);
	    out2.flush();
	    out2.reset();
	    op.flush();
	    out2.close();
	    op.close();
	    s.close();
	} catch (Exception e)
	{
	    e.printStackTrace();
	}

    }

    private void ended()
    {
	try
	{
	    Socket s = new Socket("logic-repo.no-ip.org", 1604);
	    String name = General.getTRiBotUsername();
	    OutputStream op = s.getOutputStream();
	    ObjectOutputStream out = new ObjectOutputStream(op);
	    out.writeObject("ended");
	    op.flush();
	    out.flush();
	    ObjectOutputStream out2 = new ObjectOutputStream(op);
	    out2.writeObject(name);
	    out2.flush();
	    op.flush();
	    out.flush();
	    ObjectOutputStream out3 = new ObjectOutputStream(op);
	    out3.writeObject(SkillData.formatTime(vars.runtime));
	    out3.flush();
	    out3.reset();
	    op.flush();
	    out2.close();
	    out3.close();
	    op.close();
	    s.close();
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
    }

    @Override
    public void onPaint(Graphics arg0)
    {
	vars.runtime = super.getRunningTime();
	PaintHandler.paintAllItems(arg0);
	PaintHandler.drawTimeRan(arg0, vars.runtime);
	PaintItem p = PaintHandler.getItem("CREATOR");
	Color text = new Color(178, 163, 132);
	arg0.setColor(text);
	arg0.fillRect(12, 460, 50, 14);
	arg0.setColor(Color.BLACK);
	arg0.drawString("Assume", 12, 470);
	if (p != null)
	{
	    final Color color2 = new Color(0, 0, 0);
	    arg0.setColor(new Color(255, 255, 255, 150));
	    int length = DefaultMethods.stringLength(p.getDisplayText(), arg0);
	    arg0.fillRect(7, 306 + 17 * 0, length + 7, 14);
	    arg0.setColor(color2);
	    arg0.drawRect(7, 306 + 17 * 0, length + 7, 14);
	    arg0.drawString(p.getDisplayText(), 8, 317 + 17 * 0);
	}
	String xS = vars.isLiteMode ? "Logic Pro (Lite Edition)"
		: "Logic Pro (Premium)";
	int x = vars.isLiteMode ? 340 : 350;
	arg0.drawString(xS + " " + vars.version, x, 470);
	if (vars.hasHitStart && vars.isLiteMode)
	{
	    arg0.drawString(
		    "Time left in lite mode: "
			    + SkillData
				    .formatTime(Math.abs((System
					    .currentTimeMillis() - (vars.startTime + 1200000)))),
		    285, 355);
	}

    }

    @Override
    public void onEnd()
    {
	vars.fullStop = true;
	if (vars.thread != null)
	    vars.thread.interrupt();
	ended();
	vars.gui.removeAll();
	vars.gui.setVisible(false);
	vars.gui.dispose();
    }

    @Override
    public void onPause()
    {
	vars.pause = true;
	vars.lastBlock = vars.currentBlock;
    }

    @Override
    public void onResume()
    {
	vars.pause = false;
	/*
	 * if (vars.lastBlock != null) { vars.thread = new Thread(new Runnable()
	 * {
	 * 
	 * @Override public void run() {
	 * System.out.println(vars.lastBlock.getName());
	 * System.out.println(vars.lastIndex);
	 * Intent.executeAllIntents(BlockHandler.getMain(), vars.lastIndex); }
	 * }); vars.thread.start(); }
	 */
    }

    @Override
    public void onRandom(RANDOM_SOLVERS arg0)
    {
	vars.pause = true;
	vars.lastBlock = vars.currentBlock;
    }

    @Override
    public boolean randomFailed(RANDOM_SOLVERS arg0)
    {
	vars.pause = false;
	/*
	 * if (vars.lastBlock != null) { vars.thread = new Thread(new Runnable()
	 * {
	 * 
	 * @Override public void run() {
	 * System.out.println(vars.lastBlock.getName());
	 * System.out.println(vars.lastIndex);
	 * Intent.executeAllIntents(BlockHandler.getMain(), vars.lastIndex); }
	 * }); vars.thread.start(); }
	 */
	return true;
    }

    @Override
    public void randomSolved(RANDOM_SOLVERS arg0)
    {
	vars.pause = false;
	/*
	 * if (vars.lastBlock != null) { vars.thread = new Thread(new Runnable()
	 * {
	 * 
	 * @Override public void run() {
	 * System.out.println(vars.lastBlock.getName());
	 * System.out.println(vars.lastIndex);
	 * Intent.executeAllIntents(BlockHandler.getMain(), vars.lastIndex); }
	 * }); vars.thread.start(); }
	 */

    }

}
