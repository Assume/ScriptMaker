package scripts.ScriptMaker.api.types.intent.conditionals.location;

import org.tribot.api2007.Player;

import scripts.ScriptMaker.api.types.main.Conditional;
import scripts.ScriptMaker.api.types.wrappers.CustomTile;

public class DistanceToIsLessThanConditional extends Conditional
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
	
	
}
