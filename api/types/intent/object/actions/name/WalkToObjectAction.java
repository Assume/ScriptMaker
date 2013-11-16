package scripts.ScriptMaker.api.types.intent.object.actions.name;

import java.io.Serializable;

import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.util.PathNavigator;

import scripts.ScriptMaker.api.types.main.Action;

public class WalkToObjectAction extends Action implements Serializable
{

	private static final long serialVersionUID = 91931234253329320L;
	
	private String name;

	public WalkToObjectAction(final String name)
	{
		this.name = name;
	}

	@Override
	public boolean run()
	{
		RSObject[] ob = Objects.findNearest(50, name);
		if (ob.length == 0)
			return false;
		new PathNavigator().traverse(ob[0].getPosition());
		return true;
	}

	@Override
	public String toString()
	{
		return "If " + name + " is on screen";
	}

}
