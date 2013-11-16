package scripts.ScriptMaker.api.types.intent.object.actions.id;

import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSObject;

import scripts.ScriptMaker.api.methods.DefaultMethods;
import scripts.ScriptMaker.api.types.main.Action;

public class ClickObjectIDAction extends Action
{

	private static final long serialVersionUID = -8941109662573752346L;
	
	private int id;
	private String action;

	public ClickObjectIDAction(final int id, final String action)
	{
		this.id = id;
		this.action = action;
	}

	@Override
	public boolean run()
	{
		RSObject[] ob = Objects.findNearest(50, id);
		if (ob.length == 0)
			return false;
		DefaultMethods.clickObject(ob[0], action);
		return true;
	}

	@Override
	public String toString()
	{
		return "Clicking "+id +" with the action "+action;
	}
	
}
