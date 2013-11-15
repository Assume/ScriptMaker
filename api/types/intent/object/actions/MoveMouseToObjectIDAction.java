package scripts.ScriptMaker.api.types.intent.object.actions;

import java.awt.Point;

import org.tribot.api.input.Mouse;
import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSObject;

import scripts.ScriptMaker.api.methods.DefaultMethods;
import scripts.ScriptMaker.api.types.main.Action;

public class MoveMouseToObjectIDAction extends Action
{

	private static final long serialVersionUID = -3292177587535258093L;
	private int id;

	public MoveMouseToObjectIDAction(final int id)
	{
		this.id = id;
	}

	@Override
	public boolean run()
	{
		RSObject[] ob = Objects.findNearest(50, id);
		if (ob.length == 0)
			return false;
		Point p = DefaultMethods.getAverage(ob[0].getModel()
				.getAllVisiblePoints(), 10);
		Mouse.move(p);
		return true;
	}

	@Override
	public String toString()
	{
		return "move mouse to " + id;
	}

}
