package scripts.ScriptMaker.api.types.intent.general;

import java.io.Serializable;

import scripts.ScriptMaker.api.types.main.Action;

public class SleepAction extends Action implements Serializable
{

	private static final long serialVersionUID = 3863374169998622971L;
	private long length;

	public SleepAction(final long length)
	{
		this.length = length;
	}

	@Override
	public boolean run()
	{
		try
		{
			Thread.sleep(length);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public String toString()
	{
		return "sleep for "+length + " milliseconds";
	}
}
