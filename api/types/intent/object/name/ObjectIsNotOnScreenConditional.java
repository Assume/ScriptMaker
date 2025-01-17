package scripts.ScriptMaker.api.types.intent.object.name;

import java.io.Serializable;

import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSObject;

import scripts.ScriptMaker.api.types.main.Conditional;

public class ObjectIsNotOnScreenConditional extends Conditional implements Serializable
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
			return false;
		}
		return true;
	}
	
	@Override
	public String toString()
	{
		return "If " + name +" is not on screen";
	}

}
