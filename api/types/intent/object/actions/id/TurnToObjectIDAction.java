package scripts.ScriptMaker.api.types.intent.object.actions.id;

import org.tribot.api2007.Camera;
import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSObject;

import scripts.ScriptMaker.api.types.main.Action;

public class TurnToObjectIDAction extends Action
{

	private static final long serialVersionUID = 38998044843372039L;

	private int id;

	public TurnToObjectIDAction(final int id)
	{
		this.id = id;
	}

	@Override
	public boolean run()
	{
		RSObject[] ob = Objects.findNearest(50, id);
		if (ob.length == 0)
			return false;
		Camera.turnToTile(ob[0].getPosition());
		return true;
	}

	@Override
	public String toString()
	{
		return "Turn camera to object " + id;
	}

}
