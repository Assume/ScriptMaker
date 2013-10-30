package scripts.ScriptMaker.api.types.intent.conditionals.location;

import java.io.Serializable;

import org.tribot.api2007.Player;

import scripts.ScriptMaker.api.types.main.Conditional;
import scripts.ScriptMaker.api.types.wrappers.CustomTile;

public class DistanceToIsLessThanConditional extends Conditional implements Serializable
{

	private static final long serialVersionUID = -5840995413834307919L;
	private int distance;
	private CustomTile t;
	
	public DistanceToIsLessThanConditional(int distance, CustomTile t)
	{
		this.distance = distance;
		this.t = t;
	}
	
	@Override
	public boolean run()
	{
		return Player.getPosition().distanceTo(t.toTileWrapper()) <= distance;
	}
	
	@Override
	public String toString()
	{
	    return "if distance to "+t.toString() +" is less than "+distance;
	}
	
	
}
