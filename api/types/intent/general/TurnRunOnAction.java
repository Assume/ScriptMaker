package scripts.ScriptMaker.api.types.intent.general;

import java.io.Serializable;

import org.tribot.api2007.Walking;

import scripts.ScriptMaker.api.types.main.Action;

public class TurnRunOnAction extends Action implements Serializable
{
	
	private static final long serialVersionUID = 7798342970205765448L;

	@Override
	public boolean run()
	{
	    Walking.setControlClick(true);
		return true;
	} 
	
	@Override
	public String toString()
	{
		return "turn on run";
	}

}
