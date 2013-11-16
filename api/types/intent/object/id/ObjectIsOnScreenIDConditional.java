package scripts.ScriptMaker.api.types.intent.object.id;

import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSObject;

import scripts.ScriptMaker.api.types.main.Conditional;

public class ObjectIsOnScreenIDConditional extends Conditional
{

	private static final long serialVersionUID = -5943836978686669512L;

	private int id;

	public ObjectIsOnScreenIDConditional(final int id)
	{
		this.id = id;
	}

	@Override
	public boolean run()
	{
		RSObject[] ob = Objects.findNearest(50, id);
		if (ob.length == 0)
			return false;
		if (ob[0].isOnScreen())
		{
			return true;
		}
		return false;
	}

	@Override
	public String toString()
	{
		return "If " + id + " is on screen";
	}

}
