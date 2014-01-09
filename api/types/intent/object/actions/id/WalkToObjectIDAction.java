package scripts.ScriptMaker.api.types.intent.object.actions.id;

import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.util.PathNavigator;

import scripts.ScriptMaker.api.types.main.Action;

public class WalkToObjectIDAction extends Action
{

	private static final long serialVersionUID = -2244975361736674433L;
	
	private int id;

	public WalkToObjectIDAction(final int id)
	{
		this.id = id;
	}

	@Override
	public boolean run()
	{
		RSObject[] ob = Objects.findNearest(50, id);
		if (ob.length == 0)
			return false;
		new PathNavigator().traverse(ob[0].getPosition());
		return true;
	}

	@Override
	public String toString()
	{
		return "Walk to "+id+"";
	}

}
