package scripts.ScriptMaker.api.types.intent.object.actions.name;

import java.io.Serializable;

import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSObject;

import scripts.ScriptMaker.api.methods.DefaultMethods;
import scripts.ScriptMaker.api.types.main.Action;

public class ClickObjectAction extends Action implements Serializable
{

	private static final long serialVersionUID = 9193512364153329320L;
	private String name;
	private String action;

	public ClickObjectAction(final String name, final String action)
	{
		this.name = name;
		this.action = action;
	}

	@Override
	public boolean run()
	{
		RSObject[] ob = Objects.findNearest(50, name);
		if (ob.length == 0)
			return false;
		DefaultMethods.clickObject(ob[0], action);
		return true;
	}

	@Override
	public String toString()
	{
		return "Clicking "+name +" with the action "+action;
	}

}
