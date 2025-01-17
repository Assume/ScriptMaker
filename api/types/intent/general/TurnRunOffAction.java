package scripts.ScriptMaker.api.types.intent.general;

import java.io.Serializable;

import org.tribot.api2007.Walking;

import scripts.ScriptMaker.api.types.main.Action;

public class TurnRunOffAction extends Action implements Serializable
{

	private static final long serialVersionUID = 905537761085692976L;

	@Override
	public boolean run()
	{
		Walking.setControlClick(false);
		return false;
	}
	
	@Override 
	public String toString()
	{
		return "turn off run";
	}

}
