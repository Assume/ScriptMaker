package scripts.ScriptMaker.api.types.intent.object.id;

import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSObject;

import scripts.ScriptMaker.api.types.main.Conditional;

public class ObjectisNotOnScreenIDConditional extends Conditional
{

	private static final long serialVersionUID = -3446753307261368322L;
	private int id;

	public ObjectisNotOnScreenIDConditional(final int id)
	{
		this.id = id;
	}

	@Override
	public boolean run()
	{
		RSObject[] ob = Objects.findNearest(50, id);
		if (ob.length == 0)
			return true;
		if (ob[0].isOnScreen())
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "If " + id + " is not on screen";
	}

}
