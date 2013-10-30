package scripts.ScriptMaker.api.types.intent.walking.actions;

import java.io.Serializable;

import org.tribot.api2007.WebWalking;

import scripts.ScriptMaker.api.types.main.Action;

public class WebWalkToBankAction extends Action implements Serializable
{

	private static final long serialVersionUID = 3507956590499922236L;

	@Override
	public boolean run()
	{
		return WebWalking.walkToBank();
	}

	@Override
	public String toString()
	{
		return "attempt to WebWalk to nearest bank";
	}
	
}
