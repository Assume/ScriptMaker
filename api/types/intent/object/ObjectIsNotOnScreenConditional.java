package scripts.ScriptMaker.api.types.intent.object;

import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSObject;

import scripts.ScriptMaker.api.types.main.Conditional;

public class ObjectIsNotOnScreenConditional extends Conditional
{

	private static final long serialVersionUID = 9193997494153329320L;
	
	private String name;
	
	public ObjectIsNotOnScreenConditional(final String name)
	{
		this.name = name;
	}
	
	
	@Override
	public boolean run()
	{
		RSObject[] ob = Objects.findNearest(50, name);
		if(ob.length == 0)
			return true;
		if(ob[0].isOnScreen())
		{
			return true;
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		return "If " + name +" is on screen";
	}

}
