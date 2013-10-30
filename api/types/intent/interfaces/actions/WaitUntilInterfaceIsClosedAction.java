package scripts.ScriptMaker.api.types.intent.interfaces.actions;

import java.io.Serializable;

import org.tribot.api2007.Interfaces;

import scripts.ScriptMaker.api.types.main.Action;

public class WaitUntilInterfaceIsClosedAction extends Action implements Serializable
{

    private static final long serialVersionUID = -3243676857701647252L;

    private int parent;
    private long timeout;

    public WaitUntilInterfaceIsClosedAction(int parent, long timeout)
    {
	this.parent = parent;
	this.timeout = timeout;
    }

    @Override
    public boolean run()
    {
	long startTime = System.currentTimeMillis();
	while (Interfaces.isInterfaceValid(parent)
		&& (System.currentTimeMillis() - startTime) < timeout)
	    try
	    {
		Thread.sleep(10);
	    } catch (InterruptedException e)
	    {
		e.printStackTrace();
	    }
	return true;
    }
    
    @Override
    public String toString()
    {
	return "sleep until "+parent + " is closed";
    }

}
