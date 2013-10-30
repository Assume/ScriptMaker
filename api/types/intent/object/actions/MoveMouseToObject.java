package scripts.ScriptMaker.api.types.intent.object.actions;

import java.awt.Point;
import java.io.Serializable;

import org.tribot.api.input.Mouse;
import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSObject;

import scripts.ScriptMaker.api.methods.DefaultMethods;
import scripts.ScriptMaker.api.types.main.Action;

public class MoveMouseToObject extends Action implements Serializable
{

	private static final long serialVersionUID = 9193997494153329320L;
	
	private String name;

	public MoveMouseToObject(final String name)
	{
		this.name = name;
	}

	@Override
	public boolean run()
	{
		RSObject[] ob = Objects.findNearest(50, name);
		if (ob.length == 0)
			return false;
		Point p = DefaultMethods.getAverage(ob[0].getModel().getAllVisiblePoints(), 10);
		Mouse.move(p);
		return true;
	}

	@Override
	public String toString()
	{
		return "move mouse to "+name;
	}

}
