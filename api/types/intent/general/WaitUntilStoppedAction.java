package scripts.ScriptMaker.api.types.intent.general;

import org.tribot.api.General;
import org.tribot.api2007.Player;

import scripts.ScriptMaker.api.types.main.Action;

public class WaitUntilStoppedAction extends Action
{

	private static final long serialVersionUID = 5086372224723259099L;

	public WaitUntilStoppedAction()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean run()
	{
		while(Player.isMoving())
		{
			General.sleep(50);
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "wait until player has stopped moving";
	}
	
}
