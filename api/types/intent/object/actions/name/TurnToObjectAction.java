package scripts.ScriptMaker.api.types.intent.object.actions.name;

import java.io.Serializable;

import org.tribot.api2007.Camera;
import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSObject;

import scripts.ScriptMaker.api.types.main.Action;

public class TurnToObjectAction extends Action implements Serializable
{

	private static final long serialVersionUID = 919392342153329320L;
	
	private String name;

	public TurnToObjectAction(final String name)
	{
		this.name = name;
	}

	@Override
	public boolean run()
	{
		RSObject[] ob = Objects.findNearest(50, name);
		if (ob.length == 0)
			return false;
		Camera.turnToTile(ob[0].getPosition());
		return true;
	}

	@Override
	public String toString()
	{
		return "Turn camera to object "+name;
	}

}
