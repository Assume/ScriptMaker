package scripts.ScriptMaker.api.types.intent.object.name;

import java.io.Serializable;

import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSObject;

import scripts.ScriptMaker.api.types.main.Conditional;

public class ObjectIsOnScreenConditional extends Conditional implements Serializable
{

	private static final long serialVersionUID = 919399723413329320L;
	
	private String name;
	
	public ObjectIsOnScreenConditional(final String name)
	{
		this.name = name;
	}
	
	
	@Override
	public boolean run()
	{
		RSObject[] ob = Objects.findNearest(50, name);
		if(ob.length == 0)
			return false;
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
