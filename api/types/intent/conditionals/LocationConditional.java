package scripts.ScriptMaker.api.types.intent.conditionals;

import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSTile;

import scripts.ScriptMaker.api.types.main.Conditional;

public class LocationConditional extends Conditional
{

	private RSTile tile;
	private int distance;
	
	public LocationConditional(RSTile tile, final int distance)
	{
		this.tile = tile;
	}
	
	private static final long serialVersionUID = -6902617622802866256L;

	@Override
	public boolean run()
	{
		return Player.getPosition().distanceTo(tile) < distance;
	}
	
	@Override
	public String toString()
	{
		return "If distance to " + tile + " < " + "distance";
	}

}
