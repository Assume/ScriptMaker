package scripts.ScriptMaker.api.types.intent.conditionals.location;

import java.io.Serializable;

import org.tribot.api2007.Player;

import scripts.ScriptMaker.api.types.main.Conditional;
import scripts.ScriptMaker.api.types.wrappers.CustomTile;

public class DistanceToIsGreaterConditional extends Conditional implements Serializable
{

	private static final long serialVersionUID = 2838241718386792951L;
	private int distance;
	private CustomTile t;
	
	public DistanceToIsGreaterConditional(int distance, CustomTile t)
	{
		this.distance = distance;
		this.t = t;
	}
	
	@Override
	public boolean run()
	{
		return Player.getPosition().distanceTo(t.toTileWrapper()) >= distance;
	}

	
	@Override
	public String toString()
	{
	    return "if distance to "+t.toString() +" is greater than "+distance;
	}
}
